package interactorUnitTest;


import Mockito.MockitoExtension;
import excepciones.BarrioExisteException;
import excepciones.BarrioIncompletoException;
import interactor.CrearBarrioUseCase;
import modelo.Barrio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearBarrio;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearBarrioUnitTest {

    @Mock
    IRepositorioCrearBarrio CrearBarrioGateWay;

    @Test
    public void CrearBarrio_BarrioNoExiste_GuardadoCorrecto() throws BarrioIncompletoException, BarrioExisteException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        when(CrearBarrioGateWay.guardar(elBarrio)).thenReturn(true);
        CrearBarrioUseCase crearBarrioUseCase = new CrearBarrioUseCase(CrearBarrioGateWay);
        boolean resultado = crearBarrioUseCase.crearBarrio(elBarrio);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void CrearBarrio_BarrioExiste_BarrioExisteException() throws BarrioIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        when(CrearBarrioGateWay.buscarBarrioPorNombre("Centro")).thenReturn(Barrio.factoryBarrio(2, "Centro"));
        CrearBarrioUseCase crearBarrioUseCase = new CrearBarrioUseCase(CrearBarrioGateWay);
        Assertions.assertThrows(BarrioExisteException.class, ()-> crearBarrioUseCase.crearBarrio(elBarrio));
    }

}
