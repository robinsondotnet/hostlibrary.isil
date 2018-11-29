/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro")
    , @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Libro.findByGenero", query = "SELECT l FROM Libro l WHERE l.genero = :genero")
    , @NamedQuery(name = "Libro.findByIdPublicador", query = "SELECT l FROM Libro l WHERE l.idPublicador = :idPublicador")
    , @NamedQuery(name = "Libro.findByIdAutor", query = "SELECT l FROM Libro l WHERE l.idAutor = :idAutor")
    , @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio")
    , @NamedQuery(name = "Libro.findByFecPublicacion", query = "SELECT l FROM Libro l WHERE l.fecPublicacion = :fecPublicacion")
    , @NamedQuery(name = "Libro.findByNumPaginas", query = "SELECT l FROM Libro l WHERE l.numPaginas = :numPaginas")
    , @NamedQuery(name = "Libro.findByPaisPublicacion", query = "SELECT l FROM Libro l WHERE l.paisPublicacion = :paisPublicacion")
    , @NamedQuery(name = "Libro.findByStock", query = "SELECT l FROM Libro l WHERE l.stock = :stock")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libro")
    private Integer idLibro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "id_publicador")
    private int idPublicador;
    @Basic(optional = false)
    @Column(name = "id_autor")
    private int idAutor;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @Column(name = "fec_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecPublicacion;
    @Basic(optional = false)
    @Column(name = "num_paginas")
    private int numPaginas;
    @Basic(optional = false)
    @Column(name = "pais_publicacion")
    private String paisPublicacion;
    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(Integer idLibro, String titulo, String genero, int idPublicador, int idAutor, double precio, Date fecPublicacion, int numPaginas, String paisPublicacion, int stock) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.genero = genero;
        this.idPublicador = idPublicador;
        this.idAutor = idAutor;
        this.precio = precio;
        this.fecPublicacion = fecPublicacion;
        this.numPaginas = numPaginas;
        this.paisPublicacion = paisPublicacion;
        this.stock = stock;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdPublicador() {
        return idPublicador;
    }

    public void setIdPublicador(int idPublicador) {
        this.idPublicador = idPublicador;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecPublicacion() {
        return fecPublicacion;
    }

    public void setFecPublicacion(Date fecPublicacion) {
        this.fecPublicacion = fecPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getPaisPublicacion() {
        return paisPublicacion;
    }

    public void setPaisPublicacion(String paisPublicacion) {
        this.paisPublicacion = paisPublicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proy.entidades.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
