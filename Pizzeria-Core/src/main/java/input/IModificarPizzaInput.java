package input;

import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public interface IModificarPizzaInput {

    boolean modificarPizza(Pizza pizza) throws PizzaIncompletaException, PizzaExisteException;

}
