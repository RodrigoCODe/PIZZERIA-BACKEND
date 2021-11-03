package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.BarrioDTOMapper;
import excepciones.BarrioExisteException;
import input.IModificarBarrioInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ModificarBarrioController {


    private IModificarBarrioInput iModificarBarrioInput;

    public ModificarBarrioController (IModificarBarrioInput iModificarBarrioInput){
        this.iModificarBarrioInput = iModificarBarrioInput;
    }


    @RequestMapping(value = "barrio", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarBarrio(@RequestBody BarrioDTO barrioDTO){

        try{

            boolean respuesta = iModificarBarrioInput.modificarBarrio(new BarrioDTOMapper().mapeoDTOCore(barrioDTO));
            if(respuesta) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (BarrioExisteException ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);

        }


    }



}
