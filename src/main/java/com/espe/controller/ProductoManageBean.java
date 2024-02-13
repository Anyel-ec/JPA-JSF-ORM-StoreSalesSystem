package com.espe.controller;

import com.espe.dao.ProductoDAOImpl;
import com.espe.idao.IProductoDAO;
import com.espe.model.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class ProductoManageBean {
    private IProductoDAO productoDAO;
    private Producto producto;
    private List<Producto> productos;

    @PostConstruct
    public void init() {
        productoDAO = new ProductoDAOImpl();
        producto = new Producto();
        cargarProductos();
    }

    public void guardarProducto() {
        productoDAO.guardar(producto);
        limpiarFormulario();
        cargarProductos();
    }

    public void actualizarProducto() {
        productoDAO.actualizar(producto);
        limpiarFormulario();
        cargarProductos();
    }

    public void eliminarProducto(int id) {
        productoDAO.eliminar(id);
        cargarProductos();
    }

    public void cargarProductos() {
        productos = productoDAO.obtenerProductos();
    }

    public void seleccionarProducto(Producto producto) {
        this.producto = producto;
    }

    public void limpiarFormulario() {
        producto = new Producto();
    }

    // Getters and setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
