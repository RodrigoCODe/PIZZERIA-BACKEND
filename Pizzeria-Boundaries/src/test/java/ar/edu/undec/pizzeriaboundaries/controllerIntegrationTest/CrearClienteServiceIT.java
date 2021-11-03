package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.CrearClienteController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import excepciones.ClienteExisteException;
import input.ICrearClienteInput;
import modelo.Barrio;
import modelo.Cliente;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearClienteServiceIT {

    @Mock
    ICrearClienteInput iCrearClienteInput;

    @Test
    public void crearCliente_clienteCreado_devuelveTrue() throws ClienteExisteException {

        BarrioDTO nuevoBarrio = new BarrioDTO(1, "Castro y Bazan");
        ClienteDTO nuevoCliente = new ClienteDTO(1, "Jose Soria", "Castro y Bazan", "39300672", nuevoBarrio);
        when(iCrearClienteInput.crearCliente(any(Cliente.class))).thenReturn(true);
        CrearClienteController crearClienteController = new CrearClienteController(iCrearClienteInput);
        assertEquals(crearClienteController.crearCliente(nuevoCliente).getStatusCodeValue(), HttpStatus.SC_OK);

    }






}
