package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.unuesc.edi.tccalculator.util.login.LoginPass;
import br.edu.unuesc.edi.tccalculator.util.login.LoginPassAluno;
import br.edu.unuesc.edi.tccalculator.util.login.LoginSHA;
import br.edu.unuesc.edi.tccalculator.util.login.LoginTrueAluno;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe para cadatrar aluno
 * 
 * @author matheus
 *
 */
public class CadastrarAluno extends JInternalFrame {
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private final JPanel contentPane = new JPanel();

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
	public CadastrarAluno() throws PropertyVetoException {
		setSelected(true);
		setFrameIcon(
				new ImageIcon("resources\\cadastroaluno].png"));
		setClosable(true);
		setTitle("Cadastro Aluno");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 270);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastro = new JLabel("Usu\u00E1rio:");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastro.setBounds(28, 26, 82, 36);
		panel.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 81, 74, 36);
		panel.add(lblNewLabel);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(120, 36, 166, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setBounds(120, 91, 166, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel lblSenhaIncorreta = new JLabel("");
				lblSenhaIncorreta.setForeground(Color.RED);
				lblSenhaIncorreta.setBounds(299, 197, 133, 25);
				if (txtUsuario.getText().equals("") || txtSenha.getText().equals("")) {
					lblSenhaIncorreta.setText("Senha Incorreta !!");
				} else {
					String senha = null;
					try {
						senha = LoginSHA.login(new String(txtSenha.getText()));
					} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					boolean pass = false;
					try {
						pass = LoginPassAluno.login(txtUsuario.getText().toLowerCase(), senha);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (pass){
						txtUsuario.setText("");
						txtSenha.setText("");
						LoginTrueAluno.init(txtUsuario.getText().toLowerCase(), senha);
					}else{
						
						lblSenhaIncorreta.setText("Senha Incorreta!!");
				
					}
				}
			}
		});
		btnCadastrar.setBounds(77, 134, 151, 23);
		panel.add(btnCadastrar);

	}
}
