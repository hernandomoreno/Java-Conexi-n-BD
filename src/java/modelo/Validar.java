
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Validar{
   PreparedStatement ps; //Ejecuta una consulta o una sentencia SQL
   ResultSet rs; //Objeto que tendrá la capacidad de obtener la respuesta desde la bd
   Connection con; //Interfaz que permite establecer la conexión con la bd
   Conexion cn = new Conexion(); // Creamos una variable tipo Conexion 
   

    public int validar(Persona per){
       int r=0; //Para contar el número de registros que cumple una dondición
       String sql = "SELECT * FROM persona WHERE Nombres = ? AND Correo = ?";
       
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNom());
            ps.setString(2, per.getCorreo());
            rs = ps.executeQuery();
            
            while(rs.next()){ //next realiza desplazamiento hasta encontrar un o un conjunto de datos
                r++;
                per.setNom(rs.getString("Nombres"));
                per.setCorreo(rs.getString("Correo"));
            }
            
            if(r >= 1)
                return 1;
            else
                return 0;
            
        } catch (SQLException e) {
            
        }

        return 0;
    }
    
    public int guardar(Persona per){
        
        String sql = "INSERT INTO persona (Nombres, Correo) VALUES (?,?)";
        
        con = cn.Conexion();
       try {
           ps = con.prepareStatement(sql);
       } catch (SQLException ex) {
           Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           ps.setString(1, per.getNom());
       } catch (SQLException ex) {
           Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           ps.setString(2, per.getCorreo());
       } catch (SQLException ex) {
           Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       try {
           ps.execute();
       } catch (SQLException ex) {
           Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       return 0;
        
    }
    
    public Persona mostrarPersona(int _id){
        
        JOptionPane.showMessageDialog(null, _id);
        
        Persona p = null;
        
        try {
            String sql = "SELECT id, Nombres, Correo FROM prueba WHERE id=?";
             
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){ //next realiza desplazamiento hasta encontrar un o un conjunto de datos
                int id = rs.getInt("id");
                String nombre = rs.getString("nom");
                String correo = rs.getString("correo");
                
                p = new Persona(id, nombre, correo);
                
             }
             return p;
             
        } catch (SQLException e) {
        }
       return null;
       
        
    }
    
    public int eliminar(int _id){
        
        String sql = "DELETE FROM persona WHERE id=?";
        
        con = cn.Conexion();
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, _id);
           ps.execute();
       } catch (SQLException ex) {
           Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return 0;
        
    }
    
    public List<Persona> listarpersonas(){
        List<Persona> lista = new ArrayList<>();
        try {
            String sql = "SELECT id, Nombres, Correo FROM persona";
             
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){ //next realiza desplazamiento hasta encontrar un o un conjunto de datos
                int id = rs.getInt("id");
                String nombre = rs.getString("nombres");
                String correo = rs.getString("correo");
                
                Persona p = new Persona(id, nombre, correo);
                
                lista.add(p);
                                        
            }
             return lista;
             
        } catch (SQLException e) {
        }
       return null;
       
     }
    
    
 }
