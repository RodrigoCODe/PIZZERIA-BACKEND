package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ObtenerPizzaPorNombreController;
import excepciones.PizzaIncompletaException;
import input.IObtenerPizzaPorNombreInput;
import modelo.Pizza;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerPizzaPorNombreServiceIT {

    @Mock
    IObtenerPizzaPorNombreInput iObtenerPizzaPorNombreInput;

    @Spy
    List<Pizza> listaPizzas = factoryListaPizza();

    @Test
    public void obtenerPizzaPorNombre_PizzaExiste_Devuelve200() throws Exception {
        String nombrePizza = "Mozzarella";
        Mockito.when(iObtenerPizzaPorNombreInput.obtenerPizzaPorNombre(any(String.class))).thenReturn(listaPizzas);
        ObtenerPizzaPorNombreController obtenerPizzaPorNombreController = new ObtenerPizzaPorNombreController(iObtenerPizzaPorNombreInput);
        assertEquals(HttpStatus.SC_OK, obtenerPizzaPorNombreController.obtenerPizzaPorNombre(nombrePizza).getStatusCodeValue());
    }

    @Test
    public void obtenerPizzaPorNombre_PizzaNoExiste_Devuelve204() throws Exception {
        String nombrePizza = "AlgunaPizzaQueNoExiste";
        Mockito.when(iObtenerPizzaPorNombreInput.obtenerPizzaPorNombre(any(String.class))).thenReturn(new ArrayList<Pizza>());
        ObtenerPizzaPorNombreController obtenerPizzaPorNombreController = new ObtenerPizzaPorNombreController(iObtenerPizzaPorNombreInput);
        assertEquals(HttpStatus.SC_NO_CONTENT, obtenerPizzaPorNombreController.obtenerPizzaPorNombre(nombrePizza).getStatusCodeValue());

    }

    @Test
    public void obtenerPizzaPorNombre_PizzaNoExiste_Devuelve500() throws Exception {
        String nombrePizza = "AlgunaPizzaQueGeneraErrorEnElSistema";
        Mockito.when(iObtenerPizzaPorNombreInput.obtenerPizzaPorNombre(any(String.class))).thenReturn(null);
        ObtenerPizzaPorNombreController obtenerPizzaPorNombreController = new ObtenerPizzaPorNombreController(iObtenerPizzaPorNombreInput);
        assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, obtenerPizzaPorNombreController.obtenerPizzaPorNombre(nombrePizza).getStatusCodeValue());
    }

    private List<Pizza> factoryListaPizza() {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        try {
            Pizza pizza = Pizza.factoryPizza(1,"Anana", 12.50f, 12);
            pizzas.add(pizza);
            pizza = Pizza.factoryPizza(2,"Mozzarella", 12.50f, 12);
            pizzas.add(pizza);
        } catch (PizzaIncompletaException e) {
            e.printStackTrace();
        }
        return pizzas;

    }


}
