package interactor;

import excepciones.BarrioExisteException;
import input.ICrearBarrioInput;
import modelo.Barrio;
import repositorio.IRepositorioCrearBarrio;

public class CrearBarrioUseCase implements ICrearBarrioInput {

    private IRepositorioCrearBarrio crearBarrioGateway;

    public CrearBarrioUseCase(IRepositorioCrearBarrio crearBarrioGateway) {
        this.crearBarrioGateway = crearBarrioGateway;
    }

    @Override
    public boolean crearBarrio(Barrio elBarrio) throws BarrioExisteException {
        if(crearBarrioGateway.buscarBarrioPorNombre(elBarrio.getNombre()) == null)
            return this.crearBarrioGateway.guardar(elBarrio);

        throw new BarrioExisteException();

    }

}
