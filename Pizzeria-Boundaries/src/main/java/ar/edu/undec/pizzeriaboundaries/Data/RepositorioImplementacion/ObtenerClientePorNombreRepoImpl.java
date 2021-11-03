package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerClientePorNombreCRUD;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerClientePorNombreRepoImpl implements IRepositorioObtenerClientePorNombre {

    @Autowired
    private IObtenerClientePorNombreCRUD iObtenerClientePorNombreCRUD;

    @Override
    public List<Cliente> obtenerClientePorNombre(String nombreCliente) {

        List<Cliente> listaClientes = new ArrayList<>();

        for (ClienteEntity cliente : iObtenerClientePorNombreCRUD.findByNombre(nombreCliente)) {

            Cliente nuevoCliente = new ClienteEntityMapper().mapeoDataCore(cliente);

            listaClientes.add(nuevoCliente);

        }

        return listaClientes;
    }


}
