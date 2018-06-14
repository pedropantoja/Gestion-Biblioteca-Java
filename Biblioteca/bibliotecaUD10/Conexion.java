package biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Conexion extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnAceptar,btnCancelar;
	private JPasswordField txtPasswd;
	private int intentos=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conexion frame = new Conexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conexion() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Conexion.class.getResource("/imagesfondo/biblioteca.jpg")));
		setResizable(false);
		setTitle("Conexión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 257, 161);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(42, 11, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(42, 38, 66, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("java");
		txtUsuario.setBounds(118, 11, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(36, 86, 91, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(135, 86, 91, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		txtPasswd = new JPasswordField();
		txtPasswd.setText("java");
		txtPasswd.setBounds(118, 35, 86, 20);
		contentPane.add(txtPasswd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAceptar)){
			
			Connection conn=conectar();
			if(conn!=null){
				new Principal(conn,this);
			}
			return;
		}
		
		if(e.getSource().equals(btnCancelar)){
			System.exit(0);
		}
		
	}
	
	private Connection conectar(){
		Connection conn;
		intentos++;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", txtUsuario.getText(), new String(txtPasswd.getPassword()));
			return conn;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra el driver de Base de Datos");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+"Te quedan "+(3-intentos+" intentos"));
		}
		if(intentos>2){
			JOptionPane.showMessageDialog(null, "Ha superado el numero de intentos");
			System.exit(0);
		}
		return null;
	}
}
