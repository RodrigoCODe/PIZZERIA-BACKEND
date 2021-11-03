package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PizzaEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerPizzaPorNombreCRUD;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioObtenerPizzaPorNombre;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerPizzaPorNombreRepoImpl implements IRepositorioObtenerPizzaPorNombre {

    @Autowired
    IObtenerPizzaPorNombreCRUD iObtenerPizzaPorNombreCRUD;

    @Override
    public List<Pizza> obtenerPizzaPorNombre(String nombre) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        for (PizzaEntity pizza: iObtenerPizzaPorNombreCRUD.findByNombreContains(nombre)) {
            try {
                Pizza pizzaDos = new PizzaEntityMapper().mapeoDataCore(pizza);
                pizzas.add(pizzaDos);
            } catch (PizzaIncompletaException e) {
                e.printStackTrace();
            }
        }
        return pizzas;
    }
}

