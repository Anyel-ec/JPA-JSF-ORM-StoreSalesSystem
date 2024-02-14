package com.espe.idao;

import com.espe.model.Pedido;

import java.util.List;

public interface IPedidoDAO {
    void guardar (Pedido pedido);
    void actualizar(Pedido pedido);
    Pedido buscarPorId(int id);
    List<Pedido> obtenerPedidos();
    void eliminar(int id);
}
