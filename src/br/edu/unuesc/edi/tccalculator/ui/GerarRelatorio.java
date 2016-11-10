package br.edu.unuesc.edi.tccalculator.ui;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class GerarRelatorio extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GerarRelatorio(JDesktopPane pane) {
		setFrameIcon(new ImageIcon(GerarRelatorio.class.getResource("/imagens/logoimg.jpg")));
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 52, 414, 28);
		panel.add(comboBox);
		
		JLabel lblSelecioneOProjeto = new JLabel("SELECIONE O PROJETO PARA FAZER O RELAT\u00D3RIO DA NOTA");
		lblSelecioneOProjeto.setBounds(63, 11, 309, 28);
		panel.add(lblSelecioneOProjeto);
		
		JLabel lblAvaliador = new JLabel("Avaliador 1 :");
		lblAvaliador.setBounds(10, 91, 154, 22);
		panel.add(lblAvaliador);
		
		JLabel lblAvaliador_1 = new JLabel("Avaliador 2 :");
		lblAvaliador_1.setBounds(10, 124, 154, 22);
		panel.add(lblAvaliador_1);
		
		JLabel lblAvaliador_2 = new JLabel("Avaliador 3 :");
		lblAvaliador_2.setBounds(10, 157, 154, 22);
		panel.add(lblAvaliador_2);

	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof GerarRelatorio);
	}
}
