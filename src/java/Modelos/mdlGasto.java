/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.clsObjeto;
import Modelos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Virgilio Ramos
 */
public class mdlGasto extends Conexion {

    public int Crear(clsObjeto c) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO `gastos`(`detalle`, `valor`, `fecha`, `idUser`) VALUES (?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getDetalle());
            pre.setString(2, c.getValor());
            pre.setString(3, c.getFecha());
            pre.setString(4, c.getIdUser());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return res;
    }

    public ArrayList<clsObjeto> mostrarClientes(String usr) {
        ArrayList<clsObjeto> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM gastos WHERE idUser = '"+usr+"'";
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

    public int GenerarAbono(clsObjeto gasto) {
        int res = 0;
        System.out.println("Realizare una actualizacion:");
        try {
            this.conectar();
            String sql = "UPDATE `gastos` SET `detalle`=? ,`valor`=valor-?,`fecha`=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, gasto.getDetalle());
            pre.setString(2, gasto.getValor());
            pre.setString(3, gasto.getFecha());
            pre.setString(4, gasto.getId());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int GenerarPago(clsObjeto gasto) {
        int res = 0;
        System.out.println("Realizare el pago.:");
        try {
            this.conectar();
            String sql = "UPDATE `gastos` SET `detalle`=? ,`valor`=?,`fecha`=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, gasto.getDetalle());
            pre.setString(2, "0");
            pre.setString(3, gasto.getFecha());
            pre.setString(4, gasto.getId());

            res = pre.executeUpdate();
            System.out.println("Modificado****");
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int Actualizar(clsObjeto gasto) {
        int res = 0;
        System.out.println("Realizare una actualizacion:");
        try {
            this.conectar();
            String sql = "UPDATE `gastos` SET `detalle`=? ,`valor`=?,`fecha`=? WHERE id=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, gasto.getDetalle());
            pre.setString(2, gasto.getValor());
            pre.setString(3, gasto.getFecha());
            pre.setString(4, gasto.getId());

            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarGasto(int GastoDelete) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM `gastos` WHERE id=?";
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
}
