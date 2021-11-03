package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.ICrearClienteCRUD;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioCrearCliente;

@Service
public class CrearClienteRepoImpl implements IRepositorioCrearCliente {

    @Autowired
    private ICrearClienteCRUD iCrearClienteCRUD;

    @Override
    public boolean guardar(Cliente nuevoCliente) {

        ClienteEntity clienteEntity = new ClienteEntityMapper().mapeoCoreData(nuevoCliente);

        boolean respuesta = iCrearClienteCRUD.save(clienteEntity).getIdCliente() != null;

        return respuesta;
    }

    @Override
    public Cliente buscarClientePorDocumento(String documentoCliente) {
        return null;
    }
}
