package proy.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import proy.daos.EmpleadoDao;
import proy.entidades.Empleado;

@ManagedBean(name="empleadoController")
@SessionScoped
public class EmpleadoController {
    Empleado obj;
    List<Empleado> lstEmpleado;
    private EmpleadoDao dao;
    private List<SelectItem> lEmpleado;
    private String strProducto;

    public EmpleadoController() {
        dao = new EmpleadoDao(Empleado.class);
        obj = new Empleado();
        lstEmpleado = new ArrayList<>();
        lEmpleado  = new ArrayList<>();
    }
    
    //creamos empleado
    public void create(){
        dao.create(obj);
    }
    
    //borramos empleado
    public void delete(Empleado obj){
        dao.remove(obj);
    }
    
    //actualizamos
    public void update(Empleado obj){
        dao.edit(obj);
    }
    
    //obtener empleado
    public Empleado getEmpleado() {
        return obj;
    }
    
    //setear empleado 
    public void setEmpleado(Empleado emp) {
        this.obj = emp;
    }
    
    //obtener lista empleado
    public List<Empleado> getLstEmpleado() {
        lstEmpleado = dao.findAll();
        return lstEmpleado;
    }
    
    //setear lista
    public void setLstEmpleado(List<Empleado> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }

    //
    public void setlEmpleado(List<SelectItem> lEmpleado) {
        this.lEmpleado = lEmpleado;
    }
    
    //llenar la lista de emepleados que será usada en el combo
     public List<SelectItem> getlProducto() {
         lEmpleado = new ArrayList<>();
         SelectItem item;
         for(Empleado p :dao.findAll() ) {
             item = new SelectItem(p.getIdEmpleado(),
                        p.getNombre());
             lEmpleado.add(item);
         }
        return lEmpleado;
    }

    public String getStrEmpleado() {
        return strProducto;
    }

    public void setStringMensaje(String strProducto) {
        this.strProducto = strProducto;
    }
    
      public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("cmbEmpleado")){
            Empleado prod = dao.find(evento.getNewValue().toString());
            
            setStringMensaje(prod.getIdEmpleado()+":"+
                        prod.getNombre()+":"+
                        prod.getApellido());
        }
     }
    
}
