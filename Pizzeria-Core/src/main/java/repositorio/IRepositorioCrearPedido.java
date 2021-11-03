package repositorio;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;

public interface IRepositorioCrearPedido {

    boolean guardar(Pedido elPedido);

    Pedido buscarPedidoPorNumero(Integer numeroPedido) throws PedidoIncompletoException, PizzaIncompletaException;


}
