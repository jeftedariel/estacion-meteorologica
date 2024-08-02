/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.reportes;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

/**
 *
 * @author jefte
 */
public class generarReporte {

    public static void pdf(JFreeChart[] chartsInformacion) {

        Document document = new Document();

        JFileChooser jFileChoose = new JFileChooser();
        int opcion = jFileChoose.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {

                final PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream(jFileChoose.getSelectedFile().getPath() + ".pdf"));
                //Se genera el documento
                document.open();

                //Creamos el encabezado
                Font fontTitle = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
                Paragraph title = new Paragraph("Reporte Meteorológico", fontTitle);
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                //Tamaños para el ancho y largo de las estadisticas.
                //Se podria poner como parámetros, pero prefiero dejarlo así harcodeado
                //de todos modos van a ser siempre los mismos
                int width = 600;
                int height = 650;

                //Generacion de las graficas
                //Se pueden ingresar tantas graficas como se quiera de los sensores necesarios
                for (int i = 0; i < chartsInformacion.length; i++) {
                    PdfContentByte cb = instance.getDirectContent();
                    PdfTemplate tp = cb.createTemplate(width, height);
                    Graphics2D g2d = tp.createGraphics(width, height, new DefaultFontMapper());
                    Rectangle2D r2d = new Rectangle2D.Double(0, 0, width, height);
                    chartsInformacion[i].draw(g2d, r2d);
                    g2d.dispose();
                    tp.sanityCheck();
                    cb.addTemplate(tp, 0, 0);
                    document.newPage();
                }

                //Se guarda el archivo y se notifica al usuario
                document.close();
                JOptionPane.showMessageDialog(null, "Documento generado exitosamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);

            } catch (DocumentException | IOException de) {
                //Arroja una exepcion en caso de que algo falle
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al generar el pdf. \n" + de.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    /*
        Ejemplo de metodo para crear charts
        Lo pongo acá como recordatorio
        para no olvidar como hacerlo luego. 
    
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
    
    Esto se debe guardar luego en un array de tipo JFreeChart y ese array pasarlo como argumento en el metodo pdf.
     */
}
