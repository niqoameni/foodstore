package com.utn.frm.desarrollosoftware.entities;

import java.util.Objects;

public class DetallePedido extends Base{
    private int cantidad;
    private Double subtotal;
    private Pedido pedido;
    private Producto producto;


    public DetallePedido(Long id, Producto producto, int cantidad) {
        super(id);
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecio() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString(){
        return String.format(
                "DetallePedido{id='%d', cantidad='%d', subtotal='%f', pedido='%s', producto='%s', creado='%s', eliminado='%b'}%n",
                getId(), cantidad, subtotal, pedido.getId(), producto, getCreatedAt(), isEliminado()
        );
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DetallePedido otra = (DetallePedido) obj;
        return getId() == otra.getId() && Objects.equals(getId(), otra.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }
}
