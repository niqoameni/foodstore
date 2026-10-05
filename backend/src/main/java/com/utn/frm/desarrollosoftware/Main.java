package com.utn.frm.desarrollosoftware;

import com.utn.frm.desarrollosoftware.entities.Categoria;
import com.utn.frm.desarrollosoftware.entities.Pedido;
import com.utn.frm.desarrollosoftware.entities.Producto;
import com.utn.frm.desarrollosoftware.entities.Usuario;
import com.utn.frm.desarrollosoftware.enums.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*------------- Creacion de Listado -------------*/
        Set<Usuario> listadoUsuarios = new HashSet<>();

        /*------------- Creacion de Usuarios -------------*/
        Usuario usuarioAdmin = new Usuario(
                1L,
                "Nicolas",
                "Ameni",
                "ameninicolas@gmail.com",
                "2612414004",
                "12345678",
                Rol.ADMIN
        );
        Usuario usuarioUser = new Usuario(
                2L,
                "Agustin",
                "Bañuls",
                "agustinbañuls@gmail.com",
                "2614445555",
                "987654321",
                Rol.USUARIO
        );

        /*------------- Carga de Usuarios -------------*/
        listadoUsuarios.add(usuarioAdmin);
        listadoUsuarios.add(usuarioUser);

        /*------------- Creacion de Categorias -------------*/
        Categoria pizza = new Categoria(100L, "Pizza", "Pizzas");
        Categoria hamburguesa = new Categoria(101L, "Hamburguesa", "Hamburguesas");
        Categoria bebida = new Categoria(102L, "Bebida", "Bebidas");

        /*------------- Collection de Productos -------------*/
        Set<Producto> catalogoProductos = new HashSet<>();

        /*------------- Creacion de Productos -------------*/
        Producto cocacola = new Producto(1000L, "Coca-Cola", 2500.00, "Gaseosa Coca-Cola", 20, "imagen", bebida);
        Producto fanta = new Producto(1001L, "Fanta", 2200.00, "Gaseosa Fanta", 20, "imagen", bebida);
        Producto sprite = new Producto(1003L, "Sprite", 2200.00, "Gaseosa Sprite", 20, "imagen", bebida);
        Producto ham_simple = new Producto(1004L, "Hamburguesa Simple", 7000.00, "Medallon de carne, cheddar, lechuga y aderezos", 10, "imagen", hamburguesa);
        Producto ham_blue = new Producto(1005L, "Hamburguesa Blue", 10000.00, "Medallon de carne, queso rockefort, nueces, alioli y mayonesa casera", 10, "imagen", hamburguesa);
        Producto ham_americana = new Producto(1006L, "Hamburguesa Americana", 10000.00, "Medallon de carne, bacon, queso cheddar, cebolla caramelizada y mayonesa casera", 10, "imagen", hamburguesa);
        Producto pizza_muzza = new Producto(1007L, "Pizza Muzzarella", 8500.00, "Pizza con queso muzzarella y aceitas", 10, "imagen", pizza);
        Producto pizza_especial = new Producto(1008L, "Pizza Especial", 9500.00, "Pizza con queso muzarrella, jamon, morron y aceitunas", 10, "imagen", pizza);
        Producto pizza_fuga = new Producto(1009L, "Pizza Fugazzeta", 9500.00, "Pizza con queso y cebolla", 10, "imagen", pizza);
        Producto pizza_calabresa = new Producto(1010L, "Pizza Calabresa", 9500.00, "Pizza con queso, salame y aceitunas", 10, "imagen", pizza);

        /*------------- Carga de Productos -------------*/
        catalogoProductos.add(cocacola);
        catalogoProductos.add(fanta);
        catalogoProductos.add(sprite);
        catalogoProductos.add(ham_simple);
        catalogoProductos.add(ham_blue);
        catalogoProductos.add(ham_americana);
        catalogoProductos.add(pizza_muzza);
        catalogoProductos.add(pizza_especial);
        catalogoProductos.add(pizza_fuga);
        catalogoProductos.add(pizza_calabresa);

        /*------------- Creacion de Pedidos -------------*/
        Pedido pedido1 = usuarioAdmin.crearPedido(5000L, FormaPago.TRASFERENCIA);
        pedido1.addDetallePedido(10000L, 1, ham_blue);
        pedido1.addDetallePedido(10001L, 1, fanta);

        Pedido pedido2 = usuarioUser.crearPedido(50001L, FormaPago.EFECTIVO);
        pedido2.addDetallePedido(10002L, 1, pizza_calabresa);
        pedido2.addDetallePedido(10003L, 3, cocacola);

        Pedido pedido3 = usuarioAdmin.crearPedido(50002L, FormaPago.TRASFERENCIA);
        pedido3.addDetallePedido(10004L, 1, pizza_fuga);
        pedido3.addDetallePedido(10005L, 1, pizza_especial);
        pedido3.addDetallePedido(10006L, 4, sprite);

        System.out.println(cocacola);

        for (Producto producto : catalogoProductos){
            System.out.println(producto);
        }

        int maximo = 0;
        Usuario usuarioMax = null;
        for (Usuario usuario : listadoUsuarios){
            if (usuario.getPedido().size() > maximo) {
                maximo = usuario.getPedido().size();
                usuarioMax = usuario;
            }
        }
        System.out.println(usuarioMax.getNombre() + " es el usuario con más pedidos (" + maximo + ")");

        // 5. Instancie un producto nuevo donde el/los campos comparados en equals sean iguales,
        //    compare esa instancia con toda la colección. Mostrar resultados por pantalla.

        Producto cocazero = new Producto(1011L, "Coca-Cola", 2700.00, "Gaseosa Coca-Cola Zero", 10, "imagen", bebida);
        catalogoProductos.add(cocazero);
        for (Producto producto : catalogoProductos){
            if (producto.equals(cocazero)){
                System.out.println("Concidencia encontrada:");
                System.out.println(producto);
            }
        }

    }
}