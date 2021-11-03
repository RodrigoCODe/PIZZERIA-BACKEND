package interactor;

import excepciones.ClienteExisteException;
import input.ICrearClienteInput;
import modelo.Cliente;
import repositorio.IRepositorioCrearCliente;

public class CrearClienteUseCase implements ICrearClienteInput {

    private IRepositorioCrearCliente crearClienteGateway;

    public CrearClienteUseCase(IRepositorioCrearCliente crearClienteGateway) {
       this.crearClienteGateway = crearClienteGateway;
    }

    public boolean existeCliente(Cliente elCliente){
        return crearClienteGateway.buscarClientePorDocumento(elCliente.getNombre()) != null;
    }

    public boolean crearCliente(Cliente elCliente) throws ClienteExisteException {
        if(!existeCliente(elCliente)) {
            return this.crearClienteGateway.guardar(elCliente);
        }
            throw new ClienteExisteException();

    }

}
