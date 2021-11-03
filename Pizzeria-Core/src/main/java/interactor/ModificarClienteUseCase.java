package interactor;

import excepciones.ClienteExisteException;
import input.IModificarClienteInput;
import modelo.Cliente;
import repositorio.IRepositorioModificarCliente;

public class ModificarClienteUseCase implements IModificarClienteInput {

    private IRepositorioModificarCliente modificarClienteRepo;

    public ModificarClienteUseCase(IRepositorioModificarCliente modificarClienteRepo) {
        this.modificarClienteRepo = modificarClienteRepo;
    }


    @Override
    public Boolean modificarCliente(Cliente cliente) throws ClienteExisteException {
        Cliente clienteAModificar  = modificarClienteRepo.findByDocumento(cliente.getDocumento());

        if(clienteAModificar == null )
            return this.modificarClienteRepo.actualizar(cliente);
        else{
            if(clienteAModificar.getIdCliente() != cliente.getIdCliente())
                throw new ClienteExisteException();
            else{
                return this.modificarClienteRepo.actualizar(cliente);
            }
        }
    }
}
