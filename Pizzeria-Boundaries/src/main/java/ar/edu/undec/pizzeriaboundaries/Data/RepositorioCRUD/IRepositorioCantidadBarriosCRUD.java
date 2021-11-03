package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioCantidadBarriosCRUD extends CrudRepository<BarrioEntity, Integer> {
}
