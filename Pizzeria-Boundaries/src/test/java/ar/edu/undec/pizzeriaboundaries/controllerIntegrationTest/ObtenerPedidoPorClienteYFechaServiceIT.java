package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.Controller.ObtenerPedidoPorClienteYFechaController;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.ClienteDTOMapper;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PedidoDTOMapper;
import excepciones.PedidoIncompletoException;
import input.IRepositorioObtenerPedidoPorClienteYFechaImput;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import repositorio.IRepositorioObtenerPedidoPorClienteYFecha;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerPedidoPorClienteYFechaServiceIT {
    @Mock
    IRepositorioObtenerPedidoPorClienteYFechaImput iRepositorioObtenerPedidoPorClienteYFechaImput;
    private List<PedidoDTO> pedidos = new ArrayList<>();

    private List<Pedido> factoryListPedido(List<PedidoDTO> pedidos) throws PedidoIncompletoException {
        List<Pedido> devolver = new ArrayList<>();
            for (PedidoDTO pedido : pedidos) {
                devolver.add(new PedidoDTOMapper().mapeoDTOCore(pedido));
            }
            return devolver;
    }


    @Test
    public void obtenerPedidoPorClienteYFecha_ClienteYFechasCorrectos_Devuelve200() throws PedidoIncompletoException {
        BarrioDTO barrio = new BarrioDTO(1,"Mayo");
        ClienteDTO cliente = new ClienteDTO(1,"Daniel","San Juan 570","37492933",barrio);
        PizzaDTO comun = new PizzaDTO(1,"Comun",150.0f,30);
        List<PizzaDTO> pedidas = new ArrayList<>();
        pedidas.add(comun);
        PedidoDTO pedido = new PedidoDTO(1,cliente, LocalDateTime.of(2019,11,19,22,0),pedidas,1);
        pedidos.add(pedido);
        when(iRepositorioObtenerPedidoPorClienteYFechaImput.obtenerPedidoPorClienteYfecha(new ClienteDTOMapper().mapeoDTOCore(cliente),LocalDateTime.of(2019,11,19,22,00))).thenReturn(this.factoryListPedido(pedidos));
        ObtenerPedidoPorClienteYFechaController controlador = new ObtenerPedidoPorClienteYFechaController(iRepositorioObtenerPedidoPorClienteYFechaImput);
        assertEquals(org.apache.http.HttpStatus.SC_OK,controlador.obtenerPedidoPorClienteYFecha(cliente,LocalDateTime.of(2019,11,19,22,00)).getStatusCodeValue());
    }
}
