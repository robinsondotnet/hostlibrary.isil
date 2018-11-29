package proy.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import proy.daos.CargoDao;
import proy.entidades.Cargo;


@ManagedBean(name="cargoController")
@SessionScoped
public class CargoController {
    Cargo obj;
    List<Cargo> lstCargo;
private CargoDao dao;
    private List<SelectItem> lCargo;
    private String strCargo;

    public CargoController() {
        dao = new CargoDao(Cargo.class);
        obj = new Cargo();
        lstCargo = new ArrayList<>();
        lCargo  = new ArrayList<>();
    }
    
    //creamos Cargo
    public void create(){
        dao.create(obj);
    }
    
    //borramos Cargo
    public void delete(Cargo obj){
        dao.remove(obj);
    }
    
    //actualizamos
    public void update(Cargo obj){
        dao.edit(obj);
    }
    
    //obtener Cargo
    public Cargo getCargo() {
        return obj;
    }
    
    //setear Cargo 
    public void setCargo(Cargo emp) {
        this.obj = emp;
    }
    
    //obtener lista Cargo
    public List<Cargo> getLstCargo() {
        lstCargo = dao.findAll();
        return lstCargo;
    }
    
    //setear lista
    public void setLstCargo(List<Cargo> lstCargo) {
        this.lstCargo = lstCargo;
    }

    //
    public void setlCargo(List<SelectItem> lCargo) {
        this.lCargo = lCargo;
    }
    
    //llenar la lista de emepleados que será usada en el combo
     public List<SelectItem> getlCargo() {
         lCargo = new ArrayList<>();
         SelectItem item;
         for(Cargo p :dao.findAll() ) {
             item = new SelectItem(p.getIdCargo(),
                        p.getNombreCargo());
             lCargo.add(item);
         }
        return lCargo;
    }

    public String getStrCargo() {
        return strCargo;
    }

    public void setStringMensaje(String strProducto) {
        this.strCargo = strProducto;
    }
    
      public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("cmbCargo")){
            Cargo prod = dao.find(evento.getNewValue().toString());
            
            setStringMensaje(prod.getIdCargo()+":"+
                        prod.getIdCargo()+":"+
                        prod.getNombreCargo());
        }
     }

}

