package input;

import excepciones.PedidoExisteException;
import modelo.Pedido;

public interface IModificarPedidoInput {

    Boolean modificarPedido(Pedido Pedido) throws PedidoExisteException;
}
