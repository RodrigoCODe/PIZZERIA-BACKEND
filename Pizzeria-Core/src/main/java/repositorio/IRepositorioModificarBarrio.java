package repositorio;

import modelo.Barrio;

public interface IRepositorioModificarBarrio {
	Barrio findByNombre(String nombre);

    Boolean actualizar( Barrio Barrio);

}
   