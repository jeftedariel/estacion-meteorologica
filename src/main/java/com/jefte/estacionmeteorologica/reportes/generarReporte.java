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

import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author jefte
 */
public class generarReporte {

    public static void pdf(JFreeChart chartTemperatura, JFreeChart chartHumedad, JFreeChart chartPresion) {

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
                int width= 600;
                int height= 650;
                
                //Gráfica Temperatura
                PdfContentByte cb = instance.getDirectContent();
    		PdfTemplate tp = cb.createTemplate(width, height);
    		Graphics2D g2d = tp.createGraphics(width, height, new DefaultFontMapper());
    		Rectangle2D r2d = new Rectangle2D.Double(0, 0, width, height);
    		chartTemperatura.draw(g2d, r2d);
    		g2d.dispose();
    		tp.sanityCheck();
    		cb.addTemplate(tp, 0, 0);
                
                document.newPage();
                //Gráfica Presion Admosferica
                PdfContentByte cb2 = instance.getDirectContent();
    		PdfTemplate tp2 = cb2.createTemplate(width, height);
    		Graphics2D g2d2 = tp2.createGraphics(width, height, new DefaultFontMapper());
    		Rectangle2D r2d2 = new Rectangle2D.Double(0, 0, width, height);
    		chartHumedad.draw(g2d2, r2d2);
    		g2d2.dispose();
    		tp2.sanityCheck();
    		cb2.addTemplate(tp2, 0, 0);
                
                document.newPage();
                //Gráfica Humedad de Suelo
                PdfContentByte cb3 = instance.getDirectContent();
    		PdfTemplate tp3 = cb3.createTemplate(width, height);
    		Graphics2D g2d3 = tp3.createGraphics(width, height, new DefaultFontMapper());
    		Rectangle2D r2d3 = new Rectangle2D.Double(0, 0, width, height);
    		chartPresion.draw(g2d3, r2d3);
    		g2d3.dispose();
    		tp3.sanityCheck();
    		cb3.addTemplate(tp3, 0, 0);
                
                //Generacion de la estadistica
                //Se guarda el archivo y se notifica al usuario
                document.close();
                JOptionPane.showMessageDialog(null, "Documento generado exitosamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);

            } catch (DocumentException | IOException de) {
                //Arroja una exepcion en caso de que algo falle
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al generar el pdf. \n" + de.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }



}
