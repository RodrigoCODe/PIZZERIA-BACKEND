package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import interactor.ObtenerClientePorNombreUseCase;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerClientePorNombreUnitTest {


    @Mock
    IRepositorioObtenerClientePorNombre obtenerClientePorNombreGateway;

    @Spy
    List<Cliente> misClientes = factoryListaClientes();


    public ObtenerClientePorNombreUnitTest() throws ClienteIncompletoException, BarrioIncompletoException {
    }

    @Test
    public void obtenerCLientePorNombre_listaClientes_devuelveListaCorrecto(){

        when(obtenerClientePorNombreGateway.obtenerClientePorNombre("Jose")).thenReturn(misClientes);
        ObtenerClientePorNombreUseCase obtenerClientePorNombreUseCase = new ObtenerClientePorNombreUseCase(obtenerClientePorNombreGateway);
        List<Cliente> lista = obtenerClientePorNombreUseCase.obtenerClientePorNombre("Jose");

        Assertions.assertEquals(1, lista.size());

    }

    public List<Cliente> factoryListaClientes() throws ClienteIncompletoException, BarrioIncompletoException {

        List<Cliente> misClientes = new ArrayList();

        Barrio elBarrio1 = Barrio.factoryBarrio(1,"Castro Y Bazan");

        Cliente elCliente1 = Cliente.factoryCliente(1,"Jose","Castro y Bazan", elBarrio1,"39300672");

        misClientes.add(elCliente1);

        return misClientes;
    }


}
