package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerPizzaPorNombreRepoImpl;
import modelo.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerPizzaPorNombreAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerPizzaPorNombreDespues.sql")
})
public class ObtenerPizzaPorNombreIT {

    @Autowired
    private ObtenerPizzaPorNombreRepoImpl obtenerPizzaPorNombreRepo;


    @Test
    public void obtenerPizzaPorNombre_ExistenPizzaEnBD_DevuelvePizza() {
        List<Pizza> pizzas = obtenerPizzaPorNombreRepo.obtenerPizzaPorNombre("Mozzarella");
        assertEquals(1, pizzas.size());
    }
}
