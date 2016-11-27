
package br.edu.unoesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.edu.unoesc.edi.tccalculator.db.Curso;
import br.edu.unoesc.edi.tccalculator.db.DAOManager;
import br.edu.unuesc.edi.tccalculator.util.login.CadastroAluno;

/**
 * Classe para cadatrar aluno
 * 
 * @author matheus
 *
 */
public class CadastrarAluno extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textAluno1;
	private final JPanel contentPane = new JPanel();
	private JEditorPane textAssunto;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<JRadioButton> arrayRadios = new ArrayList<>();
	private JTextField textAluno2;
	private JTextField txtOrientador;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAluno frame = new CadastrarAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o Frame.
	 * 
	 * @throws PropertyVetoException
	 * @throws SQLException
	 */
	public CadastrarAluno() throws PropertyVetoException, SQLException {
		setSelected(true);
		setFrameIcon(new ImageIcon(CadastrarAluno.class.getResource("/imagens/cadastroaluno].png")));
		setClosable(true);
		setTitle("Cadastro Aluno");
		setBounds(100, 100, 450, 300);
		setMaximumSize(new Dimension(450, 300));
		getContentPane().setLayout(null);
		getContentPane().add(contentPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 270);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastro = new JLabel("Aluno 1:");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastro.setBounds(28, 11, 82, 36);
		panel.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("Curso:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 73, 74, 36);
		panel.add(lblNewLabel);

		JComboBox<String> curso = new JComboBox<>();
		List<Curso> a = DAOManager.cursoDAO.queryForAll();
		for (int i = 0; i < a.size(); i++) {
			curso.addItem(a.get(i).getCurso());
		}
		curso.setBounds(89, 83, 166, 20);
		panel.add(curso);

		textAluno1 = new JTextField();
		textAluno1.setBorder(new LineBorder(new Color(171, 173, 179)));
		textAluno1.setBounds(89, 21, 166, 20);
		panel.add(textAluno1);
		textAluno1.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBounds(263, 236, 151, 23);
		panel.add(btnCadastrar);

		JLabel lblTeseDefendida = new JLabel("Tese defendida:");
		lblTeseDefendida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTeseDefendida.setBounds(27, 152, 112, 36);
		panel.add(lblTeseDefendida);

		textAssunto = new JEditorPane();
		textAssunto.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAssunto.setBounds(28, 187, 386, 36);
		panel.add(textAssunto);
		getContentPane().add(panel);

		JRadioButton radioTCCI = new JRadioButton("TCC I");
		radioTCCI.setSelected(true);
		buttonGroup.add(radioTCCI);
		radioTCCI.setBounds(315, 36, 109, 23);
		panel.add(radioTCCI);

		JRadioButton radioTCCII = new JRadioButton("TCC II");
		buttonGroup.add(radioTCCII);
		radioTCCII.setBounds(315, 62, 109, 23);
		panel.add(radioTCCII);
		radioTCCII.setToolTipText("TESC");

		JRadioButton radioTCCIII = new JRadioButton("TCC III");
		buttonGroup.add(radioTCCIII);
		radioTCCIII.setBounds(315, 87, 109, 23);
		panel.add(radioTCCIII);

		textAluno2 = new JTextField();
		JButton btnAddAluno = new JButton("");
		btnAddAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textAluno2.isDisplayable()) {
					return;
				}
				JLabel label = new JLabel("Aluno 2:");
				label.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label.setBounds(28, 40, 82, 36);
				panel.add(label);

				textAluno2 = new JTextField();
				textAluno2.setColumns(10);
				textAluno2.setBorder(new LineBorder(new Color(171, 173, 179)));
				textAluno2.setBounds(89, 52, 166, 20);
				panel.add(textAluno2);
				repaint();
				revalidate();
			}
		});
		btnAddAluno.setIcon(new ImageIcon(CadastrarAluno.class.getResource("/imagens/more.png")));
		btnAddAluno.setBounds(260, 11, 36, 36);
		panel.add(btnAddAluno);

		JLabel lblOrientador = new JLabel("Orientador:");
		lblOrientador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrientador.setBounds(27, 114, 112, 36);
		panel.add(lblOrientador);

		txtOrientador = new JTextField();
		txtOrientador.setBounds(121, 124, 217, 20);
		panel.add(txtOrientador);
		txtOrientador.setColumns(10);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String orient = txtOrientador.getText();
				String aluno1 = textAluno1.getText();
				String aluno2 = textAluno2.getText();
				if (validaNome(orient, aluno1, aluno2)) {

					String tcc = null;
					if (radioTCCI.isSelected())
						tcc = "tcc1";
					else if (radioTCCII.isSelected())
						tcc = "tcc2";
					else if (radioTCCIII.isSelected())
						tcc = "tcc3";
					else
						return;

					if (txtOrientador.getText().trim().equals("") || textAluno1.getText().trim().equals("")
							|| curso.getSelectedItem().toString().equals("")
							|| textAssunto.getText().trim().equals("")) {
						JLabel lblSenhaIncorreta = new JLabel("");
						lblSenhaIncorreta.setForeground(Color.RED);
						lblSenhaIncorreta.setBounds(299, 197, 133, 25);
						lblSenhaIncorreta.setText("Espaços em Brancos!!");
					} else {
						CadastroAluno.init(textAluno1.getText(), textAluno2.getText(),
								curso.getSelectedItem().toString(), textAssunto.getText(), tcc,
								txtOrientador.getText());
						textAluno1.setText("");
						textAluno2.setText("");
						txtOrientador.setText("");
						curso.setSelectedIndex(0);
						textAssunto.setText("");

					}
				}
			}
		});
	}

	private boolean validaNome(String orient, String aluno1, String aluno2) {
		Pattern p = Pattern.compile("^[[ ]|\\p{L}*]+$");
		Matcher m = p.matcher(orient);
		Matcher m2 = p.matcher(aluno1);
		Matcher m3 = p.matcher(aluno2);
		int n2 = 0;
		int n = 0;
		int al1 = 0;
		int al12 = 0;
		int al2 = 0;
		int al22 = 0;
		if (m.find()) {
			n = orient.indexOf(" ");
			n2 = orient.indexOf("  ");
			if (m2.find()) {
				al1 = aluno1.indexOf(" ");
				al12 = aluno1.indexOf("  ");
			} else {
				JOptionPane.showMessageDialog(null, "Certifique-se que seu nome não possua caracteres inválidos");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Certifique-se que seu nome não possua caracteres inválidos");
			return false;
		}

		if ((!(n < 0) && (n2 < 0)) && (!(al1 < 0) && (al12 < 0))) {
			if (textAluno2.isDisplayable()) {
				if (m3.find()) {
					al2 = aluno2.indexOf(" ");
					al22 = aluno2.indexOf("  ");

				} else {
					return false;
				}
				if (!(al2 < 0) && (al22 < 0)) {
				} else {
					JOptionPane.showMessageDialog(null, "Nomes Completos Requeridos no Aluno 2");
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nomes Completos Requeridos");
			return false;
		}
		return true;
	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof CadastrarAluno);
	}
}
