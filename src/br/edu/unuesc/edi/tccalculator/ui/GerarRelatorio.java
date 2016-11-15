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
		setFrameIcon(new ImageIcon(GerarRelatorio.class.getResource("/imagens/logoimg.jpg")));
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		ArrayList<Integer> nArray = new ArrayList<>();
		List<Aluno> listaAlunos = DAOManager.alunoDAO.queryForAll();
		for (int i = 0; i < listaAlunos.size(); i++) {
			if(!listaAlunos.get(i).getNota().equals("0")){
				comboBox.addItem(listaAlunos.get(i).getAssunto());
				nArray.add(listaAlunos.get(i).getnUsuario());
			}
		}
		comboBox.setBounds(10, 52, 414, 28);
		panel.add(comboBox);
		
		

		
		JLabel lblSelecioneOProjeto = new JLabel("SELECIONE O PROJETO PARA FAZER O RELAT\u00D3RIO DA NOTA");
		lblSelecioneOProjeto.setBounds(63, 11, 309, 28);
		panel.add(lblSelecioneOProjeto);
		
		JLabel lblAvaliador = new JLabel("Avaliador 1 :");
		lblAvaliador.setBounds(10, 91, 61, 22);
		panel.add(lblAvaliador);
		
		JLabel lblAvaliador_1 = new JLabel("Avaliador 2 :");
		lblAvaliador_1.setBounds(10, 124, 154, 22);
		panel.add(lblAvaliador_1);
		
		JLabel lblAvaliador_2 = new JLabel("Avaliador 3 :");
		lblAvaliador_2.setBounds(10, 157, 154, 22);
		panel.add(lblAvaliador_2);
		
		JButton btnNewButton = new JButton("Gerar Relat\u00F3rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ReportGenerator.gerar();;
			}
		});
		btnNewButton.setBounds(270, 237, 154, 22);
		panel.add(btnNewButton);
		
		JLabel avaliador1 = new JLabel("Selecione algum TCC para ver os avaliadores cadastrados");
		avaliador1.setBounds(81, 91, 328, 22);
		panel.add(avaliador1);
		
		JLabel avaliador2 = new JLabel("");
		avaliador2.setBounds(81, 124, 261, 22);
		panel.add(avaliador2);
		
		JLabel avaliador3 = new JLabel("");
		avaliador3.setBounds(81, 157, 261, 22);
		panel.add(avaliador3);
		
		comboBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int n = comboBox.getSelectedIndex();
		        avaliador1.setText(listaAlunos.get(nArray.get(n)-1).getAvaliador1());
		        avaliador2.setText(listaAlunos.get(nArray.get(n)-1).getAvaliador2());
		        avaliador3.setText(listaAlunos.get(nArray.get(n)-1).getAvaliador3());
		        System.out.println(nArray.get(n));
		        repaint();
		        revalidate();
		    }
		});
	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof GerarRelatorio);
	}
}
