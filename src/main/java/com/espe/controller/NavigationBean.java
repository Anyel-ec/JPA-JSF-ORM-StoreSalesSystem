package com.espe.controller;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jdk.jfr.Name;

@Named
@RequestScoped
public class NavigationBean {
    public String irClientes() {
        // Lógica para determinar a qué página redirigir
        return "/cliente/index.xhtml";
    }
    public String nuevoCliente() {
        // Lógica para determinar a qué página redirigir
        return "/cliente/nuevo.xhtml";
    }
    public String irProductos() {
        // Lógica para determinar a qué página redirigir
        return "/index.xhtml";
    }
    public String nuevoProducto() {
        // Lógica para determinar a qué página redirigir
        return "/producto/nuevo.xhtml";
    }

    public String irDetalles() {
        // Lógica para determinar a qué página redirigir
        return "/detalles/index.xhtml";
    }
    public String nuevoDetalle() {
        // Lógica para determinar a qué página redirigir
        return "/detalles/nuevo.xhtml";
    }
    public String irEmpleados() {
        // Lógica para determinar a qué página redirigir
        return "/empleado/index.xhtml";
    }

    public String nuevoEmpleado() {
        // Lógica para determinar a qué página redirigir
        return "/empleado/nuevo.xhtml";
    }

    public String irPedidos() {
        // Lógica para determinar a qué página redirigir
        return "/pedido/index.xhtml";
    }
    public String nuevoPedido() {
        // Lógica para determinar a qué página redirigir
        return "/pedido/nuevo.xhtml";
    }
}
