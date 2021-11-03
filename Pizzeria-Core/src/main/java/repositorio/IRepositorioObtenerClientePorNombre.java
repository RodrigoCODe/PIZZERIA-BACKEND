package repositorio;

import modelo.Cliente;

import java.util.Collection;
import java.util.List;

public interface IRepositorioObtenerClientePorNombre {

    Collection<Cliente> obtenerClientePorNombre(String nombreCliente);

}
