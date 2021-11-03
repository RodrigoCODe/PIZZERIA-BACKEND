package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerMontoIngresadoPorPedidoEntreFechasRepoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerMontoIngresadoPorPedidoEntreFechasIT {
    @Autowired
    private ObtenerMontoIngresadoPorPedidoEntreFechasRepoImpl repositorio;
    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerMontoIngresadoPorPedidoEntreFechasAntes.sql")
    })
    public void obtenerMontoIngresadoPorPedidoEntreFechas_FechasIngresadasCorrectamente_ObtenerMonto(){
       Double valorEsperado = 850.0;
       assertEquals(valorEsperado,repositorio.obtenerMontoIngresadoPorPedidoEntreFechas(
               LocalDate.of(2019,11,14), LocalDate.of(2019,11,20)));
    }
}
