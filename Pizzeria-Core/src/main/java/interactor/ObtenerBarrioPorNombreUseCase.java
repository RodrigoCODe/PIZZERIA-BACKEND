package interactor;

import input.IObtenerBarrioPorNombreInput;
import modelo.Barrio;
import repositorio.IObtenerBarrioPorNombre;

import java.util.List;

public class ObtenerBarrioPorNombreUseCase implements IObtenerBarrioPorNombreInput {

    private IObtenerBarrioPorNombre obtenerBarrioPorNombre;

    public ObtenerBarrioPorNombreUseCase(IObtenerBarrioPorNombre obtenerBarrioPorNombre) {
        this.obtenerBarrioPorNombre = obtenerBarrioPorNombre;
    }

    @Override
    public List<Barrio> obtenerBarrioPorNombre(String nombre) {
        return obtenerBarrioPorNombre.obtenerBarrioPorNombre(nombre);
    }
}
