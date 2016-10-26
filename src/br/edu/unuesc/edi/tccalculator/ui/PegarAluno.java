package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PegarAluno extends JInternalFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	JDesktopPane cadastroAluno = null;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PegarAluno(JDesktopPane pane, String tcc) throws SQLException {
		setFrameIcon(new ImageIcon("resources/boneco-not.jpg"));
		setTitle("Aluno para " + tcc);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 521, 127);
		getContentPane().setLayout(null);
		
		cadastroAluno = pane;
		JComboBox<String> comboBox = new JComboBox<String>();
		List<Aluno> a = DAOManager.alunoDAO.queryForAll();
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getTcc().equals(tcc)) {
				comboBox.addItem(a.get(i).getAssunto());
				array.add(a.get(i).getnUsuario());
			}
		}
		comboBox.setBounds(10, 14, 485, 29);
		getContentPane().add(comboBox);
		
		
		JButton btnGravarNotas = new JButton("Gravar Notas");
		btnGravarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					if (tcc.equals("tcc1")) {
						CadastroTCC1 cadastro = null;
						cadastro = new CadastroTCC1(array.get(comboBox.getSelectedIndex()));
						for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
							if (cadastroAluno.getComponent(i).equals(cadastro)) {
								cadastro = (CadastroTCC1) cadastroAluno.getComponent(i++);
								cadastro.requestFocus();
								return;
							}
						}
						dispose();
						cadastro.setMinimumSize(new Dimension(350, 500));
						cadastroAluno.add(cadastro).setBounds(10, 10, 743, 545);
						cadastro.setVisible(true);
					}else if(tcc.equals("tcc2")){
						CadastroTCC2 cadastro = null;
						cadastro = new CadastroTCC2(array.get(comboBox.getSelectedIndex()));
						for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
							if (cadastroAluno.getComponent(i).equals(cadastro)) {
								cadastro = (CadastroTCC2) cadastroAluno.getComponent(i++);
								cadastro.requestFocus();
								return;
							}
						}
						dispose();
						cadastro.setMinimumSize(new Dimension(350, 500));
						cadastroAluno.add(cadastro).setBounds(10, 10, 743, 545);
						cadastro.setVisible(true);
					}else{

						CadastroTCC3 cadastro = null;
						cadastro = new CadastroTCC3(array.get(comboBox.getSelectedIndex()));
						for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
							if (cadastroAluno.getComponent(i).equals(cadastro)) {
								cadastro = (CadastroTCC3) cadastroAluno.getComponent(i++);
								cadastro.requestFocus();
								return;
							}
						}
						dispose();
						cadastro.setMinimumSize(new Dimension(350, 500));
						cadastroAluno.add(cadastro).setBounds(10, 10, 743, 545);
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
		btnGravarNotas.setBounds(192, 57, 138, 29);
		getContentPane().add(btnGravarNotas);
		
	}
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof PegarAluno);
	}
}
