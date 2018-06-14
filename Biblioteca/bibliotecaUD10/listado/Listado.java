package biblioteca.listado;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Listado extends JFrame implements ActionListener, WindowListener{

	private JPanel contentPane;
	private Connection conn;
	private PanelJtable tabla;
	private JButton btnGenerarPdf;

	public Listado(){
		initComponents();
	}
	
	public Listado(Connection conn) {
		this.conn=conn;
		initComponents();
	}
	private void initComponents(){
		setTitle("Listado Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 486);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnGenerarPdf = new JButton("Generar PDF");
		btnGenerarPdf.setBounds(163, 400, 106, 23);
		contentPane.add(btnGenerarPdf);
		btnGenerarPdf.addActionListener(this);
		
		String sql="Select codusuario as Codigo,Nombre as \"Nombre del empleado\", apellido1 as \"1º Apellido\", apellido2 as \"2º Apellido\" from usuario";
		tabla = new PanelJtable(conn,sql);
		tabla.setBounds(30, 26, 379, 352);
		contentPane.add(tabla);

		addWindowListener(this);
	}

	private void desconectar(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void generarListado() {
		try {
			JFileChooser chooser = new JFileChooser(); 
			chooser.showOpenDialog(this);
			File file = chooser.getSelectedFile();
			if(file!=null){
				generarPDF(file);
				Desktop.getDesktop().open(file);
			}
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "No se encuentra el fichero creado");
		}
	}
	
	private void generarPDF(File file){
		Document documento = new Document();
		FileOutputStream ficheroPdf;
		try {
			ficheroPdf = new FileOutputStream(file);

			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			documento.open();
			documento.add(new Paragraph("Listado de Usuarios",
							FontFactory.getFont("arial",   
							18,                           
							Font.ITALIC,                  
							BaseColor.CYAN)));
			
			documento.add(new Paragraph(" "));
			try{
				Statement stmt=conn.createStatement();
				String sql="select * from usuario";
				ResultSet rset=stmt.executeQuery(sql);

				ResultSetMetaData metaDatos = rset.getMetaData();
				int numeroColumnas = metaDatos.getColumnCount();
				PdfPTable tabla = new PdfPTable(numeroColumnas);

				for(int i=1;i<=numeroColumnas;i++){
					tabla.addCell(metaDatos.getColumnLabel(i));
				}

				while (rset.next())
				{
				   for (int i=1;i<=numeroColumnas;i++){
				      tabla.addCell(""+rset.getObject(i)); 
				   }
				}
				documento.add(tabla);
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			documento.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "La ruta introducida no es valida");
		} catch (DocumentException e) {
			JOptionPane.showMessageDialog(null, "Error al Crear el listado");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnGenerarPdf)) {
			generarListado();
		}
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		this.contentPane.setEnabled(false);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		this.contentPane.setEnabled(true);
		desconectar();
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
	}
}

