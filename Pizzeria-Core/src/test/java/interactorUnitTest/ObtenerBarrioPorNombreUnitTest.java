package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.BarrioIncompletoException;
import interactor.ObtenerBarrioPorNombreUseCase;
import modelo.Barrio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import repositorio.IObtenerBarrioPorNombre;

import java.util.ArrayList;
import java.util.List;

import static modelo.Barrio.factoryBarrio;

@ExtendWith(MockitoExtension.class)
public class ObtenerBarrioPorNombreUnitTest {

    @Mock
    IObtenerBarrioPorNombre obtenerBarrioPorNombre;

    @Spy
    List<Barrio> barriosList = factoryListaBarrios();

    @Test
    public void obtenerBarrioPorNombre_ExisteBarrio_devuelveBarrio(){
        Mockito.when(obtenerBarrioPorNombre.obtenerBarrioPorNombre("140 Lotes")).thenReturn(barriosList);
        ObtenerBarrioPorNombreUseCase buscarBarrio = new ObtenerBarrioPorNombreUseCase(obtenerBarrioPorNombre);
        List<Barrio> resultado = buscarBarrio.obtenerBarrioPorNombre("140 Lotes");
        Assertions.assertEquals(1,resultado.size());

    }

    private List<Barrio> factoryListaBarrios() {
        try {
            List<Barrio> barrios = new ArrayList<Barrio>();
            Barrio barrio= factoryBarrio(1, "140 Lotes");
            barrios.add(barrio);
            return barrios;
        } catch (BarrioIncompletoException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
