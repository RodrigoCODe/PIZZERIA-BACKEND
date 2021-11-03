package ar.edu.undec.pizzeriaboundaries.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarrioDTO {

    @JsonProperty("id")
    private Integer idBarrio;

    @JsonProperty("nombre")
    private String nombre;

    public BarrioDTO(@JsonProperty("id") Integer id,
                     @JsonProperty("nombre") String nombre) {
        this.idBarrio = id;
        this.nombre = nombre;
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
