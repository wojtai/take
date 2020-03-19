/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author wojtek
 */
@Named(value="chartBean")
@RequestScoped
public class ChartBean {
    
    private LineChartModel model;
    
    public ChartBean() {
        this.model = new LineChartModel();
        model.setZoom(true);
        LineChartSeries s1 = new LineChartSeries();
        s1.setLabel("sin");
        
        LineChartSeries s2 = new LineChartSeries();
        s2.setLabel("cos");
        
        for(double x = 0; x<=360; x+=10) {
            double radians = Math.toRadians(x);
            s1.set(x, Math.sin(radians));
            s2.set(x, Math.cos(radians));
        }
        model.addSeries(s1);
        model.addSeries(s2);
        model.setTitle("Line Chart");
    }

    /**
     * @return the model
     */
    public LineChartModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(LineChartModel model) {
        this.model = model;
    }
    
}
