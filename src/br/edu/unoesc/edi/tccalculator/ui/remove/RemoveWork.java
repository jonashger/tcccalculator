package br.edu.unoesc.edi.tccalculator.ui.remove;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import br.edu.unoesc.edi.tccalculator.db.Aluno;
import br.edu.unoesc.edi.tccalculator.db.DAOManager;
import br.edu.unoesc.edi.tccalculator.util.Rcurso;
/**
 * Classe que solicita ao usuario qual curso deseja ser removido
 * @author jonas
 *
 */
public class RemoveWork extends JInternalFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
/**
 * Classe Principal - Frame
 * @throws SQLException trata dos erros do algoritmo sql
 */
	public RemoveWork() throws SQLException {
		List<Aluno> curso = DAOManager.alunoDAO.queryForAll();
		ArrayList<Integer> array = new ArrayList<>();
	
		setTitle("Remover Trabalho");
		setFrameIcon(new ImageIcon(RemoveWork.class.getResource("/imagens/delete.png")));
		setClosable(true);
		setBounds(100, 100, 360, 362);
		getContentPane().setLayout(null);

		JLabel lblTxt = new JLabel("Selecione o trabalho que ser\u00E1 removido:");
		lblTxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTxt.setBounds(10, 11, 299, 28);
		getContentPane().add(lblTxt);
		
		JList<String> list = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		list.setModel(model);
		list.setBounds(10, 48, 324, 230);
		getContentPane().add(list);

		for (int i = 0; i < curso.size(); i++) {
			String status = curso.get(i).getStatus();
			if (status==null) {
				status = "Não Cadastrado";
			}
			model.addElement(curso.get(i).getTcc()+ " - "+curso.get(i).getAssunto() + " - Status: " + status);
			array.add(curso.get(i).getnUsuario());
		}

		//caso escolha remover
		JLabel btnRemover = new JLabel("New label");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = array.get(list.getSelectedIndex());
				int sim = JOptionPane.showConfirmDialog(null,
						"Deseja remover \"" + list.getSelectedValue() + "\" do sistema?", "Remover Curso", 0);
				if (sim == 0) {
					try {
						model.remove(list.getSelectedIndex());
						Rcurso.removeCurso(id);
					} catch (SQLException e1) {
						System.out.println("Erro ao excluir o Dado Curso do Sistema");
					}
				}
			}
		});
		btnRemover.setIcon(new ImageIcon(RemoveWork.class.getResource("/imagens/btnRemover.png")));
		btnRemover.setBounds(209, 289, 125, 34);
		btnRemover.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnRemover);
		System.out.println(curso);
		if (curso.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum curso para ser removido.");
			//btnRemover.setVisible(false);
		}
	}
	
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof RemoveWork);
	}
}
