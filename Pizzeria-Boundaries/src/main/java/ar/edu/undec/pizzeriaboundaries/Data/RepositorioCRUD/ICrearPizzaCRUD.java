package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrearPizzaCRUD extends CrudRepository<PizzaEntity, Integer> {

    PizzaEntity findByNombre(String nombrePizza);


}

