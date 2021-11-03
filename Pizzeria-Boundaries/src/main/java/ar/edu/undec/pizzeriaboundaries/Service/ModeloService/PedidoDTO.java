package ar.edu.undec.pizzeriaboundaries.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {

    @JsonProperty("id")
    private Integer idPedido;
    @JsonProperty("cliente")
    private ClienteDTO elCliente;
    @JsonProperty("fecha")
    private LocalDateTime fecha;
    @JsonProperty("numero")
    private Integer numeroPedido;
    @JsonProperty("items")
    private List<PizzaDTO> items;


    public PedidoDTO(@JsonProperty("id") Integer idPedido,
                      @JsonProperty("cliente") ClienteDTO elCliente,
                      @JsonProperty("fecha") LocalDateTime fecha,
                      @JsonProperty("items") List<PizzaDTO> items,
                      @JsonProperty("numero") Integer numeroPedido)
                      {

        this.idPedido = idPedido;
        this.elCliente = elCliente;
        this.fecha = fecha;
        this.items = items;
        this.numeroPedido = numeroPedido;

    }


    public Integer getIdPedido() {
        return idPedido;
    }

    public ClienteDTO getElCliente() {
        return elCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public List<PizzaDTO> getItems() {
        return items;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public void setElCliente(ClienteDTO elCliente) {
        this.elCliente = elCliente;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setItems(List<PizzaDTO> items) {
        this.items = items;
    }
}
