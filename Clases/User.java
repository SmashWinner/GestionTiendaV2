package Clases;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    public User(){
    }

    public User(String username, String email, String password ){
        this.username = username;
        this.email = email;{
        this.password = password;
        this.balance = 0;
        this.id = UUID.randomUUID().toString();
        }
    }


    private static ArrayList<User> usuarios = new ArrayList<>();

    private ArrayList<String> historialCompras = new ArrayList<>();

    private String id;
    private String username ;
    private String password;
    private String email;
    private String role;
    private double balance;
    private String direccion;
    private double telefono;

    //Getters Atributos
    public String getId(){return this.id;}
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public String getEmail(){return this.email;}
    public String getRole(){return this.role;}
    public double getBalance(){return this.balance;}
    public String getDirection(){return this.direccion;}
    public double getTelefono(){return this.telefono;}

    public ArrayList<String> getHistorial(){return historialCompras;}
    public static ArrayList<User> getUsers(){return usuarios;}
    
    //Setters Atributos
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
    public void setEmail(String email){this.email = email;}
    public void setrole(String role){this.role = role;}
    public void setBalance(double balance){this.balance = balance;}
    public void setDireccion(String dieccion){this.direccion = dieccion;}
    public void setTelefono(double telefono){this.telefono = telefono;}

    //Crear cuenta
    public static void setUsuario(User user){
        usuarios.add(user);
    }


}
