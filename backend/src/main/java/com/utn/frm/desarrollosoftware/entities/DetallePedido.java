package com.utn.frm.desarrollosoftware.entities;

public class DetallePedido extends Base{
    private int cantidad;
    private Double subtotal;
    private Pedido pedido;
    //private Producto producto;


    public DetallePedido(Long id, int cantidad, Double subtotal) {
        super(id);
        this.cantidad = cantidad;
        //this.subtotal = producto.getPrecio() * cantidad;
    }
}
