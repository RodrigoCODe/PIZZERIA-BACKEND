package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerClientePorNombreRepoImpl;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.testng.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerClientePorNombreIT {

    @Autowired
    private ObtenerClientePorNombreRepoImpl obtenerClientePorNombreRepo;

    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerClientePorNombreAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerClientePorNombreDespues.sql")
    })

    @Test
    public void obtenerClientePorNombre_clienteDevuelto_clienteCorrecto() throws BarrioIncompletoException, ClienteIncompletoException {

        List<Cliente> misClientes = obtenerClientePorNombreRepo.obtenerClientePorNombre("Jose");

       assertEquals(misClientes.size(),1);


    }



}
