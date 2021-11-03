package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObtenerPedidosCRUD extends CrudRepository<PedidoEntity, Integer> {
    List<PedidoEntity> findAll();

}
