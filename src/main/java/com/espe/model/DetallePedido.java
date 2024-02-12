package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_detalle_pedido;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column
    private int cantidad;

    @Column
    private double subtotal;


    public DetallePedido() {
    }

    public DetallePedido(long id_detalle_pedido, Pedido pedido, Producto producto, int cantidad, double subtotal) {
        this.id_detalle_pedido = id_detalle_pedido;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public long getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(long id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "id_detalle_pedido=" + id_detalle_pedido +
                ", pedido=" + pedido +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
