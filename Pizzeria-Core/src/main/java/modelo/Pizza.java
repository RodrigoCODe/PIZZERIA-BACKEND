package modelo;

import excepciones.PizzaIncompletaException;

public class Pizza {

    private Integer idPizza;
    private String nombre;
    private float precio;
    private Integer tiempoPreparacion;

    private Pizza(Integer idPizza, String nombre, float precio, Integer tiempoPreparacion) {
        this.idPizza = idPizza;
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public static Pizza factoryPizza(Integer idPizza, String nombre, float precio, Integer tiempoPreapracion) throws PizzaIncompletaException {
        if(idPizza == null || nombre == "" || nombre == null || precio == 0.0f || tiempoPreapracion== null){
            throw new PizzaIncompletaException();
        }else{
            return new Pizza(idPizza, nombre, precio, tiempoPreapracion);
        }
    }



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
}
