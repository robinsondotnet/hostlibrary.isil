package proy.controladores;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import proy.daos.EmpleadoDao;
import proy.daos.ValidarDao;
import proy.entidades.Empleado;
import proy.entidades.EmpleadoLog;


@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController {
     String user="Invitado";
    String password;
    String mensaje;

    public String validar(){
        ValidarDao dao = new ValidarDao();
        EmpleadoLog admin = dao.validar(user,password);
        if(admin!=null){
            mensaje = "Ingreso: "+admin.getEmail();
            return "ventas";
        }if(admin==null ){
            mensaje = "Invitado";
            return "ventas";
                    }
        else{
            mensaje = "No Ingreso";
            return "index";
        }
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
