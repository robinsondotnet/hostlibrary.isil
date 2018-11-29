package proy.service;


import proy.entidades.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Carrito;
import modelo.CarritoItem;
import proy.entidades.Tienda;
import proy.util.DBConn;

public class VentaService {

	public List<Libro> consultarArticulos() throws Exception {
		List<Libro> lista = new ArrayList<>();
		Connection cn = null;
		try {
			String query = "SELECT id_libro, titulo, precio, stock FROM libro ";
			cn = DBConn.getConnection();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Libro o = new Libro();
				o.setIdLibro(rs.getInt("id_libro"));
				o.setTitulo(rs.getString("titulo"));
				o.setPrecio(rs.getDouble("precio"));
				o.setStock(rs.getInt("stock"));
				lista.add(o);
			}
			stm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}
        public List<Tienda> consultarTienda() throws Exception {
		List<Tienda> lista = new ArrayList<>();
		Connection cn = null;
		try {
			String query = "SELECT id_tienda, nombre FROM tienda ";
			cn = DBConn.getConnection();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Tienda o = new Tienda();
				o.setIdTienda(rs.getInt("id_tienda"));
				o.setNombre(rs.getString("nombre"));
				lista.add(o);
			}
			stm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}
        

	public Libro consultarArticulo(int idArt) throws Exception {
		Libro art;
		Connection cn = null;
		try {
			String query = "SELECT id_libro, titulo, precio, stock FROM libro where id_libro = ?";
			cn = DBConn.getConnection();
			PreparedStatement pstm = cn.prepareStatement(query);
			pstm.setLong(1, idArt);
			ResultSet rs = pstm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Articulo no existe.");
			}
			art = new Libro();
			art.setIdLibro(rs.getInt("id_libro"));
			art.setTitulo(rs.getString("titulo"));
			art.setPrecio(rs.getDouble("precio"));
                        art.setStock(rs.getInt("stock"));
			pstm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return art;
	}

	public void grabarVenta(Carrito carrito) throws Exception{
		Connection cn = null;
		try {
                    System.out.println("f");
			cn = DBConn.getConnection();
			cn.setAutoCommit(false);
			// Grabar la cabecera
			String query = "insert into boleta(fecha,dni_cliente, id_empleado) values(sysdate(),?,?)";
			PreparedStatement pstm = cn.prepareStatement(query);
			pstm.setString(1, carrito.getDni_cliente());
			pstm.setDouble(2, carrito.getEmpleado());

			pstm.executeUpdate();
			// Obtener el id des venta
			query = "select LAST_INSERT_ID() as id"; //funcion mysql
			pstm = cn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			int idVenta = rs.getInt("id");
			// Grabar los detalles y actualizar los stocks
			for (CarritoItem i : carrito.getItems()) {
				// Stock
				Libro a = consultarArticulo(i.getId());
				if( i.getCant() > a.getStock() ){
					throw new Exception("Solo quedan " + a.getStock()+ " libros.");
				}
                                else
                                {
                                    query = "update libro set stock = stock - ? where id_libro = ?";
                                    pstm = cn.prepareStatement(query);
                                    pstm.setInt(1, i.getCant());
                                    pstm.setInt(2, i.getId());
                                    pstm.executeUpdate();
                                    // Grabar el detalle
                                    query = "insert into boleta_detalle(id_boleta,id_libro,precio_total,cantidad) values(?,?,?,?)";
                                    pstm = cn.prepareStatement(query);
                                    pstm.setInt(1, idVenta);
                                    pstm.setInt(2, i.getId());
                                    pstm.setDouble(3, i.getSubtotal());
                                    pstm.setInt(4, i.getCant());
                                    pstm.executeUpdate();
                                }
				
			}
			cn.commit();
			pstm.close();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}
}
