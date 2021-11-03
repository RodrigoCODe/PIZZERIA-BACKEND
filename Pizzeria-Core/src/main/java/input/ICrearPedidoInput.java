package input;

import excepciones.PedidoExisteException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;

public interface ICrearPedidoInput {

    boolean crearPedido(Pedido nuevoPedido) throws PedidoExisteException, PedidoIncompletoException, PizzaIncompletaException;
}
