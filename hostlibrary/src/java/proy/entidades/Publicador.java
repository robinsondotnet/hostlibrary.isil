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
@Table(name = "publicador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicador.findAll", query = "SELECT p FROM Publicador p")
    , @NamedQuery(name = "Publicador.findByIdPublicador", query = "SELECT p FROM Publicador p WHERE p.idPublicador = :idPublicador")
    , @NamedQuery(name = "Publicador.findByRuc", query = "SELECT p FROM Publicador p WHERE p.ruc = :ruc")
    , @NamedQuery(name = "Publicador.findByRazSocial", query = "SELECT p FROM Publicador p WHERE p.razSocial = :razSocial")
    , @NamedQuery(name = "Publicador.findByTelefono", query = "SELECT p FROM Publicador p WHERE p.telefono = :telefono")})
public class Publicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_publicador")
    private Integer idPublicador;
    @Basic(optional = false)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @Column(name = "raz_social")
    private String razSocial;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;

    public Publicador() {
    }

    public Publicador(Integer idPublicador) {
        this.idPublicador = idPublicador;
    }

    public Publicador(Integer idPublicador, String ruc, String razSocial, int telefono) {
        this.idPublicador = idPublicador;
        this.ruc = ruc;
        this.razSocial = razSocial;
        this.telefono = telefono;
    }

    public Integer getIdPublicador() {
        return idPublicador;
    }

    public void setIdPublicador(Integer idPublicador) {
        this.idPublicador = idPublicador;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazSocial() {
        return razSocial;
    }

    public void setRazSocial(String razSocial) {
        this.razSocial = razSocial;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicador != null ? idPublicador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicador)) {
            return false;
        }
        Publicador other = (Publicador) object;
        if ((this.idPublicador == null && other.idPublicador != null) || (this.idPublicador != null && !this.idPublicador.equals(other.idPublicador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proy.entidades.Publicador[ idPublicador=" + idPublicador + " ]";
    }
    
}
