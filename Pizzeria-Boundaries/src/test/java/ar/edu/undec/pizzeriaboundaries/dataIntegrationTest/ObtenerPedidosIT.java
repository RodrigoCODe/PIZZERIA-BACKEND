package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;


import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerPedidosRepoImpl;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import static org.testng.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerPedidosIT {

    @Autowired
    private ObtenerPedidosRepoImpl obtenerPedidosRepo;

    @Spy
    List<Pedido> losPedidos= new ArrayList<>();

    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerPedidosAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerPedidosDespues.sql")

    })

    @Test
    public void obtenerTodosLosPedidos_DevuelveListaCorrecta() throws PedidoIncompletoException, PizzaIncompletaException {

        losPedidos = obtenerPedidosRepo.obtenerPedidos();

        assertEquals(losPedidos.size(), 2);
    }

}
