package repositorio;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Cliente;
import modelo.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioObtenerPedidoPorClienteYFecha {
   List<Pedido> obtenerPedidoPorClienteYFecha(Cliente cliente, LocalDateTime fecha) throws PedidoIncompletoException, PizzaIncompletaException;
}
