package input;

import excepciones.ClienteExisteException;
import modelo.Cliente;

public interface ICrearClienteInput {

    boolean crearCliente(Cliente nuevoCliente) throws ClienteExisteException;

}
