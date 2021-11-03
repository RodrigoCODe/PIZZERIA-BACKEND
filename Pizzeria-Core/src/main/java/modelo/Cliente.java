package modelo;

import excepciones.ClienteIncompletoException;

public class Cliente {

    private Integer idCliente;
    private String nombre;
    private String direccion;
    private Barrio elBarrio;
    private String documento;


    private Cliente(Integer idCliente, String nombre, String direccion, Barrio elBarrio, String documento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.elBarrio = elBarrio;
        this.documento = documento;
    }

    public static Cliente factoryCliente(Integer idCliente, String nombre, String direccion, Barrio elBarrio, String documento) throws ClienteIncompletoException {
        if(idCliente== null || nombre == null || nombre =="" || direccion == null || direccion == "" ||
                elBarrio==null || documento ==null || documento==""){
            throw new ClienteIncompletoException();
        }else{
            return new Cliente(idCliente, nombre, direccion, elBarrio, documento);
        }
    }



    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Barrio getElBarrio() {
        return elBarrio;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        return getDocumento().equals(cliente.getDocumento());
    }

}
