
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class Validar {
   PreparedStatement ps; //Ejecuta una consulta o una sentencia SQL
   ResultSet rs; //Objeto que tendrá la capacidad de obtener la respuesta desde la bd
   Connection con; //Interfaz que permite establecer la conexión con la bd
   Conexion cn = new Conexion();
   

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
}
