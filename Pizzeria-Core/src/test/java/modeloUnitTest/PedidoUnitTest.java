package modeloUnitTest;

import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoUnitTest {



    public ArrayList<Pizza> factoryItemsPizza() throws PizzaIncompletaException {
        ArrayList<Pizza> items = new ArrayList<Pizza>();
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
        Pizza laSegundaPizza=Pizza.factoryPizza(2,"Comun",200.00f,10);
        items.add(laPizza);
        items.add(laSegundaPizza);
        return items;
    }


    @Test
    void instanciarPedido_PedidoCompleto_InstanciaCorrecta() throws BarrioIncompletoException, ClienteIncompletoException, PizzaIncompletaException, PedidoIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        LocalDateTime fecha = LocalDateTime.now();
        ArrayList<Pizza> items= factoryItemsPizza();
        Pedido elPedido=Pedido.factoryPedido(1,elCliente, fecha, items,  1 );
        assertNotNull(elPedido);
        assertEquals(2, elPedido.getItems().size());

    }

    @Test
    void instanciarPedido_PedidoSinNroDePedido_InstanciaIncorrecta() throws BarrioIncompletoException, ClienteIncompletoException, PizzaIncompletaException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        ArrayList<Pizza> items = factoryItemsPizza();
        LocalDateTime fecha = LocalDateTime.now();
        Assertions.assertThrows(PedidoIncompletoException.class, ()-> Pedido.factoryPedido(1,elCliente, fecha, items, null ));



    }
    @Test
    void instanciarPedido_PedidoItemsIgualACero_InstanciaIncorrecta() throws BarrioIncompletoException, ClienteIncompletoException, PizzaIncompletaException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        ArrayList<Pizza> items = new ArrayList<Pizza>();
        LocalDateTime fecha = LocalDateTime.now();
        Assertions.assertThrows(PedidoIncompletoException.class, ()-> Pedido.factoryPedido(1,elCliente, fecha, items, null ));



    }
}
