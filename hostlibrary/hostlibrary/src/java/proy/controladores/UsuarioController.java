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
    
    EmpleadoLog obj;
    private ValidarDao dao;
    
    
}
