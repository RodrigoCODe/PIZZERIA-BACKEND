package repositorio;

import modelo.Barrio;

public interface IRepositorioCrearBarrio {

    boolean guardar(Barrio elBarrio);

    Barrio buscarBarrioPorNombre(String nombreBarrio);


}