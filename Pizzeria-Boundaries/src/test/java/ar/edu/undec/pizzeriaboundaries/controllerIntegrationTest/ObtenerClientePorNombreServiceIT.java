package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ObtenerClientePorNombreController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import input.IObtenerClientePorNombreInput;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.Test;
import org.apache.http.HttpStatus;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerClientePorNombreServiceIT {

    @Mock
    IObtenerClientePorNombreInput iObtenerClientePorNombreInput;
    
    @Spy
    List<Cliente> misClientes = factoryListaClientes();

    private List<Cliente> factoryListaClientes() {

        try {
            List<Cliente> clientesList = new ArrayList();
            Barrio barrio = Barrio.factoryBarrio(1, "Castro y Bazan");
            Cliente cliente = Cliente.factoryCliente(1, "Jose Soria", "Castro y Bazan", barrio, "39300672");
            clientesList.add(cliente);
            return clientesList;
        }catch (ClienteIncompletoException | BarrioIncompletoException ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }


    }

    @Test
    public void obtenerCliente_nombreCliente_clienteCorrecto(){

        String nombreCliente = "Jose";
        when(iObtenerClientePorNombreInput.obtenerClientePorNombre(any(String.class))).thenReturn(misClientes);
        ObtenerClientePorNombreController obtenerClientePorNombreController = new ObtenerClientePorNombreController(iObtenerClientePorNombreInput);
        assertEquals(HttpStatus.SC_OK, obtenerClientePorNombreController.obtenerClientePorNombre(nombreCliente).getStatusCodeValue());
    }

    @Test
    public void obtenerCliente_nombreCliente_clienteNoExiste(){

        String nombreCliente = "CualquierVerdura";
        misClientes = new ArrayList<>();
        when(iObtenerClientePorNombreInput.obtenerClientePorNombre(any(String.class))).thenReturn(misClientes);
        ObtenerClientePorNombreController obtenerClientePorNombreController = new ObtenerClientePorNombreController(iObtenerClientePorNombreInput);
        assertEquals(HttpStatus.SC_NO_CONTENT, obtenerClientePorNombreController.obtenerClientePorNombre(nombreCliente).getStatusCodeValue());

    }


}