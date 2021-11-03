package modelo;

import excepciones.BarrioIncompletoException;

public class Barrio {

    private Integer idBarrio;
    private String nombre;


    private Barrio(Integer idBarrio, String nombre) {
        this.idBarrio = idBarrio;
        this.nombre = nombre;
    }

    public static Barrio factoryBarrio(Integer idBarrio, String nombre) throws BarrioIncompletoException {
        if( nombre == null || nombre == "") throw new BarrioIncompletoException();
        return new Barrio(idBarrio, nombre);

    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barrio)) return false;

        Barrio barrio = (Barrio) o;

        return getNombre().equals(barrio.getNombre());
    }

}
