package proy.daos;

import proy.entidades.Empleado;
import proy.service.AbstractEntity;

public class EmpleadoDao extends AbstractEntity<Empleado> {
    
    public EmpleadoDao(Class<Empleado> obj) {
        super(obj);
    }
}
