package br.edu.unoesc.edi.tccalculator.ui.relatorio;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import br.edu.unoesc.edi.tccalculator.db.Aluno;
import br.edu.unoesc.edi.tccalculator.db.DAOManager;

/**
 * Classe que vai gerar o  relatório
 * 
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
	  * Gera o relatório de seu respectivo tcc
	  * @param nTcc informa qual tcc (I,II,III)
	  *  @throws SQLException faz o tratamento dos erros de SQL
	  */

	public GerarRelatorio(String nTcc) throws SQLException {
		setTitle("Projeto " + nTcc);
		setFrameIcon(new ImageIcon(GerarRelatorio.class.getResource("/imagens/logoimg.jpg")));
		setClosable(true);
		setBounds(100, 100, 656, 281);

		JPanel panel = new JPanel();

		getContentPane().add(panel, BorderLayout.CENTER);

		

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>();
		list.setBorder(new TitledBorder(null, "Selecione Projeto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		list.setBounds(22, 11, 362, 213);
		panel.add(list);
		list.setModel(model);

		ArrayList<Integer> nArray = new ArrayList<>();
		List<Aluno> listaAlunos = DAOManager.alunoDAO.queryForAll();
		for (int i = 0; i < listaAlunos.size(); i++) {
			if (!listaAlunos.get(i).getNota().equals("0")) {
				if (listaAlunos.get(i).getTcc().equals(nTcc)) {
					model.addElement(listaAlunos.get(i).getAssunto());
					nArray.add(listaAlunos.get(i).getnUsuario());
				}
			}
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(22, 25, 298, 199);
		panel.add(scrollPane);

		//avaliadores
		
		JLabel avaliador1 = new JLabel("Avaliador 1");
		avaliador1.setBounds(394, 41, 83, 22);
		panel.add(avaliador1);

		JLabel avaliador2 = new JLabel("Avaliador 2");
		avaliador2.setBounds(394, 94, 83, 22);
		panel.add(avaliador2);

		JLabel avaliador3 = new JLabel("Avaliador 3");
		avaliador3.setBounds(394, 144, 83, 22);
		panel.add(avaliador3);

		JLabel labelAval1 = new JLabel("");
		labelAval1.setBounds(394, 53, 236, 27);
		panel.add(labelAval1);

		JLabel labelAval2 = new JLabel("");
		labelAval2.setBounds(394, 110, 236, 27);
		panel.add(labelAval2);

		JLabel labelAval3 = new JLabel("");
		labelAval3.setBounds(394, 158, 236, 27);
		panel.add(labelAval3);

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				labelAval1.setText(listaAlunos.get(nArray.get(list.getSelectedIndex())-1).getAvaliador1());
				labelAval2.setText(listaAlunos.get(nArray.get(list.getSelectedIndex())-1).getAvaliador2());	
				labelAval3.setText(listaAlunos.get(nArray.get(list.getSelectedIndex())-1).getAvaliador3());	
				repaint();
				revalidate();

			}
		};
		list.addMouseListener(mouseListener);
		
		//botao do relatorio
		JButton btnNewButton = new JButton("Gerar Relat\u00F3rio");
		btnNewButton.setBounds(513, 196, 117, 22);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!list.isSelectionEmpty()) {
					int id =listaAlunos.get(nArray.get(list.getSelectedIndex())-1).getnUsuario();
					String tcc = listaAlunos.get(nArray.get(list.getSelectedIndex())-1).getTcc();
					
					try {
						if (tcc.equals("tcc3")) {
							ReportGenerator.tcc3(id);
						}else
						ReportGenerator.tcc1e2(id);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Selecione Algum Projeto");
				}
			
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		
		//assinatura
		JButton btnAssinatura = new JButton("Assinatura\r\n");
		btnAssinatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione um Projeto");
				}else{	
					JOptionPane.showMessageDialog(null,"Em Breve, Aguarde!!");
				}
			}
		});
		btnAssinatura.setBounds(547, 41, 83, 22);
		panel.add(btnAssinatura);
	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof GerarRelatorio);
	}
}
