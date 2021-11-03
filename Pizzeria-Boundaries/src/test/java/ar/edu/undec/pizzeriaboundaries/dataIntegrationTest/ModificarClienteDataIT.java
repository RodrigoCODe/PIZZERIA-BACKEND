package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;


import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ModificarClienteRepoImpl;

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
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarClienteAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarClienteDespues.sql")
})
public class ModificarClienteDataIT {
    @Autowired
    ModificarClienteRepoImpl actualizarClienteRepo;


    @Test
    public void actualizarCliente_ClienteGuardado_devuelveTrue() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio barrio = Barrio.factoryBarrio(1, "Altos de Chilecito");
        Cliente cliente= Cliente.factoryCliente(1, "Santiago","San Roman", barrio,"12312312");
        boolean resultado= actualizarClienteRepo.actualizar(cliente);
        assertTrue(resultado);
    }


}
