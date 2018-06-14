package biblioteca.gestion;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GestionArticulos extends Gestion {
	
	private JTextField textArticulo;
	private JTextField textFabricante;
	private JTextField textPeso;
	private JTextField textCategoria;
	private JTextField textPrecioVenta;
	private JTextField textPrecioCoste;
	private JTextField textExistencias;
	
	/**
	 * Create the frame.
	 */
	public GestionArticulos() {
		super();
		initCompenents();
	}

	public GestionArticulos(Connection conn, JFrame ventanaPadre) {
		super(conn,ventanaPadre);
		initCompenents();
	}
	
	private void initCompenents() {
		setTitle("Gestión Articulos");
		sql="select articulo,cod_fabricante,peso,categoria,precio_venta,precio_costo,existencias from articulos order by articulo";
		
		btnNuevo.setLocation(47, 199);
		btnModificar.setLocation(191, 199);
		btnEliminar.setLocation(343, 199);
		txtNav.setSize(70, 20);
		btnSiguiente.setSize(79, 23);
		btnAnterior.setSize(79, 23);
		btnPrimero.setSize(79, 23);
		btnUltimo.setSize(79, 23);
		btnUltimo.setLocation(389, 165);
		btnSiguiente.setLocation(300, 165);
		txtNav.setLocation(216, 166);
		btnAnterior.setLocation(109, 165);
		btnPrimero.setLocation(20, 165);
		campos.setBounds(10, 11, 471, 143);
		campos.setLayout(null);
		
		JLabel lblArtculo = new JLabel("Art\u00EDculo");
		lblArtculo.setBounds(10, 11, 46, 14);
		campos.add(lblArtculo);
		
		textArticulo = new JTextField();
		textArticulo.setBounds(54, 8, 183, 20);
		campos.add(textArticulo);
		textArticulo.setColumns(10);
		
		JLabel lblCodFabricante = new JLabel("Cod_Fabricante");
		lblCodFabricante.setBounds(263, 11, 86, 14);
		campos.add(lblCodFabricante);
		
		textFabricante = new JTextField();
		textFabricante.setBounds(359, 8, 96, 20);
		campos.add(textFabricante);
		textFabricante.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 49, 46, 14);
		campos.add(lblPeso);
		
		textPeso = new JTextField();
		textPeso.setBounds(54, 46, 86, 20);
		campos.add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(150, 49, 70, 14);
		campos.add(lblCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(212, 46, 86, 20);
		campos.add(textCategoria);
		textCategoria.setColumns(10);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta");
		lblPrecioVenta.setBounds(41, 91, 83, 14);
		campos.add(lblPrecioVenta);
		
		textPrecioVenta = new JTextField();
		textPrecioVenta.setBounds(134, 88, 86, 20);
		campos.add(textPrecioVenta);
		textPrecioVenta.setColumns(10);
		
		JLabel lblPrecioCosto = new JLabel("Precio Costo");
		lblPrecioCosto.setBounds(251, 91, 79, 14);
		campos.add(lblPrecioCosto);
		
		textPrecioCoste = new JTextField();
		textPrecioCoste.setBounds(340, 88, 86, 20);
		campos.add(textPrecioCoste);
		textPrecioCoste.setColumns(10);
		
		JLabel lblExistencias = new JLabel("Existencias");
		lblExistencias.setBounds(308, 49, 63, 14);
		campos.add(lblExistencias);
		
		textExistencias = new JTextField();
		textExistencias.setBounds(369, 46, 86, 20);
		campos.add(textExistencias);
		textExistencias.setColumns(10);
		
		setBounds(100, 100, 499, 285);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	protected void mostrarDatos() throws SQLException {
		textArticulo.setText(rset.getString("articulo"));
		textFabricante.setText(""+rset.getInt("cod_Fabricante"));
		textPeso.setText(""+rset.getInt("peso"));
		textCategoria.setText(rset.getString("categoria"));
		textPrecioVenta.setText(""+rset.getInt("precio_venta"));
		textPrecioCoste.setText(""+rset.getInt("precio_costo"));
		textExistencias.setText(""+rset.getInt("existencias"));
		super.mostrarDatos();
	}
	
	@Override
	protected void activarCampos(boolean activo) {
		textArticulo.setEditable(activo);
		textCategoria.setEditable(activo);
		textExistencias.setEditable(activo);
		textPeso.setEditable(activo);
		textPrecioCoste.setEditable(activo);
		textPrecioVenta.setEditable(activo);
		super.activarCampos(activo);
	}
	
	@Override
	protected void activarPK(boolean activo) {
		textFabricante.setEditable(activo);
		super.activarPK(activo);
	}
	
	@Override
	protected void modificarRegistro() throws SQLException {
		rset.updateString("articulo", textArticulo.getText());
		rset.updateString("peso", textPeso.getText());
		rset.updateString("categoria", textCategoria.getText());
		rset.updateString("precio_venta", textPrecioVenta.getText());
		rset.updateString("precio_costo", textPrecioCoste.getText());
		rset.updateString("existencias", textExistencias.getText());
		super.modificarRegistro();
	}
	
	@Override
	protected void limpiarCampos() {
		textArticulo.setText("");
		textFabricante.setText("");
		textPeso.setText("");
		textCategoria.setText("");
		textPrecioVenta.setText("");
		textPrecioCoste.setText("");
		textExistencias.setText("");
		super.limpiarCampos();
	}
	
	@Override
	protected void insertarRegistro() throws NumberFormatException, SQLException {
		rset.updateLong("cod_fabricante", Long.parseLong(textFabricante.getText()));
		modificarRegistro();
		super.insertarRegistro();
	}
}
