package interactor;

import input.ObtenerCincoBarriosConMayorCantidadDePedidosInput;
import modelo.Barrio;
import repositorio.IRepositorioObtenerCincoBarriosConMayorCantidadDePedidos;

import java.util.List;

public class ObtenerCincoBarriosConMayorCantidadDePedidosUseCase implements ObtenerCincoBarriosConMayorCantidadDePedidosInput {

    private IRepositorioObtenerCincoBarriosConMayorCantidadDePedidos iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos;

    public ObtenerCincoBarriosConMayorCantidadDePedidosUseCase(IRepositorioObtenerCincoBarriosConMayorCantidadDePedidos iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos) {
        this.iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos = iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos;
    }

    @Override
    public List<Barrio> obtenerCincoBarriosConMayorCantidadDePedidos() {
        return this.iRepositorioObtenerCincoBarriosConMayorCantidadDePedidos.obtenerCincoBarriosConMayorCantidadDePedidos();
    }
}
