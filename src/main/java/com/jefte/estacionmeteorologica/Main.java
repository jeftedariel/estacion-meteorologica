/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jefte.estacionmeteorologica;

import com.jefte.estacionmeteorologica.Auth.GUILogin;
import com.jefte.estacionmeteorologica.reportes.generarReporte;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {
    
    
    public static JFreeChart getXYChart() {
        XYSeries series = new XYSeries("Grados Celcius");
        series.add(1, 5);
        series.add(2, 7);
        series.add(3, 3);
        series.add(4, 5);
        series.add(5, 4);
        series.add(6, 5);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return ChartFactory.createXYLineChart(
                "Temperatura", "Tiempo", "Celcius", dataset,
                PlotOrientation.VERTICAL, true, true, false);
    }
    
    public static void main(String[] args) {
    JFreeChart[] graficas = {getXYChart()};
    
    generarReporte.pdf(graficas);

    GUILogin.initGUI ();

}
}
