package com.espe.idao;

import com.espe.model.Producto;

import java.util.List;

public interface IProductoDAO {
    void guardar (Producto producto);
    void actualizar(Producto producto);
    Producto buscarPorId(int id);
    List<Producto> obtenerProductos();
   void eliminar(int id);
   void actualizarEstado(int id, boolean eliminado);

}
