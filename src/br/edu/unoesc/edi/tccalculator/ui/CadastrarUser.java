package br.edu.unoesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.edu.unuesc.edi.tccalculator.util.login.CadastroUserEspecial;
import br.edu.unuesc.edi.tccalculator.util.login.GeradorSHA;
import br.edu.unuesc.edi.tccalculator.util.login.LoginPass;
import br.edu.unuesc.edi.tccalculator.util.login.UsrExiste;
/**
 * Frame para realizar o cadastro de novo user especial
 * @author jonas
 *
 */
public class CadastrarUser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7711768174925790517L;
	/**
	 * 
	 */
	//variáveis
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUser;
	private  JPasswordField  textFieldSenha;
	private JTextField textFieldUserEspecial;
	private  JPasswordField  textFieldSenhaEspecial;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void init() {
		try {
			CadastrarUser dialog = new CadastrarUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	//classe para cadastro
	public CadastrarUser() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarUser.class.getResource("/imagens/logoimg.jpg")));
		setTitle("Cadastrar Novo Usu\u00E1rio - TTCalculator");
		setBounds(100, 100, 433, 300);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//criação da janela, botao...
		JLabel lblCadastrarNovoUsu = new JLabel("<html>Lembre-se que necessitar\u00E1 de usu\u00E1rio especial para poder cadastrar novo usu\u00E1rio!");
		lblCadastrarNovoUsu.setBounds(10, 11, 414, 27);
		contentPanel.add(lblCadastrarNovoUsu);
		{
			//campo usuario
			JLabel lblUsurio = new JLabel("Usu\u00E1rio");
			lblUsurio.setBounds(139, 162, 46, 14);
			contentPanel.add(lblUsurio);
		}
		{
			//campo senha
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setBounds(139, 187, 46, 14);
			contentPanel.add(lblSenha);
		}
		/**
		 * Campo de texto
		 */
		{
			textFieldUser = new JTextField();
			textFieldUser.setBounds(195, 159, 86, 20);
			contentPanel.add(textFieldUser);
			textFieldUser.setColumns(10);
		}
		{
			textFieldSenha = new  JPasswordField ();
			textFieldSenha.setBounds(195, 184, 86, 20);
			contentPanel.add(textFieldSenha);
			textFieldSenha.setColumns(10);
		}
		//campos do usuario 
		{
			JLabel lblNovoUsurio = new JLabel("Novo Usu\u00E1rio");
			lblNovoUsurio.setBounds(176, 137, 71, 14);
			contentPanel.add(lblNovoUsurio);
		}
		{
			JLabel lblUsurioEspecial = new JLabel("Usu\u00E1rio Especial");
			lblUsurioEspecial.setBounds(176, 42, 105, 14);
			contentPanel.add(lblUsurioEspecial);
		}
		/**
		 * campos para texto
		 */
		{
			textFieldUserEspecial = new JTextField();
			textFieldUserEspecial.setColumns(10);
			textFieldUserEspecial.setBounds(195, 67, 86, 20);
			contentPanel.add(textFieldUserEspecial);
		}
		{
			textFieldSenhaEspecial = new  JPasswordField ();
			textFieldSenhaEspecial.setColumns(10);
			textFieldSenhaEspecial.setBounds(195, 92, 86, 20);
			contentPanel.add(textFieldSenhaEspecial);
		}
		{
			JLabel labelSenhaEspecial = new JLabel("Senha");
			labelSenhaEspecial.setBounds(139, 95, 46, 14);
			contentPanel.add(labelSenhaEspecial);
		}
		{
			JLabel labelEspecial = new JLabel("Usu\u00E1rio");
			labelEspecial.setBounds(139, 70, 46, 14);
			contentPanel.add(labelEspecial);
		}
		{
			//botão dok
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!(((new String(textFieldSenha.getPassword()).trim()).equals(""))|| ((new String(textFieldSenhaEspecial.getPassword()).trim()).equals(""))|| (textFieldUser.getText().equals(""))||(textFieldUserEspecial.getText().equals("")))){
							String senha = null;
							try {
								senha = GeradorSHA.login((new String(textFieldSenhaEspecial.getPassword()).trim()));
							} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
								JOptionPane.showMessageDialog(null, "Algo aconteceu de errado.");
							}
							boolean pass = false;
							try {
								pass = LoginPass.login(textFieldUserEspecial.getText().toLowerCase(), senha);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							if (pass){
								boolean usrExistente = false;
								try {
									usrExistente = UsrExiste.login(textFieldUser.getText().toLowerCase());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								if(!usrExistente){
									try {
										CadastroUserEspecial.init(textFieldUser.getText().toLowerCase(), GeradorSHA.login((new String(textFieldSenha.getPassword()).trim())));
										textFieldSenha.setText("");
										textFieldSenhaEspecial.setText("");
										textFieldUser.setText("");
										textFieldUserEspecial.setText("");
									} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}else{
									JOptionPane.showMessageDialog(contentPanel, "Esse usuário já existe!");
								}
								
								
								
							}else{
								JOptionPane.showMessageDialog(null,"Usuário Especial Inválido");
							}
						}else{
							System.err.println("dwqqdqwdqwdwqdqwd");
							JOptionPane.showMessageDialog(null, "Existem Campos não preenchidos");
						}
							
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				//cancelar
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUserEspecial, textFieldSenhaEspecial, textFieldUser, textFieldSenha, okButton, cancelButton}));
	}
}
