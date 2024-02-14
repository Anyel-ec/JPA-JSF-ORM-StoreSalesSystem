package com.espe.controller;

import com.espe.dao.DetallePedidoDAO;
import com.espe.dao.EmpleadoDAOImpl;
import com.espe.dao.PedidoDAOImpl;
import com.espe.dao.ProductoDAOImpl;
import com.espe.idao.IDetallePedidoDAO;
import com.espe.idao.IEmpleadoDAO;
import com.espe.idao.IPedidoDAO;
import com.espe.idao.IProductoDAO;
import com.espe.model.DetallePedido;
import com.espe.model.Pedido;
import com.espe.model.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class DetallePedidoManageBean {
    private DetallePedido detallePedido = new DetallePedido();
    IDetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();
    IPedidoDAO pedidoDAO = new PedidoDAOImpl();
    IProductoDAO productoDAO = new ProductoDAOImpl();
    @PostConstruct
    public void init() {
        detallePedido = new DetallePedido();
        detallePedido.setPedido(new Pedido());
        detallePedido.setProducto(new Producto());
    }

    public String guardar(DetallePedido detallePedido) {
        detallePedidoDAO.guardar(detallePedido);
        this.detallePedido = new DetallePedido();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle pedido agregado correctamente", "Detalle pedido  correctamente"));
        return "/detalles/index.xhtml?faces-redirect=true";
    }

    public String actualizar(DetallePedido detallePedido) {
        detallePedidoDAO.actualizar(detallePedido);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Empleado actualizado correctamente"));
        return "/detalles/index.xhtml?faces-redirect=true";
    }

    public DetallePedido buscarPorId(int id) {
        return detallePedidoDAO.buscarPorId(id);
    }
    public String editar(int id) {
        DetallePedido detallePedido = detallePedidoDAO.buscarPorId(id);
        if (detallePedido != null) {
            // Almacenar el empleado en el ámbito de sesión
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("detallePedidoEditado", detallePedido);
        }
        return "/detalles/editar.xhtml?faces-redirect=true";
    }

    public void eliminar(int id) {
        // eliminar segun el id obtenido
        detallePedidoDAO.eliminar(id);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Detalle pedido eliminado correctamente"));
    }
    public List<DetallePedido> obtenerDetallePedido() {
        return detallePedidoDAO.obtenerDetallePedido();
    }
    public List<Pedido> obtenerPedidos() {
        return pedidoDAO.obtenerPedidos();
    }
    public List<Producto> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public IDetallePedidoDAO getDetallePedidoDAO() {
        return detallePedidoDAO;
    }

    public void setDetallePedidoDAO(IDetallePedidoDAO detallePedidoDAO) {
        this.detallePedidoDAO = detallePedidoDAO;
    }

    public IPedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public IProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
}
