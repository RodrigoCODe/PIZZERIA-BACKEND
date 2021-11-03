package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IModificarClienteCRUD;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioModificarCliente;

@Service
public class ModificarClienteRepoImpl implements IRepositorioModificarCliente {

    @Autowired
    IModificarClienteCRUD iModificarClienteCRUD;

    @Override
    public Boolean actualizar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntityMapper().mapeoCoreData(cliente);
        return iModificarClienteCRUD.save(clienteEntity) != null;
    }


    @Override
    public Cliente findByDocumento(String documento) {

        return new ClienteEntityMapper().mapeoDataCore(iModificarClienteCRUD.findByDocumento(documento));
    }
}
