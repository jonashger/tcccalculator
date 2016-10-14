package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.edu.unuesc.edi.tccalculator.db.Curso;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewCurso extends JInternalFrame {
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
		setFrameIcon(new ImageIcon("resources/boneco-not.jpg"));
		setTitle("Cadastro de Curso");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblCurso.setBounds(10, 191, 78, 27);
		getContentPane().add(lblCurso);

		nomeCurso = new JTextField();
		nomeCurso.setBounds(72, 191, 352, 27);
		getContentPane().add(nomeCurso);
		nomeCurso.setColumns(10);

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
					nomeCurso.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Insira um nome de qualquer curso");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(261, 229, 163, 30);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resources\\curso.png"));
		lblNewLabel.setBounds(98, 11, 267, 173);
		getContentPane().add(lblNewLabel);

	}
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof NewCurso);
	}
}
