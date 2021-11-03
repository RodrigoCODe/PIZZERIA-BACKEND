package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteExisteException;
import excepciones.ClienteIncompletoException;
import interactor.ModificarClienteUseCase;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioModificarCliente;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarClienteUnitTest {

    @Mock
    IRepositorioModificarCliente modificarClienteRepo;

    @Test
    public void modificarCliente_NoHayConflictosClienteExistente_GuardaCorrectamente() throws BarrioIncompletoException, ClienteIncompletoException, ClienteExisteException {
        Barrio barrioCliente = Barrio.factoryBarrio(1,"80 Lotes");

        Cliente clienteDatosNuevos = Cliente.factoryCliente(1, "Renzo", "Presidente Alambour", barrioCliente, "48.365.236");
        when(modificarClienteRepo.findByDocumento("48.365.236")).thenReturn(null);
        when(modificarClienteRepo.actualizar(clienteDatosNuevos)).thenReturn(true);

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepo);
        boolean resultadoActualizarCliente = modificarClienteUseCase.modificarCliente(clienteDatosNuevos);
        Assertions.assertTrue(resultadoActualizarCliente);
    }

    @Test
    public void modificarCliente_ConflictoClienteExistente_ClienteExisteException() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio barrioCliente = Barrio.factoryBarrio(1,"80 Lotes");

        Cliente clienteExistente = Cliente.factoryCliente(1, "Santiago", "San Roman", barrioCliente, "48.365.236");
        Cliente clienteDatosNuevos = Cliente.factoryCliente(2, "Renzo", "Presidente Alambour", barrioCliente, "48.365.236");
        when(modificarClienteRepo.findByDocumento("48.365.236")).thenReturn(clienteExistente);
        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepo);
        Assertions.assertThrows(ClienteExisteException.class, ()-> modificarClienteUseCase.modificarCliente(clienteDatosNuevos));
    }

    @Test
    public void modificarCliente_ConflictoClienteExistentePeroEsElMismo_GuardaCorrectamente() throws BarrioIncompletoException, ClienteIncompletoException, ClienteExisteException {
        Barrio barrioCliente = Barrio.factoryBarrio(1,"80 Lotes");

        Cliente clienteExistente = Cliente.factoryCliente(1, "Santiago", "San Roman", barrioCliente, "48.365.236");
        Cliente clienteDatosNuevos = Cliente.factoryCliente(1, "Renzo", "Presidente Alambour", barrioCliente, "48.365.236");
        when(modificarClienteRepo.findByDocumento("48.365.236")).thenReturn(clienteExistente);
        when(modificarClienteRepo.actualizar(clienteDatosNuevos)).thenReturn(true);

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepo);
        boolean resultadoActualizarCliente = modificarClienteUseCase.modificarCliente(clienteDatosNuevos);
        Assertions.assertTrue(resultadoActualizarCliente);
    }
}
