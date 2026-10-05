package com.utn.frm.desarrollosoftware.entities;

import java.util.Objects;

public class Producto extends Base{
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;
    private Categoria categoria;

    public Producto(Long id, String nombre, Double precio, String descripcion, int stock, String imagen, Categoria categoria) {
        super(id);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = true;
        this.categoria = categoria;
        categoria.getProductos().add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public String getImagen() {
        return imagen;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return String.format(
                "Producto{id='%d', nombre='%s', precio='%f', descripcion='%s', stock='%d', imagen='%s', disponible='%b', categoria='%s', creado='%s', eliminado='%b'}%n",
                getId(), nombre, precio, descripcion, stock, imagen, disponible, categoria.getNombre(), getCreatedAt(), isEliminado()
        );
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto otra = (Producto) obj;
        return nombre == otra.nombre && Objects.equals(getNombre(), otra.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }
}
