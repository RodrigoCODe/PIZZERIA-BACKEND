package ar.edu.undec.pizzeriaboundaries.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {

    @JsonProperty("id")
    private int idCliente;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("documento")
    private String documento;
    @JsonProperty("barrio")
    private BarrioDTO barrio;

    public ClienteDTO(@JsonProperty("id") int idCliente,
                      @JsonProperty("nombre") String nombre,
                      @JsonProperty("direccion") String direccion,
                      @JsonProperty("documento") String documento,
                      @JsonProperty("barrio") BarrioDTO barrio) {

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.documento = documento;
        this.barrio = barrio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public BarrioDTO getBarrio() {
        return barrio;
    }

    public void setBarrio(BarrioDTO barrio) {
        this.barrio = barrio;
    }
}
