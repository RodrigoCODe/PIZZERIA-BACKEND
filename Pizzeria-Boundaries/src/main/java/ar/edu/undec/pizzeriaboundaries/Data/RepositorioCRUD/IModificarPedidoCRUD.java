package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModificarPedidoCRUD extends CrudRepository<PedidoEntity, Integer> {
    PedidoEntity findByNumeroPedido(Integer numeroPedido);
}
