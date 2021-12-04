package repositorio;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;


import java.util.List;

public interface IRepositorioObtenerPedidos {

    List<Pedido> obtenerPedidos() throws PedidoIncompletoException, PizzaIncompletaException;
}
