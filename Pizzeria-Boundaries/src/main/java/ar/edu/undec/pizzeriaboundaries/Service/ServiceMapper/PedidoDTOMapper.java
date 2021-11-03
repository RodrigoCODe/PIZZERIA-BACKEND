package ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper;


import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import excepciones.PedidoIncompletoException;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.hibernate.engine.internal.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PedidoDTOMapper {

    public Pedido mapeoDTOCore(PedidoDTO pedidoDTO) throws PedidoIncompletoException {
        Cliente cliente = new ClienteDTOMapper().mapeoDTOCore(pedidoDTO.getElCliente());
        Collection<Pizza> losItems = new ArrayList<Pizza>();
        for (PizzaDTO pizzaIterDTO : pedidoDTO.getItems()) {
            losItems.add(new PizzaDTOMapper().mapeoDTOCore(pizzaIterDTO));
        }
        return Pedido.factoryPedido(pedidoDTO.getIdPedido(), cliente, pedidoDTO.getFecha(),  losItems, pedidoDTO.getNumeroPedido());

    }

    public PedidoDTO mapeoCoreDTO(Pedido pedido){
        ClienteDTO clienteDTO = new ClienteDTOMapper().mapetoCoreDTO(pedido.getElCliente());
        List<PizzaDTO> losItemsDTO =  new ArrayList<>();
        for (Pizza pizzaIter : pedido.getItems()) {
            losItemsDTO.add(new PizzaDTOMapper().mapeoCoreDTO(pizzaIter));
        }
        PedidoDTO pedidoDTO = new PedidoDTO(pedido.getIdPedido(), clienteDTO, pedido.getFecha(), losItemsDTO, pedido.getNumeroPedido());

        return pedidoDTO;
    }
}
