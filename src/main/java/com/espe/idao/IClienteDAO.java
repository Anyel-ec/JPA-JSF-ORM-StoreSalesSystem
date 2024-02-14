package com.espe.idao;

import com.espe.model.Cliente;
import com.espe.model.Producto;

import java.util.List;

public interface IClienteDAO {
    void guardar (Cliente cliente);
    void actualizar(Cliente cliente);
    Cliente buscarPorId(int id);
    List<Cliente> obtenerClientes();
    void eliminar(int id);
    void actualizarEstado(int id, boolean eliminado);
}