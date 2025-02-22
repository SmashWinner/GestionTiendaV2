import java.util.Scanner;
import Clases.*;
import Utils.*;
public class Main implements Colors{

    public static void main(String[] args){

        Producto.agregarProducto(new Producto("Galletas", "saladitas", 15, 10));
        Producto.agregarProducto(new Producto("Coquita", "Limpia el riñon :D", 20, 10));

        Scanner sc = new Scanner(System.in);
        String input = "";
    
        while(!input.equals("salir")){
            textoMenuPrincipal();
            //sc.nextLine(); //Limpiar buffer
            int opcion = sc.nextInt();
            switch(opcion){
                case(1):
                    System.out.println("Menu iniciar sesion:");
                    iniciarSesion(sc);
                break;
                case(2):
                    System.out.println("Menu Crear Cuenta:");
                    crearCuenta(sc);
                break;
                case(3):
                    System.out.println("saliste");
                    input = "salir";
                break;
                default:
                break;
            }
            //input = sc.next();
        }
        sc.close();
    }

    public static void menuCliente(Cliente cliente, Scanner sc){
        String input = "";
        while(!input.equals("salir")){
            System.out.println("Hola " + cliente.getUsername() + " Que deceas realizar? :D");
            textoMenuCliente();
            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Los productos son:");
                    Producto.mostrarProductos();
                    break;
                case 2:
                    sc.nextLine(); //limpiar buffer
                    String inputp = "";
                    //sc.nextLine(); //limpiar buffer
                    while(!inputp.equalsIgnoreCase("salir")){
                        System.out.println("Que productos deceas agregar? ingresa el nombre de ellos o salir para terminar");
                        inputp = sc.next();
                        if(Producto.verificarProducto(inputp)){
                            System.out.println("Ingresa la cantidad que vas a comprar: ");
                            cliente.aggProductoCarrito(inputp, sc.nextInt());
                        }else{
                            System.out.println("No se encontro el producto");
                        }
                    }
                    break;
                case 3:
                    String input3 = "";
                    while(!input3.equalsIgnoreCase("salir")){
                        cliente.mostrarCarrito();
                        System.out.println("Costo total:" + cliente.costoCarrito());
                        sc.nextLine(); //limpiar buffer
                        System.out.println("1.comprar todo");
                        System.out.println("2.Quitar un producto");
                        System.out.println("3.regresar");
                        switch (sc.nextInt()) {
                            case 1:
                                if(cliente.getBalance() >= cliente.costoCarrito()){
                                    cliente.setBalance(cliente.getBalance() - cliente.costoCarrito());
                                    System.out.println("Has comprado toodo tu carrito con exito");
                                    cliente.removeAllCarrito();
                                }else{
                                    System.out.println("No te alcanza, necesitas: " + cliente.costoCarrito());
                                }
                                break;
                            case 2:
                                String inputn = "";
                                while(!inputn.equalsIgnoreCase("salir")){
                                    sc.nextLine(); //limpiar buffer
                                    System.out.println("Que producto deceas quitar? escribe el nombre o salir");
                                    inputn = sc.next();
                                    if(cliente.verificarProductoCarrito(inputn)){
                                        cliente.removeProductoCarrito(inputn);
                                    }else{
                                        System.out.println("No se encontro el producto");
                                    }
                                }
                                break;
                            case 3:
                                input3 = "salir";
                                break;
                            default:
                                break;
                        }

                    }
                    break;
                case 4:
                    String inputd = "";
                    while(!inputd.equalsIgnoreCase("salir")){
                        sc.nextLine(); //limpiar buffer
                        System.out.println("Que datos quieres actualizar?");
                        System.out.println("1.Nombre");
                        System.out.println("2.Contraseña");
                        System.out.println("3.Email");
                        System.out.println("4.Direccion");
                        System.out.println("5.Telefono");
                        System.out.println("6.Agregar dinero");
                        System.out.println("7.regresar");
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Ingresa tu nuevo nombre: ");
                                cliente.setUsername(sc.next());
                                break;
                            case 2:
                                System.out.println("Ingresa tu nueva contraseña: ");
                                cliente.setPassword(sc.next());
                                break;
                            case 3:
                                System.out.println("Ingresa tu nuevo email: ");
                                cliente.setEmail(sc.next());
                                break;
                            case 4:
                                System.out.println("Ingresa tuu nueva direccion: ");
                                cliente.setDireccion(sc.next());
                                break;
                            case 5:
                                System.out.println("Ingresa tu nuevo telefono");
                                cliente.setTelefono(sc.nextInt());
                                break;
                            case 6:
                                System.out.println("Cuanto dinero deceas agregar?");
                                cliente.setBalance(sc.nextInt());
                                break;
                            case 7:
                                inputd = "salir";
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                input = "salir";
                break;
                default:
                    break;
            }
        }
    }

    public static void iniciarSesion(Scanner sc){
        sc.nextLine(); //limpiamos buuffer
        System.out.println("Ingresa tu nobre de usuarrio");
        String username = sc.nextLine();
        System.out.println("Ingresa tu contraseña");
        String password = sc.next();

        Cliente Cuenta = Cliente.encontrarCuenta(username, password);
        if(Cuenta == null){
            System.out.println("No se ah encontrado tu cuenta");
        }else{
            System.out.println("Has iniciado sesion correctamente");
            menuCliente(Cuenta, sc);
        }
    }

    public static void crearCuenta(Scanner sc){
        sc.nextLine(); //Limpiar el buffer
        System.out.println("Ingresa tu nombre:");
        String username = sc.nextLine();
        System.out.println("Ingresa tu contraseña:");
        String password = sc.next();
        System.out.println("Ingresa tu email:");
        String email = sc.next();

        if(Cliente.veificarEmail(email) || Cliente.veificarUsername(username)){
            Cliente nuevoCliente = new Cliente(username, email, password);
            Cliente.crearCuenta(nuevoCliente);

            System.out.println("Tu cuenta ah sido creada con exito, con los datos:");
            System.out.println("Nombre: " + nuevoCliente.getUsername());
            System.out.println("email: " + nuevoCliente.getEmail());
            System.out.println("Tipo: " + nuevoCliente.getRole());
        }else{
            System.out.println("No se pudo crear tu cuenta unu");
        }

    }

    public static void textoMenuPrincipal(){
        System.out.println("Bienvenido a la tienda virtual de Smash");
        System.out.println("1.iniciar sesion");
        System.out.println("2.Crear cuenta");
        System.out.println("3.salir");
    }

    public static void textoMenuCliente(){
        System.out.println("1.Ver productos:");
        System.out.println("2.Agregar productos al carrito");
        System.out.println("3.Ver carrito");
        System.out.println("4.Actualizar tus datos");
        System.out.println("5.Salir");
    }
}