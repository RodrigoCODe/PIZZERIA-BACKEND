package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ModificarPizzaRepoImpl;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarPizzaIT {

    @Autowired
    private ModificarPizzaRepoImpl modificarPizzaRepo;

    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarPizzaAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarPizzaDespues.sql")
    })

    @Test
    public void actualizarPizza_nuevaPizza_devuelveTrue() throws PizzaIncompletaException {

        Pizza pizza = Pizza.factoryPizza(1, "Napolitana", 250.00f, 15);

        boolean respuesta = modificarPizzaRepo.actualizarPizza(pizza);

        assertTrue(respuesta);

    }

}
