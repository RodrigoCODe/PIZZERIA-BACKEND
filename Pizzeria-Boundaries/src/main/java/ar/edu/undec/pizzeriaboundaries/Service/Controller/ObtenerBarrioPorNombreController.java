package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.BarrioDTOMapper;
import input.IObtenerBarrioPorNombreInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerBarrioPorNombreController {

    private IObtenerBarrioPorNombreInput obtenerBarrioPorNombreInput;

    public ObtenerBarrioPorNombreController(IObtenerBarrioPorNombreInput obtenerBarrioPorNombreInput) {
        this.obtenerBarrioPorNombreInput = obtenerBarrioPorNombreInput;
    }

    @RequestMapping(value = "barrio/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerBarrioPorNombre(@PathVariable("nombre") String nombreBarrio) {
        try {
            List<BarrioDTO> barrios = new ArrayList<BarrioDTO>();
            this.obtenerBarrioPorNombreInput.obtenerBarrioPorNombre(nombreBarrio).forEach(br -> barrios.add(new BarrioDTOMapper().mapeoCoreDTO(br)));
            if (barrios.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(barrios);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
