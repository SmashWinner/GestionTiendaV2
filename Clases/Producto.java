package Clases;

import java.util.ArrayList;
import java.util.UUID;

public class Producto {

    public Producto(){}

    public Producto(String nombre, String descripcion, int precio, int stock){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.id = UUID.randomUUID().toString();
    }

    public Producto(String nombre, int cantidad){
        this.nombre = nombre;
        //this.stock = stock;
        this.cantidadComprar = cantidad;
    }

    private static ArrayList<Producto> productos = new ArrayList<>();

    private String nombre;
    private String descripcion;
    private int precio;
    private int stock;
    private String id;

    private int cantidadComprar;

    //GETTERS
    public String getNombre(){return this.nombre;}
    public String getDescripcion(){return this.descripcion;}
    public int getPrecio(){return this.precio;}
    public int getStock(){return this.stock;}
    public String getId(){return this.id;}
    public int getCantidadComprar(){return this.cantidadComprar;}

    public static ArrayList<Producto> getProductos(){
        return productos;
    }


    //SETTERS
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
    public void setPrecio(int precio){this.precio = precio;}
    public void setStock(int stock){this.stock = stock;}
    public void setCantidadComprar(int cantidad){this.cantidadComprar = cantidad;}


    //METODO/COMPORTAMIENTO
    public static void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public static void mostrarProductos(){
        if(productos.isEmpty()){
            System.out.println("No hay prodctos aun unu");
            return;
        }
        for(Producto p : productos){
            System.out.println(p.getNombre() + " - $" + p.getPrecio() + " - Stock: " + p.getStock());
        }
    }

        //SETTER REGRESAR PRODUCTO de array
        public static boolean verificarProducto(String nombre){
            for(Producto p : productos){
                if(p.getNombre().equals(nombre)){
                    return true;
                }
            }
            System.out.println("No se encontro el producto");
            return false;
        }

        public static void vender(String nombre, int cantidad) {
            boolean encontrado = false;
            
            for (Producto p : productos) {
                if (p.getNombre().equals(nombre)) {
                    if (p.stock >= cantidad) {
                        p.stock -= cantidad; // ✅ Reducir stock solo si hay suficientes productos
                        System.out.println("Venta realizada: " + cantidad + " de " + nombre);
                    } else {
                        System.out.println("Stock insuficiente para " + nombre);
                    }
                    encontrado = true;
                    break;
                }
            }
            
            if (!encontrado) {
                System.out.println("El producto " + nombre + " no existe en la tienda.");
            }
        }
        


    
}
