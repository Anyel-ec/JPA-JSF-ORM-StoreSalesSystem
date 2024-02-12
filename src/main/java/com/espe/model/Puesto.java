package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "puesto")
public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_puesto;

    @Column
    private String nombre;

    public Puesto(String nombre) {
        this.nombre = nombre;
    }

    public Puesto(long id, String nombre) {
        this.id_puesto = id;
        this.nombre = nombre;
    }

    public Puesto() {

    }

    public long getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(long id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "id_puesto=" + id_puesto +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
