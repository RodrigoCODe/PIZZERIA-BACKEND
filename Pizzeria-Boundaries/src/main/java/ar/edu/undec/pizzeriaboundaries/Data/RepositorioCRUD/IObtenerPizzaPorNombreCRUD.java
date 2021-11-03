package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObtenerPizzaPorNombreCRUD extends JpaRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findByNombreContains(String nombre);
}
