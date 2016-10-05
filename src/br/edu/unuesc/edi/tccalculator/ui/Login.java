package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.edu.unuesc.edi.tccalculator.util.login.LoginPass;
import br.edu.unuesc.edi.tccalculator.util.login.LoginSHA;
import br.edu.unuesc.edi.tccalculator.util.login.LoginTrue;

import java.awt.Component;
import java.awt.Toolkit;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1416571999827062981L;

	private JPanel contentPane;

	private JPasswordField textFieldSenha;
	private JTextField textFieldUser;

	/**
	 * Launch the application.
	 */
	public static void Init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\logoimg.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 300));
		setMinimumSize(new Dimension(500, 300));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setTitle("Login - TCCalculator");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnEntrar = new JButton("");
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnEntrar.setMnemonic(KeyEvent.VK_ENTER);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JLabel lblSenhaIncorreta = new JLabel("");
					lblSenhaIncorreta.setForeground(Color.RED);
					lblSenhaIncorreta.setBounds(299, 197, 133, 25);
					if (new String(textFieldSenha.getPassword()).trim().equals("") || textFieldUser.getText().equals("")) {
					
						lblSenhaIncorreta.setText("Campos Vazios!!");
					
					} else {
						String senha = LoginSHA.login(new String(textFieldSenha.getPassword()).trim());
						boolean pass = LoginPass.login(textFieldUser.getText().toLowerCase(), senha);
						if (pass){
							Home.init();
							dispose();
						}else{
							
							lblSenhaIncorreta.setText("Senha Incorreta!!");
					
						}
					}
				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnEntrar.setIcon(new ImageIcon("resources\\login.jpg"));
		btnEntrar.setBounds(332, 215, 109, 36);
		panel.add(btnEntrar);

		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(293, 176, 133, 20);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);

		textFieldUser = new JTextField();
		textFieldUser.setColumns(10);
		textFieldUser.setBounds(293, 145, 133, 20);
		panel.add(textFieldUser);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(237, 148, 59, 14);
		panel.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(237, 179, 46, 14);
		panel.add(lblSenha);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("resources\\login_logo.png"));
		label.setBounds(195, 29, 279, 100);
		panel.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("resources\\boneco-not.jpg"));
		label_1.setBounds(0, 0, 204, 251);
		panel.add(label_1);

		getRootPane().setDefaultButton(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUser.init();
			}
		});
		btnCadastrar.setIcon(null);
		btnCadastrar.setMnemonic(KeyEvent.VK_ENTER);
		btnCadastrar.setBounds(214, 215, 109, 36);
		panel.add(btnCadastrar);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUser, textFieldSenha, btnEntrar}));
		
	}
}
