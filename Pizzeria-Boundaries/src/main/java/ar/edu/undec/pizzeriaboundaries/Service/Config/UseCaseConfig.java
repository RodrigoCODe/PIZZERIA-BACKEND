package ar.edu.undec.pizzeriaboundaries.Service.Config;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import interactor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.*;

@Configuration
public class UseCaseConfig {


    @Autowired
    private  IRepositorioObtenerPedidos iRepositorioObtenerPedidos;

    @Autowired
    private IRepositorioCrearPizza iRepositorioCrearPizza;

    @Autowired
    private IRepositorioModificarCliente iRepositorioModificarCliente;

    @Autowired
    private IRepositorioCrearBarrio iRepositorioCrearBarrio;

    @Autowired
    private IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre;

    @Autowired
    private IRepositorioCrearCliente iRepositorioCrearCliente;

    @Autowired
    private IObtenerBarrioPorNombre iObtenerBarrioPorNombre;

    @Autowired
    private IRepositorioModificarPizza iRepositorioModificarPizza;

    @Autowired
    private IRepositorioCrearPedido iRepositorioCrearPedido;

    @Autowired
    private IRepositorioModificarBarrio iRepositorioModificarBarrio;


    @Autowired
    private IRepositorioObtenerPizzaPorNombre iRepositorioObtenerPizzaPorNombre;


    @Autowired
    private IRepositorioModificarPedido modificarPedidoRepo;

    @Bean
    public ObtenerPizzasMasVendidasEntreFechasUseCase obtenerPizzasMasVendidasEntreFechasUseCase() { return new ObtenerPizzasMasVendidasEntreFechasUseCase(iRepositorioObtenerPedidos);}

    @Bean
    public ObtenerPedidosUseCase obtenerPedidosUseCase(){ return new ObtenerPedidosUseCase(iRepositorioObtenerPedidos);}

    @Bean
    public CrearPedidoUseCase crearPedidoUseCase(){ return new CrearPedidoUseCase(iRepositorioCrearPedido);}


    @Bean
    public CrearPizzaUseCase crearPizzaUseCase(){ return new CrearPizzaUseCase((iRepositorioCrearPizza));}

    @Bean
    public ModificarClienteUseCase modificarClienteUseCase(){ return new ModificarClienteUseCase(iRepositorioModificarCliente); }

    @Bean
    public ObtenerClientePorNombreUseCase obtenerClientePorNombreUseCase(){ return new ObtenerClientePorNombreUseCase(iRepositorioObtenerClientePorNombre); }

    @Bean
    public CrearClienteUseCase crearClienteUseCase(){
        return new CrearClienteUseCase(iRepositorioCrearCliente);
    }

    @Bean
    public CrearBarrioUseCase crearBarrioUseCase(){ return new CrearBarrioUseCase(iRepositorioCrearBarrio);}

    @Bean
    public ObtenerBarrioPorNombreUseCase obtenerBarrioPorNombreUseCase(){ return new ObtenerBarrioPorNombreUseCase(iObtenerBarrioPorNombre);}

    @Bean
    public ModificarPizzaUseCase modificarPizzaUseCase(){
        return new ModificarPizzaUseCase(iRepositorioModificarPizza);
    }

    @Bean
    public ModificarBarrioUseCase modificarBarrioUseCase(){
        return new ModificarBarrioUseCase(iRepositorioModificarBarrio);
    }

    @Bean
    public ObtenerPizzaPorNombreUseCase obtenerPizzaPorNombreUseCase(){
        return new ObtenerPizzaPorNombreUseCase(iRepositorioObtenerPizzaPorNombre);
    }

    @Bean
    public ModificarPedidoUseCase modificarPedidoUseCase(){
        return new ModificarPedidoUseCase(modificarPedidoRepo);
    }
}
