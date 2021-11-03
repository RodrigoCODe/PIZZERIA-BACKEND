package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerPedidoPorClienteYFechaRepoImpl;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerPedidoPorClienteYFechaIT {
    @Autowired
    private ObtenerPedidoPorClienteYFechaRepoImpl repositorio;
    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerPedidoPorClienteYFechaAntes.sql")
    })
    public void obtenerPedidoPorClienteYFecha_ClienteYFechaCorrectos_DevolverPedidos() throws BarrioIncompletoException, ClienteIncompletoException, PedidoIncompletoException, PizzaIncompletaException {
        ArrayList<Pizza> primerEncargo = new ArrayList<>();
        Barrio barrio = Barrio.factoryBarrio(1, "Nueva Italia");
        Cliente cliente = Cliente.factoryCliente(1,"Federico", "San Juan 570", barrio,
                "37492933");
        List<Pedido> resultado = new ArrayList();;
        assertEquals(3, repositorio.obtenerPedidoPorClienteYFecha(cliente, LocalDateTime.of(2019,11,19,0,0)).size());
    }
}
