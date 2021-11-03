package input;

import modelo.Cliente;
import modelo.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioObtenerPedidoPorClienteYFechaImput {
    List<Pedido> obtenerPedidoPorClienteYfecha(Cliente cliente, LocalDateTime fecha);
}
