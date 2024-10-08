package com.jefte.estacionmeteorologica.grafica;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import com.jefte.estacionmeteorologica.Serial.SerialHandler;
import com.jefte.estacionmeteorologica.claseDatosSensor.DatosSensor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;

public class Grafica extends ApplicationFrame {

    private String titulo;
    private String tipo;
    private double rango;
    private int count = 1000;
    private Timer timer;

    private static final Random random = new Random();
    private static final int COUNT = 2 * 60;
    private static int MINMAX = 40;
    private JsonHandler<DatosSensor> gestionDatosSensor;
    private String nombreJson = "datosSensores.json";
    private boolean cerrar = false;

    public Grafica(final String title, String idSensor, String tipoDato, double Rango) {
        super(title);
        this.gestionDatosSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer, DatosSensor>>() {
        });
        this.rango = Rango;
        this.titulo = title;
        this.tipo = tipoDato;
        ;
        final DynamicTimeSeriesCollection dataset
                = new DynamicTimeSeriesCollection(1, COUNT, new Second());
        dataset.setTimeBase(new Second(0, 0, 0, 1, 1, 2011));
        dataset.addSeries(gaussianData(), 0, "Gaussian data");
        JFreeChart chart = createChart(dataset);
        this.add(new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        }, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel(new FlowLayout());

        final JButton salir = new JButton("Salir");

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
                cerrar=true;
            }
        });
        btnPanel.add(salir);

        this.add(btnPanel, BorderLayout.SOUTH);

        SerialHandler.abrirPuerto("ttyACM0");

        timer = new Timer(1000, new ActionListener() {
            float[] newData = new float[1];
            float[] datosJson = new float[4];

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cerrar){
                 
                String[] data = SerialHandler.obtenerDato();

                newData[0] = datosJson[0];
                try {
                    for (int i = 0; i < 4; i++) {
                        // Verifica si el dato no es vacío antes de intentar convertirlo
                        if (data[i] != null && !data[i].trim().isEmpty()) {
                            try {
                                datosJson[i] = Float.parseFloat(data[i]);
                            } catch (NumberFormatException ex) {
                                System.out.println("Error al convertir el dato: " + ex.getMessage());
                                datosJson[i] = 0;  // Asigna un valor por defecto
                            }
                        } else {
                            System.out.println("Dato vacío recibido, asignando 0");
                            datosJson[i] = 0;  // Asigna un valor por defecto si el dato es vacío
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ind) {
                    System.out.println("ops:" + ind);
                }

                System.out.println(datosJson[0] + ", " + datosJson[1] + ", " + datosJson[2] + ", " + datosJson[3]);
                gestionDatosSensor.agregar(new DatosSensor(0, datosJson[0], "BME280"));
                gestionDatosSensor.agregar(new DatosSensor(1, datosJson[1], "BME280"));
                gestionDatosSensor.agregar(new DatosSensor(2, datosJson[2], "BME280"));
                gestionDatosSensor.agregar(new DatosSensor(3, datosJson[3], "BME280"));
                dataset.advanceTime();
                dataset.appendData(newData);
                   
                }
            }
        });
    }

    public void cerrar() {
        this.dispose();
    }

    private float randomValue() {
        return (float) (random.nextGaussian() * MINMAX / 3);
    }

    private float[] gaussianData() {
        float[] a = new float[COUNT];
        for (int i = 0; i < a.length; i++) {
            a[i] = randomValue();
        }
        return a;
    }

    public void start() {
        timer.start();
    }

    @Override
    public void dispose() {
        SerialHandler.cerrarPuerto();  // Cierra el puerto serial cuando se cierra la ventana
        super.dispose();
    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
                this.titulo, "hh:mm:ss", this.tipo, dataset, true, true, false);
        final XYPlot plot = result.getXYPlot();
        ValueAxis domain = plot.getDomainAxis();
        domain.setAutoRange(true);
        ValueAxis range = plot.getRangeAxis();
        range.setRange(-this.rango, this.rango);
        return result;
    }

    public static void visualizar() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Grafica demo = new Grafica("Temperatura", "Grados Celcius", "Grados", 30);
                demo.pack();
                UIUtils.centerFrameOnScreen(demo);
                demo.setVisible(true);
                demo.start();
            }
        });
    }
}
