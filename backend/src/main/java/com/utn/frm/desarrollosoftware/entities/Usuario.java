package com.utn.frm.desarrollosoftware.entities;

import com.utn.frm.desarrollosoftware.enums.FormaPago;
import com.utn.frm.desarrollosoftware.enums.Rol;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;
    private Set<Pedido> pedidos = new HashSet<>();

    public Usuario(Long id, String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) {
        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    //Metodo que crea un pedido y lo vincula con el usuario que lo hizo, cumpliendo la unidireccionalidad
    public Pedido crearPedido(Long id, FormaPago formaPago){
        Pedido nuevoPedido = new Pedido(id, formaPago);
        this.pedidos.add(nuevoPedido);
        return nuevoPedido;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public String getCelular() {
        return celular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public Set<Pedido> getPedido() {
        return pedidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    @Override
    public String toString(){
        return String.format(
                "entities.Usuario{id='%d', nombre='%s', apellido='%s', mail='%s', celular='%s', rol='%s', cantPedidos='%d', creado='%s', eliminado='%b'}",
                getId(), nombre, apellido, mail, celular, rol, pedidos.size(), getCreatedAt(), isEliminado()
        );
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario otra = (Usuario) obj;
        return getId() == otra.getId() && Objects.equals(getId(), otra.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }

}
