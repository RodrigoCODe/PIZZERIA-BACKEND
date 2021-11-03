package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import interactor.ModificarPizzaUseCase;
import modelo.Pizza;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioModificarPizza;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarPizzaUnitTest {

    @Mock
    private IRepositorioModificarPizza iRepositorioModificarPizza;

    @Test
    public void modificarPizza_modificarParametros_modificacionCorrecta() throws PizzaIncompletaException, PizzaExisteException {

        Pizza pizza = Pizza.factoryPizza(1, "Napolitana", 250.00f, 15);

        when(iRepositorioModificarPizza.findByNombrePizza("Napolitana")).thenReturn(null);
        when(iRepositorioModificarPizza.actualizarPizza(pizza)).thenReturn(true);

        ModificarPizzaUseCase modificarPizzaUseCase = new ModificarPizzaUseCase(iRepositorioModificarPizza);

        boolean respuesta = modificarPizzaUseCase.modificarPizza(pizza);

        assertTrue(respuesta);

    }

}

