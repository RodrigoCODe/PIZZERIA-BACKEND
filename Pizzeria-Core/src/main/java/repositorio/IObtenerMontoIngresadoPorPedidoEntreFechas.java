package repositorio;

import java.time.LocalDate;

public interface IObtenerMontoIngresadoPorPedidoEntreFechas {
    public Double obtenerMontoIngresadoPorPedidoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
