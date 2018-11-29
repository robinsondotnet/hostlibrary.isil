package proy.daos;

import proy.entidades.Libro;
import proy.service.AbstractEntity;


public class LibroDao extends AbstractEntity<Libro> {
    
    public LibroDao(Class<Libro> obj) {
        super(obj);
    }
}
