package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObtenerClientePorNombreCRUD extends CrudRepository<ClienteEntity, Integer> {

    List<ClienteEntity> findByNombre(String nombre);

}
