/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.dtoProducto;
import interfaces.OperacionesBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUMNO
 */
public class daoProducto implements OperacionesBD<dtoProducto> {

    private static final String SQL_SelectAll = "select * from producto";    
    private static final String SQL_UpdateEstado = "update producto set estado=? where id=?";
    private static final String SQL_ActualizarEstado="update estado set valor=?";
    private static final Conexion con = Conexion.conectar();
    private static PreparedStatement pstm = null;
    private static ResultSet res = null;
    
    @Override
    public ArrayList<dtoProducto> selectAll() {
        ArrayList<dtoProducto> lista = new ArrayList<>();
        try {
            pstm = con.getCon().prepareStatement(SQL_SelectAll);
            res = pstm.executeQuery();
            if (res != null) {
                while (res.next()) {
                    lista.add(new dtoProducto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getDouble(6), res.getInt(7)));
                }
            } else {
                lista = null;
            }
        } catch (Exception e) {
        } finally {
            cerrarConexiones();
        }
        return lista;
    }
    
    private void cerrarConexiones() {
        try {
            if (res != null) {
                res.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.cerrarConexion();
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object updateEstado(Object id, Object estado) {
        try {

            pstm = con.getCon().prepareStatement(SQL_UpdateEstado);
            pstm.setInt(1, Integer.parseInt((String) estado));
            pstm.setInt(2, Integer.parseInt((String) id));
            if (pstm.executeUpdate() > 0) {
                return estado;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.cerrarConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return estado;
    }

   
    
    public boolean cambiarEstado(String estado) {
        boolean result=false;
        try {
            pstm = con.getCon().prepareStatement(SQL_ActualizarEstado);
            pstm.setInt(1, Integer.parseInt(estado));
                   
            if (pstm.executeUpdate() > 0) {
                result=true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.cerrarConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return result;
    }

}


    
