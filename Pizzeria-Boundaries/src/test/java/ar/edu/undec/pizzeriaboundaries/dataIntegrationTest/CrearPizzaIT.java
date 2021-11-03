package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.CrearPizzaRepositorioImplementacion;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearPizzaIT {

    @Autowired
    CrearPizzaRepositorioImplementacion CrearPizzaRepo;

    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearPizzaAntes.sql")
    })

    @Test
    public void CrearPizza_PizzaNoExiste_GuardadoCorrecto() throws PizzaIncompletaException {
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
        boolean resultado = CrearPizzaRepo.guardar(laPizza);
        assertTrue(resultado);
    }








}
