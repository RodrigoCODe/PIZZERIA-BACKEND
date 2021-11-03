package interactor;

import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Cliente;
import modelo.Pedido;
import repositorio.IRepositorioObtenerPedidoPorClienteYFecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObtenerPedidoPorClienteYFecha {
    private  IRepositorioObtenerPedidoPorClienteYFecha repositorio;

    public ObtenerPedidoPorClienteYFecha(IRepositorioObtenerPedidoPorClienteYFecha repositorio) {
       this.repositorio = repositorio;
    }

    public List<Pedido> obtenerPedidoPorClienteYFecha(Cliente cliente, LocalDateTime fecha) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException {
        if(fecha.isAfter(LocalDateTime.now()))
            throw new FechaIncorrectaException();
        else return repositorio.obtenerPedidoPorClienteYFecha(cliente,fecha);
    }
}
