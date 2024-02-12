package com.espe.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    private long id_pedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "estado_pedido_id")
    private EstadoPedido estadoPedido;

    @Column
    private LocalDate fecha_pedido;
    @Column
    private double total;


    public Pedido() {
    }

    public Pedido(long id_pedido, Cliente cliente, Empleado empleado, EstadoPedido estadoPedido, LocalDate fecha_pedido, double total) {
        this.id_pedido = id_pedido;
        this.cliente = cliente;
        this.empleado = empleado;
        this.estadoPedido = estadoPedido;
        this.fecha_pedido = fecha_pedido;
        this.total = total;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public LocalDate getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDate fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", estadoPedido=" + estadoPedido +
                ", fecha_pedido=" + fecha_pedido +
                ", total=" + total +
                '}';
    }
}
