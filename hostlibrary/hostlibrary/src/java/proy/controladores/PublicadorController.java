package proy.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import proy.daos.LibroDao;
import proy.daos.PublicadorDao;
import proy.entidades.Libro;
import proy.entidades.Publicador;


@ManagedBean(name="publicadorController")
@SessionScoped
public class PublicadorController {
    Publicador obj;
    List<Publicador> lstPublicador;
    private PublicadorDao dao;
    private List<SelectItem> lPublicador;
    private String strPublicador;

    public PublicadorController() {
        dao = new PublicadorDao(Publicador.class);
        obj = new Publicador();
        lstPublicador = new ArrayList<>();
        lPublicador  = new ArrayList<>();
    }
    
    //creamos empleado
    public void create(){
        dao.create(obj);
    }
    
    //borramos empleado
    public void delete(Publicador obj){
        dao.remove(obj);
    }
    
    //actualizamos
    public void update(Publicador obj){
        dao.edit(obj);
    }
    
    //obtener empleado
    public Publicador getPublicador() {
        return obj;
    }
    
    //setear empleado 
    public void setPublicador(Publicador emp) {
        this.obj = emp;
    }
    
    //obtener lista empleado
    public List<Publicador> getLstPublicador() {
        lstPublicador = dao.findAll();
        return lstPublicador;
    }
    
    //setear lista
    public void setLstEmpleado(List<Publicador> lstPublicador) {
        this.lstPublicador = lstPublicador;
    }

    //
    public void setlPublicador(List<SelectItem> lPublicador) {
        this.lPublicador = lPublicador;
    }
    
    //llenar la lista de emepleados que será usada en el combo
     public List<SelectItem> getlPublicador() {
         lPublicador = new ArrayList<>();
         SelectItem item;
         for(Publicador p :dao.findAll() ) {
             item = new SelectItem(p.getIdPublicador(),
                        p.getRazSocial());
             lPublicador.add(item);
         }
        return lPublicador;
    }

    public String getStrEmpleado() {
        return strPublicador;
    }

    public void setStringMensaje(String strProducto) {
        this.strPublicador = strProducto;
    }
    
      public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("cmbPublicador")){
            Publicador prod = dao.find(evento.getNewValue().toString());
            
            setStringMensaje(prod.getIdPublicador()+":"+
                        prod.getIdPublicador()+":"+
                        prod.getRazSocial());
        }
     }

}
