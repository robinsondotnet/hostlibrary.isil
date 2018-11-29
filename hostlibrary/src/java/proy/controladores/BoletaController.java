package proy.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import proy.daos.BoletaDao;
import proy.entidades.Boleta;


@ManagedBean(name="boletaController")
@SessionScoped
public class BoletaController {
    Boleta obj;
    List<Boleta> lstBoleta;
private BoletaDao dao;
    private List<SelectItem> lBoleta;
    private String strBoleta;

    public BoletaController() {
        dao = new BoletaDao(Boleta.class);
        obj = new Boleta();
        lstBoleta = new ArrayList<>();
        lBoleta  = new ArrayList<>();
    }
    
    //creamos Boleta
    public void create(){
        dao.create(obj);
    }
    
    //borramos Boleta
    public void delete(Boleta obj){
        dao.remove(obj);
    }
    
    //actualizamos
    public void update(Boleta obj){
        dao.edit(obj);
    }
    
    //obtener Boleta
    public Boleta getBoleta() {
        return obj;
    }
    
    //setear Boleta 
    public void setBoleta(Boleta emp) {
        this.obj = emp;
    }
    
    //obtener lista Boleta
    public List<Boleta> getLstBoleta() {
        lstBoleta = dao.findAll();
        return lstBoleta;
    }
    
    //setear lista
    public void setLstBoleta(List<Boleta> lstBoleta) {
        this.lstBoleta = lstBoleta;
    }

    //
    public void setlBoleta(List<SelectItem> lBoleta) {
        this.lBoleta = lBoleta;
    }
    
    //llenar la lista de emepleados que será usada en el combo
     public List<SelectItem> getlBoleta() {
         lBoleta = new ArrayList<>();
         SelectItem item;
         for(Boleta p :dao.findAll() ) {
            item = new SelectItem(p.getIdBoleta(),
                        p.getFecha().toString());
             lBoleta.add(item);
         }
        return lBoleta;
    }

    public String getStrBoleta() {
        return strBoleta;
    }

    public void setStringMensaje(String strProducto) {
        this.strBoleta = strProducto;
    }
    
      public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("cmbBoleta")){
            Boleta prod = dao.find(evento.getNewValue().toString());
            
            setStringMensaje(prod.getIdBoleta()+":"+
                         prod.getFecha().toString())
                    ;
        }
     }

}

