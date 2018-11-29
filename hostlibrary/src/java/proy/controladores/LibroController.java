package proy.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.primefaces.model.chart.PieChartModel;
import proy.daos.EmpleadoDao;
import proy.daos.LibroDao;
import proy.entidades.Empleado;
import proy.entidades.Libro;

@ManagedBean(name="libroController")
@SessionScoped
public class LibroController {
    Libro obj;
    List<Libro> lstLibro;
    private LibroDao dao;
    private List<SelectItem> lLibro;
    private String strLibro;
    private PieChartModel pieModel;
    
    private void crearGrafico(){
        pieModel = new PieChartModel();
        for(Libro libro:dao.findAll()){
            pieModel.set(libro.getGenero(),libro.getStock());
        }
        
    }

    public LibroController() {
        dao = new LibroDao(Libro.class);
        obj = new Libro();
        lstLibro = new ArrayList<>();
        lLibro  = new ArrayList<>();
        crearGrafico();
    }
    
    //creamos empleado
    public void create(){
        dao.create(obj);
    }
    
    //borramos empleado
    public void delete(Libro obj){
        dao.remove(obj);
    }
    
    //actualizamos
    public void update(Libro obj){
        dao.edit(obj);
    }
    
    //obtener empleado
    public Libro getLibro() {
        return obj;
    }
    
    //setear empleado 
    public void setLibro(Libro emp) {
        this.obj = emp;
    }
    
    //obtener lista empleado
    public List<Libro> getLstLibro() {
        lstLibro = dao.findAll();
        return lstLibro;
    }
    
    //setear lista
    public void setLstEmpleado(List<Libro> lstLibro) {
        this.lstLibro = lstLibro;
    }

    //
    public void setlLibro(List<SelectItem> lLibro) {
        this.lLibro = lLibro;
    }
    
    //llenar la lista de emepleados que será usada en el combo
     public List<SelectItem> getlLibro() {
         lLibro = new ArrayList<>();
         SelectItem item;
         for(Libro p :dao.findAll() ) {
             item = new SelectItem(p.getIdLibro(),
                        p.getTitulo());
             lLibro.add(item);
         }
        return lLibro;
    }

    public String getStrEmpleado() {
        return strLibro;
    }

    public void setStringMensaje(String strProducto) {
        this.strLibro = strProducto;
    }
    
      public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("cmbLibro")){
            Libro prod = dao.find(evento.getNewValue().toString());
            
            setStringMensaje(prod.getIdLibro()+":"+
                        prod.getTitulo()+":"+
                        prod.getGenero());
        }
     }
    
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
}