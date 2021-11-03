package input;

import excepciones.ClienteExisteException;
import modelo.Cliente;

public interface IModificarClienteInput {

    Boolean modificarCliente(Cliente cliente) throws ClienteExisteException;
}
