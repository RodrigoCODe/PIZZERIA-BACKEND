package interactor;

import input.IObtenerPizzaPorNombreInput;
import modelo.Pizza;
import repositorio.IRepositorioObtenerPizzaPorNombre;

import java.util.List;

public class ObtenerPizzaPorNombreUseCase implements IObtenerPizzaPorNombreInput {

    private IRepositorioObtenerPizzaPorNombre iRepositorioObtenerPizzaPorNombre;

    public ObtenerPizzaPorNombreUseCase(IRepositorioObtenerPizzaPorNombre iRepositorioObtenerPizzaPorNombre) {
        this.iRepositorioObtenerPizzaPorNombre = iRepositorioObtenerPizzaPorNombre;
    }

    @Override
    public List<Pizza> obtenerPizzaPorNombre(String nombre) {
        return iRepositorioObtenerPizzaPorNombre.obtenerPizzaPorNombre(nombre);
    }

}
