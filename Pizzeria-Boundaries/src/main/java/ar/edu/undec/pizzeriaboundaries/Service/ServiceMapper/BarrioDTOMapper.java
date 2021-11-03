package ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import excepciones.BarrioIncompletoException;
import modelo.Barrio;

public class BarrioDTOMapper {

    public Barrio mapeoDTOCore(BarrioDTO barrioDTO) {
        try {
            return Barrio.factoryBarrio(barrioDTO.getIdBarrio(), barrioDTO.getNombre());
        } catch (BarrioIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BarrioDTO mapeoCoreDTO(Barrio elBarrio) {

        BarrioDTO barrioDTO = new BarrioDTO(elBarrio.getIdBarrio(), elBarrio.getNombre());

        return barrioDTO;
    }
}
