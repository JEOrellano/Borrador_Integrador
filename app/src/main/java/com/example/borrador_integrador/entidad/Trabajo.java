package com.example.borrador_integrador.entidad;

public class Trabajo {
    private Integer id;
    private String descripcion;

    public Trabajo() {
    }

    public Trabajo(String descripcion) {
        this.descripcion = descripcion;
    }

    public Trabajo(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Trabajo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
