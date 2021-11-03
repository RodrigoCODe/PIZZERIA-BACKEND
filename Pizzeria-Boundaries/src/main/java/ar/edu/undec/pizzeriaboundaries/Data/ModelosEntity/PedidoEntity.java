package ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "Pedidos")
@SequenceGenerator(name = "seq_pedidos", sequenceName = "seq_pedidos", initialValue = 1, allocationSize = 1)
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedidos")
    private Integer idPedido;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name= "id_Cliente")
    private ClienteEntity elCliente;

    private LocalDateTime fecha;
    private Integer numeroPedido;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "pizzasPorPedido", joinColumns = {@JoinColumn(name="idPedido")}, inverseJoinColumns = { @JoinColumn(name="idPizza")})
    private Collection<PizzaEntity> items;

    public PedidoEntity() {
        items = new ArrayList<PizzaEntity>();
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public ClienteEntity getElCliente() {
        return elCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public Collection<PizzaEntity> getItems() {
        return items;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public void setElCliente(ClienteEntity elCliente) {
        this.elCliente = elCliente;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setItems(Collection<PizzaEntity> items) {
        this.items = items;
    }
}
