package repositorio;

import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public interface IRepositorioModificarPizza {

    Pizza findByNombrePizza(String nombrePizza) throws PizzaIncompletaException;

    boolean actualizarPizza(Pizza pizza);


}
