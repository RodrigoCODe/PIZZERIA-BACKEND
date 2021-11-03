package interactor;

import excepciones.FechaIncorrectaException;
import repositorio.IObtenerMontoIngresadoPorPedidoEntreFechas;

import java.time.LocalDate;

public class ObtenerMontoIngresadoPorPedidoEntreFechas {
    private IObtenerMontoIngresadoPorPedidoEntreFechas repositorio;
    public ObtenerMontoIngresadoPorPedidoEntreFechas(IObtenerMontoIngresadoPorPedidoEntreFechas repositorio) {
        this.repositorio = repositorio;
    }

    public Double obtenerMontoIngresadoPorPedidosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws FechaIncorrectaException {
        if((fechaInicio.isAfter(LocalDate.now()))||(fechaFin.isAfter(LocalDate.now())))
            throw new FechaIncorrectaException();
        else return repositorio.obtenerMontoIngresadoPorPedidoEntreFechas(fechaInicio,fechaFin);
    }
}
