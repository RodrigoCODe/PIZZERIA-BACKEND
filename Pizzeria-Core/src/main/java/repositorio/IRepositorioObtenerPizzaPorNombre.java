package repositorio;

import modelo.Pizza;

import java.util.List;

public interface IRepositorioObtenerPizzaPorNombre {

    List<Pizza> obtenerPizzaPorNombre(String nombre);

}
