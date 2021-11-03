package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.ClienteDTOMapper;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PizzaDTOMapper;
import excepciones.ClienteExisteException;
import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import input.ICrearPizzaInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearPizzaController {

    private ICrearPizzaInput iCrearPizzaInput;

    public CrearPizzaController(ICrearPizzaInput iCrearPizzaInput) {
        this.iCrearPizzaInput = iCrearPizzaInput;
    }

    @RequestMapping(value = "pizza", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearPizza(@RequestBody PizzaDTO pizzaDTO)  {
        try {

            boolean respuesta = this.iCrearPizzaInput.crearPizza(new PizzaDTOMapper().mapeoDTOCore(pizzaDTO));
            if (respuesta) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (PizzaIncompletaException | PizzaExisteException ex ) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }

    }
}
