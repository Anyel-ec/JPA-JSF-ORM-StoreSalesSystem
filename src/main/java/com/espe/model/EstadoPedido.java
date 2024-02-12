package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_pedido")
public class EstadoPedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_estado_pedido;
    @Column
    private String nombre;

    public EstadoPedido() {
    }

    public EstadoPedido(long id_estado_pedido, String nombre) {
        this.id_estado_pedido = id_estado_pedido;
        this.nombre = nombre;
    }

    public long getId_estado_pedido() {
        return id_estado_pedido;
    }

    public void setId_estado_pedido(long id_estado_pedido) {
        this.id_estado_pedido = id_estado_pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" +
                "id_estado_pedido=" + id_estado_pedido +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
