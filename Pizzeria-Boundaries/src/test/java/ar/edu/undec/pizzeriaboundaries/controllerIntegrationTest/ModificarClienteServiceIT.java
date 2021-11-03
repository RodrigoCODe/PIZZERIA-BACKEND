package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ModificarClienteController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import excepciones.ClienteExisteException;
import input.IModificarClienteInput;
import modelo.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarClienteServiceIT {

    @Mock
    IModificarClienteInput modificarClienteInput;

    @Test
    public void modificarCliente_ClienteModificado_DevuelveTrue() throws Exception, ClienteExisteException {
        ClienteDTO clienteAModificar = new ClienteDTO(1,"Juan", "Siempre Viva", "12312312",new BarrioDTO(1, "Altos de Chilecito") );
        when(modificarClienteInput.modificarCliente(any(Cliente.class))).thenReturn(true);
        ModificarClienteController modificarClienteController = new ModificarClienteController(modificarClienteInput);
        assertEquals(modificarClienteController.modificarCliente(clienteAModificar).getStatusCodeValue(), org.apache.http.HttpStatus.SC_OK);
    }


    @Test
    public void modificarCliente_ClienteExiste_DevuelveFalse() throws Exception, ClienteExisteException {
        ClienteDTO clienteAModificar = new ClienteDTO(1,"Juan", "Siempre Viva",  "12312312", new BarrioDTO(1, "Altos de Chilecito") );
        when(modificarClienteInput.modificarCliente(any(Cliente.class))).thenThrow(new ClienteExisteException());
        ModificarClienteController modificarClienteController = new ModificarClienteController(modificarClienteInput);
        assertEquals(modificarClienteController.modificarCliente(clienteAModificar).getStatusCodeValue(), org.apache.http.HttpStatus.SC_PRECONDITION_FAILED);
    }


}
