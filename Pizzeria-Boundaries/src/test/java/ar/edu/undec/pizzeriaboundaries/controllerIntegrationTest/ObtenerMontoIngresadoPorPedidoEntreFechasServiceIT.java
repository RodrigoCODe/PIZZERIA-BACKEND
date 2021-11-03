package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ObtenerMontoIngresadoPorPedidoEntreFechasController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import input.IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerMontoIngresadoPorPedidoEntreFechasServiceIT {
    @Mock
    IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput repositorio;

    @Test
    public void obtenerMontoIngresadoPorPedidoEntreFechas_FechasCorrectas_Devuelve200(){
        BarrioDTO barrio = new BarrioDTO(1,"Mayo");
        ClienteDTO cliente = new ClienteDTO(1,"Daniel","San Juan 570","37492933",barrio);
        PizzaDTO comun = new PizzaDTO(1,"Comun",150.0f,30);
        PizzaDTO especial = new PizzaDTO(2,"Especial",200.0f,30);
        List<PizzaDTO> pedidasUno = new ArrayList<>();
        List<PizzaDTO> pedidasDos = new ArrayList<>();
        pedidasUno.add(comun);
        pedidasUno.add(comun);
        pedidasDos.add(comun);
        pedidasDos.add(especial);
        PedidoDTO primerPedido = new PedidoDTO(1,cliente, LocalDateTime.of(2019,11,18,22,0),pedidasUno,2);
        PedidoDTO segundoPedido = new PedidoDTO(2,cliente, LocalDateTime.of(2019,11,19,22,0),pedidasDos,2);
        when(repositorio.obtenerMontoIngresadoPorPedidoEntreFechas(LocalDate.of(2019,11,17),LocalDate.of(2019,11,20))).thenReturn(650.00);
        ObtenerMontoIngresadoPorPedidoEntreFechasController controlador = new ObtenerMontoIngresadoPorPedidoEntreFechasController(repositorio);
        assertEquals(org.apache.http.HttpStatus.SC_OK,controlador.obtenerMontoIngresadoPorPedidoEntreFechasImput(LocalDate.of(2019,11,17),LocalDate.of(2019,11,20)).getStatusCodeValue());

    }
}
