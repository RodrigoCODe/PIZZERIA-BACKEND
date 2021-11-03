package ar.edu.undec.pizzeriaboundaries.Data.EntityMapper;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public class PizzaEntityMapper {

    public PizzaEntity mapeoCoreData(Pizza pizzaCore){
        PizzaEntity pizzaentity = new PizzaEntity();
        pizzaentity.setIdPizza(pizzaCore.getIdPizza());
        pizzaentity.setNombre(pizzaCore.getNombre());
        pizzaentity.setPrecio(pizzaCore.getPrecio());
        pizzaentity.setTiempoPreparacion(pizzaCore.getTiempoPreparacion());
        return pizzaentity;
    }

    public Pizza mapeoDataCore(PizzaEntity pizzaEntity) throws PizzaIncompletaException {
        return Pizza.factoryPizza(pizzaEntity.getIdPizza(), pizzaEntity.getNombre(), pizzaEntity.getPrecio(), pizzaEntity.getTiempoPreparacion());
    }
}
