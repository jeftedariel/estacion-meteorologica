/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jefte.estacionmeteorologica;

import com.jefte.estacionmeteorologica.reportes.generarReporte;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author jefte
 */
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
    
    public static JFreeChart getXYChart2() {
        XYSeries series = new XYSeries("XYGraph");
        series.add(1, 1);
        series.add(2, 2);
        series.add(3, 3);
        series.add(4, 4);
        series.add(5, 5);
        series.add(6, 3);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return ChartFactory.createXYLineChart(
                "Temperatura", "Tiempo", "Celcius", dataset,
                PlotOrientation.VERTICAL, true, true, false);
    }
    
    public static JFreeChart getXYChart3() {
        XYSeries series = new XYSeries("XYGraph");
        series.add(1,9);
        series.add(2, 8);
        series.add(3, 7);
        series.add(4, 6);
        series.add(5, 5);
        series.add(6, 4);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return ChartFactory.createXYLineChart(
                "Temperatura", "Tiempo", "Celcius", dataset,
                PlotOrientation.VERTICAL, true, true, false);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        generarReporte.pdf(getXYChart(),getXYChart2(),getXYChart3());
    }
    

}
