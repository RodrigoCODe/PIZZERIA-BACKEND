package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.PizzaIncompletaException;
import interactor.ObtenerBarrioPorNombreUseCase;
import interactor.ObtenerPizzaPorNombreUseCase;
import modelo.Barrio;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import repositorio.IRepositorioObtenerPizzaPorNombre;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerPizzaPorNombreUnitTest {

    @Mock
    IRepositorioObtenerPizzaPorNombre iRepositorioObtenerPizzaPorNombre;


    @Spy
    List<Pizza> listaPizza= factoryListaPizza();

    @Test
    public void buscarPizzaPorNombre_PizzaExiste_RetornaTrue(){
        Mockito.when(iRepositorioObtenerPizzaPorNombre.obtenerPizzaPorNombre("Anana")).thenReturn(listaPizza);
        ObtenerPizzaPorNombreUseCase obtenerPizza = new ObtenerPizzaPorNombreUseCase(iRepositorioObtenerPizzaPorNombre);
        List<Pizza> resultado = obtenerPizza.obtenerPizzaPorNombre("Anana");
        Assertions.assertEquals(1,resultado.size());
    }


    private List<Pizza> factoryListaPizza() {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        try {
            Pizza pizza = Pizza.factoryPizza(1,"Anana", 12.50f, 12);
            pizzas.add(pizza);

        } catch (PizzaIncompletaException e) {
            e.printStackTrace();
        }
            return pizzas;

    }

}
