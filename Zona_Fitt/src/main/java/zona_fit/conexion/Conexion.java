package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){

        Connection conexion = null;
        var baseDatos = "zona_fit_db"; //nombre de l base de datos en mysql
        var url = "jdbc:mysql://localhost:3306/"+baseDatos; //Cadena de conexion
        var usuario = "root"; //usuario
        var password = "admin"; //password.

        try{
            /*Clase de conexion a la base de datos
            * Cada base de datos tiene su propia clase de conexion
            * La clase que permite conectarse a la base de datos se llama Driver*/
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Realizar una cionexion utilizando la clase DriverManager
            conexion = DriverManager.getConnection(url,usuario,password);

        }catch (Exception e){
            System.out.println("Error al coectarnos a la base de datos "+e.getMessage());
        }
        return  conexion; //Objeto de conexion de la base de datos.
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();

        if(conexion != null){
            System.out.println("Conexion exitosa " + conexion);
        }
        else{
            System.out.println("Error al conectarse");
        }
    }

}


