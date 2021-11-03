package ar.edu.undec.pizzeriaboundaries.Service.Controller;


import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PizzaDTOMapper;
import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import input.IModificarPizzaInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/")
public class ModificarPizzaController {

    private IModificarPizzaInput iModificarPizzaInput;

    public ModificarPizzaController (IModificarPizzaInput iModificarPizzaInput){
        this.iModificarPizzaInput = iModificarPizzaInput;
    }


    @RequestMapping(value = "pizza", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarPizza(@RequestBody PizzaDTO pizzaActualizada){
        try {
            boolean respuesta = iModificarPizzaInput.modificarPizza(new PizzaDTOMapper().mapeoDTOCore(pizzaActualizada));
            if(respuesta) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }catch (PizzaIncompletaException | PizzaExisteException ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);

        }

    }


}
