package Modelos;

import Clases.Empleado;
import Clases.clsObjeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class inicio extends Conexion {
   
    int r;
    public inicio() {
    }
    
      public Empleado  Consultar(String user, String dni) {
          System.out.println("Metodo:  Consultar:");
        try {
            System.out.println("----------Inicio----------");
            this.conectar();
            String sql = "select * from empleado where User = '"+user+"' and Dni = '" +dni+"'";
            System.out.println("sql: "+sql);
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                Empleado c = new Empleado();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setUser(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setNombre(rs.getString(5));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return null;
        
    }
      public ArrayList<clsObjeto> tablaInicio() {
        ArrayList<clsObjeto> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM gastos WHERE valor > 0";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                clsObjeto c = new clsObjeto();
                c.setId(rs.getString(1));
                c.setDetalle(rs.getString(2));
                c.setValor(rs.getString(3));
                c.setFecha(rs.getString(4));

                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
