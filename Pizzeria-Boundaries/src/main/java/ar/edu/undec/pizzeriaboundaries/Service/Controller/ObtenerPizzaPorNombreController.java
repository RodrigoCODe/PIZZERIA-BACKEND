package ar.edu.undec.pizzeriaboundaries.Service.Controller;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PizzaDTOMapper;
import input.IObtenerPizzaPorNombreInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerPizzaPorNombreController {
    private IObtenerPizzaPorNombreInput iObtenerPizzaPorNombreInput;

    public ObtenerPizzaPorNombreController(IObtenerPizzaPorNombreInput iObtenerPizzaPorNombreInput) {
        this.iObtenerPizzaPorNombreInput = iObtenerPizzaPorNombreInput;
    }

    @RequestMapping(value = "pizza/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerPizzaPorNombre(@PathVariable("nombre") String nombrePizza) {
        try{
            List<PizzaDTO> pizzasDto= new ArrayList<>();
            this.iObtenerPizzaPorNombreInput.obtenerPizzaPorNombre(nombrePizza).forEach(pizza -> pizzasDto.add(new PizzaDTOMapper().mapeoCoreDTO(pizza)));
            if(pizzasDto.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(pizzasDto);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
