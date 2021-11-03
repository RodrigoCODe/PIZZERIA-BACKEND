package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ModificarPizzaController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PizzaDTOMapper;
import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import input.IModificarPizzaInput;
import modelo.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarPizzaIT {


    @Mock
    IModificarPizzaInput iModificarPizzaInput;

    @Test
    public void modificarPizza_pizzaModificada_devuelveTrue() throws PizzaIncompletaException, PizzaExisteException {

        PizzaDTO pizzaActualizada = new PizzaDTO(1, "Muzzarella", 200.0f, 25);
        when(iModificarPizzaInput.modificarPizza(any(Pizza.class))).thenReturn(true);
        ModificarPizzaController modificarPizzaController = new ModificarPizzaController(iModificarPizzaInput);
        assertEquals(modificarPizzaController.modificarPizza(pizzaActualizada).getStatusCodeValue(), org.apache.http.HttpStatus.SC_OK);
    }




}
