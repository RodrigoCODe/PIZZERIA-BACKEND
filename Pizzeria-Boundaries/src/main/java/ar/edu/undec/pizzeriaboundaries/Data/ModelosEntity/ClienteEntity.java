package ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity;


import javax.persistence.*;

@Entity(name = "clientes")
@SequenceGenerator(name = "seq_clientes", sequenceName = "seq_clientes", initialValue = 1, allocationSize = 1)
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clientes")
    private Integer id_cliente;

    private String nombre;
    private String direccion;
    private String documento;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_barrio")
    private BarrioEntity barrio;

    public ClienteEntity(){

    }

    public Integer getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public BarrioEntity getBarrio() {
        return barrio;
    }

    public void setBarrio(BarrioEntity barrio) {
        this.barrio = barrio;
    }
}
