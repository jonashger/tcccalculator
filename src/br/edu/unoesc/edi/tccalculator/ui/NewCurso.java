package br.edu.unoesc.edi.tccalculator.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unoesc.edi.tccalculator.db.Curso;
import br.edu.unoesc.edi.tccalculator.db.DAOManager;
/**
 * Cadastro de novo curso caso o curso que o aluno faça não esteja ali.
 * @author jonas
 *
 */
public class NewCurso extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeCurso;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCurso frame = new NewCurso();
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
	public NewCurso() {
		//janela para cadastro
		setFrameIcon(new ImageIcon(NewCurso.class.getResource("/imagens/cadastroaluno].png")));
		setTitle("Cadastro de Curso");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		//curso
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblCurso.setBounds(10, 191, 78, 27);
		getContentPane().add(lblCurso);

		//campo para curso
		nomeCurso = new JTextField();
		nomeCurso.setBounds(72, 191, 352, 27);
		getContentPane().add(nomeCurso);
		nomeCurso.setColumns(10);

		//botão para salvar dados inseridos
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso curso = new Curso();
				if (!nomeCurso.getText().equals("")) {
					curso.setCurso(nomeCurso.getText());
					try {
						DAOManager.cursoDAO.create(curso);
					} catch (SQLException e1) {
					}
					JOptionPane.showMessageDialog(null, "Dados do curso \""+nomeCurso.getText()+"\" foram gravadas com sucesso!");
					nomeCurso.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Insira um nome de qualquer curso");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(261, 229, 163, 30);
		getContentPane().add(btnNewButton);

		//setando imagem 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewCurso.class.getResource("/imagens/curso.png")));
		lblNewLabel.setBounds(98, 11, 250, 173);
		getContentPane().add(lblNewLabel);

	}
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof NewCurso);
	}
}
