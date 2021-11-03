package repositorio;

import modelo.Barrio;

import java.util.List;

public interface IObtenerBarrioPorNombre {
    List<Barrio> obtenerBarrioPorNombre(String nombre);
}
