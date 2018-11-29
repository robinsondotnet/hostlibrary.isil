package proy.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "boleta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletaDetalle.findAll", query = "SELECT b FROM BoletaDetalle b")
    , @NamedQuery(name = "BoletaDetalle.findByIdBoleta", query = "SELECT b FROM BoletaDetalle b WHERE b.idBoleta = :idBoleta")
    , @NamedQuery(name = "BoletaDetalle.findByIdTienda", query = "SELECT b FROM BoletaDetalle b WHERE b.idTienda = :idTienda")
    , @NamedQuery(name = "BoletaDetalle.findByIdLibro", query = "SELECT b FROM BoletaDetalle b WHERE b.idLibro = :idLibro")
    , @NamedQuery(name = "BoletaDetalle.findByCantidad", query = "SELECT b FROM BoletaDetalle b WHERE b.cantidad = :cantidad")
    , @NamedQuery(name = "BoletaDetalle.findByPrecioTotal", query = "SELECT b FROM BoletaDetalle b WHERE b.precioTotal = :precioTotal")})
public class BoletaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_boleta")
    private Integer idBoleta;
    @Basic(optional = false)
    @Column(name = "id_tienda")
    private int idTienda;
    @Basic(optional = false)
    @Column(name = "id_libro")
    private int idLibro;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio_total")
    private double precioTotal;

    public BoletaDetalle() {
    }

    public BoletaDetalle(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public BoletaDetalle(Integer idBoleta, int idTienda, int idLibro, int cantidad, double precioTotal) {
        this.idBoleta = idBoleta;
        this.idTienda = idTienda;
        this.idLibro = idLibro;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleta != null ? idBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoletaDetalle)) {
            return false;
        }
        BoletaDetalle other = (BoletaDetalle) object;
        if ((this.idBoleta == null && other.idBoleta != null) || (this.idBoleta != null && !this.idBoleta.equals(other.idBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proy.entidades.BoletaDetalle[ idBoleta=" + idBoleta + " ]";
    }
    
}
