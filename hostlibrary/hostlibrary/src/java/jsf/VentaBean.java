package jsf;

import proy.entidades.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import modelo.Carrito;
import modelo.CarritoItem;
import proy.controladores.TiendaController;
import proy.entidades.Empleado;
import proy.entidades.Tienda;
import proy.service.VentaService;

@ManagedBean
@SessionScoped
public class VentaBean implements Serializable {

	// Empleado
	private Empleado empleado = null;
	private String usuario = "";
	private String clave = "";
	private String mensaje = "";
	// Venta
        private String dni_cli;

    public String getDni_cli() {
        return dni_cli;
    }

    public void setDni_cli(String dni_cli) {
        this.dni_cli = dni_cli;
    }
	private int idlibro;
	private int idArticulo;
        private int idTienda;

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
	private Double precio = 0.0;
	private int cant = 1;
	private Double subtotal = 0.0;
	private List<SelectItem> listaClientes = null;
	private List<SelectItem> listaArticulos = null;
        private List<SelectItem> listaTienda = null;
	private Carrito carrito = new Carrito();
        


	public VentaBean() {
	}

	public Carrito getCarrito() {
		return carrito;
	}



	public Double getSubtotal() {
		return subtotal;
	}


	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public List<SelectItem> getListaArticulos() {
		if (listaArticulos == null) {
			try {
				listaArticulos = new ArrayList<SelectItem>();
				VentaService srv = new VentaService();
				List<Libro> lista = srv.consultarArticulos();
				listaArticulos.add(new SelectItem(0, "Seleccione un articulo"));
				for (Libro o : lista) {
					SelectItem op = new SelectItem();
					op.setValue(o.getIdLibro());
					op.setLabel(o.getTitulo());
					listaArticulos.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaArticulos;
	}
        public List<SelectItem> getListaTienda() {
		if (listaTienda == null) {
			try {
				listaTienda = new ArrayList<SelectItem>();
				VentaService srv = new VentaService();
				List<Tienda> lista = srv.consultarTienda();
				listaTienda.add(new SelectItem(0, "Seleccione una tienda"));
				for (Tienda o : lista) {
					SelectItem op = new SelectItem();
					op.setValue(o.getIdTienda());
					op.setLabel(o.getNombre());
					listaArticulos.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaTienda;
	}

	public List<SelectItem> getListaClientes() {
		if (listaClientes == null) {
			try {
				listaClientes = new ArrayList<SelectItem>();
				VentaService srv = new VentaService();
				List<Libro> lista = srv.consultarArticulos();
				for (Libro c : lista) {
					SelectItem op = new SelectItem();
					op.setValue(c.getIdLibro());
					op.setLabel(c.getTitulo());
					listaClientes.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaClientes;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/*public String doIngresar() {
		String destino = "ventas";
		mensaje = "";
		try {
			VentaService srv = new VentaService();
			//empleado = srv.validarIngreso(usuario, clave);
		} catch (Exception e) {
			mensaje = e.getMessage();
			destino = "index";
		}
		return destino;
	}*/

	/*public String doSalir() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		req.getSession(true).invalidate();
		return "index";
	}*/

	public void modificarPrecio(ValueChangeEvent event) {
		try {
			int idArt = (int) event.getNewValue();
			VentaService srv = new VentaService();
			Libro a = srv.consultarArticulo(idArt);
			precio = a.getPrecio();
			subtotal = precio * cant;
		} catch (Exception e) {
			precio = 0.0;
		}
	}

	public void modificarCantidad(ValueChangeEvent event) {
		try {
			int c = (int) event.getNewValue();
			subtotal = precio * c;
		} catch (Exception e) {
			precio = 0.0;
		}
	}

	public String doAgregarItem(){
		try {
			VentaService srv = new VentaService();
			Libro a = srv.consultarArticulo(idArticulo);
			CarritoItem item = new CarritoItem();
			item.setId(a.getIdLibro());
			item.setNombre(a.getTitulo());
			item.setPrecio(a.getPrecio());
			item.setCant(cant);
			item.setSubtotal(item.getPrecio() * item.getCant());
			carrito.add(item);
		} catch (Exception e) {
		}
		return "ventas";
	}

	public String doEliminarItem( int id ) {
		carrito.remove(id);
		return "ventas";
	}

	public String doGrabar(){
		mensaje = "";
		try {
                        carrito.setIdTienda(idTienda);
			carrito.setDNICliente(dni_cli);
			carrito.setEmpleado(empleado.getIdEmpleado());
			VentaService srv = new VentaService();
			srv.grabarVenta(carrito);
			carrito.clear();
			mensaje = "Proceso ok.";
		} catch (Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		return "ventas";
	}


}
