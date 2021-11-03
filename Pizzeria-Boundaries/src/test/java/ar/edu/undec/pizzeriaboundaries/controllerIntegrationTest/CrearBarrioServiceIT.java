package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.CrearBarrioController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import excepciones.BarrioExisteException;
import input.ICrearBarrioInput;
import modelo.Barrio;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearBarrioServiceIT {

    @Mock
    ICrearBarrioInput crearBarrioInput;

    @Test
    public void crearBarrio_BarrioNoExiste_Devuelve200() throws BarrioExisteException {
        BarrioDTO barrio = new BarrioDTO(null, "Altos de chilecito");
        when(crearBarrioInput.crearBarrio(any(Barrio.class))).thenReturn(true);
        CrearBarrioController crearBarrioController = new CrearBarrioController(crearBarrioInput);
        Assert.assertEquals(crearBarrioController.crearBarrio(barrio).getStatusCodeValue(), HttpStatus.SC_OK);
    }

    @Test
    public void crearBarrio_BarrioExiste_Devuelve412() throws BarrioExisteException {
        BarrioDTO barrio = new BarrioDTO(null, "Altos de chilecito");
        when(crearBarrioInput.crearBarrio(any(Barrio.class))).thenThrow(new BarrioExisteException());
        CrearBarrioController crearBarrioController = new CrearBarrioController(crearBarrioInput);
        Assert.assertEquals(crearBarrioController.crearBarrio(barrio).getStatusCodeValue(), HttpStatus.SC_PRECONDITION_FAILED);
    }

}
