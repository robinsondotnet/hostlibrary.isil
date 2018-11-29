package proy.entidades;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
@Table(name = "empleado_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoLog.findAll", query = "SELECT e FROM EmpleadoLog e")
    , @NamedQuery(name = "EmpleadoLog.findByIdLog", query = "SELECT e FROM EmpleadoLog e WHERE e.idLog = :idLog")
    , @NamedQuery(name = "EmpleadoLog.findByIdEmpleado", query = "SELECT e FROM EmpleadoLog e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "EmpleadoLog.findByEmail", query = "SELECT e FROM EmpleadoLog e WHERE e.email = :email")
    , @NamedQuery(name = "EmpleadoLog.findByContraseña", query = "SELECT e FROM EmpleadoLog e WHERE e.contraseña = :contraseña")
    , @NamedQuery(name = "validarLogin", query = "SELECT e FROM EmpleadoLog e WHERE e.email = :us and e.contraseña = :ps")})
public class EmpleadoLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log")
    private Integer idLog;
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private int idEmpleado;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "contraseña")
    private String contraseña;

    public EmpleadoLog() {
    }

    public EmpleadoLog(Integer idLog) {
        this.idLog = idLog;
    }

    public EmpleadoLog(Integer idLog, int idEmpleado, String email, String contraseña) {
        this.idLog = idLog;
        this.idEmpleado = idEmpleado;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoLog)) {
            return false;
        }
        EmpleadoLog other = (EmpleadoLog) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proy.entidades.EmpleadoLog[ idLog=" + idLog + " ]";
    }
    
}
        
    

