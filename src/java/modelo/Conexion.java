/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

// Importamos las classes necesarias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.Url;
import java.sql.*; 


public class Conexion {
    
    String usuario  = "root"; //Usuario de la base de datos
    String password = ""; //Password de la bd
    String url = "jdbc:mysql://localhost:3306/prueba"; //Url para realizar la conexión
    Connection conex; //Creamos un objeto tipo conexión
    Statement statement; //Creamos un objeto tipo statement que permita ejecutar sentencias sql a traves de la coenxión establecida
    ResultSet rs; //apuntador de tipo Cursor que está direccionado a la primera posición de toda la estructura tabular que está referenciando
    String driver = "com.mysql.cj.jdbc.Driver"; //Cargamos el controlador
    
    // Creamos un método conexión tipo Connection
    public Connection Conexion(){  
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //carga una clase de manera dinámica en tiempo de ejecución. 
            try {
                conex = DriverManager.getConnection(url, usuario, password); //Establece una conexión con la bd
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay conexión con "+url);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conex;
        
    } 
    //Para saber si todo está funcionando
    /*public static void main(String[] args) {
        //Instanciamos el objeto conexión
        Conexion conexion = new Conexion();
        conexion.Conexion();
    }*/
}
   
 