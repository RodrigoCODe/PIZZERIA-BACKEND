package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.BarrioEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerBarrioPorNombreCRUD;
import modelo.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerBarrioPorNombre;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerBarrioPorNombreRepoImpl implements IObtenerBarrioPorNombre {

    @Autowired
    IObtenerBarrioPorNombreCRUD iObtenerBarrioPorNombreCRUD;

    @Override
    public List<Barrio> obtenerBarrioPorNombre(String nombre) {
        List<Barrio> barrios = new ArrayList<>();
        for (BarrioEntity barrio: iObtenerBarrioPorNombreCRUD.findByNombreContains(nombre)) {
            Barrio barrioDos = new BarrioEntityMapper().mapeoDataCore(barrio);
            barrios.add(barrioDos);
        }
        return barrios;
    }
}
