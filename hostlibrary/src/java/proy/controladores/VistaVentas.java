/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.PieChartModel;
import proy.daos.vwVentas;
import proy.entidades.Publicador;
import proy.entidades.VwVentasempleado;

/**
 *
 * @author Diego
 */
@ManagedBean(name="vistaVentas")
@SessionScoped
public class VistaVentas {
    private VwVentasempleado obj;
    private vwVentas dao;
    private PieChartModel pieModel;

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

     public VistaVentas() {
        dao = new vwVentas(VwVentasempleado.class);
        obj = new VwVentasempleado();
        crearGrafico();
    }
    private void crearGrafico(){
        pieModel = new PieChartModel();
        for(VwVentasempleado vista:dao.findAll()){
            pieModel.set(vista.getNombre(),vista.getContador());
            
        }
        
        
    }
}
