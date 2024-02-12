package com.espe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_empleado;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "puesto_id")
    private Puesto puesto;
    @Column
    private String telefono;
    @Column
    private String cedula;

    @Column
    private boolean eliminado = Boolean.FALSE;

    public Empleado() {
    }

    public Empleado(long id_empleado, String nombre, String apellido, Puesto puesto, String telefono, String cedula, boolean eliminado) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.telefono = telefono;
        this.cedula = cedula;
        this.eliminado = eliminado;
    }

    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id_empleado=" + id_empleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puesto=" + puesto +
                ", telefono='" + telefono + '\'' +
                ", cedula='" + cedula + '\'' +
                ", eliminado=" + eliminado +
                '}';
    }
}
