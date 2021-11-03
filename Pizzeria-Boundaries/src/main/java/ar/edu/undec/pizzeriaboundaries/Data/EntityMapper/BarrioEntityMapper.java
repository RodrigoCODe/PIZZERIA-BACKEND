package ar.edu.undec.pizzeriaboundaries.Data.EntityMapper;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import excepciones.BarrioIncompletoException;
import modelo.Barrio;

public class BarrioEntityMapper {

    public BarrioEntity mapeoCoreData(Barrio barrioCore) {
        BarrioEntity barrioEntity = new BarrioEntity();
        barrioEntity.setId_barrio(barrioCore.getIdBarrio());
        barrioEntity.setNombre(barrioCore.getNombre());
        return barrioEntity;
    }

    public Barrio mapeoDataCore(BarrioEntity barrioEntity) {
        try {
            return Barrio.factoryBarrio(barrioEntity.getId_barrio(), barrioEntity.getNombre());
        } catch (  BarrioIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }

}
