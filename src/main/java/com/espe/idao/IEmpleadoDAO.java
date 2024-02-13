package com.espe.idao;

import com.espe.model.Empleado;
import com.espe.model.Producto;

import java.util.List;

public interface IEmpleadoDAO {

    void guardar (Empleado empleado);
    void actualizar(Empleado empleado);
    Empleado buscarPorId(int id);
    List<Empleado> obtenerEmpleados();
    void eliminar(int id);
    void actualizarEstado(int id, boolean eliminado);
}
