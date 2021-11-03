package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;


import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.CrearBarrioRepoImpl;
import excepciones.BarrioIncompletoException;
import modelo.Barrio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearBarrioAntesUno.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearBarrioDespues.sql")
})
public class CrearBarrioIT {

    @Autowired
    CrearBarrioRepoImpl crearBarrioRepo;

    @Test
    public void crearBarrio_BarrioNoExiste_BarrioGuardado() throws BarrioIncompletoException {
        Barrio barrio = Barrio.factoryBarrio(null, "Castro y Bazan");
        boolean resultado = crearBarrioRepo.guardar(barrio);
        Assert.assertTrue(resultado);
    }



}
