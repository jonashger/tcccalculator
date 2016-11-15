package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;
import br.edu.unuesc.edi.tccalculator.util.ReportGenerator;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
/**
 * Classe que gera relatório
 * @author jonas
 *
 */
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
	 * @throws SQLException 
	 */
	public GerarRelatorio(JDesktopPane pane) throws SQLException {
		setTitle("Projeto");
		setFrameIcon(new ImageIcon(GerarRelatorio.class.getResource("/imagens/logoimg.jpg")));
		setClosable(true);
		setBounds(100, 100, 656, 281);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		ArrayList<Integer> nArray = new ArrayList<>();
		List<Aluno> listaAlunos = DAOManager.alunoDAO.queryForAll();
		for (int i = 0; i < listaAlunos.size(); i++) {
			if(!listaAlunos.get(i).getNota().equals("0")){
				comboBox.addItem(listaAlunos.get(i).getAssunto());
				nArray.add(listaAlunos.get(i).getnUsuario());
			}
		}
		
		JButton btnNewButton = new JButton("Gerar Relat\u00F3rio");
		btnNewButton.setBounds(447, 202, 154, 22);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ReportGenerator.gerar();;
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JList list = new JList();
		list.setBorder(new TitledBorder(null, "Selecione Projeto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		list.setBounds(22, 11, 362, 213);
		panel.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(22, 25, 298, 199);
		panel.add(scrollPane);
		
		JComboBox<String> comboAvaliador1 = new JComboBox<String>();
		comboAvaliador1.setBounds(403, 60, 227, 23);
		panel.add(comboAvaliador1);
		
		JLabel avaliador1 = new JLabel("Avaliador 1");
		avaliador1.setBounds(394, 41, 83, 22);
		panel.add(avaliador1);
		
		JLabel avaliador2 = new JLabel("Avaliador 2");
		avaliador2.setBounds(394, 94, 83, 22);
		panel.add(avaliador2);
		
		JComboBox<String> comboAvaliador2 = new JComboBox<String>();
		comboAvaliador2.setBounds(403, 112, 227, 23);
		panel.add(comboAvaliador2);
		
		JLabel avaliador3 = new JLabel("Avaliador 3");
		avaliador3.setBounds(403, 146, 83, 22);
		panel.add(avaliador3);
		
		JComboBox<String> comboAvaliador3 = new JComboBox<String>();
		comboAvaliador3.setBounds(403, 165, 227, 23);
		panel.add(comboAvaliador3);
	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof GerarRelatorio);
	}
}
