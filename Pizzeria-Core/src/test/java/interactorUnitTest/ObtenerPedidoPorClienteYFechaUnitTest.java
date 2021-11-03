package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.*;
import interactor.ObtenerPedidoPorClienteYFecha;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioObtenerPedidoPorClienteYFecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ObtenerPedidoPorClienteYFechaUnitTest {
    @Mock
    IRepositorioObtenerPedidoPorClienteYFecha repositorio;
    @Test
    public void obtenerPedidoPorClienteYFecha_ClienteYFechaCorrectos_DevolverPedidosCorrectamente() throws ClienteIncompletoException, BarrioIncompletoException, PedidoIncompletoException, PizzaIncompletaException, FechaIncorrectaException{
        Barrio barrio = Barrio.factoryBarrio(2, "Nueva Italia");
        Cliente cliente = Cliente.factoryCliente(1,"Federico", "San Juan 570", barrio,
                "37492933");
        Pizza pizzaMuzza = Pizza.factoryPizza(1, "Muzzarella", 250.00f, 30);
        Pizza pizzaComun = Pizza.factoryPizza(2, "Comun", 100.00f, 30);
        Pizza pizzaNapo = Pizza.factoryPizza(2, "Napolitana", 300.00f, 45);
        Pizza pizzaConChampiñones = Pizza.factoryPizza(2, "Con Champignones Salteados", 250.00f,
                30);
        ArrayList<Pizza> primerEncargo = new ArrayList<>();
        primerEncargo.add(pizzaMuzza);
        primerEncargo.add(pizzaComun);
        Pedido primerPedido = Pedido.factoryPedido(1, cliente, LocalDateTime.of(2019, 11,8,19,30),
                primerEncargo,2);
        ArrayList<Pizza> segundoEncargo = new ArrayList<>();
        segundoEncargo.add(pizzaNapo);
        segundoEncargo.add(pizzaConChampiñones);
        Pedido segundoPedido = Pedido.factoryPedido(2,cliente,LocalDateTime.of(2019,11,8,21,35),
                segundoEncargo, 2);
        ArrayList<Pedido> resultado = new ArrayList<>();
        resultado.add(primerPedido);
        resultado.add(segundoPedido);
        when(repositorio.obtenerPedidoPorClienteYFecha(cliente, LocalDateTime.of(2019, 11, 8,0,0))).thenReturn(resultado);
        ObtenerPedidoPorClienteYFecha caso = new ObtenerPedidoPorClienteYFecha(repositorio);
        assertEquals(resultado, caso.obtenerPedidoPorClienteYFecha(cliente, LocalDateTime.of(2019, 11, 8,0,0)));
    }

    @Test
    public void obtenerPedidoPorClienteYFecha_FechaIncorrecta_DevolverExcepcion() throws ClienteIncompletoException, BarrioIncompletoException {
        Barrio barrio = Barrio.factoryBarrio(2, "Nueva Italia");
        Cliente cliente = Cliente.factoryCliente(1,"Federico", "San Juan 570", barrio,
                "37492933");
        ObtenerPedidoPorClienteYFecha caso = new ObtenerPedidoPorClienteYFecha(repositorio);
        Assertions.assertThrows(FechaIncorrectaException.class, ()-> caso.obtenerPedidoPorClienteYFecha(cliente,
                LocalDateTime.of(2020, 01,01,0,0)));
    }

}
