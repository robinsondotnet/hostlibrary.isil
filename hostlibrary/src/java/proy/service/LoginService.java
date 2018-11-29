package proy.service;

import java.util.List;
import proy.entidades.EmpleadoLog;

public interface LoginService {
    public EmpleadoLog validar(String user, String password);
    public int registrar(EmpleadoLog user);
    /*public int cambiarPassword (String oldPassword, String newoldPassword);
    
    public int registrarEmpleado(EmpleadoLog service);
    public int eliminarEmpleado(int codigo);
    public int actualizarEmpleado(EmpleadoLog service);
    public List<EmpleadoLog> obtenerEmpleado();
    public EmpleadoLog buscarEmpleado(int codigo);*/
}
