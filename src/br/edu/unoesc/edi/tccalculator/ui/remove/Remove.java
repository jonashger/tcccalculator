package br.edu.unoesc.edi.tccalculator.ui.remove;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
/**
 * Classe que pede ao usuario qual tipo de dado deseja remover
 * @author jonas
 *
 */
public class Remove extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Remove(JDesktopPane janelas) {
		setTitle("Selecione para remover");
		setFrameIcon(new ImageIcon(Remove.class.getResource("/imagens/delete.png")));
		setClosable(true);
		setBounds(10, 10, 509, 217);
		getContentPane().setLayout(null);

		JLabel btnTrabalho = new JLabel("Remover Aluno");

		//remover trabalho
		btnTrabalho.setToolTipText("Remover Trabalho");
		btnTrabalho.setIcon(new ImageIcon(Remove.class.getResource("/imagens/job-search.png")));
		btnTrabalho.setBounds(10, 11, 128, 128);
		getContentPane().add(btnTrabalho);
		btnTrabalho.setCursor(new Cursor(Cursor.HAND_CURSOR));

		//remover aluno
		JLabel btnAvaliador = new JLabel("Remover Aluno");

		//avaliador
		btnAvaliador.setIcon(new ImageIcon(Remove.class.getResource("/imagens/student.png")));
		btnAvaliador.setToolTipText("Remover Trabalho");
		btnAvaliador.setBounds(181, 11, 128, 128);
		getContentPane().add(btnAvaliador);

		btnAvaliador.setCursor(new Cursor(Cursor.HAND_CURSOR));

		//remover trabalho
		JLabel lblRemoverTrabalho = new JLabel("Remover Trabalho");
		lblRemoverTrabalho.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblRemoverTrabalho.setBounds(10, 150, 146, 43);
		getContentPane().add(lblRemoverTrabalho);

		//remover o avaliador
		JLabel lblRemoverAvaliador = new JLabel("Remover Avaliador");
		lblRemoverAvaliador.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblRemoverAvaliador.setBounds(181, 150, 149, 43);
		getContentPane().add(lblRemoverAvaliador);

		//remover aluno, 
		JLabel btnCurso = new JLabel("Remover Aluno");
		btnCurso.setIcon(new ImageIcon(Remove.class.getResource("/imagens/scholarship.png")));
		btnCurso.setToolTipText("Remover Trabalho");
		btnCurso.setBounds(354, 11, 128, 128);
		getContentPane().add(btnCurso);

		btnCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));

		//remover curso
		JLabel lblRemoverCurso = new JLabel("Remover Curso");
		lblRemoverCurso.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblRemoverCurso.setBounds(364, 150, 117, 43);
		getContentPane().add(lblRemoverCurso);

		//ação de clique do trabalho
		btnTrabalho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RemoveWork work = null;
				try {
					work = new RemoveWork();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(work)) {
						work = (RemoveWork) janelas.getComponent(i);
						work.requestFocus();
						work.requestFocusInWindow();
						return;

					}
				}
				work.setMinimumSize(new Dimension(350, 300));
				janelas.add(work).setBounds(10, 10, 360, 362);
				work.setVisible(true);
				dispose();
			}
		});
		//ação de clique no avaliador
		btnAvaliador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				RemoveAvaliador avalia = null;
				try {
					avalia = new RemoveAvaliador();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(avalia)) {
						avalia = (RemoveAvaliador) janelas.getComponent(i);
						avalia.requestFocus();
						avalia.requestFocusInWindow();
						return;

					}
				}
				avalia.setMinimumSize(new Dimension(350, 300));
				janelas.add(avalia).setBounds(10, 10, 360, 362);
				avalia.setVisible(true);
			}
		});

		//ação do clique no curso
		btnCurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					dispose();
					RemoveCurso cad = null;
					try {
						 cad = new RemoveCurso();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i = 0; i < janelas.getComponents().length; i++) {
						if (janelas.getComponent(i).equals(cad)) {
							cad = (RemoveCurso) janelas.getComponent(i);
							cad.requestFocus();
							cad.requestFocusInWindow();
							return;

						}
					}

					cad.setMinimumSize(new Dimension(350, 300));
					janelas.add(cad).setBounds(10, 10, 360, 362);
					cad.setVisible(true);
				
			}
		});

	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof Remove);
	}
}
