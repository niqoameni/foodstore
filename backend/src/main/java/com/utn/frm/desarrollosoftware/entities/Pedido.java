package com.utn.frm.desarrollosoftware.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.utn.frm.desarrollosoftware.enums.Estado;
import com.utn.frm.desarrollosoftware.enums.FormaPago;

public class Pedido extends Base implements Calculable{
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private final Set<DetallePedido> detalles = new HashSet<>();

    public Pedido(Long id, FormaPago formaPago) {
        super(id);
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
        this.formaPago = formaPago;
        this.total = 0.0;
    }

    public void addDetallePedido(Long id, int cantidad, Producto producto){
        DetallePedido nuevoDetalle = new DetallePedido(id, producto, cantidad);
        nuevoDetalle.setPedido(this);
        this.detalles.add(nuevoDetalle);
        producto.setStock(producto.getStock() - cantidad);
        calcularTotal();
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto){
        for (DetallePedido detalle : detalles){
            if (Objects.equals(detalle.getProducto(), producto)){
                return detalle;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detalleEliminar = findDetallePedidoByProducto(producto);
        this.detalles.remove(detalleEliminar);
        calcularTotal();
        detalleEliminar.setEliminado(true);
        producto.setStock(producto.getStock() + detalleEliminar.getCantidad());
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public Double getTotal() {
        return total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public void calcularTotal(){
        for (DetallePedido detalle : detalles) {
            this.total = total + detalle.getSubtotal();
        }
    }

    @Override
    public String toString(){
        return String.format(
                "entities.Pedido{id='%d', fecha='%s', estado='%s', total='%f', formaPago='%s', cantDetalle='%d', eliminado='%b'}",
                getId(), fecha, estado, total, formaPago, detalles.size(), isEliminado()
        );
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pedido otra = (Pedido) obj;
        return getId() == otra.getId() && Objects.equals(getId(), otra.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }
}

