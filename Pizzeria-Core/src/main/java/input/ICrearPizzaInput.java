package input;

import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public interface ICrearPizzaInput {

    boolean crearPizza(Pizza nuevaPizza) throws PizzaIncompletaException, PizzaExisteException;

}
