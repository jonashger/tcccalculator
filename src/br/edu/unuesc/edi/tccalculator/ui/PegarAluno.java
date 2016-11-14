package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.Avaliador;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;

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
		setBounds(100, 100, 520, 263);
		getContentPane().setLayout(null);

		cadastroAluno = pane;
		JComboBox<String> comboBox = new JComboBox<String>();
		List<Aluno> a = DAOManager.alunoDAO.queryForAll();
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getTcc().equals(tcc)) {
				if (a.get(i).getNota().equals("0")) {
					comboBox.addItem(a.get(i).getAssunto());
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
		comboBox.setBounds(10, 14, 485, 29);
		getContentPane().add(comboBox);

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
				int idDoAluno = array.get(comboBox.getSelectedIndex());
				
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
		btnGravarNotas.setBounds(194, 203, 138, 29);
		getContentPane().add(btnGravarNotas);
		
		JLabel lblAvaliador = new JLabel("Avaliador 1");
		lblAvaliador.setBounds(10, 54, 83, 22);
		getContentPane().add(lblAvaliador);
		
		JLabel lblAvaliador_1 = new JLabel("Avaliador 2");
		lblAvaliador_1.setBounds(10, 103, 83, 22);
		getContentPane().add(lblAvaliador_1);
		
		JLabel lblAvaliador_2 = new JLabel("Avaliador 3");
		lblAvaliador_2.setBounds(10, 152, 83, 22);
		getContentPane().add(lblAvaliador_2);
		
		List<Avaliador> aval = DAOManager.avaliadorDAO.queryForAll();
		 avaliador1 = new JComboBox<String>();
		idAvaliadores = new ArrayList<>();
		for (int i = 0; i < aval.size(); i++) {
			avaliador1.addItem(aval.get(i).getAvaliador());
			idAvaliadores.add(aval.get(i).getnAvaliador());
		}
		avaliador1.setBounds(20, 71, 453, 23);
		getContentPane().add(avaliador1);
		
		 avaliador2 = new JComboBox<String>();
		avaliador2.setBounds(20, 120, 453, 23);
		for (int i = 0; i < aval.size(); i++) {
			avaliador2.addItem(aval.get(i).getAvaliador());
		}
		getContentPane().add(avaliador2);
		
		avaliador3 = new JComboBox<String>();
		for (int i = 0; i < aval.size(); i++) {
			avaliador3.addItem(aval.get(i).getAvaliador());
		}
		avaliador3.setBounds(20, 169, 453, 23);
		getContentPane().add(avaliador3);

	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof PegarAluno);
	}
}
