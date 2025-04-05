package Modelos;
import Clases.clsObjeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Virgilio Ramos
 */
public class mdlIngreso extends Conexion {

    public int Crear(clsObjeto c) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO `ingresos`( `detalles`, `fecha`, `valor`) VALUES (?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getDetalle());
            pre.setString(2, c.getFecha());
            pre.setString(3, c.getValor());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return res;
    }

    public ArrayList<clsObjeto> mostrarIngresos() {
        ArrayList<clsObjeto> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM ingresos";
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

    public int Actualizar(clsObjeto gasto) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE `ingresos` SET `detalles`=?,`fecha`=?,`valor`=?  WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, gasto.getDetalle());
            pre.setString(2, gasto.getFecha());
            pre.setString(3, gasto.getValor());
            pre.setString(4, gasto.getId());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarCliente(int GastoDelete) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM `ingresos` WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, GastoDelete);

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int ConsultaObligaciones() {
        int cantidades = 0;
        try {
            this.conectar();
            String sql = "SELECT valor FROM `actividades"
                    + "`";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
     public int ConsultaDisponible() {
        int cantidades = 0;
        try {
            this.conectar();
            String sql = "SELECT valor FROM `ejecutandose`";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
     public int ConsultaObligaciones2() {
         Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String mesActual = sdf.format(todayDate);
        int cantidades = 0;
        try {
            this.conectar();
            String sql = "SELECT valor FROM `pagado` WHERE MONTH(fecha) ="+mesActual;
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
    
     public int ConsultaMes(String mes) {
          int cantidades = 0;
         
        try {
            this.conectar();
            String sql = "SELECT valor FROM `pagado` WHERE MONTH(fecha) ="+mes;
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);

                cantidades = cantidades + cantidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return cantidades;
    }
}
