package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.CrearClienteController;
import ar.edu.undec.pizzeriaboundaries.Service.Controller.CrearPedidoController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import excepciones.*;
import input.ICrearPedidoInput;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearPedidoServiceIT {

    @Mock
    ICrearPedidoInput iCrearPedidoInput;

    @Spy
    List<PizzaDTO> listaItems= new ArrayList<>();

    private PedidoDTO cargaPedido() {
        BarrioDTO elBarrio= new BarrioDTO(1,"Centro");
        List<PizzaDTO> items = listaItems;
        PizzaDTO laPizza= new PizzaDTO(1,"Napolitana",250.00f,15);
        PizzaDTO laSegundaPizza= new PizzaDTO(2,"Comun",200.00f,10);
        items.add(laPizza);
        items.add(laSegundaPizza);
        ClienteDTO elCliente= new ClienteDTO(1,"Rodrigo Alarcon","San Francisco 285", "39400500", elBarrio);
        LocalDateTime fecha = LocalDateTime.now();
        PedidoDTO elPedido= new PedidoDTO(1,elCliente, fecha, items,  1 );
        return elPedido;
    }

    @Test
    public void crearPedido_PedidoCreado_devuelveTrue() throws PedidoIncompletoException, PedidoExisteException, PizzaIncompletaException {

        PedidoDTO elPedido = cargaPedido();
        when(iCrearPedidoInput.crearPedido(any(Pedido.class))).thenReturn(true);
        CrearPedidoController crearPedidoController = new CrearPedidoController(iCrearPedidoInput);
        assertEquals(crearPedidoController.crearPedido(elPedido).getStatusCodeValue(), HttpStatus.SC_OK);

    }
}
