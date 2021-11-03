package input;

import java.time.LocalDate;

public interface IRepositorioObtenerMontoIngresadoPorPedidoEntreFechasImput {
    Double obtenerMontoIngresadoPorPedidoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
