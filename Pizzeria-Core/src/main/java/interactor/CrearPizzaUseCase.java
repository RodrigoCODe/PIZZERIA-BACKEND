package interactor;

import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import input.ICrearPizzaInput;
import modelo.Pizza;
import repositorio.IRepositorioCrearPizza;

public class CrearPizzaUseCase implements ICrearPizzaInput {

    private IRepositorioCrearPizza crearPizzaGateWay;

    public CrearPizzaUseCase(IRepositorioCrearPizza crearPizzaGateWay) {
        this.crearPizzaGateWay = crearPizzaGateWay;
    }

    public boolean existePizza(Pizza laPizza) throws PizzaIncompletaException {
        return crearPizzaGateWay.buscarPizzaPorNombre(laPizza.getNombre()) != null;
    }

    public boolean crearPizza(Pizza laPizza) throws PizzaExisteException, PizzaIncompletaException {
        if(!existePizza(laPizza)){
            return this.crearPizzaGateWay.guardar(laPizza);
        }
        throw new PizzaExisteException();
    }
}
