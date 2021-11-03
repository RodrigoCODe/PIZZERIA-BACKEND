package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ObtenerBarrioPorNombreController;
import excepciones.BarrioIncompletoException;
import input.IObtenerBarrioPorNombreInput;
import modelo.Barrio;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static modelo.Barrio.factoryBarrio;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerBarrioPorNombreServiceIT {

    @Mock
    IObtenerBarrioPorNombreInput obtenerBarrioPorNombreInput;

    @Spy
    List<Barrio> barriosList = factoryListaBarrios();


    @Test
    public void obtenerBarrioPorNombre_BarrioExiste_Devuelve200() throws Exception {
        String nombreBarrio = "Siempre";
        when(obtenerBarrioPorNombreInput.obtenerBarrioPorNombre(any(String.class))).thenReturn(barriosList);
        ObtenerBarrioPorNombreController obtenerBarrioPorNombreController = new ObtenerBarrioPorNombreController(obtenerBarrioPorNombreInput);
        assertEquals(HttpStatus.SC_OK, obtenerBarrioPorNombreController.obtenerBarrioPorNombre(nombreBarrio).getStatusCodeValue());

    }

    @Test
    public void obtenerBarrioPorNombre_BarrioNoExiste_Devuelve204() throws Exception {
        String nombreBarrio = "Nose";
        barriosList = new ArrayList<Barrio>();
        when(obtenerBarrioPorNombreInput.obtenerBarrioPorNombre(any(String.class))).thenReturn(barriosList);
        ObtenerBarrioPorNombreController obtenerBarrioPorNombreController = new ObtenerBarrioPorNombreController(obtenerBarrioPorNombreInput);
        assertEquals(HttpStatus.SC_NO_CONTENT, obtenerBarrioPorNombreController.obtenerBarrioPorNombre(nombreBarrio).getStatusCodeValue());

    }

    @Test
    public void obtenerBarrioPorNombre_BarrioNoExiste_Devuelve500() throws Exception {
        String nombreBarrio = "Nose";
        when(obtenerBarrioPorNombreInput.obtenerBarrioPorNombre(any(String.class))).thenReturn(null);
        ObtenerBarrioPorNombreController obtenerBarrioPorNombreController = new ObtenerBarrioPorNombreController(obtenerBarrioPorNombreInput);
        assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, obtenerBarrioPorNombreController.obtenerBarrioPorNombre(nombreBarrio).getStatusCodeValue());

    }

    private List<Barrio> factoryListaBarrios() {
        try {
            List<Barrio> barrios = new ArrayList<Barrio>();
            Barrio barrio= factoryBarrio(1, "140 Lotes");
            barrios.add(barrio);
            return barrios;
        } catch (BarrioIncompletoException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
