package interactor;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import input.IObtenerPedidosInput;
import modelo.Pedido;
import repositorio.IRepositorioObtenerPedidos;

import java.util.Collection;
import java.util.List;

public class ObtenerPedidosUseCase  implements IObtenerPedidosInput {

    private IRepositorioObtenerPedidos obtenerPedidosGateWay;

    public ObtenerPedidosUseCase(IRepositorioObtenerPedidos obtenerPedidosGateWay) {
        this.obtenerPedidosGateWay = obtenerPedidosGateWay;
    }

    public List<Pedido> obtenerPedidos() throws PedidoIncompletoException, PizzaIncompletaException {
        return obtenerPedidosGateWay.obtenerPedidos();
    }
}
