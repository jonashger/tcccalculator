package br.edu.unuesc.edi.tccalculator.util;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.edu.unuesc.edi.tccalculator.ui.Home;

public class CadastrarUser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7711768174925790517L;
	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUser;
	private JTextField textFieldSenha;
	private JTextField textFieldUserEspecial;
	private JTextField textFieldSenhaEspecial;
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
	public CadastrarUser() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\logoimg.jpg"));
		setTitle("Cadastrar Novo Usu\u00E1rio - TTCalculator");
		setBounds(100, 100, 433, 300);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCadastrarNovoUsu = new JLabel("<html>Lembre-se que necessitar\u00E1 de usu\u00E1rio especial para poder cadastrar novo usu\u00E1rio!");
		lblCadastrarNovoUsu.setBounds(10, 11, 414, 14);
		contentPanel.add(lblCadastrarNovoUsu);
		{
			JLabel lblUsurio = new JLabel("Usu\u00E1rio");
			lblUsurio.setBounds(139, 162, 46, 14);
			contentPanel.add(lblUsurio);
		}
		{
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setBounds(139, 187, 46, 14);
			contentPanel.add(lblSenha);
		}
		{
			textFieldUser = new JTextField();
			textFieldUser.setBounds(195, 159, 86, 20);
			contentPanel.add(textFieldUser);
			textFieldUser.setColumns(10);
		}
		{
			textFieldSenha = new JTextField();
			textFieldSenha.setBounds(195, 184, 86, 20);
			contentPanel.add(textFieldSenha);
			textFieldSenha.setColumns(10);
		}
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
		{
			textFieldUserEspecial = new JTextField();
			textFieldUserEspecial.setColumns(10);
			textFieldUserEspecial.setBounds(195, 67, 86, 20);
			contentPanel.add(textFieldUserEspecial);
		}
		{
			textFieldSenhaEspecial = new JTextField();
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!((textFieldSenha.getText().equals(""))|| (textFieldSenhaEspecial.getText().equals(""))|| (textFieldUser.getText().equals(""))||(textFieldUserEspecial.getText().equals("")))){
							String senha = null;
							try {
								senha = LoginSHA.login(textFieldSenhaEspecial.getText());
							} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
								JOptionPane.showMessageDialog(null, "Algo aconteceu de errado.");
							}
							boolean pass = LoginPass.login(textFieldUserEspecial.getText().toLowerCase(), senha);
							if (pass){
								//TODO
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
