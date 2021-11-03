package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;


import ar.edu.undec.pizzeriaboundaries.Service.Controller.CrearClienteController;
import ar.edu.undec.pizzeriaboundaries.Service.Controller.CrearPizzaController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import excepciones.ClienteExisteException;
import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import input.ICrearPizzaInput;
import modelo.Cliente;
import modelo.Pizza;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearPizzaServiceIT {

    @Mock
    private ICrearPizzaInput iCrearPizzaInput;

    @Test
    public void crearPizza_PizzaCreada_devuelveTrue() throws PizzaIncompletaException, PizzaExisteException {

        PizzaDTO nuevaPizza = new PizzaDTO(1, "Napolitana", 250, 15);

        when(iCrearPizzaInput.crearPizza(any(Pizza.class))).thenReturn(true);
        CrearPizzaController crearPizzaController = new CrearPizzaController(iCrearPizzaInput);
        assertEquals(crearPizzaController.crearPizza(nuevaPizza).getStatusCodeValue(), HttpStatus.SC_OK);

    }

}
