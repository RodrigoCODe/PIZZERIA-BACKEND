package interactorUnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import Mockito.MockitoExtension;
import excepciones.BarrioExisteException;
import excepciones.BarrioIncompletoException;
import interactor.ModificarBarrioUseCase;
import interactor.ModificarPedidoUseCase;
import modelo.Barrio;
import repositorio.IRepositorioModificarBarrio;
import repositorio.IRepositorioModificarPedido;
@ExtendWith(MockitoExtension.class)
public class ModificarBarrioUnitTest {
	@Mock 
	IRepositorioModificarBarrio modificarBarrioRepo;
	

	@Test 
	public void modificarBarrio_BarrioExiste_GuardarBarrioCorrectamente() throws BarrioIncompletoException, BarrioExisteException{
		 Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
		 when(modificarBarrioRepo.findByNombre("Centro")).thenReturn(null);
	     when(modificarBarrioRepo.actualizar(elBarrio)).thenReturn(true);
	     ModificarBarrioUseCase modificarBarrioUseCase = new ModificarBarrioUseCase(modificarBarrioRepo);
	     boolean resultadoActualizarBarrio = modificarBarrioUseCase.modificarBarrio(elBarrio);
	     Assertions.assertTrue(resultadoActualizarBarrio);
	}
}
