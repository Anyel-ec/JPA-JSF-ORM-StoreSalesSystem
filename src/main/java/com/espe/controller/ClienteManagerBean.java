package com.espe.controller;

import com.espe.dao.ClienteDAOImpl;
import com.espe.dao.ProductoDAOImpl;
import com.espe.idao.IClienteDAO;
import com.espe.idao.IProductoDAO;
import com.espe.model.Cliente;
import com.espe.model.Producto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
@Named
@RequestScoped
public class ClienteManagerBean {
    private Cliente cliente = new Cliente();


    // Crear un objeto de tipo IUsuarioDAO
    IClienteDAO clienteDAO = new ClienteDAOImpl();

    // Método para guardar un producto
    public String guardar(Cliente cliente) {
        clienteDAO.guardar(cliente);
        // Limpiar el formulario
        this.cliente = new Cliente();
        // Mostrar un mensaje de éxito
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente agregado correctamente", "Cliente agregado correctamente"));
        return "cliente/index.xhtml?faces-redirect=true";
    }


    // Método para actualizar un producto
    public String actualizar(Cliente cliente) {
        clienteDAO.actualizar(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Cliente actualizado correctamente"));
        return "/cliente/index.xhtml?faces-redirect=true";
    }


    // Método para eliminar un producto (soft delete)
    public void eliminar(int id) {
        clienteDAO.actualizarEstado(id, Boolean.TRUE);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Cliente eliminado correctamente"));

    }


    // Método para obtener todos los productos
    public List<Cliente> obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }

    // Método para editar un producto
    public String editar(int id) {
        Cliente cliente = clienteDAO.buscarPorId(id);
        if (cliente != null) {
            // Almacenar el producto en el ámbito de sesión
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteEditado", cliente);
            return "/cliente/editar.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se encontró el cliente"));
            return null;
        }
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}