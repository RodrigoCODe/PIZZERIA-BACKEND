package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.ClienteDTOMapper;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import excepciones.FechaIncorrectaException;
import input.IRepositorioObtenerPedidoPorClienteYFechaImput;
import modelo.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

public class ObtenerPedidoPorClienteYFechaController {
    private IRepositorioObtenerPedidoPorClienteYFechaImput repositorio;
    public ObtenerPedidoPorClienteYFechaController(IRepositorioObtenerPedidoPorClienteYFechaImput repo) {
        this.repositorio = repo;
    }

    @RequestMapping(value = "pedido/cliente/fecha", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> obtenerPedidoPorClienteYFecha(@RequestBody ClienteDTO cliente,@RequestBody LocalDateTime fecha) {
        try{
            List<Pedido> resultado = this.repositorio.obtenerPedidoPorClienteYfecha(new ClienteDTOMapper().mapeoDTOCore(cliente),fecha);
            if(resultado.size() > 0)
                return ResponseEntity.status(HttpStatus.OK).body(resultado);
            else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
    }
}
