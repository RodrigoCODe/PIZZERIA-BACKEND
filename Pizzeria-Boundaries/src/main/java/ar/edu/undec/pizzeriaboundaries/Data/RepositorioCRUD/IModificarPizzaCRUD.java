package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IModificarPizzaCRUD extends CrudRepository<PizzaEntity, Integer> {

    PizzaEntity findByNombre(String nombrePizza);

}
