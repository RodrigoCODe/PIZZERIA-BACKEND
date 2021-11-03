package input;

import excepciones.BarrioExisteException;
import modelo.Barrio;

public interface ICrearBarrioInput {

    boolean crearBarrio(Barrio barrio) throws BarrioExisteException;

}
