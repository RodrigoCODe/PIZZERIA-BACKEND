package modeloUnitTest;

import excepciones.PizzaIncompletaException;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PizzaUnitTest {
    @Test
    void instanciarPizza_PizzaCompleta_InstanciaCorrecta() throws PizzaIncompletaException {
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
        assertNotNull(laPizza);
    }

    @Test
    void instanciarPizza_PizzaSinNombre_PizzaInstanciaIncorrecta() {
        Assertions.assertThrows(PizzaIncompletaException.class, ()-> Pizza.factoryPizza(1,"",250.00f,15) );
    }



}
