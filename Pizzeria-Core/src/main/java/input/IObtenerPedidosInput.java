package input;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;


import java.util.List;


public interface IObtenerPedidosInput {

    List<Pedido> obtenerPedidos() throws PedidoIncompletoException, PizzaIncompletaException;
}
