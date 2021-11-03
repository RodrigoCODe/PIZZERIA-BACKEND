package modelo;

import excepciones.PedidoIncompletoException;


import java.time.LocalDateTime;
import java.util.Collection;

public class Pedido {

    private Integer idPedido;
    private Cliente elCliente;
    private LocalDateTime fecha;
    private Integer numeroPedido;
    private Collection<Pizza> items;


    private Pedido(Integer idPedido, Cliente elCliente, LocalDateTime fecha, Collection<Pizza> items, Integer numeroPedido) {
        this.idPedido = idPedido;
        this.elCliente = elCliente;
        this.fecha = fecha;
        this.numeroPedido = numeroPedido;
        this.items = items;
    }

    public static Pedido factoryPedido(Integer idPedido, Cliente elCliente, LocalDateTime fecha, Collection<Pizza> items, Integer numeroPedido) throws PedidoIncompletoException {
        if(elCliente == null || fecha == null || numeroPedido == null || items == null || items.size() == 0) {
            throw new PedidoIncompletoException();
        }else{
            return new Pedido(idPedido, elCliente, fecha, items, numeroPedido);
        }

    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public Cliente getElCliente() {
        return elCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public Collection<Pizza> getItems() {
        return items;
    }
}
