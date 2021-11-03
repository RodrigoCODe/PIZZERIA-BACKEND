package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PizzaEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IModificarPizzaCRUD;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioModificarPizza;

@Service
public class ModificarPizzaRepoImpl implements IRepositorioModificarPizza {

    @Autowired
    IModificarPizzaCRUD iModificarPizzaCRUD;

    @Override
    public Pizza findByNombrePizza(String nombrePizza) throws PizzaIncompletaException {

        return new PizzaEntityMapper().mapeoDataCore(iModificarPizzaCRUD.findByNombre(nombrePizza));
    }

    @Override
    public boolean actualizarPizza(Pizza pizza) {

        PizzaEntity pizzaEntity = new PizzaEntityMapper().mapeoCoreData(pizza);

        return iModificarPizzaCRUD.save(pizzaEntity) != null;
    }
}
