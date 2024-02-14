package com.espe.controller;

import com.espe.dao.*;
import com.espe.idao.*;
import com.espe.model.Cliente;
import com.espe.model.Empleado;
import com.espe.model.EstadoPedido;
import com.espe.model.Pedido;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class PedidoManageBean {
    private Pedido pedido = new Pedido();

    IProductoDAO productoDAO = new ProductoDAOImpl();
    IEstadoPedido estadoPedidoDAO = new EstadoPedidoDAOImpl();
    IClienteDAO clienteDAO = new ClienteDAOImpl();
    IPedidoDAO pedidoDAO = new PedidoDAOImpl();
    IEmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
    @PostConstruct
    public void init() {
        pedido = new Pedido();
        pedido.setCliente(new Cliente());
        pedido.setEmpleado(new Empleado());
        pedido.setEstadoPedido(new EstadoPedido());
    }

    public String guardar(Pedido pedido) {
        pedidoDAO.guardar(pedido);
        this.pedido = new Pedido();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empleado agregado correctamente", "Empleado agregado correctamente"));
        return "/pedido/index.xhtml?faces-redirect=true";
    }

    public String actualizar(Pedido pedido) {
        pedidoDAO.actualizar(pedido);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Empleado actualizado correctamente"));
        return "/pedido/index.xhtml?faces-redirect=true";
    }

    public Pedido buscarPorId(int id) {
        return pedidoDAO.buscarPorId(id);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoDAO.obtenerPedidos();
    }

    public String editar(int id) {
        Pedido pedido = pedidoDAO.buscarPorId(id);
        if (pedido != null) {
            // Almacenar el empleado en el ámbito de sesión
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pedidoEditado", pedido);
            return "/pedido/editar.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se encontró el empleado"));
            return null;
        }
    }

    public void eliminar(int id) {
        // eliminacion fisica con remove
        Pedido pedido = buscarPorId(id);
        pedidoDAO.eliminar(id);
    }

    public List<Cliente> obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }
    public List<EstadoPedido> obtenerEstadosPedido() {
        return estadoPedidoDAO.obtenerEstadoPedido();
    }

    public List<Empleado> obtenerEmpleados() {
        return  empleadoDAO.obtenerEmpleados();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public IProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }


    public IClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public IPedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public IEstadoPedido getEstadoPedidoDAO() {
        return estadoPedidoDAO;
    }

    public void setEstadoPedidoDAO(IEstadoPedido estadoPedidoDAO) {
        this.estadoPedidoDAO = estadoPedidoDAO;
    }

    public IEmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(IEmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }
}
