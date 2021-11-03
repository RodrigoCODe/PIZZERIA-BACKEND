package interactorUnitTest;


import Mockito.MockitoExtension;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteExisteException;
import excepciones.ClienteIncompletoException;
import interactor.CrearClienteUseCase;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearCliente;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearClienteUnitTest {

    @Mock
    IRepositorioCrearCliente crearClienteGatway;

    @Test
    public void crearCliente_ClienteNoExiste_GuardaCorrectamente() throws BarrioIncompletoException, ClienteIncompletoException, ClienteExisteException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente clienteNuevo= Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        when(crearClienteGatway.guardar(clienteNuevo)).thenReturn(true);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteGatway);
        boolean resultado = crearClienteUseCase.crearCliente(clienteNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearCliente_ClienteExiste_ClienteExisteException() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio elBarrio = Barrio.factoryBarrio(1, "Centro");
        Cliente clienteNuevo = Cliente.factoryCliente(1, "39400500", "Timoteo Gordillo 43", elBarrio, "39400500");
        when(crearClienteGatway.buscarClientePorDocumento("39400500")).thenReturn(Cliente.factoryCliente(2, "Juan Asis", "Timoteo Gordillo 43", elBarrio, "39400500"));
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteGatway);
        Assertions.assertThrows(ClienteExisteException.class, () -> crearClienteUseCase.crearCliente(clienteNuevo));
    }

}
