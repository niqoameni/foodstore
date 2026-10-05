package com.utn.frm.desarrollosoftware.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base{
    private String nombre;
    private String descripcion;
    private Set<Producto> productos = new HashSet<>();

    public Categoria(Long id, String nombre, String descripcion) {
        super(id);
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public Set<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString(){
        return String.format(
                "Categoria{id='%d', nombre='%s', descripcion='%s', creado='%s', eliminado='%b'}%n",
                getId(), nombre, descripcion, getCreatedAt(), isEliminado()
        );
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria otra = (Categoria) obj;
        return nombre == otra.nombre && Objects.equals(getNombre(), otra.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }
}
