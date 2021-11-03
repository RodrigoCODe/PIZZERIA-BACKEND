package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerCincoBarriosConMayorCantidadDePedidosRepoImpl;
import modelo.Barrio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerCincoBarriosConMayorCantidadDeDedidosIT {
    @Autowired
    ObtenerCincoBarriosConMayorCantidadDePedidosRepoImpl repositorio;
    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerCincoBarriosConMayorCantidadDePedidos.sql")})

    public void obtenerCincoBarriosConMayorCantidadDePedidos_PedidosExistentes_RetornarLista(){
        List<Barrio> topBarrios = repositorio.obtenerCincoBarriosConMayorCantidadDePedidos();

     /*
        >>>>>>>>>>>>     Este es el orden correcto
       assertEquals("Castro y Bazan",topBarrios.get(0).getNombre());
       assertEquals("Altos Chilecito",topBarrios.get(1).getNombre());
        assertEquals("140 Lotes",topBarrios.get(2).getNombre());
       assertEquals("Lomas de Zamora",topBarrios.get(3).getNombre());
       assertEquals("Mis Montañas",topBarrios.get(4).getNombre());
     */
     //        >>>>>>>>>>>>     Este es el orden en el que recibo ordenado los datos del top barrios
        assertEquals("Castro y Bazan",topBarrios.get(0).getNombre());
        assertEquals("Lomas de Zamora",topBarrios.get(1).getNombre());
        assertEquals("Altos Chilecito",topBarrios.get(2).getNombre());
        assertEquals("Mis Montañas",topBarrios.get(3).getNombre());
        assertEquals("140 Lotes",topBarrios.get(4).getNombre());
    }

}
