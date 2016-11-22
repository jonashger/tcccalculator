package br.edu.unoesc.edi.tccalculator.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import br.edu.unoesc.edi.tccalculator.db.Aluno;
import br.edu.unoesc.edi.tccalculator.db.Avaliador;
import br.edu.unoesc.edi.tccalculator.db.DAOManager;

/**
 * Classe que pede o usuario a informar em qual tese ele quer gravar as notas
 * 
 * @author jonas
 *
 */
public class PegarAluno extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	JDesktopPane cadastroAluno = null;
	JComboBox<String> avaliador1 = null;
	JComboBox<String> avaliador2 = null;
	JComboBox<String> avaliador3 = null;
	ArrayList<Integer> idAvaliadores  =null;

	/**
	 * Launch the application.
	 * 
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public PegarAluno(JDesktopPane pane, String tcc) throws SQLException {
		setFrameIcon(new ImageIcon(PegarAluno.class.getResource("/imagens/more.png")));
		setTitle("Aluno para " + tcc);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 664, 257);
		getContentPane().setLayout(null);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
	
		JList<String> list = new JList<String>();
		list.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		list.setBorder(new TitledBorder(null, "Selecionar Trabalho", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		list.setBounds(21, 11, 368, 204);
		getContentPane().add(list);
		list.setModel(model);
		JScrollPane scrollPane = new JScrollPane(list); 
		scrollPane.setBounds(21, 11, 368, 204);
		scrollPane.setVisible(true);
		scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);
		cadastroAluno = pane;
		List<Aluno> a = DAOManager.alunoDAO.queryForAll();
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getTcc().equals(tcc)) {
				if (a.get(i).getNota().equals("0")) {
					model.addElement(a.get(i).getAssunto());
					array.add(a.get(i).getnUsuario());
				}
			}
		}
		if (array.isEmpty()) {
		int ad2 =	JOptionPane.showConfirmDialog(cadastroAluno,
					"<html>Nenhum aluno cadastrado para ser gerado notas.</br> Entre em Cadastrar -> Cadastrar aluno - e preenche os campos.</html>",
					"Fechar", 2);
		if (ad2 == 0) {
			dispose();
		}	
		}

		JButton btnGravarNotas = new JButton("Gravar Notas");
		btnGravarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (avaliador1.getSelectedIndex() == avaliador2.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Avaliador 1 e Avaliador 2 são iguais");
					return;
				}else if (avaliador2.getSelectedIndex() == avaliador3.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Avaliador 2 e Avaliador 3 são iguais");
					return;
				}else if (avaliador1.getSelectedIndex() == avaliador3.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Avaliador 1 e Avaliador 3 são iguais");
					return;
				}
				ArrayList<Integer> arrayIdAvali = new ArrayList<>();
				arrayIdAvali.add(idAvaliadores.get(avaliador1.getSelectedIndex()));
				arrayIdAvali.add(idAvaliadores.get(avaliador2.getSelectedIndex()));
				arrayIdAvali.add(idAvaliadores.get(avaliador3.getSelectedIndex()));
				int idDoAluno = array.get(list.getSelectedIndex());
				
				try {
					if (array.isEmpty()) {
						dispose();
						return;
					}
					if (tcc.equals("tcc1")) {
						CadastroTCC1 cadastro = null;
						cadastro = new CadastroTCC1(idDoAluno,arrayIdAvali);
						for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
							if (cadastroAluno.getComponent(i).equals(cadastro)) {
								cadastro = (CadastroTCC1) cadastroAluno.getComponent(i++);
								cadastro.requestFocus();
								return;
							}
						}
						dispose();
						cadastro.setMinimumSize(new Dimension(350, 500));
						cadastroAluno.add(cadastro).setBounds(10, 10, 743, 644);
						cadastro.setVisible(true);
					} else if (tcc.equals("tcc2")) {
						CadastroTCC2 cadastro = null;
						cadastro = new CadastroTCC2(idDoAluno,arrayIdAvali);
						for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
							if (cadastroAluno.getComponent(i).equals(cadastro)) {
								cadastro = (CadastroTCC2) cadastroAluno.getComponent(i++);
								cadastro.requestFocus();
								return;
							}
						}
						dispose();
						cadastro.setMinimumSize(new Dimension(350, 500));
						cadastroAluno.add(cadastro).setBounds(10, 10, 743, 631);
						cadastro.setVisible(true);
					} else {

						CadastroTCC3 cadastro = null;
						cadastro = new CadastroTCC3(idDoAluno,arrayIdAvali);
						for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
							if (cadastroAluno.getComponent(i).equals(cadastro)) {
								cadastro = (CadastroTCC3) cadastroAluno.getComponent(i++);
								cadastro.requestFocus();
								return;
							}
						}
						dispose();
						cadastro.setMinimumSize(new Dimension(350, 500));
						cadastroAluno.add(cadastro).setBounds(10, 10, 816, 631);
						cadastro.setVisible(true);
					}

				} catch (PropertyVetoException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnGravarNotas.setBounds(500, 186, 138, 29);
		getContentPane().add(btnGravarNotas);
		
		JLabel lblAvaliador = new JLabel("Avaliador 1");
		lblAvaliador.setBounds(399, 37, 83, 22);
		getContentPane().add(lblAvaliador);
		
		JLabel lblAvaliador_1 = new JLabel("Avaliador 2");
		lblAvaliador_1.setBounds(399, 86, 83, 22);
		getContentPane().add(lblAvaliador_1);
		
		JLabel lblAvaliador_2 = new JLabel("Avaliador 3");
		lblAvaliador_2.setBounds(399, 135, 83, 22);
		getContentPane().add(lblAvaliador_2);
		
		List<Avaliador> aval = DAOManager.avaliadorDAO.queryForAll();
		 avaliador1 = new JComboBox<String>();
		idAvaliadores = new ArrayList<>();
		for (int i = 0; i < aval.size(); i++) {
			avaliador1.addItem(aval.get(i).getAvaliador());
			idAvaliadores.add(aval.get(i).getnAvaliador());
		}
		avaliador1.setBounds(409, 54, 227, 23);
		getContentPane().add(avaliador1);
		
		 avaliador2 = new JComboBox<String>();
		avaliador2.setBounds(409, 103, 227, 23);
		for (int i = 0; i < aval.size(); i++) {
			avaliador2.addItem(aval.get(i).getAvaliador());
		}
		getContentPane().add(avaliador2);
		
		avaliador3 = new JComboBox<String>();
		for (int i = 0; i < aval.size(); i++) {
			avaliador3.addItem(aval.get(i).getAvaliador());
		}
		avaliador3.setBounds(409, 152, 227, 23);
		getContentPane().add(avaliador3);

		if (a.size() == 0) {
			btnGravarNotas.setVisible(false);
		}
	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof PegarAluno);
	}
}
