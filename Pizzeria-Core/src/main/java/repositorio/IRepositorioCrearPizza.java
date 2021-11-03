package repositorio;

import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public interface IRepositorioCrearPizza {

    boolean guardar(Pizza nuevaPizza);

    Pizza buscarPizzaPorNombre(String nombrePizza) throws PizzaIncompletaException;
}
