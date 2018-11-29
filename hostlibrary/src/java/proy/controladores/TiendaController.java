package proy.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import proy.daos.TiendaDao;
import proy.entidades.Tienda;


@ManagedBean(name="tiendaController")
@SessionScoped
public class TiendaController {
    Tienda obj;
    List<Tienda> lstTienda;
    private TiendaDao dao;
    private List<SelectItem> lTienda;
    private String strTienda;

    public TiendaController() {
        dao = new TiendaDao(Tienda.class);
        obj = new Tienda();
        lstTienda = new ArrayList<>();
        lTienda  = new ArrayList<>();
    }
    
    //creamos Tienda
    public void create(){
        dao.create(obj);
    }
    
    //borramos Tienda
    public void delete(Tienda obj){
        dao.remove(obj);
    }
    
    //actualizamos
    public void update(Tienda obj){
        dao.edit(obj);
    }
    
    //obtener Tienda
    public Tienda getTienda() {
        return obj;
    }
    
    //setear Tienda 
    public void setTienda(Tienda emp) {
        this.obj = emp;
    }
    
    //obtener lista Tienda
    public List<Tienda> getLstTienda() {
        lstTienda = dao.findAll();
        return lstTienda;
    }
    
    //setear lista
    public void setLstTienda(List<Tienda> lstTienda) {
        this.lstTienda = lstTienda;
    }

    //
    public void setlTienda(List<SelectItem> lTienda) {
        this.lTienda = lTienda;
    }
    
    //llenar la lista de emepleados que será usada en el combo
     public List<SelectItem> getlTienda() {
         lTienda = new ArrayList<>();
         SelectItem item;
         for(Tienda p :dao.findAll() ) {
             item = new SelectItem(p.getIdTienda(),
                        p.getNombre());
             lTienda.add(item);
         }
        return lTienda;
    }
     

    public String getStrTienda() {
        return strTienda;
    }

    public void setStringMensaje(String strProducto) {
        this.strTienda = strProducto;
    }
    
      public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("cmbTienda")){
            Tienda prod = dao.find(evento.getNewValue().toString());
            
            setStringMensaje(prod.getIdTienda()+":"+
                        prod.getIdTienda()+":"+
                        prod.getNombre());
        }
     }

}

