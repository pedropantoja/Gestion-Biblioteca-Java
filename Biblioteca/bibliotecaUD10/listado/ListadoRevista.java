package biblioteca.listado;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ListadoRevista {

	private Connection conn;
	
	public ListadoRevista(Connection conn) {
		this.conn=conn;
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		String nombreFichero=file.getAbsolutePath();

		Document documento = new Document();
		FileOutputStream ficheroPdf;
		try {
			ficheroPdf = new FileOutputStream(file);
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			documento.open();
			
			Paragraph cabecera=new Paragraph("Listado de Revistas",
					FontFactory.getFont("arial",
					22,                 
					Font.BOLD,        
					BaseColor.RED));

			cabecera.setAlignment(Element.ALIGN_CENTER);
			cabecera.setSpacingAfter(40f);
			documento.add(cabecera);          			

			String sql="select codrevista,signatura,nombre,materia from revista";

			PdfPTable tabla = new PdfPTable(4);
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			tabla.addCell("codigo revista");
			tabla.addCell("signatura");
			tabla.addCell("nombre");
			tabla.addCell("materia");
			while(rset.next()){
				tabla.addCell(""+rset.getString("codrevista"));
				tabla.addCell(rset.getString("signatura"));
				tabla.addCell(rset.getString("nombre"));
				tabla.addCell(rset.getString("materia"));
			}
			documento.add(tabla);
			documento.close();
			Desktop.getDesktop().open(file);
		} catch (DocumentException|IOException e) {
			JOptionPane.showMessageDialog(null, "El fichero "+nombreFichero+" no existe","Error al generar listado",JOptionPane.ERROR_MESSAGE);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"Error de BD",JOptionPane.ERROR_MESSAGE);
		}
	}
}
