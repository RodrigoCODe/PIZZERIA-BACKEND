package repositorio;

import modelo.Cliente;

public interface IRepositorioModificarCliente {

    Cliente findByDocumento(String documento);

    Boolean actualizar(Cliente cliente);
}
