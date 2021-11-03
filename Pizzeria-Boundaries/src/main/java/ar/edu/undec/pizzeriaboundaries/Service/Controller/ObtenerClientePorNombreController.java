package ar.edu.undec.pizzeriaboundaries.Service.Controller;


import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.ClienteDTOMapper;
import input.IObtenerClientePorNombreInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ObtenerClientePorNombreController {


    private IObtenerClientePorNombreInput iObtenerClientePorNombreInput;

    public ObtenerClientePorNombreController(IObtenerClientePorNombreInput iObtenerClientePorNombreInput){
        this.iObtenerClientePorNombreInput = iObtenerClientePorNombreInput;
    }

    @RequestMapping(value = "cliente/nombre/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> obtenerClientePorNombre(@PathVariable("nombre") String nombre){

        try{

            List<ClienteDTO> misClientes = new ArrayList<>();
            this.iObtenerClientePorNombreInput.obtenerClientePorNombre(nombre).forEach(cliente -> misClientes.add(new ClienteDTOMapper().mapetoCoreDTO(cliente)));
            if(misClientes.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(misClientes);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }


}
