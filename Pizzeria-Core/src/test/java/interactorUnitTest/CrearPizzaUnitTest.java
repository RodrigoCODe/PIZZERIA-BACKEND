package interactorUnitTest;


import Mockito.MockitoExtension;
import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import interactor.CrearPizzaUseCase;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearPizza;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearPizzaUnitTest {

    @Mock
    IRepositorioCrearPizza CrearPizzaGateway;

    @Test
    public void CrearPizza_PizzaNoExiste_GuardadoCorrecto() throws PizzaIncompletaException, PizzaExisteException {
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
        when(CrearPizzaGateway.guardar(laPizza)).thenReturn(true);
        CrearPizzaUseCase crearPizzaUseCase = new CrearPizzaUseCase(CrearPizzaGateway);
        boolean resultado = crearPizzaUseCase.crearPizza(laPizza);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void CrearPizza_PizzaExiste_PizzaExisteException() throws PizzaIncompletaException {
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
        when(CrearPizzaGateway.buscarPizzaPorNombre("Napolitana")).thenReturn(Pizza.factoryPizza(3,"Napolitana",275.00f, 15));
        CrearPizzaUseCase crearPizzaUseCase = new CrearPizzaUseCase(CrearPizzaGateway);
        Assertions.assertThrows(PizzaExisteException.class , ()-> crearPizzaUseCase.crearPizza(laPizza));
    }




}
