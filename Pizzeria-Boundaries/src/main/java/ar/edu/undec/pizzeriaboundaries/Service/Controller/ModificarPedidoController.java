package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PedidoDTOMapper;
import excepciones.PedidoExisteException;
import excepciones.PedidoIncompletoException;
import input.IModificarPedidoInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ModificarPedidoController {
    private IModificarPedidoInput modificarPedidoInput;

    public ModificarPedidoController() {
        this.modificarPedidoInput = modificarPedidoInput;
    }

    public ModificarPedidoController(IModificarPedidoInput iModificarPedidoInput) {
        this.modificarPedidoInput = iModificarPedidoInput;
    }

    @RequestMapping(value = "Pedido", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarPedido(@RequestBody PedidoDTO PedidoAModificar) {
        try{
            boolean resultado = this.modificarPedidoInput.modificarPedido(new PedidoDTOMapper().mapeoDTOCore(PedidoAModificar));
            if(resultado)return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception | PedidoIncompletoException | PedidoExisteException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }

    }
}
