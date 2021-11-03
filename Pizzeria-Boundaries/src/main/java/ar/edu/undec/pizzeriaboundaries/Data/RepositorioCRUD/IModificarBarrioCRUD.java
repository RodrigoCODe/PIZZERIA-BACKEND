package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import modelo.Barrio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModificarBarrioCRUD extends CrudRepository<BarrioEntity, Integer> {
    BarrioEntity findByNombre(String nombre);
}
