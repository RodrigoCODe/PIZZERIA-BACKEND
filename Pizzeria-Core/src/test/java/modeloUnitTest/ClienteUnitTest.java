package modeloUnitTest;

import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ClienteUnitTest {
    @Test
    void instanciar_ClienteClienteCompleto_InstanciaCorrecta() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elCliente= Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        assertNotNull(elCliente);
    }

    @Test
    void instanciarCliente_ClienteSinDocumento_ClienteInstanciaIncorrecta() throws BarrioIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Assertions.assertThrows(ClienteIncompletoException.class, ()-> Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"") );
    }

    @Test
    void instanciarCliente_ClienteConDocumentoRepetidoPeroElRestoDeDatosDiferentes_ClientesIguales() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elClienteUno= Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        Cliente elClienteDos= Cliente.factoryCliente(2,"Manuel Ruarte","La Plata",elBarrio,"39400500");
        assertEquals(elClienteUno, elClienteDos);
    }

}
    

