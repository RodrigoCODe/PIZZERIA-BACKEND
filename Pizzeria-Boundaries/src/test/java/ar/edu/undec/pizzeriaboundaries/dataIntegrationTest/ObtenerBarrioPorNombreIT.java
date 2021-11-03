package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerBarrioPorNombreRepoImpl;
import modelo.Barrio;
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
public class ObtenerBarrioPorNombreIT {
    @Autowired
    private ObtenerBarrioPorNombreRepoImpl obtenerBarrioPorNombreRepo;

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerBarrioPorNombreAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerBarrioPorNombreDespues.sql")
    })
    public void obtenerBarrioPorNombre_existenBarrios_devuelveBarrio() {
        List<Barrio> barrios = (List<Barrio>) obtenerBarrioPorNombreRepo.obtenerBarrioPorNombre("Siempre");
        assertEquals(1, barrios.size());
    }
}
