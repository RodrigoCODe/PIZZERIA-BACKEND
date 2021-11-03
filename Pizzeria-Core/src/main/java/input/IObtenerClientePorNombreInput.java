package input;

import modelo.Cliente;

import java.util.List;

public interface IObtenerClientePorNombreInput {

    List<Cliente> obtenerClientePorNombre(String nombreCliente);

}
