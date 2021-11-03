package modeloUnitTest;

import excepciones.BarrioIncompletoException;
import modelo.Barrio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BarrioUnitTest {

    @Test
    void instanciarBarrio_BarrioCompleto_InstanciaCorrecta() throws BarrioIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        assertNotNull(elBarrio);
    }

    @Test
    void instanciarBarrio_BarrioSinNombreBarrio_InstanciaIncorrecta() {
        Assertions.assertThrows(BarrioIncompletoException.class, ()-> Barrio.factoryBarrio(1,"") );
    }

    @Test
    void instanciarBarrio_BarrioNombreIgual_BarriorIguales() throws BarrioIncompletoException {
        Barrio barrioUno=Barrio.factoryBarrio(1,"Centro");
        Barrio barrioDos=Barrio.factoryBarrio(2,"Centro");
        assertEquals(barrioUno, barrioDos);

    }

    
    
    
}
