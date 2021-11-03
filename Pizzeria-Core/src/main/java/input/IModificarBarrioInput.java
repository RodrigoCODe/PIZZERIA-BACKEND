package input;

import excepciones.BarrioExisteException;
import modelo.Barrio;

public interface IModificarBarrioInput {

    boolean modificarBarrio(Barrio barrio) throws BarrioExisteException;

}
