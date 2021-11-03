package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PedidoEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerPedidoPorClienteYPedidoCRUD;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Cliente;
import modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioObtenerPedidoPorClienteYFecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerPedidoPorClienteYFechaRepoImpl implements IRepositorioObtenerPedidoPorClienteYFecha {
    @Autowired
    IObtenerPedidoPorClienteYPedidoCRUD obtenerPedidoCRUD;

    @Override
    public List<Pedido> obtenerPedidoPorClienteYFecha(Cliente cliente, LocalDateTime fecha) throws PedidoIncompletoException, PizzaIncompletaException {
        ClienteEntity clienteEntity = new ClienteEntityMapper().mapeoCoreData(cliente);
        List<Pedido> pedidos = new ArrayList();
        List<PedidoEntity> resultados = (List<PedidoEntity>) obtenerPedidoCRUD.findAll();
        for(PedidoEntity pedido : resultados){
            if((pedido.getElCliente().getDocumento().equals(cliente.getDocumento())) && (pedido.getFecha().isBefore(fecha))){
                pedidos.add(new PedidoEntityMapper().mapeoDataCore(pedido));
            }
        }
        return pedidos;

    }
}
