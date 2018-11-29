/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "vw_ventasempleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwVentasempleado.findAll", query = "SELECT v FROM VwVentasempleado v")
    , @NamedQuery(name = "VwVentasempleado.findByContador", query = "SELECT v FROM VwVentasempleado v WHERE v.contador = :contador")
    , @NamedQuery(name = "VwVentasempleado.findByNombre", query = "SELECT v FROM VwVentasempleado v WHERE v.nombre = :nombre")})
public class VwVentasempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "contador")
    @Id
    private long contador;
    @Column(name = "nombre")
    private String nombre;

    public VwVentasempleado() {
    }

    public long getContador() {
        return contador;
    }

    public void setContador(long contador) {
        this.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
