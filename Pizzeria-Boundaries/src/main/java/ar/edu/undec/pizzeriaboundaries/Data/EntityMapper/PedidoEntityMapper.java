package ar.edu.undec.pizzeriaboundaries.Data.EntityMapper;


import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import modelo.Pizza;

import java.util.ArrayList;
import java.util.Collection;

public class PedidoEntityMapper {



    public PedidoEntity mapeoCoreData(Pedido pedidoCore){

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdPedido(pedidoCore.getIdPedido());
        pedidoEntity.setElCliente(new ClienteEntityMapper().mapeoCoreData(pedidoCore.getElCliente()));
        pedidoEntity.setFecha(pedidoCore.getFecha());
        pedidoEntity.setNumeroPedido(pedidoCore.getNumeroPedido());
        for (Pizza pizzaIter : pedidoCore.getItems()) {
            pedidoEntity.getItems().add(new PizzaEntityMapper().mapeoCoreData(pizzaIter));
        }
        return pedidoEntity;
    }


    public Pedido mapeoDataCore(PedidoEntity pedidoEntity) throws PedidoIncompletoException, PizzaIncompletaException {
        Collection<Pizza> losItems = new ArrayList<Pizza>();
        for (PizzaEntity pizzaIter : pedidoEntity.getItems()) {
            losItems.add(new PizzaEntityMapper().mapeoDataCore(pizzaIter));
        }


        return Pedido.factoryPedido(pedidoEntity.getIdPedido(),new ClienteEntityMapper().mapeoDataCore(pedidoEntity.getElCliente()), pedidoEntity.getFecha(), losItems, pedidoEntity.getNumeroPedido());
    }

}
