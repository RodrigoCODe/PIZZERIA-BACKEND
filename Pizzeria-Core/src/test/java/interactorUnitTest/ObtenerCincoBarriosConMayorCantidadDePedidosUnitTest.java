package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import interactor.ObtenerCincoBarriosConMayorCantidadDePedidosUseCase;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import repositorio.IRepositorioObtenerCincoBarriosConMayorCantidadDePedidos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerCincoBarriosConMayorCantidadDePedidosUnitTest {

    @Mock
    IRepositorioObtenerCincoBarriosConMayorCantidadDePedidos iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos;

    @Spy
    List<Barrio> barrios = factoryBarrios();

    @Test
    public void obtenerCincoBarriosConMayorCantidadPedidos_ExistenPedidos_RetornaTrue(){

        Mockito.when(iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos.obtenerCincoBarriosConMayorCantidadDePedidos()).thenReturn(this.barrios);
        ObtenerCincoBarriosConMayorCantidadDePedidosUseCase obtenerBarriosUseCase = new ObtenerCincoBarriosConMayorCantidadDePedidosUseCase(iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos);
        List<Barrio> barriosMayorPedidos = obtenerBarriosUseCase.obtenerCincoBarriosConMayorCantidadDePedidos();
        Assertions.assertEquals(5,barriosMayorPedidos.size());

    }

    private List<Barrio> factoryBarrios() {
        this.barrios = new ArrayList<Barrio>();
        try {
            Barrio barrioUno = Barrio.factoryBarrio(1, "Castro y Bazan");
            Barrio barrioDos = Barrio.factoryBarrio(2, "Lomas de Zamora");
            Barrio barrioTres = Barrio.factoryBarrio(3, "Altos Chilecito");
            Barrio barrioCuatro = Barrio.factoryBarrio(4, "Mis Montanas");
            Barrio barrioCinco = Barrio.factoryBarrio(5, "140 Lotes");

            this.barrios.add(barrioUno);
            this.barrios.add(barrioDos);
            this.barrios.add(barrioTres);
            this.barrios.add(barrioCuatro);
            this.barrios.add(barrioCinco);

        } catch (BarrioIncompletoException e) {
            e.printStackTrace();
        }
        return barrios;
    }

   /* private List<Pedido> factoryListaPedidos() {
        this.pedidos = new ArrayList<Pedido>();
        try {
            Barrio barrioUno = Barrio.factoryBarrio(1, "Castro y Bazan");
            Barrio barrioDos = Barrio.factoryBarrio(2, "Lomas de Zamora");
            Barrio barrioTres = Barrio.factoryBarrio(3, "Altos Chilecito");
            Barrio barrioCuatro = Barrio.factoryBarrio(4, "Mis Montanas");
            Barrio barrioCinco = Barrio.factoryBarrio(5, "140 Lotes");
            Barrio barrioSeis = Barrio.factoryBarrio(6, "Padre Inestal");

            Cliente clienteUno = Cliente.factoryCliente(1, "Mariano", "La Plata", barrioUno, "38.440.761");
            Cliente clienteDos = Cliente.factoryCliente(2, "Yamil", "La Plata", barrioDos, "38.440.761");
            Cliente clienteTres = Cliente.factoryCliente(3, "Pablo", "Siempre Viva", barrioTres, "38.440.761");
            Cliente clienteCuatro = Cliente.factoryCliente(4, "Javier", "Siempre Viva", barrioCuatro, "38.440.761");
            Cliente clienteCinco = Cliente.factoryCliente(5, "Jose", "Siempre Viva", barrioCinco, "38.440.761");
            Cliente clienteSeis = Cliente.factoryCliente(6, "Manuel", "Siempre Viva", barrioSeis, "38.440.761");

            Pizza pizzaUno = Pizza.factoryPizza(1, "Margarita", 50, 30);
            Pizza pizzaDos = Pizza.factoryPizza(2, "Primavera", 50, 30);

            List<Pizza> pizzasPedidas = new ArrayList<>();
            pizzasPedidas.add(pizzaUno);
            pizzasPedidas.add(pizzaUno);
            pizzasPedidas.add(pizzaDos);

            List<Pedido> pedidos = new ArrayList<Pedido>();

            Pedido pedidoUno = Pedido.factoryPedido(1, clienteUno, LocalDateTime.now(), pizzasPedidas, 1);
            Pedido pedidoDos = Pedido.factoryPedido(2, clienteDos, LocalDateTime.now(), pizzasPedidas, 2);
            Pedido pedidoTres = Pedido.factoryPedido(3, clienteTres, LocalDateTime.now(), pizzasPedidas, 3);
            Pedido pedidoCuatro = Pedido.factoryPedido(4, clienteCuatro, LocalDateTime.now(), pizzasPedidas, 4);
            Pedido pedidoCinco = Pedido.factoryPedido(5, clienteCinco, LocalDateTime.now(), pizzasPedidas, 5);
            Pedido pedidoSeis = Pedido.factoryPedido(6, clienteSeis, LocalDateTime.now(), pizzasPedidas, 6);
            Pedido pedidoSiete = Pedido.factoryPedido(7, clienteUno, LocalDateTime.now(), pizzasPedidas, 7);
            Pedido pedidoOcho = Pedido.factoryPedido(8, clienteDos, LocalDateTime.now(), pizzasPedidas, 8);
            Pedido pedidoNueve = Pedido.factoryPedido(9, clienteTres, LocalDateTime.now(), pizzasPedidas, 9);
            Pedido pedidoDiez = Pedido.factoryPedido(10, clienteCuatro, LocalDateTime.now(), pizzasPedidas, 10);
            Pedido pedidoOnce = Pedido.factoryPedido(11, clienteCinco, LocalDateTime.now(), pizzasPedidas, 11);


            this.pedidos.add(pedidoUno);
            this.pedidos.add(pedidoDos);
            this.pedidos.add(pedidoTres);
            this.pedidos.add(pedidoCuatro);
            this.pedidos.add(pedidoCinco);
            this.pedidos.add(pedidoSeis);
            this.pedidos.add(pedidoSiete);
            this.pedidos.add(pedidoOcho);
            this.pedidos.add(pedidoNueve);
            this.pedidos.add(pedidoDiez);
            this.pedidos.add(pedidoOnce);

        } catch (PedidoIncompletoException e) {
            e.printStackTrace();
        } catch (ClienteIncompletoException e) {
            e.printStackTrace();
        } catch (PizzaIncompletaException e) {
            e.printStackTrace();
        } catch (BarrioIncompletoException e) {
            e.printStackTrace();
        }
        return pedidos;
    }*/

}
