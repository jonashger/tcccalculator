package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.unuesc.edi.tccalculator.util.login.LoginSHA;
import br.edu.unuesc.edi.tccalculator.util.login.LoginTrueAluno;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ButtonUI;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

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
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private final JPanel contentPane = new JPanel();
	private JEditorPane textAssunto; 
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<JRadioButton> arrayRadios = new ArrayList<>();
	
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
	 * Create the frame.
	 * 
	 * @throws PropertyVetoException
	 */
	public CadastrarAluno()  throws PropertyVetoException {
		setSelected(true);
		setFrameIcon(new ImageIcon("resources\\cadastroaluno].png"));
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

		JLabel lblCadastro = new JLabel("Aluno:");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastro.setBounds(28, 26, 82, 36);
		panel.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 73, 74, 36);
		panel.add(lblNewLabel);

		txtUsuario = new JTextField();
		txtUsuario.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtUsuario.setBounds(120, 36, 166, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtSenha.setBounds(120, 83, 166, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setBounds(263, 236, 151, 23);
		panel.add(btnCadastrar);
		
		JLabel lblTeseDefendida = new JLabel("Tese defendida:");
		lblTeseDefendida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTeseDefendida.setBounds(28, 120, 112, 36);
		panel.add(lblTeseDefendida);
		
		textAssunto = new JEditorPane();
		textAssunto.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAssunto.setBounds(28, 152, 386, 71);
		panel.add(textAssunto);
		getContentPane().add(panel);
		
		ArrayList<JRadioButton> arrayRadios = new ArrayList<>();
		
		JRadioButton radioTCCI = new JRadioButton("TCC I");
		radioTCCI.setSelected(true);
		buttonGroup.add(radioTCCI);
		radioTCCI.setBounds(305, 35, 109, 23);
		panel.add(radioTCCI);
		
		JRadioButton radioTCCII = new JRadioButton("TCC II");
		buttonGroup.add(radioTCCII);
		radioTCCII.setBounds(305, 61, 109, 23);
		panel.add(radioTCCII);
		radioTCCII.setToolTipText("TESC");
		
		JRadioButton radioTCCIII = new JRadioButton("TCC III");
		buttonGroup.add(radioTCCIII);
		radioTCCIII.setBounds(305, 86, 109, 23);
		panel.add(radioTCCIII);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tcc = null ;
				if(radioTCCI.isSelected())
					tcc = "tcc1";
				else if (radioTCCII.isSelected())
					tcc = "tcc2";
				else if (radioTCCIII.isSelected())
					tcc = "tcc3";
				else
					return;
				
				if (txtUsuario.getText().equals("") || txtSenha.getText().equals("")|| textAssunto.getText().equals("")) {
					JLabel lblSenhaIncorreta = new JLabel("");
					lblSenhaIncorreta.setForeground(Color.RED);
					lblSenhaIncorreta.setBounds(299, 197, 133, 25);
					lblSenhaIncorreta.setText("Senha Incorreta !!");
				} else {
					String senha = null;
					try {
						senha = LoginSHA.login(new String(txtSenha.getText()));
					} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						LoginTrueAluno.init(txtUsuario.getText().toLowerCase(), senha, textAssunto.getText());
						txtUsuario.setText("");
						txtSenha.setText("");
						textAssunto.setText("");

				}
			}
		});
	}
	
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof CadastrarAluno);
	}
}
