package FramesGraficas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
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

public class Grafica extends ApplicationFrame {

    private String titulo;
    private String tipo;
    private double rango;
    private int count = 2 * 60;
    private static final Random random = new Random();
    private Timer timer;

    public Grafica(final String title, String tipoDato, double Rango) {
        super(title);
        this.rango = Rango;
        this.titulo = title;
        this.tipo = tipoDato;
        
        final DynamicTimeSeriesCollection dataset
                = new DynamicTimeSeriesCollection(1, count, new Second());
        dataset.setTimeBase(new Second(0, 0, 0, 1, 1, 2024));
        dataset.addSeries(gaussianData(), 0, this.tipo);
        JFreeChart chart = createChart(dataset);

        this.add(new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        }, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel(new FlowLayout());

        this.add(btnPanel, BorderLayout.SOUTH);

        timer = new Timer(100, new ActionListener() {
            float[] newData = new float[1];

            @Override
            public void actionPerformed(ActionEvent e) {
                newData[0] = randomValue();
                dataset.advanceTime();
                dataset.appendData(newData);
            }
        });
    }

    private float randomValue() {
        return (float) (random.nextFloat() * 6);
    }

    private float[] gaussianData() {
        float[] a = new float[count];
        for (int i = 0; i < a.length; i++) {
            a[i] = randomValue();
        }
        return a;
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

    public void start() {
        timer.start();
    }
    
    
    /*Ejemplo de como iniciar una gráfica. falta hacerlo funcionar con Arduino y no con random.
    public static void main(final String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Grafica demo = new Grafica("Temperatura", "Grados Celcius", 100);
                demo.pack();
                UIUtils.centerFrameOnScreen(demo);
                demo.setVisible(true);
                demo.start();
            }
        });
    } */
}
