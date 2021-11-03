package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.ClienteDTOMapper;
import excepciones.ClienteExisteException;
import input.ICrearClienteInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearClienteController {

    private ICrearClienteInput iCrearClienteInput;

    public CrearClienteController (ICrearClienteInput iCrearClienteInput){
        this.iCrearClienteInput = iCrearClienteInput;
    }

    @RequestMapping(value = "cliente", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearCliente(@RequestBody ClienteDTO clienteDTO) throws ClienteExisteException {
       try {

            boolean respuesta = this.iCrearClienteInput.crearCliente(new ClienteDTOMapper().mapeoDTOCore(clienteDTO));
            if (respuesta) return ResponseEntity.status(HttpStatus.OK).body(true);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (ClienteExisteException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }

    }


}
