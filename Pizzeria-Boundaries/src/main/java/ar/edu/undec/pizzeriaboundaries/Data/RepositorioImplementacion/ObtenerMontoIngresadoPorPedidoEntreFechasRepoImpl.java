package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IObtenerMontoIngresadoPorPedidoEntreFechasCRUD;
import modelo.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerMontoIngresadoPorPedidoEntreFechas;

import java.time.LocalDate;
import java.util.List;

@Service
public class ObtenerMontoIngresadoPorPedidoEntreFechasRepoImpl implements IObtenerMontoIngresadoPorPedidoEntreFechas {
    @Autowired
    IObtenerMontoIngresadoPorPedidoEntreFechasCRUD obtenerPedidoCrud;
    @Override
    public Double obtenerMontoIngresadoPorPedidoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<PedidoEntity> pedidos = (List<PedidoEntity>) obtenerPedidoCrud.findAll();
        Double total = 0.0;
        for(PedidoEntity pedido : pedidos){
            if((fechaInicio.isBefore(pedido.getFecha().toLocalDate())) && (fechaFin.isAfter(pedido.getFecha().toLocalDate()))){
                for(PizzaEntity pizza : pedido.getItems())
                    total += pizza.getPrecio();
            }
        }
        return total;
    }
}
