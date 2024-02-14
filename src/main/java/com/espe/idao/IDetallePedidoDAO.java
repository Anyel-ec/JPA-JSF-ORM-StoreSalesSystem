package com.espe.idao;

import com.espe.model.DetallePedido;
import com.espe.model.Producto;
import com.espe.model.Puesto;

import java.util.List;

public interface IDetallePedidoDAO {
    void guardar (DetallePedido detallePedido);
    void actualizar(DetallePedido detallePedido);
    DetallePedido buscarPorId(int id);
    List<DetallePedido> obtenerDetallePedido();
    void eliminar(int id);


}
