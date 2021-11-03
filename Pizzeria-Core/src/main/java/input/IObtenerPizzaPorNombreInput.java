package input;

import modelo.Pizza;

import java.util.List;

public interface IObtenerPizzaPorNombreInput {
    List<Pizza> obtenerPizzaPorNombre(String nombre);
}
