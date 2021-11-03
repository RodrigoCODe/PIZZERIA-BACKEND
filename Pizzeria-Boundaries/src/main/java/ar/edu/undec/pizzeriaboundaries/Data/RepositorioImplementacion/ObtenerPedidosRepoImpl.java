package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PedidoEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerPedidosCRUD;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioObtenerPedidos;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerPedidosRepoImpl implements IRepositorioObtenerPedidos {

    @Autowired
    private IObtenerPedidosCRUD obtenerPedidosCRUD;

    @Override
    public List<Pedido> obtenerPedidos() throws PedidoIncompletoException, PizzaIncompletaException {

        List<Pedido> listaPedidos = new ArrayList<>();

        for(PedidoEntity pedido : obtenerPedidosCRUD.findAll()){

            Pedido elPedido = new PedidoEntityMapper().mapeoDataCore(pedido);
            listaPedidos.add(elPedido);
        }
        return listaPedidos;

    }
}
