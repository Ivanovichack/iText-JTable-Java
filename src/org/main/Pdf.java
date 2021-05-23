/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.main;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;

public class Pdf {

    List<Persona> personas;

    public Pdf(List<Persona> personas) {
        this.personas = personas;
    }

    public void generarPdf() {
        Document documento = new Document();
        try {
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream("documento.pdf");

// Se asocia el documento al OutputStream y se indica que el espaciado entre
// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

            documento.open();

            documento.add(new Paragraph("Registros existentes"));
            documento.add(new Chunk().setBackground(BaseColor.YELLOW));
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            
            tabla.addCell("Nombre");
            tabla.addCell("Edad");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");            
            
            for(Persona persona: this.personas){
                tabla.addCell(persona.getNombre());                
                tabla.addCell(persona.getEdad()+"");
                tabla.addCell(persona.getTelefono());
                tabla.addCell(persona.getDireccion());
            }
            documento.add(tabla);
            documento.close();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }

}
