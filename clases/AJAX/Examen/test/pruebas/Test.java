/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import dao.daoProducto;

/**
 *
 * @author Alumno
 */
public class Test {
    
    public static void main(String[] args) {
        daoProducto dao = new daoProducto();
        
        dao.cambiarEstado("20");
        
        
        
    }
    
}
