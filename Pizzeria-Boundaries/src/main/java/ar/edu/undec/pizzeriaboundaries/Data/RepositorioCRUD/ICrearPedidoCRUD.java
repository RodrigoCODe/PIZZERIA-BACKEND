package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrearPedidoCRUD extends CrudRepository<PedidoEntity, Integer> {

    PedidoEntity findByNumeroPedido(Integer numeroPedido);
}
