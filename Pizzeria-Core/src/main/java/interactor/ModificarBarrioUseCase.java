package interactor;

import excepciones.BarrioExisteException;
import input.IModificarBarrioInput;
import modelo.Barrio;
import repositorio.IRepositorioModificarBarrio;

public class ModificarBarrioUseCase implements IModificarBarrioInput {
	  private IRepositorioModificarBarrio modificarBarrioRepo;

	   
	    //Constructor
	    public ModificarBarrioUseCase(IRepositorioModificarBarrio modificarBarrioRepo) {
	        this.modificarBarrioRepo = modificarBarrioRepo;
	    }


		public boolean modificarBarrio(Barrio BarrioDatosNuevos) throws BarrioExisteException {
	        Barrio BarrioAModificar  = modificarBarrioRepo.findByNombre(BarrioDatosNuevos.getNombre());
	     
	        if(BarrioAModificar == null )
	            return this.modificarBarrioRepo.actualizar(BarrioDatosNuevos);
	        else if(BarrioAModificar.getIdBarrio() != BarrioDatosNuevos.getIdBarrio())
	            throw new BarrioExisteException();
	        else{
	            if (BarrioAModificar.getNombre().equals(BarrioDatosNuevos.getNombre()))
	                return this.modificarBarrioRepo.actualizar(BarrioDatosNuevos);
	        }
	        return false;
	    }


}
