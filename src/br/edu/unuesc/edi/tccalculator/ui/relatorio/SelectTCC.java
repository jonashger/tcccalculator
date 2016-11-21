package br.edu.unuesc.edi.tccalculator.ui.relatorio;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class SelectTCC extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String nTcc = null;
	JDesktopPane janelas = null;
	public SelectTCC(JDesktopPane panel) {
		janelas = panel;
		setTitle("Gerar Relat\u00F3rio - Selecionar TCC - TCCalculator");
		setFrameIcon(new ImageIcon(SelectTCC.class.getResource("/imagens/tccCad.png")));
		setClosable(true);
		setBounds(100, 100, 450, 211);
		getContentPane().setLayout(null);
		
		JLabel btn1 = new JLabel("");
		btn1.setIcon(new ImageIcon(SelectTCC.class.getResource("/imagens/number-1.png")));
		btn1.setBounds(10, 11, 128, 128);
		getContentPane().add(btn1);
		btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 nTcc = "tcc1";
			 gerarRelatorio();
			}
		});
		
		
		JLabel btn2 = new JLabel("");
		btn2.setIcon(new ImageIcon(SelectTCC.class.getResource("/imagens/number-2.png")));
		btn2.setBounds(152, 11, 128, 128);
		getContentPane().add(btn2);
		btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 nTcc = "tcc2";
				 gerarRelatorio();
			}
		});
		
		JLabel btn3 = new JLabel("");
		btn3.setIcon(new ImageIcon(SelectTCC.class.getResource("/imagens/numbre-3.png")));
		btn3.setBounds(296, 11, 128, 128);
		getContentPane().add(btn3);
		btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));	
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 nTcc = "tcc3";
				 gerarRelatorio();
			}
		});
		
		
		JLabel lblTcc = new JLabel("TCC 1");
		lblTcc.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblTcc.setBounds(59, 150, 44, 25);
		getContentPane().add(lblTcc);
		
		JLabel lblTcc_1 = new JLabel("TCC 2");
		lblTcc_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblTcc_1.setBounds(199, 150, 44, 25);
		getContentPane().add(lblTcc_1);
		
		JLabel lblTcc_2 = new JLabel("TCC 3");
		lblTcc_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblTcc_2.setBounds(335, 150, 44, 25);
		getContentPane().add(lblTcc_2);

	}
	
	private void gerarRelatorio(){
		GerarRelatorio cad = null;
		try {
			cad = new GerarRelatorio(nTcc);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < janelas.getComponents().length; i++) {
			if (janelas.getComponent(i).equals(cad)) {
				cad = (GerarRelatorio) janelas.getComponent(i);
				cad.requestFocus();
				cad.requestFocusInWindow();
				return;

			}
		}

		cad.setMinimumSize(new Dimension(350, 300));
		janelas.add(cad).setBounds(10, 10, 656, 281);
		cad.setVisible(true);
	}
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof SelectTCC);
	}
}
