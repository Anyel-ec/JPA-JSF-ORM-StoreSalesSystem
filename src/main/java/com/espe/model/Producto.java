package com.espe.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;
    @Column
    private int codigo_producto;
    @Column
    private String nombre;

    @Column
    private String descripcion;
    @Column
    private double precio;
    @Column
    private boolean eliminado = Boolean.FALSE;


    public Producto() {
    }

    public Producto(long id_producto, int codigo_producto, String nombre, String descripcion, double precio, boolean eliminado) {
        this.id_producto = id_producto;
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.eliminado = eliminado;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", codigo_producto=" + codigo_producto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", eliminado=" + eliminado +
                '}';
    }
}
