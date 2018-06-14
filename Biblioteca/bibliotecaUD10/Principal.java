package biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.gestion.GestionArticulos;
import biblioteca.gestion.GestionCds;
import biblioteca.gestion.GestionLibros;
import biblioteca.gestion.GestionRevistas;
import biblioteca.gestion.GestionUsuarios;
import biblioteca.listado.ListadoArticulos;
import biblioteca.listado.ListadoCds;
import biblioteca.listado.ListadoLibros;
import biblioteca.listado.ListadoRevista;
import biblioteca.listado.ListadoUsuarios;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Principal extends JFrame implements WindowListener{

	private PanelFondo contentPane;
	private JFrame miventana;
	private Connection conn;

	/**
	 * Create the frame.
	 */
	public Principal() {
		initComponents();
	}
	
	public Principal(Connection conn,JFrame padre){
		initComponents();
		this.conn=conn;
		padre.dispose();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		this.setResizable(false);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		desconectar();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	private void initComponents(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("")));
		miventana=this;
		setTitle("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGestion = new JMenu("Gesti\u00F3n");
		menuBar.add(mnGestion);
		
		JMenuItem mntmGestionUsuarios = new JMenuItem("Gesti\u00F3n Usuarios");
		mntmGestionUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionUsuarios(conn,miventana);
			}
		});
		mnGestion.add(mntmGestionUsuarios);
		
		JMenuItem mntmGestionLibros = new JMenuItem("Gesti\u00F3n de Libros");
		mntmGestionLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionLibros(conn,miventana);
			}
		});
		mnGestion.add(mntmGestionLibros);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gesti\u00F3n Cds");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GestionCds(conn,miventana);
			}
		});
		mnGestion.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gestion Articulos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GestionArticulos(conn,miventana);
			}
		});
		mnGestion.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestion Revistas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GestionRevistas(conn,miventana);
			}
		});
		mnGestion.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnGestion.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desconectar();
				System.exit(0);
			}
		});
		mnGestion.add(mntmSalir);
		
		JMenu mnPrestamos = new JMenu("Prestamos");
		menuBar.add(mnPrestamos);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Realizar Prestamo");
		mnPrestamos.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Consula Prestamo");
		mnPrestamos.add(mntmNewMenuItem_4);
		
		JMenu mnListados = new JMenu("Listados");
		menuBar.add(mnListados);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listar Prestamos Activos");
		mnListados.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listar Prestamos por Usuario");
		mnListados.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Listado Usuarios");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ListadoUsuarios(conn);
			}
		});
		mnListados.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listados Libros");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ListadoLibros(conn);
			}
		});
		mnListados.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Listados Revistas");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ListadoRevista(conn);
			}
		});
		mnListados.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Listados Cds");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ListadoCds(conn);
			}
		});
		
		mnListados.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listados Articulos");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ListadoArticulos(conn);
			}
		});
		mnListados.add(mntmNewMenuItem_6);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca De");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AcercaDe();
			}
		});
		mnAyuda.add(mntmAcercaDe);

		contentPane = new PanelFondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addWindowListener(this);
		setVisible(true);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
	private void desconectar(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
