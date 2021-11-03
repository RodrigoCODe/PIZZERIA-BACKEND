package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PedidoEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IModificarPedidoCRUD;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioModificarPedido;
@Service
public class ActualizarPedidoRepoImpl implements IRepositorioModificarPedido {
    @Autowired
    IModificarPedidoCRUD modificarPedidoCRUD;


    @Override
    public Pedido findByNroPedido(Integer numeroPedido) throws PedidoIncompletoException, PizzaIncompletaException {
        Pedido pedido = new PedidoEntityMapper().mapeoDataCore((PedidoEntity) modificarPedidoCRUD);
        return pedido;
    }

    @Override
    public Boolean actualizar(Pedido Pedido) {
        PedidoEntity PedidoEntity = new PedidoEntityMapper().mapeoCoreData(Pedido);
        boolean result= modificarPedidoCRUD.save(PedidoEntity) != null;
        return result;
    }
}
