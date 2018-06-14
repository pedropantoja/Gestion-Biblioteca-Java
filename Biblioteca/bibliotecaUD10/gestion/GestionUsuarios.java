package biblioteca.gestion;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GestionUsuarios extends Gestion {
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtApellido2;

	/**
	 * Create the frame.
	 */
	public GestionUsuarios() {
		super();
		initComponents();

	}
	public GestionUsuarios(Connection conn,JFrame ventanaPadre){
		super(conn,ventanaPadre);
		initComponents();
	}
	private void initComponents(){
		setTitle("Gestión de Usuarios");
		this.sql="Select codusuario,nombre,apellido1,apellido2 from usuario order by codusuario";
		campos.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(43, 14, 76, 14);
		campos.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(123, 11, 86, 20);
		campos.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 52, 76, 14);
		campos.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(123, 49, 86, 20);
		campos.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(43, 90, 76, 14);
		campos.add(lblerApellido);
		
		JLabel lblApellido = new JLabel("2\u00BA Apellido");
		lblApellido.setBounds(43, 128, 76, 14);
		campos.add(lblApellido);
		
		txtApellido1 = new JTextField();
		txtApellido1.setEditable(false);
		txtApellido1.setBounds(123, 87, 86, 20);
		campos.add(txtApellido1);
		txtApellido1.setColumns(10);
		
		txtApellido2 = new JTextField();
		txtApellido2.setEditable(false);
		txtApellido2.setBounds(123, 125, 86, 20);
		campos.add(txtApellido2);
		txtApellido2.setColumns(10);

	}
	
	@Override
	protected void mostrarDatos() throws SQLException {
		txtCodigo.setText(""+rset.getInt("codusuario"));
		txtNombre.setText(rset.getString("nombre"));
		txtApellido1.setText(rset.getString("apellido1"));
		txtApellido2.setText(rset.getString("apellido2"));
		super.mostrarDatos();
	}
	
	@Override
	protected void activarCampos(boolean activo) {
		//txtCodigo.setEditable(activo);
		txtNombre.setEditable(activo);
		txtApellido1.setEditable(activo);
		txtApellido2.setEditable(activo);
		super.activarCampos(activo);
	}
	
	@Override
	protected void activarPK(boolean activo) {
		txtCodigo.setEditable(activo);
		super.activarPK(activo);
	}
	
	@Override
	protected void modificarRegistro() throws SQLException {
		rset.updateString("nombre", txtNombre.getText());
		rset.updateString("apellido1", txtApellido1.getText());
		rset.updateString("apellido2", txtApellido2.getText());
		super.modificarRegistro();
	}
	
	@Override
	protected void insertarRegistro() throws NumberFormatException, SQLException {
		rset.updateInt("codusuario", Integer.parseInt(txtCodigo.getText()));
		modificarRegistro();
		super.insertarRegistro();
	}
	
	@Override
	protected void limpiarCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		super.limpiarCampos();
	}
}
