package biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AcercaDe extends JFrame {

	/**
	 * Create the frame.
	 */
	public AcercaDe() {
		setTitle("Acerca De...");
		setBounds(100, 100, 359, 151);
		getContentPane().setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel lblPedro = new JLabel("Pedro Luis Pantoja González");
		lblPedro.setBounds(24, 26, 187, 23);
		getContentPane().add(lblPedro);
		
		JLabel lblIesPoligonoSur = new JLabel("I.E.S Poligono Sur");
		lblIesPoligonoSur.setBounds(240, 85, 121, 23);
		getContentPane().add(lblIesPoligonoSur);
		
		JLabel lblDaw = new JLabel("1\u00BA DAW");
		lblDaw.setBounds(240, 26, 94, 23);
		getContentPane().add(lblDaw);
		
		JLabel lblProgramacin = new JLabel("Programaci\u00F3n");
		lblProgramacin.setBounds(24, 85, 94, 23);
		getContentPane().add(lblProgramacin);
		//setContentPane(contentPane);
	}

}
