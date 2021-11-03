package input;


import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PedidosNoEncontradosException;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;

import java.time.LocalDate;
import java.util.HashMap;

public interface IObtenerPizzasMasVendidasFechasInput {

    HashMap<Pizza, Integer> obtenerPizzasMasVendidasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException, PedidosNoEncontradosException;
}
