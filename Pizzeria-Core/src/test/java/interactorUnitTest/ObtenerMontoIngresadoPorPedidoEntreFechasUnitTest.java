package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.*;
import interactor.ObtenerMontoIngresadoPorPedidoEntreFechas;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IObtenerMontoIngresadoPorPedidoEntreFechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerMontoIngresadoPorPedidoEntreFechasUnitTest {
    @Mock
    IObtenerMontoIngresadoPorPedidoEntreFechas repositorio;

    @Test
    public void obtenerMontoIngresadoPorPedidoEntreFechas_FechasIngresadasCorrectamente_DevolverMonto() throws PizzaIncompletaException, BarrioIncompletoException, ClienteIncompletoException, PedidoIncompletoException, FechaIncorrectaException {
        Pizza comun = Pizza.factoryPizza(1,"Comun",150,30);
        Pizza especial = Pizza.factoryPizza(2,"Especial",200,30);
        Barrio barrioMayo = Barrio.factoryBarrio(1,"Mayo");
        Barrio barrioPaiman = Barrio.factoryBarrio(1,"Paiman Sur");
        Cliente primerCliente = Cliente.factoryCliente(1,"Manuel","San Juan 570",barrioMayo,"37492933");
        Cliente segundoCliente = Cliente.factoryCliente(1,"Federico","Santa Rosa 544",barrioPaiman,"37492933");
        List<Pizza> pizzasPrimerPedido = new ArrayList<>();
        List<Pizza> pizzasSegundoPedido = new ArrayList<>();
        List<Pizza> pizzasTercerPedido = new ArrayList<>();
        List<Pizza> pizzasCuartoPedido = new ArrayList<>();
        pizzasPrimerPedido.add(especial);
        pizzasSegundoPedido.add(comun);
        pizzasTercerPedido.add(comun);
        pizzasTercerPedido.add(especial);
        pizzasCuartoPedido.add(comun);
        Pedido primerPedido = Pedido.factoryPedido(1,primerCliente, LocalDateTime.of(2019,11,15,21,30),pizzasPrimerPedido,1);
        Pedido segundoPedido = Pedido.factoryPedido(2,segundoCliente, LocalDateTime.of(2019,11,18,20,10),pizzasSegundoPedido,1);
        Pedido tercerPedido = Pedido.factoryPedido(3,segundoCliente, LocalDateTime.of(2019,11,18,20,30),pizzasTercerPedido,2);
        Pedido cuartoPedido = Pedido.factoryPedido(4,primerCliente, LocalDateTime.of(2019,11,19,21,30),pizzasCuartoPedido,1);

        when(repositorio.obtenerMontoIngresadoPorPedidoEntreFechas(LocalDate.of(2019,11,15),LocalDate.of(2019,11,19))).thenReturn(850.0);
        ObtenerMontoIngresadoPorPedidoEntreFechas caso = new ObtenerMontoIngresadoPorPedidoEntreFechas(repositorio);
        assertEquals(850.0,caso.obtenerMontoIngresadoPorPedidosEntreFechas(LocalDate.of(2019,11,15),LocalDate.of(2019,11,19)));
    }

    @Test
    public void obtenerMontoIngresadoPorPedidoEntreFechas_FechaInicioIncorrecta_ArrojarExcepcion(){
        ObtenerMontoIngresadoPorPedidoEntreFechas caso = new ObtenerMontoIngresadoPorPedidoEntreFechas(repositorio);
        Assertions.assertThrows(FechaIncorrectaException.class, ()-> caso.obtenerMontoIngresadoPorPedidosEntreFechas(
                LocalDate.of(2019,11,23),LocalDate.of(2019,11,20)));
    }
}
