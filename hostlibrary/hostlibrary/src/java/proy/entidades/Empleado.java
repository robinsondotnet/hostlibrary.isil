package proy.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleado.findByDni", query = "SELECT e FROM Empleado e WHERE e.dni = :dni")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empleado.findByFecNacimiento", query = "SELECT e FROM Empleado e WHERE e.fecNacimiento = :fecNacimiento")
    , @NamedQuery(name = "Empleado.findByIdCargo", query = "SELECT e FROM Empleado e WHERE e.idCargo = :idCargo")
    , @NamedQuery(name = "Empleado.findByIdTienda", query = "SELECT e FROM Empleado e WHERE e.idTienda = :idTienda")
    , @NamedQuery(name = "Empleado.findByRemuneracion", query = "SELECT e FROM Empleado e WHERE e.remuneracion = :remuneracion")
    , @NamedQuery(name = "Empleado.findByFecInicio", query = "SELECT e FROM Empleado e WHERE e.fecInicio = :fecInicio")
    , @NamedQuery(name = "Empleado.findByFecCese", query = "SELECT e FROM Empleado e WHERE e.fecCese = :fecCese")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacimiento;
    @Basic(optional = false)
    @Column(name = "id_cargo")
    private int idCargo;
    @Basic(optional = false)
    @Column(name = "id_tienda")
    private int idTienda;
    @Basic(optional = false)
    @Column(name = "remuneracion")
    private double remuneracion;
    @Basic(optional = false)
    @Column(name = "fec_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio;
    @Basic(optional = false)
    @Column(name = "fec_cese")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCese;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String dni, String nombre, String apellido, String direccion, Date fecNacimiento, int idCargo, int idTienda, double remuneracion, Date fecInicio, Date fecCese) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fecNacimiento = fecNacimiento;
        this.idCargo = idCargo;
        this.idTienda = idTienda;
        this.remuneracion = remuneracion;
        this.fecInicio = fecInicio;
        this.fecCese = fecCese;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecCese() {
        return fecCese;
    }

    public void setFecCese(Date fecCese) {
        this.fecCese = fecCese;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proy.entidades.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
