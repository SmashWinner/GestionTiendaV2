package Clases;

import java.util.ArrayList;

public class Cliente extends User {

    private ArrayList<Producto> carrito = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(String username, String email, String password){
        super(username, email, password);
        this.setrole("Cliente");

    }

    //COMPORTAMIENTOS DEL CARRITO
    public void aggProductoCarrito(String nombre, int cantidad){
        //String producto = Producto.getProducto(nombre, cantidad);
        if(verificarStock(nombre, cantidad)){
            Producto productoAdd = new Producto(nombre, cantidad);
            carrito.add(productoAdd);
        }else{
            System.out.println("No hay tantos en stock");
        }
    }

    public boolean verificarStock(String nombre, int cantidad){

        for(Producto o : Producto.getProductos()){
            if(o.getNombre().equals(nombre)){
                return o.getStock() >= cantidad;
            }
        }
        return false;
    }

    public void mostrarCarrito(){
        for(Producto p : carrito){
            for(Producto o : Producto.getProductos()){
                if(o.getNombre().equals(p.getNombre())){
                    System.out.println(p.getNombre() + " - $" + (o.getPrecio() * p.getCantidadComprar()));
                }
            }
        }
    }

    public int costoCarrito(){
        int total = 0;
        for(Producto p : carrito){
            for (Producto o : Producto.getProductos()){
                if(o.getNombre().equals(p.getNombre())){
                    total += (o.getPrecio() * p.getCantidadComprar());
                }
            }
            //total =+ (p.getPrecio() * p.getCantidadComprar());
        }
        return total;
    }

    public void removeProductoCarrito(String nombre){
        for(Producto p : carrito){
            if(p.getNombre().equals(nombre)){
                Producto.vender(nombre, p.getCantidadComprar());
                carrito.remove(p);
                System.out.println("Producto " + nombre + "eliminado del carrito");
                break;
            }
        }
    }

    public void removeAllCarrito(){
            for(Producto p : carrito){
                Producto.vender(p.getNombre(), p.getCantidadComprar());
            }
            carrito.clear();
    }

    public boolean verificarProductoCarrito(String nombre){
        for(Producto p : carrito){
            if(p.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
        
        //COMPORTAMIENTOS ESTATICOS
        //Crear cuenta Cliente
        public static void crearCuenta(Cliente cliente){
            clientes.add(cliente);
        }
    
    
        //Encontrar cuenta
        public static Cliente encontrarCuenta(String username, String password){
            for(Cliente u : clientes){
                if(u.getUsername().equals(username) || u.getPassword().equals(password)){
                    return u;
                }
            }
            return null;
        }


    //Getters
    public static boolean veificarUsername(String username){
        for(User users : clientes){
            if(users.getEmail().equals(username)){
                System.out.println("Este nombre ya esta registrado :/");
                return false;
            }
        }
        return true;
    }
    public static boolean veificarEmail(String email){
        for(User users : clientes){
            if(users.getEmail().equals(email)){
                System.out.println("Este email ya esta registrado :/");
                return true;
            }
        }
        return false;
    }

}
