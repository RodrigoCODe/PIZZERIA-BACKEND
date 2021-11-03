package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.BarrioEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.ICrearBarrioCRUD;
import modelo.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioCrearBarrio;

@Service
public class CrearBarrioRepoImpl implements IRepositorioCrearBarrio {

    @Autowired
    ICrearBarrioCRUD iCrearBarrioCRUD;

    @Override
    public boolean guardar(Barrio barrio) {
        BarrioEntity barrioEntity = new BarrioEntityMapper().mapeoCoreData(barrio);
        return iCrearBarrioCRUD.save(barrioEntity).getId_barrio() != null;
    }

    @Override
    public Barrio buscarBarrioPorNombre(String nombreBarrio) {
        BarrioEntity barrioEntity = iCrearBarrioCRUD.findByNombre(nombreBarrio);
        if (barrioEntity != null)
            return new BarrioEntityMapper().mapeoDataCore(barrioEntity);
        return null;
    }
}
