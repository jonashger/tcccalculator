package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

public class CadastroTCC1 extends JInternalFrame {
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroTCC1 frame = new CadastroTCC1();
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
	public CadastroTCC1() {
		setTitle(" C\u00E1lculo das Avalia\u00E7\u00F5es TCC1");
		setBounds(100, 100, 812, 472);
		getContentPane().setLayout(null);
		
		JLabel lblAP = new JLabel("Avalia\u00E7\u00E3o do Projeto - AP");
		lblAP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAP.setBounds(139, 10, 226, 21);
		getContentPane().add(lblAP);
		
		JLabel lblNotasAP = new JLabel("Notas");
		lblNotasAP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNotasAP.setBounds(571, 12, 72, 14);
		getContentPane().add(lblNotasAP);
		
		JLabel lblItensAvaliadosAA = new JLabel("Itens Avaliados");
		lblItensAvaliadosAA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItensAvaliadosAA.setBounds(182, 44, 121, 14);
		getContentPane().add(lblItensAvaliadosAA);
		
		JLabel lblAvaliadorAP = new JLabel("Avaliador1");
		lblAvaliadorAP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvaliadorAP.setBounds(435, 44, 72, 14);
		getContentPane().add(lblAvaliadorAP);
		
		JLabel lblAvaliador2AP = new JLabel("Avaliador2");
		lblAvaliador2AP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvaliador2AP.setBounds(517, 44, 75, 14);
		getContentPane().add(lblAvaliador2AP);
		
		JLabel lblAvaliador3AP = new JLabel("Avaliador3");
		lblAvaliador3AP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvaliador3AP.setBounds(602, 44, 70, 14);
		getContentPane().add(lblAvaliador3AP);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(397);
		table.getColumnModel().getColumn(0).setMaxWidth(397);
		table.getColumnModel().getColumn(1).setPreferredWidth(82);
		table.getColumnModel().getColumn(1).setMaxWidth(82);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(2).setMaxWidth(82);
		table.getColumnModel().getColumn(3).setPreferredWidth(82);
		table.getColumnModel().getColumn(3).setMaxWidth(82);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		table.getColumnModel().getColumn(4).setMaxWidth(82);
		table.setBounds(33, 63, 725, 80);
		getContentPane().add(table);
		
		JLabel lblMediaAP = new JLabel("M\u00E9dia");
		lblMediaAP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMediaAP.setBounds(696, 44, 46, 14);
		getContentPane().add(lblMediaAP);
		
		JLabel lblAA = new JLabel("Avalia\u00E7\u00E3o da Apresenta\u00E7\u00E3o - AA");
		lblAA.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAA.setBounds(106, 170, 273, 21);
		getContentPane().add(lblAA);
		
		JLabel lblNotasAA = new JLabel("Notas");
		lblNotasAA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNotasAA.setBounds(571, 175, 72, 14);
		getContentPane().add(lblNotasAA);
		
		JLabel lblitensAvaliadosAA = new JLabel("Itens Avaliados");
		lblitensAvaliadosAA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblitensAvaliadosAA.setBounds(182, 202, 121, 14);
		getContentPane().add(lblitensAvaliadosAA);
		
		JLabel lblAvaliadorAA = new JLabel("Avaliador1");
		lblAvaliadorAA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvaliadorAA.setBounds(435, 204, 72, 14);
		getContentPane().add(lblAvaliadorAA);
		
		JLabel lblAvaliador2AA = new JLabel("Avaliador2");
		lblAvaliador2AA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvaliador2AA.setBounds(517, 204, 75, 14);
		getContentPane().add(lblAvaliador2AA);
		
		JLabel lblAvaliador3AA = new JLabel("Avaliador3");
		lblAvaliador3AA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvaliador3AA.setBounds(602, 204, 70, 14);
		getContentPane().add(lblAvaliador3AA);
		
		JLabel lblMediaAA = new JLabel("M\u00E9dia");
		lblMediaAA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMediaAA.setBounds(696, 204, 46, 14);
		getContentPane().add(lblMediaAA);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(397);
		table_1.getColumnModel().getColumn(0).setMaxWidth(397);
		table_1.setBounds(36, 227, 722, 50);
		getContentPane().add(table_1);
		
		JLabel lblAvaliacaoOrientador = new JLabel("Avalia\u00E7\u00E3o do Orientador - AO");
		lblAvaliacaoOrientador.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAvaliacaoOrientador.setBounds(60, 304, 273, 21);
		getContentPane().add(lblAvaliacaoOrientador);
		
		JLabel lblNotaAO = new JLabel("Nota");
		lblNotaAO.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNotaAO.setBounds(373, 306, 72, 14);
		getContentPane().add(lblNotaAO);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(300);
		table_2.getColumnModel().getColumn(0).setMaxWidth(300);
		table_2.setBounds(33, 325, 423, 14);
		getContentPane().add(table_2);
		
		JLabel lblAutoAvaliaoDo = new JLabel("Auto Avalia\u00E7\u00E3o do Academico - AAA");
		lblAutoAvaliaoDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAutoAvaliaoDo.setBounds(60, 364, 305, 21);
		getContentPane().add(lblAutoAvaliaoDo);

	}
}
