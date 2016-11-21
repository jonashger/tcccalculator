package br.edu.unuesc.edi.tccalculator.ui.remove;

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

import br.edu.unuesc.edi.tccalculator.db.Avaliador;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;
import br.edu.unuesc.edi.tccalculator.util.Rcurso;
/**
 * Classe que solicita ao usuario qual Avaliador deseja ser removido
 * @author jonas
 *
 */
public class RemoveAvaliador extends JInternalFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public RemoveAvaliador() throws SQLException {
		List<Avaliador> curso = DAOManager.avaliadorDAO.queryForAll();
		ArrayList<Integer> array = new ArrayList<>();
	
		setTitle("Remover Avaliador");
		setFrameIcon(new ImageIcon(RemoveAvaliador.class.getResource("/imagens/delete.png")));
		setClosable(true);
		setBounds(100, 100, 360, 362);
		getContentPane().setLayout(null);

		JLabel lblTxt = new JLabel("Selecione o avaliador que ser\u00E1 removido:");
		lblTxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTxt.setBounds(10, 11, 294, 28);
		getContentPane().add(lblTxt);
				
				
		JList<String> list = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		list.setModel(model);
		list.setBounds(10, 48, 324, 230);
		getContentPane().add(list);

		for (int i = 0; i < curso.size(); i++) {
			model.addElement(curso.get(i).getAvaliador());
			array.add(curso.get(i).getnAvaliador());
		}

		JLabel btnRemover = new JLabel("New label");
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = array.get(list.getSelectedIndex());
				int sim = JOptionPane.showConfirmDialog(null,
						"Deseja remover \"" + list.getSelectedValue() + "\" do sistema?", "Remover Curso", 0);
				if (sim == 0) {
					try {
						model.remove(list.getSelectedIndex());;
						Rcurso.removeAvaliador(id);
					} catch (SQLException e1) {
						System.out.println("Erro ao excluir o Dado Curso do Sistema");
					}
				}
			}
		});
		btnRemover.setIcon(new ImageIcon(RemoveCurso.class.getResource("/imagens/btnRemover.png")));
		btnRemover.setBounds(209, 289, 125, 34);
		btnRemover.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnRemover);
		
		if (curso.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum curso para ser removido.");
			btnRemover.setVisible(false);;
		}
	}
	
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof RemoveAvaliador);
	}
}