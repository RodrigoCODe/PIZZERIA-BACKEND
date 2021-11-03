package interactor;

import excepciones.PedidoExisteException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import input.ICrearPedidoInput;
import modelo.Pedido;
import repositorio.IRepositorioCrearPedido;


public class CrearPedidoUseCase implements ICrearPedidoInput {

    private IRepositorioCrearPedido CrearPedidoGateWay;

    public CrearPedidoUseCase(IRepositorioCrearPedido crearPedidoGateWay) {
        this.CrearPedidoGateWay = crearPedidoGateWay;
    }

    public boolean existePedido(Pedido elPedido) throws PedidoIncompletoException, PizzaIncompletaException {
        return CrearPedidoGateWay.buscarPedidoPorNumero(elPedido.getNumeroPedido()) != null;
    }

    public boolean crearPedido(Pedido elPedido) throws PedidoExisteException, PedidoIncompletoException, PizzaIncompletaException {
        if(!existePedido(elPedido)){
            return this.CrearPedidoGateWay.guardar(elPedido);
        }
        throw new PedidoExisteException();
    }
}
