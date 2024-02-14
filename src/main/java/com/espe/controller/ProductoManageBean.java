package com.espe.controller;

import com.espe.dao.ProductoDAOImpl;
import com.espe.idao.IProductoDAO;
import com.espe.model.Producto;
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
public class ProductoManageBean {
    private Producto producto = new Producto();


    // Crear un objeto de tipo IUsuarioDAO
    IProductoDAO productoDAO = new ProductoDAOImpl();

    // Método para guardar un producto
    public String guardar(Producto producto) {
        productoDAO.guardar(producto);
        // Limpiar el formulario
        this.producto = new Producto();
        // Mostrar un mensaje de éxito
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto agregado correctamente", "Producto agregado correctamente"));
        return "/producto/listar.xhtml?faces-redirect=true";
    }


    // Método para actualizar un producto
    public String actualizar(Producto producto) {
        productoDAO.actualizar(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto actualizado correctamente"));
        return "/index.xhtml?faces-redirect=true";
    }


    // Método para eliminar un producto (soft delete)
    public void eliminar(int id) {
        productoDAO.actualizarEstado(id, Boolean.TRUE);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto eliminado correctamente"));
    }


    // Método para obtener todos los productos
    public List<Producto> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }

    // Método para editar un producto
    public String editar(int id) {
        Producto producto = productoDAO.buscarPorId(id);
        if (producto != null) {
            // Almacenar el producto en el ámbito de sesión
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("productoEditado", producto);
            return "/producto/editar.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se encontró el producto"));
            return null;
        }
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}