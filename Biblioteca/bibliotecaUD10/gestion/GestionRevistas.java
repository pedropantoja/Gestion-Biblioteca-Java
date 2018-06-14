package biblioteca.gestion;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GestionRevistas extends Gestion {
	private JTextField textCodRevista;
	private JTextField textSignatura;
	private JTextField textnombre;
	private JTextField textMateria;

	/**
	 * Create the frame.
	 */
	public GestionRevistas() {
		super();
		initCompenents();
	}

	public GestionRevistas(Connection conn, JFrame miventana) {
		super(conn,miventana);
		initCompenents();
	}
	
	private void initCompenents(){
		sql="select codrevista,signatura,nombre,materia from revista order by nombre";
		setTitle("Gestión Revistas");
		setBounds(100, 100, 304, 347);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		campos.setLayout(null);
		
		JLabel lblCodRevista = new JLabel("Cod Revista");
		lblCodRevista.setBounds(10, 11, 65, 14);
		campos.add(lblCodRevista);
		
		textCodRevista = new JTextField();
		textCodRevista.setBounds(87, 8, 86, 20);
		campos.add(textCodRevista);
		textCodRevista.setColumns(10);
		
		JLabel lblSignatura = new JLabel("Signatura");
		lblSignatura.setBounds(10, 50, 65, 14);
		campos.add(lblSignatura);
		
		textSignatura = new JTextField();
		textSignatura.setBounds(87, 47, 149, 20);
		campos.add(textSignatura);
		textSignatura.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 91, 46, 14);
		campos.add(lblNewLabel);
		
		textnombre = new JTextField();
		textnombre.setBounds(87, 88, 149, 20);
		campos.add(textnombre);
		textnombre.setColumns(10);
		
		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setBounds(10, 137, 46, 14);
		campos.add(lblMateria);
		
		textMateria = new JTextField();
		textMateria.setBounds(87, 134, 149, 20);
		campos.add(textMateria);
		textMateria.setColumns(10);
	}

	@Override
	protected void mostrarDatos() throws SQLException {
		textCodRevista.setText(""+rset.getInt("codrevista"));
		textSignatura.setText(rset.getString("signatura"));
		textnombre.setText(rset.getString("nombre"));
		textMateria.setText(rset.getString("Materia"));	
		super.mostrarDatos();
	}
	
	@Override
	protected void activarCampos(boolean activo) {
		textCodRevista.setEditable(activo);
		textSignatura.setEditable(activo);
		textnombre.setEditable(activo);
		textMateria.setEditable(activo);
		super.activarCampos(activo);
	}
	@Override
	protected void activarPK(boolean activo) {
		textCodRevista.setEditable(activo);
		super.activarPK(activo);
	}
	
	@Override
	protected void modificarRegistro() throws SQLException {
		rset.updateString("codrevista", textCodRevista.getText());
		rset.updateString("signatura", textSignatura.getText());
		rset.updateString("nombre", textnombre.getText());
		rset.updateString("materia", textMateria.getText());
		super.modificarRegistro();
	}
	
	@Override
	protected void limpiarCampos() {
		textCodRevista.setText("");
		textMateria.setText("");
		textnombre.setText("");
		textSignatura.setText("");
		super.limpiarCampos();
	}
	
	@Override
	protected void insertarRegistro() throws NumberFormatException, SQLException {
		rset.updateLong("CodRevista", Long.parseLong(textCodRevista.getText()));
		modificarRegistro();
		super.insertarRegistro();
	}
}
