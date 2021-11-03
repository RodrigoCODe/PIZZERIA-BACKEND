package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface IObtenerMontoIngresadoPorPedidoEntreFechasCRUD extends CrudRepository<PedidoEntity,Integer> {
}
