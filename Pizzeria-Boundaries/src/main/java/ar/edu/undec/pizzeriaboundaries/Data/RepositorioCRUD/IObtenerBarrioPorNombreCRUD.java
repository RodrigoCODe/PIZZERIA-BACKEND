package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import modelo.Barrio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObtenerBarrioPorNombreCRUD extends CrudRepository<BarrioEntity, Integer> {
    List<BarrioEntity> findByNombreContains(String nombre);
}
