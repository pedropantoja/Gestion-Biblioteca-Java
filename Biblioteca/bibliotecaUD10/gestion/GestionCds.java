package biblioteca.gestion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GestionCds extends Gestion {
	private JTextField textcodcd;
	private JTextField textSignatura;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textMateria;
	private JTextField textEditorial;

	/**
	 * Create the frame.
	 */
	
	public GestionCds(Connection conn,JFrame ventanaPadre){
		super(conn, ventanaPadre);
		initComponents();
	}
	
	public GestionCds() {
		super();
		initComponents();
	}
	
	private void initComponents(){
		
		setTitle("Gestión Cds");
		sql="select codcdrom,signatura,titulo,autor,materia,editorial from cdrom order by titulo";
		
		campos.setLayout(null);
		
		btnPrimero.setSize(63, 23);
		btnPrimero.setLocation(17, 212);
		btnAnterior.setLocation(90, 212);
		btnNuevo.setLocation(29, 273);
		btnModificar.setLocation(182, 273);
		btnEliminar.setLocation(334, 273);
		txtNav.setSize(118, 20);
		txtNav.setLocation(168, 213);
		btnSiguiente.setLocation(313, 212);
		btnUltimo.setSize(65, 23);
		btnUltimo.setLocation(372, 212);
		campos.setBounds(10, 11, 427, 176);
		setBounds(100, 100, 474, 339);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		campos.setLayout(null);
		
		JLabel lblCodCdrom = new JLabel("Cod CdRom");
		lblCodCdrom.setBounds(10, 11, 61, 14);
		campos.add(lblCodCdrom);
		
		textcodcd = new JTextField();
		textcodcd.setBounds(71, 8, 86, 20);
		campos.add(textcodcd);
		textcodcd.setColumns(10);
		
		JLabel lblSignatura = new JLabel("Signatura");
		lblSignatura.setBounds(195, 11, 56, 14);
		campos.add(lblSignatura);
		
		textSignatura = new JTextField();
		textSignatura.setBounds(258, 8, 159, 20);
		campos.add(textSignatura);
		textSignatura.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 63, 46, 14);
		campos.add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(50, 60, 125, 20);
		campos.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(195, 63, 46, 14);
		campos.add(lblAutor);
		
		textAutor = new JTextField();
		textAutor.setBounds(236, 60, 181, 20);
		campos.add(textAutor);
		textAutor.setColumns(10);
		
		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setBounds(10, 113, 46, 14);
		campos.add(lblMateria);
		
		textMateria = new JTextField();
		textMateria.setBounds(50, 110, 125, 20);
		campos.add(textMateria);
		textMateria.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(195, 113, 46, 14);
		campos.add(lblEditorial);
		
		textEditorial = new JTextField();
		textEditorial.setBounds(258, 110, 159, 20);
		campos.add(textEditorial);
		textEditorial.setColumns(10);
	}
	
	@Override
	protected void mostrarDatos() throws SQLException {
		textcodcd.setText(""+rset.getInt("codcdrom"));
		textSignatura.setText(rset.getString("signatura"));
		textTitulo.setText(rset.getString("titulo"));
		textAutor.setText(rset.getString("autor"));
		textMateria.setText(rset.getString("Materia"));
		textEditorial.setText(rset.getString("Editorial"));
		super.mostrarDatos();
	}
	
	@Override
	protected void activarCampos(boolean activo) {
		textSignatura.setEditable(activo);
		textTitulo.setEditable(activo);
		textAutor.setEditable(activo);
		textMateria.setEditable(activo);
		textEditorial.setEditable(activo);
		super.activarCampos(activo);
	}
	
	@Override
	protected void activarPK(boolean activo) {
		textcodcd.setEditable(activo);
		super.activarPK(activo);
	}
	
	@Override
	protected void modificarRegistro() throws SQLException {
		rset.updateString("signatura", textSignatura.getText());
		rset.updateString("titulo", textTitulo.getText());
		rset.updateString("autor", textAutor.getText());
		rset.updateString("materia", textMateria.getText());
		rset.updateString("editorial", textEditorial.getText());
		super.modificarRegistro();
	}
	
	@Override
	protected void limpiarCampos() {
		textcodcd.setText("");
		textSignatura.setText("");
		textTitulo.setText("");
		textAutor.setText("");
		textMateria.setText("");
		textEditorial.setText("");
		super.limpiarCampos();
	}
	
	@Override
	protected void insertarRegistro() throws NumberFormatException, SQLException {
		rset.updateLong("CODCDROM", Long.parseLong(textcodcd.getText()));
		modificarRegistro();
		super.insertarRegistro();
	}
}
