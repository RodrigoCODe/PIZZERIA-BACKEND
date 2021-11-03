package repositorio;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;

public interface IRepositorioModificarPedido {

    Pedido findByNroPedido(Integer numeroPedido) throws PedidoIncompletoException, PizzaIncompletaException;

    Boolean actualizar(Pedido Pedido);

}
