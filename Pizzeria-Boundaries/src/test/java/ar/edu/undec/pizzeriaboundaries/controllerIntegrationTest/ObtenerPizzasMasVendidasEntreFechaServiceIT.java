package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ObtenerPizzasMasVendidasEntreFechaController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;

import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PedidosNoEncontradosException;
import excepciones.PizzaIncompletaException;

import input.IObtenerPizzasMasVendidasFechasInput;

import modelo.Pizza;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.HashMap;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerPizzasMasVendidasEntreFechaServiceIT {

    @Mock
    IObtenerPizzasMasVendidasFechasInput obtenerPizzasMasVendidasFechasInput;




    private HashMap<PizzaDTO, Integer> lasPizzasDTO = new HashMap<>();


    private HashMap<Pizza, Integer> factoryMap(HashMap<PizzaDTO, Integer> mapaPizzaDTO)  {
        HashMap<Pizza, Integer> pizzaCoreMap = new HashMap<>();
        ArrayList<Pizza> laPizzaArrayCore = new ArrayList(mapaPizzaDTO.keySet());
        ArrayList<Integer> laCantidadCore = new ArrayList(mapaPizzaDTO.values());
        for(int i=0; i<laPizzaArrayCore.size();++i){
            pizzaCoreMap.put(laPizzaArrayCore.get(i), laCantidadCore.get(i));
        }
        return pizzaCoreMap;
    }


    @Test
    public void ObtenerPizzasMasVendidasEntreFecha_DevuelveCorrecto() throws PedidoIncompletoException, PizzaIncompletaException, FechaIncorrectaException, PedidosNoEncontradosException {

        PizzaDTO Especial = new PizzaDTO(1,"Especial",250.0f,15);
        PizzaDTO Comun = new PizzaDTO(2,"Comun",200.0f,10);
        PizzaDTO Napo = new PizzaDTO(3, "Napolitana", 270.0f, 15);
        PizzaDTO Palmitos = new PizzaDTO(4, "Palmitos", 260.0f, 20);
        PizzaDTO Argentina = new PizzaDTO(5, "Argentina", 300.0f, 20);
        PizzaDTO DobleMuzza = new PizzaDTO(6, "DobleMuzza", 270.0f, 15);


        lasPizzasDTO.put(Especial, 10);
        lasPizzasDTO.put(Comun, 9);
        lasPizzasDTO.put(Napo, 9);
        lasPizzasDTO.put(Palmitos, 7);
        lasPizzasDTO.put(DobleMuzza,6);
        lasPizzasDTO.put(Argentina, 6);

        LocalDate fechaInicio = LocalDate.of(2019, 11, 8);
        LocalDate fechaFin = LocalDate.of(2019, 11, 10);


        when(obtenerPizzasMasVendidasFechasInput.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin)).thenReturn(this.factoryMap(lasPizzasDTO));
        ObtenerPizzasMasVendidasEntreFechaController obtenerPizzasMasVendidasEntreFechaController = new ObtenerPizzasMasVendidasEntreFechaController(obtenerPizzasMasVendidasFechasInput);
        assertEquals(HttpStatus.SC_OK, obtenerPizzasMasVendidasEntreFechaController.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin).getStatusCodeValue());

    }


}

