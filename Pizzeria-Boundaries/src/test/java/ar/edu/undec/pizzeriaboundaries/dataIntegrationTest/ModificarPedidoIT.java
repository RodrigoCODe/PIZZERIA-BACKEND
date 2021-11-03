package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ActualizarPedidoRepoImpl;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarPedidoIT {

    @Autowired
    private ActualizarPedidoRepoImpl actualizarPedidoRepo;



    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarPedidoAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarPedidoDespues.sql")
    })
    @Test
    public void actualizarPedido_PedidoGuardado_devuelveTrue() throws PedidoIncompletoException, BarrioIncompletoException, ClienteIncompletoException, PizzaIncompletaException {
        Collection<Pizza> items = new ArrayList<>();
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
        Pizza laSegundaPizza=Pizza.factoryPizza(2,"Comun",200.00f,10);
        items.add(laPizza);
        items.add(laSegundaPizza);
        Barrio elBarrio=Barrio.factoryBarrio(1,"San Francisco");
        Cliente elCliente=Cliente.factoryCliente(1,"Rodrigo Alarcon","San Francisco",elBarrio,"28131367");
        LocalDateTime fecha = LocalDateTime.now();
        Pedido elPedido=Pedido.factoryPedido(null,elCliente, fecha, items,  1 );


        boolean resultado= actualizarPedidoRepo.actualizar(elPedido);
        assertTrue(resultado);
    }

}
