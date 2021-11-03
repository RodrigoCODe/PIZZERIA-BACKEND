package ar.edu.undec.pizzeriaboundaries.Service.Controller;


import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;

import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PedidoDTOMapper;

import excepciones.PedidoExisteException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import input.ICrearPedidoInput;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearPedidoController {


    private ICrearPedidoInput iCrearPedidoInputt;

    public CrearPedidoController(ICrearPedidoInput iCrearPedidoInputt) {

        this.iCrearPedidoInputt = iCrearPedidoInputt;
    }

    @RequestMapping(value = "pedido", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearPedido(@RequestBody PedidoDTO pedidoDTO)  {
       try{

            boolean respuesta = this.iCrearPedidoInputt.crearPedido(new PedidoDTOMapper().mapeoDTOCore(pedidoDTO));
            if (respuesta) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
            catch (PizzaIncompletaException | PedidoIncompletoException | PedidoExisteException ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }

           }


}
