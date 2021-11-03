package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.BarrioEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IRepositorioCantidadBarriosCRUD;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IRepositorioObtenerCincoBarriosConMayorCantidadDePedidosCRUD;
import modelo.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioObtenerCincoBarriosConMayorCantidadDePedidos;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerCincoBarriosConMayorCantidadDePedidosRepoImpl implements IRepositorioObtenerCincoBarriosConMayorCantidadDePedidos {
    @Autowired
    IRepositorioObtenerCincoBarriosConMayorCantidadDePedidosCRUD repositorio;
    @Autowired
    IRepositorioCantidadBarriosCRUD repoBarrio;
    @Override
    public List<Barrio> obtenerCincoBarriosConMayorCantidadDePedidos() {
        List<Barrio> auxiliar = new ArrayList<>();
        List<Barrio> devolver = new ArrayList<>();
        List<BarrioEntity> todosLosBarrios = (List<BarrioEntity>) repoBarrio.findAll();
        List<PedidoEntity> todosLosPedidos = (List<PedidoEntity>) repositorio.findAll();
        List<Double> montoPorBarrio = new ArrayList<>();

        for (BarrioEntity barrio: todosLosBarrios ) {
            devolver.add(new BarrioEntityMapper().mapeoDataCore(barrio));
            auxiliar.add(new BarrioEntityMapper().mapeoDataCore(barrio));
        }

        Double contador = 0.0;
        Integer posicion = 0;
        for(Integer i = 0; i < todosLosBarrios.size();i++){
            for(PedidoEntity pedido : todosLosPedidos){
                if(pedido.getElCliente().getBarrio().getId_barrio().equals((i+1))){
                    for(PizzaEntity pizza : pedido.getItems()){
                        contador += pizza.getPrecio();
                    }
                }
            }
            montoPorBarrio.add(i,contador);
            contador = 0.0;
        }
        for(Integer i = 0; i < todosLosBarrios.size();i++){
            System.out.println("Barrio: " + (i+1)  + " nombre: " + todosLosBarrios.get(i).getNombre());
        }

        for(Integer i = 0; i < montoPorBarrio.size();i++){
            System.out.println("Barrio: " + (i+1)  + " Monto: " + montoPorBarrio.get(i));
        }


        //"devolver" tiene que estar ordenado de acuerdo al orden de monto por barrio,

        return devolver;
    }
}
