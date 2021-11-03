package interactorUnitTest;
import Mockito.MockitoExtension;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import excepciones.PedidoExisteException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import interactor.ModificarPedidoUseCase;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import repositorio.IRepositorioModificarPedido;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;


@ExtendWith(MockitoExtension.class)
public class ModificarPedidoUnitTest {
	@Mock
	  IRepositorioModificarPedido modificarPedidoRepo;
	@Test
	public void modificarPedido_PedidoExistente_GuardaCambiosCorrectamente() throws BarrioIncompletoException, PizzaIncompletaException, ClienteIncompletoException, PedidoIncompletoException, PedidoExisteException {
		  Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
	        ArrayList<Pizza> items = new ArrayList<Pizza>();
	        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
	        Pizza laSegundaPizza=Pizza.factoryPizza(2,"Comun",200.00f,10);
	        items.add(laPizza);
	        items.add(laSegundaPizza);
	        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
	        LocalDateTime fecha = LocalDateTime.now();
	        Pedido elPedido=Pedido.factoryPedido(1,elCliente, fecha, items,  1 );
	        when(modificarPedidoRepo.findByNroPedido(1)).thenReturn(null);
	        when(modificarPedidoRepo.actualizar(elPedido)).thenReturn(true);
	        ModificarPedidoUseCase modificarPedidoUseCase = new ModificarPedidoUseCase(modificarPedidoRepo);
	        boolean resultadoActualizarPedido = modificarPedidoUseCase.actualizarPedido(elPedido);
	        Assertions.assertTrue(resultadoActualizarPedido);
	       
	}
	

}
