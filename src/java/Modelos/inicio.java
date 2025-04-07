package Modelos;

import Clases.Empleado;
import Clases.clsObjeto;
import Controlador.Control;

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

    String Usuario;
    int r;

    public inicio() {
    }
    public static String Us = "";

    public Empleado Consultar(String user, String dni) {
        System.out.println("Metodo:  Consultar:");
        try {
            System.out.println("----------Inicio----------");
            this.conectar();
            String sql = "select * from empleado where User = '" + user + "' and Dni = '" + dni + "'";
            System.out.println("sql: " + sql);
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                Empleado c = new Empleado();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setUser(rs.getString(3));
                Us = rs.getString(3);
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

    public int Crear(Empleado c) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO `empleado`(`Dni`, `User`, `Telefono`, `Nombre`) VALUES (?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getDni());
            pre.setString(2, c.getUser());
            pre.setString(3, c.getTelefono());
            pre.setString(4, c.getNombre());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return res;
    }

    public String usuario() {
        return Us;
    }

    public ArrayList<clsObjeto> tablaInicio(String usr) {//llena la tabla inicio
        ArrayList<clsObjeto> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM gastos WHERE valor > 0 AND idUser= +'"+usr+"'";
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
