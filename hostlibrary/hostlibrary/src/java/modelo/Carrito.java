package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Carrito {

	private String dni_cliente;
	private int empleado;
        private int idTienda;

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
	private List<CarritoItem> items;

	public Carrito() {
		items = new ArrayList<CarritoItem>();
	}

	public String getDNICliente() {
		return dni_cliente;
	}
        public  String getFechaActual() {
                Calendar calendario = new GregorianCalendar();
                return String.valueOf(calendario.get(Calendar.DAY_OF_MONTH))
                + "-" + String.valueOf(calendario.get(Calendar.MONTH))
                + "-" + String.valueOf(calendario.get(Calendar.YEAR));
	}

	public void setDNICliente(String cliente) {
		this.dni_cliente = cliente;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}



	public List<CarritoItem> getItems() {
		return items;
	}

	public void add(CarritoItem item) {
		if (item == null) {
			return;
		}
		boolean encontro = false;
		for (CarritoItem i : items) {
			if( i.getId() == item.getId() ){
				i.setCant( i.getCant() + item.getCant());
				i.setSubtotal( i.getSubtotal() + item.getSubtotal());
				encontro = true;
			}
		}
		if (!encontro) {
			items.add(item);
		}
		int k = 0;
		while( k < items.size() ){
			if( items.get(k).getCant() <= 0 ){
				items.remove(k);
			} else {
				k++;
			}
		}
	}

	public Double getTotal() {
		Double t = 0.0;
		for (CarritoItem i : items) {
			t += i.getSubtotal();
		}
		return t;
	}

	public Double getImporte() {
		Double i;
		i = getTotal() / 1.18;
		return i;
	}

	public Double getImpuesto() {
		Double imp;
		imp = getTotal() - getImporte();
		return imp;
	}

	public void remove( int id ) {
		for (CarritoItem i : items) {
			if( i.getId() == id ){
				items.remove(i);
				break;
			}
		}
	}

	public void clear() {
		items.clear();
	}


}
