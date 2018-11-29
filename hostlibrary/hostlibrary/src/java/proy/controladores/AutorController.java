package proy.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import proy.daos.AutorDao;
import proy.entidades.Autor;


@ManagedBean(name="autorController")
@SessionScoped
public class AutorController {
    Autor obj;
    List<Autor> lstAutor;
    private AutorDao dao;
    private List<SelectItem> lAutor;
    private String strAutor;

    public AutorController() {
        dao = new AutorDao(Autor.class);
        obj = new Autor();
        lstAutor = new ArrayList<>();
        lAutor  = new ArrayList<>();
    }
    
    //creamos Autor
    public void create(){
        dao.create(obj);
    }
    
    //borramos Autor
    public void delete(Autor obj){
        dao.remove(obj);
    }
    
    //actualizamos
    public void update(Autor obj){
        dao.edit(obj);
    }
    
    //obtener Autor
    public Autor getAutor() {
        return obj;
    }
    
    //setear Autor 
    public void setAutor(Autor emp) {
        this.obj = emp;
    }
    
    //obtener lista Autor
    public List<Autor> getLstAutor() {
        lstAutor = dao.findAll();
        return lstAutor;
    }
    
    //setear lista
    public void setLstAutor(List<Autor> lstAutor) {
        this.lstAutor = lstAutor;
    }

    //
    public void setlAutor(List<SelectItem> lAutor) {
        this.lAutor = lAutor;
    }
    
    //llenar la lista de emepleados que será usada en el combo
     public List<SelectItem> getlAutor() {
         lAutor = new ArrayList<>();
         SelectItem item;
         for(Autor p :dao.findAll() ) {
             item = new SelectItem(p.getIdAutor(),
                        p.getNombre());
             lAutor.add(item);
         }
        return lAutor;
    }

    public String getStrAutor() {
        return strAutor;
    }

    public void setStringMensaje(String strProducto) {
        this.strAutor = strProducto;
    }
    
      public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("cmbAutor")){
            Autor prod = dao.find(evento.getNewValue().toString());
            
            setStringMensaje(prod.getIdAutor()+":"+
                        prod.getNombre());
        }
     }

}

