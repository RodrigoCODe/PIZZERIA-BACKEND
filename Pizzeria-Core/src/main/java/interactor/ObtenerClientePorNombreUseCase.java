package interactor;

import input.IObtenerClientePorNombreInput;
import modelo.Cliente;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.List;

public class ObtenerClientePorNombreUseCase implements IObtenerClientePorNombreInput {

    private IRepositorioObtenerClientePorNombre obtenerClientePorNombreGateway;

    public ObtenerClientePorNombreUseCase(IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre){

        this.obtenerClientePorNombreGateway = iRepositorioObtenerClientePorNombre;
    }


    public List<Cliente> obtenerClientePorNombre(String nombreCliente) {

        List<Cliente> nuevaLista = (List<Cliente>) obtenerClientePorNombreGateway.obtenerClientePorNombre(nombreCliente);

        return nuevaLista;
    }



}
