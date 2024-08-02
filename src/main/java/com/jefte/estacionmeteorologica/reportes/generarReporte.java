/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.reportes;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jefte
 */
public class generarReporte {
    public static void pdf() {

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
