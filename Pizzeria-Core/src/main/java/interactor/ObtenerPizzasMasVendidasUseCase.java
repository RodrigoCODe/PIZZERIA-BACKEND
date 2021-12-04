package interactor;

import repositorio.IRepositorioObtenerPedidos;

public class ObtenerPizzasMasVendidasUseCase {

    private IRepositorioObtenerPedidos obtenerPedidosGateWay;


    public ObtenerPizzasMasVendidasUseCase(IRepositorioObtenerPedidos obtenerPedidosGateWay) {
        this.obtenerPedidosGateWay = obtenerPedidosGateWay;
    }



}
