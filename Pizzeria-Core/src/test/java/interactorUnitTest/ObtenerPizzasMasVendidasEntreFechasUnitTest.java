package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.*;
import interactor.ObtenerPizzasMasVendidasEntreFechasUseCase;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioObtenerPedidos;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerPizzasMasVendidasEntreFechasUnitTest {


    @Mock
    IRepositorioObtenerPedidos obtenerPedidosGateWay;

    @Test
    public void ObtenerPizzasMasVendidasEntreFechas_PizzasCorrectas_DevuelveListaCorrecta() throws BarrioIncompletoException, ClienteIncompletoException, PizzaIncompletaException, PedidoIncompletoException, FechaIncorrectaException, PedidosNoEncontradosException {
       Barrio barrio1 = Barrio.factoryBarrio(1, "Centro");
       Barrio barrio2 = Barrio.factoryBarrio(2, "Paiman");
       Cliente rodrigo = Cliente.factoryCliente(1, "Rodrigo", "San fran 123", barrio1, "28131367");
       Cliente juan = Cliente.factoryCliente(2, "Juan", "Mama 443", barrio2, "Brasil 123");

        Pizza pizza1 = Pizza.factoryPizza(1, "Comun", 200.00f, 10);
        Pizza pizza2 = Pizza.factoryPizza(2, "Napolitana", 250.00f, 15);
        Pizza pizza3 = Pizza.factoryPizza(3, "Especial", 270.00f, 15);
        Pizza pizza4 = Pizza.factoryPizza(4, "Argentina", 350.00f, 20);
        Pizza pizza5 = Pizza.factoryPizza(5, "Palmitos", 300.00f, 15);
        Pizza pizza6 = Pizza.factoryPizza(6, "DobleMuzza", 300.00f, 15);
        Pizza pizza7 = Pizza.factoryPizza(7, "Mexicana", 320.00f, 20);
        Pizza pizza8 = Pizza.factoryPizza(8, "CuatroQuesos", 350.00f, 15);
        Pizza pizza9 = Pizza.factoryPizza(9, "Caballo", 370.00f, 25);
        Pizza pizza10 = Pizza.factoryPizza(10, "Morron", 250.00f, 15);

        Collection<Pizza> items1 = new ArrayList<>();
        items1.add(pizza1);
        items1.add(pizza3);
        items1.add(pizza1);
        items1.add(pizza5);

        Collection<Pizza> items2 = new ArrayList<>();
        items2.add(pizza1);
        items2.add(pizza1);
        items2.add(pizza7);
        items2.add(pizza6);
        items2.add(pizza2);

        Collection<Pizza> items3 = new ArrayList<>();
        items3.add(pizza1);
        items3.add(pizza4);
        items3.add(pizza8);
        items3.add(pizza9);
        items3.add(pizza10);
        items3.add(pizza2);

        Collection<Pizza> items4 = new ArrayList<>();
        items4.add(pizza1);
        items4.add(pizza2);
        items4.add(pizza3);
        items4.add(pizza2);
        items4.add(pizza3);
        items4.add(pizza8);

        Collection<Pizza> items5 = new ArrayList<>();
        items5.add(pizza1);
        items5.add(pizza1);
        items5.add(pizza4);
        items5.add(pizza10);
        items5.add(pizza5);
        items5.add(pizza3);
        items5.add(pizza2);
        items5.add(pizza1);

        Collection<Pizza> items6 = new ArrayList<>();
        items6.add(pizza1);
        items6.add(pizza3);
        items6.add(pizza4);
        items6.add(pizza7);
        items6.add(pizza2);
        items6.add(pizza10);
        items6.add(pizza3);

        Collection<Pizza> items7 = new ArrayList<>();
        items7.add(pizza1);
        items7.add(pizza3);
        items7.add(pizza4);
        items7.add(pizza7);
        items7.add(pizza2);
        items7.add(pizza10);
        items7.add(pizza3);

        Collection<Pizza> items8 = new ArrayList<>();
        items8.add(pizza1);
        items8.add(pizza3);
        items8.add(pizza4);
        items8.add(pizza7);
        items8.add(pizza2);
        items8.add(pizza10);
        items8.add(pizza3);



        Pedido pedido1 = Pedido.factoryPedido(1, rodrigo, LocalDateTime.of(2019, 11,8,19,30),
               items1 ,1);

        Pedido pedido2 = Pedido.factoryPedido(2, juan, LocalDateTime.of(2019, 11,8,19,45),
               items2 ,2);

        Pedido pedido3 = Pedido.factoryPedido(3, rodrigo, LocalDateTime.of(2019, 11,9,20,05),
               items3 ,3);

        Pedido pedido4 = Pedido.factoryPedido(4, juan, LocalDateTime.of(2019, 11,9,20,25),
               items4 ,4);

        Pedido pedido5 = Pedido.factoryPedido(5, rodrigo, LocalDateTime.of(2019, 11,10,20,14),
               items5 ,5);

        Pedido pedido6 = Pedido.factoryPedido(6, juan, LocalDateTime.of(2019, 11,10,20,45),
                items6 ,6);

        Pedido pedidoFueraDeFecha1 = Pedido.factoryPedido(7, rodrigo, LocalDateTime.of(2019, 11,7,20,45),
                items7 ,7);

        Pedido pedidoFueraDeFecha2 = Pedido.factoryPedido(8, juan, LocalDateTime.of(2019, 11,11,21,45),
                items8 ,8);


        ArrayList<Pedido> losPedidosCargados = new ArrayList<>();
        losPedidosCargados.add(pedido1);
        losPedidosCargados.add(pedido2);
        losPedidosCargados.add(pedido3);
        losPedidosCargados.add(pedido4);
        losPedidosCargados.add(pedido5);
        losPedidosCargados.add(pedido6);
        losPedidosCargados.add(pedidoFueraDeFecha1);
        losPedidosCargados.add(pedidoFueraDeFecha2);

        LocalDate fechaInicio = LocalDate.of(2019,11,8);

        LocalDate fechaFin = LocalDate.of(2019, 11, 10);


        when(obtenerPedidosGateWay.obtenerPedidos()).thenReturn(losPedidosCargados);
        ObtenerPizzasMasVendidasEntreFechasUseCase obtenerPizzasMasVendidasEntreFechas = new ObtenerPizzasMasVendidasEntreFechasUseCase(obtenerPedidosGateWay);
        Assertions.assertEquals( 10, obtenerPizzasMasVendidasEntreFechas.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin).get(pizza1));
        Assertions.assertEquals( 6, obtenerPizzasMasVendidasEntreFechas.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin).get(pizza2));
        HashMap<Pizza, Integer> laLista = obtenerPizzasMasVendidasEntreFechas.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);

        laLista.entrySet().forEach(pizzaIntegerEntry -> {System.out.println(pizzaIntegerEntry.getKey().getNombre() + " " + pizzaIntegerEntry.getValue());});


    }


}
