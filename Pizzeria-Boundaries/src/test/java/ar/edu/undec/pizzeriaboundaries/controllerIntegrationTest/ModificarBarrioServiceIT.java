package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ModificarBarrioController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import excepciones.BarrioExisteException;
import input.IModificarBarrioInput;
import modelo.Barrio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ModificarBarrioServiceIT {

    @Mock
    IModificarBarrioInput iModificarBarrioInput;

    @Test
    public void modificarBarrio_barrioModificado_devuelveTrue() throws BarrioExisteException {

        BarrioDTO barrioAModificar = new BarrioDTO(1, "Paiman");
        when(iModificarBarrioInput.modificarBarrio(any(Barrio.class))).thenReturn(true);
        ModificarBarrioController modificarBarrioController = new ModificarBarrioController(iModificarBarrioInput);
        assertEquals(modificarBarrioController.modificarBarrio(barrioAModificar).getStatusCodeValue(), org.apache.http.HttpStatus.SC_OK);

    }






}
