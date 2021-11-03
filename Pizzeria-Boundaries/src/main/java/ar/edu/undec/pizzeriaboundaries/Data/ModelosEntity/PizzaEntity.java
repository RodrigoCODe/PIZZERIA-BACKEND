package ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity;


import javax.persistence.*;


@Entity
@Table(name="Pizzas")
@SequenceGenerator(name= "seq_pizzas", sequenceName = "seq_pizzas", initialValue = 1, allocationSize =1 )
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pizzas")
    private Integer idPizza;
    private String nombre;
    private float precio;
    private Integer tiempoPreparacion;

    public PizzaEntity(){}

    public Integer getIdPizza() {
        return idPizza;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setIdPizza(Integer idPizza) {
        this.idPizza = idPizza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
}
