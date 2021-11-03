package repositorio;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;


import java.util.List;

public interface IRepositorioObtenerPedidos {

    public List<Pedido> obtenerPedidos() throws PedidoIncompletoException, PizzaIncompletaException;
}
