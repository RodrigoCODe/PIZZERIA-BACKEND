package ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public class PizzaDTOMapper {

    public Pizza mapeoDTOCore(PizzaDTO pizzaDTO){
        try {
            return Pizza.factoryPizza(pizzaDTO.getIdPizza(), pizzaDTO.getNombre(), pizzaDTO.getPrecio(), pizzaDTO.getTiempoPreparacion());
        }catch (PizzaIncompletaException ex){
            ex.printStackTrace();
            return null;
        }

    }



    public PizzaDTO mapeoCoreDTO(Pizza pizza) {

        PizzaDTO pizzaDTO = new PizzaDTO(pizza.getIdPizza(), pizza.getNombre(), pizza.getPrecio(),pizza.getTiempoPreparacion());

        return pizzaDTO;
    }

}
