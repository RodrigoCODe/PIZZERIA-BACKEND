package input;

import modelo.Barrio;

import java.util.List;

public interface IObtenerBarrioPorNombreInput {
    List<Barrio> obtenerBarrioPorNombre(String nombre);
}
