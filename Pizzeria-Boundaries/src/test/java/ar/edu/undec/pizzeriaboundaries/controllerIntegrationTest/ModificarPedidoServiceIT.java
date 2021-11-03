package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ModificarPedidoController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import excepciones.PedidoExisteException;
import input.IModificarPedidoInput;
import modelo.Pedido;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarPedidoServiceIT {

    @Mock
    IModificarPedidoInput modificarPedidoInput;
    @Spy
    List<PizzaDTO> listaItems= new ArrayList<>();
    @Test
    public void modificarPedido_PedidoModificado_DevuelveTrue() throws Exception, PedidoExisteException {
        BarrioDTO elBarrio= new BarrioDTO(1,"Centro");
        List<PizzaDTO> items = listaItems;
        PizzaDTO laPizza= new PizzaDTO(1,"Napolitana",250.00f,15);
        PizzaDTO laSegundaPizza= new PizzaDTO(2,"Comun",200.00f,10);
        items.add(laPizza);
        items.add(laSegundaPizza);
        ClienteDTO elCliente= new ClienteDTO(1,"Rodrigo Alarcon","San Francisco 285", "39400500", elBarrio);
        LocalDateTime fecha = LocalDateTime.now();
        PedidoDTO elPedido= new PedidoDTO(1,elCliente, fecha, items,  1 );

        when(modificarPedidoInput.modificarPedido(any(Pedido.class))).thenReturn(true);
        ModificarPedidoController modificarPedidoController = new ModificarPedidoController(modificarPedidoInput);
        assertEquals(org.apache.http.HttpStatus.SC_OK,modificarPedidoController.modificarPedido(elPedido).getStatusCodeValue());
    }


    @Test
    public void modificarPedido_PedidoExiste_DevuelveFalse() throws Exception, PedidoExisteException {
        BarrioDTO elBarrio= new BarrioDTO(1,"Centro");
        List<PizzaDTO> items = listaItems;
        PizzaDTO laPizza= new PizzaDTO(1,"Napolitana",250.00f,15);
        PizzaDTO laSegundaPizza= new PizzaDTO(2,"Comun",200.00f,10);
        items.add(laPizza);
        items.add(laSegundaPizza);
        ClienteDTO elCliente= new ClienteDTO(1,"Rodrigo Alarcon","San Francisco 285", "39400500", elBarrio);
        LocalDateTime fecha = LocalDateTime.now();
        PedidoDTO elPedido= new PedidoDTO(1,elCliente, fecha, items,  1 );



        when(modificarPedidoInput.modificarPedido(any(Pedido.class))).thenThrow(new PedidoExisteException());
        ModificarPedidoController modificarPedidoController = new ModificarPedidoController(modificarPedidoInput);
        assertEquals(modificarPedidoController.modificarPedido(elPedido).getStatusCodeValue(), org.apache.http.HttpStatus.SC_PRECONDITION_FAILED);
    }


}
