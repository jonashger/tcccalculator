package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PegarAlunoTCC1 extends JInternalFrame {


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
	public PegarAlunoTCC1(JDesktopPane pane) throws SQLException {
		setFrameIcon(new ImageIcon("resources/boneco-not.jpg"));
		setTitle("Aluno para TCC I");
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 309, 113);
		getContentPane().setLayout(null);
		
		cadastroAluno = pane;
		JComboBox<String> comboBox = new JComboBox<String>();
		List<Aluno> a = DAOManager.alunoDAO.queryForAll();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getTcc().equals("tcc1")) {
				comboBox.addItem(a.get(i).getAluno());
			}
		}
		comboBox.setBounds(10, 14, 273, 29);
		getContentPane().add(comboBox);
		
		
		JButton btnGravarNotas = new JButton("Gravar Notas");
		btnGravarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				CadastroTCC1 cadastro = null;
				try {
					cadastro = new CadastroTCC1(comboBox.getSelectedItem().toString());
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
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

			}
		});
		btnGravarNotas.setBounds(102, 54, 111, 23);
		getContentPane().add(btnGravarNotas);
		
	}
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof PegarAlunoTCC1);
	}
}
