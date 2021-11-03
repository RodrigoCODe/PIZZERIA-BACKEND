package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.BarrioDTOMapper;
import excepciones.BarrioExisteException;
import input.ICrearBarrioInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearBarrioController {

    private ICrearBarrioInput iCrearBarrioInput;

    public CrearBarrioController(ICrearBarrioInput crearBarrioInput) {
        this.iCrearBarrioInput = crearBarrioInput;
    }

    @RequestMapping(value = "barrio", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearBarrio(@RequestBody BarrioDTO barrio) {

        try {
            boolean resultado = this.iCrearBarrioInput.crearBarrio(new BarrioDTOMapper().mapeoDTOCore(barrio));
            if(resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (BarrioExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
