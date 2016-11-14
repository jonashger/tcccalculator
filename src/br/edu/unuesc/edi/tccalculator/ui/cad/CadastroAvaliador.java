package br.edu.unuesc.edi.tccalculator.ui.cad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unuesc.edi.tccalculator.db.Avaliador;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;
/**
 * Classe Responsavel pelo cadastro de avaliadores
 * @author jonas
 *
 */

public class CadastroAvaliador extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;


	public CadastroAvaliador() {
		setTitle("Cadastro de Avaliador");
		setFrameIcon(new ImageIcon(CadastroAvaliador.class.getResource("/imagens/cadastroaluno].png")));
		setClosable(true);
		setBounds(100, 100, 450, 167);
		getContentPane().setLayout(null);
		
		JLabel lblNomeDoAvaliador = new JLabel("Nome do Avaliador:");
		lblNomeDoAvaliador.setBounds(48, 72, 94, 26);
		getContentPane().add(lblNomeDoAvaliador);
		
		JLabel lblNewLabel = new JLabel("<html>Nesta tela \u00E9 possivel realizar o cadastro de avaliadores para ser realizado o cadastro de notas!");
		lblNewLabel.setBounds(10, 11, 414, 26);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(154, 74, 244, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String avaliador = textField.getText();
				int n = avaliador.indexOf(" ");
				int n2 = avaliador.indexOf("  ");
				if(avaliador.equals(" ")||avaliador.equals("  ")){
					JOptionPane.showMessageDialog(lblNewLabel, "Campo Vazio para realizar Cadastro.");
					return;
				}
				if (!(n<0)&& (n2<0)) {
					Avaliador a = new Avaliador();
					a.setAvaliador(avaliador);
					JOptionPane.showMessageDialog(lblNewLabel, avaliador +" cadastrada com sucesso no sistema!");
					textField.setText("");
					try {
						DAOManager.avaliadorDAO.create(a);
					} catch (SQLException e1) {
					}
				}else{
					JOptionPane.showMessageDialog(lblNewLabel, "Nome de Avaliador Inválido\nPor Favor, Preeche o campo com o nome completo do avaliador!");
				}
			
			}
		});
		btnCadastrar.setBounds(335, 108, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
			}
		});
		btnLimpar.setBounds(10, 109, 89, 23);
		getContentPane().add(btnLimpar);

	}
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof CadastroAvaliador);
	}
}
