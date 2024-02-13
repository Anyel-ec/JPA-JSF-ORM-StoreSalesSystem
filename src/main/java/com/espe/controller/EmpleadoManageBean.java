package com.espe.controller;

import com.espe.dao.EmpleadoDAOImpl;
import com.espe.dao.PuestoDAOImpl;
import com.espe.idao.IEmpleadoDAO;
import com.espe.idao.IPuestoDAO;
import com.espe.model.Empleado;
import com.espe.model.Puesto;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class EmpleadoManageBean {
    private Empleado empleado = new Empleado();
    IPuestoDAO puestoDAO = new PuestoDAOImpl();

    // Crear un objeto de tipo IEmpleadoDAO
    IEmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

    @PostConstruct
    public void init() {
        empleado = new Empleado();
        empleado.setPuesto(new Puesto()); // Inicializar el objeto Puesto
    }


    // Método para guardar un empleado
    public String guardar(Empleado empleado) {
        empleadoDAO.guardar(empleado);
        // Limpiar el formulario
        this.empleado = new Empleado();
        // Mostrar un mensaje de éxito
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empleado agregado correctamente", "Empleado agregado correctamente"));
        return "/empleado/index.xhtml?faces-redirect=true";
    }


    // Método para actualizar un empleado
    public String actualizar(Empleado empleado) {
        empleadoDAO.actualizar(empleado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Empleado actualizado correctamente"));
        return "/empleado/index.xhtml?faces-redirect=true";
    }

    // Método para eliminar un empleado (soft delete)
    public void eliminar(int id) {
        empleadoDAO.actualizarEstado(id, Boolean.TRUE);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Empleado eliminado correctamente"));
    }

    // Método para obtener todos los empleados
    public List<Empleado> obtenerEmpleados() {
        return empleadoDAO.obtenerEmpleados();
    }

    // Método para editar un empleado
    public String editar(int id) {
        Empleado empleado = empleadoDAO.buscarPorId(id);
        if (empleado != null) {
            // Almacenar el empleado en el ámbito de sesión
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleadoEditado", empleado);
            return "/empleado/editar.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se encontró el empleado"));
            return null;
        }
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }




    // Método para obtener la lista de puestos
    public List<Puesto> getListaPuestos() {
        return puestoDAO.obtenerPuestos();
    }

}
