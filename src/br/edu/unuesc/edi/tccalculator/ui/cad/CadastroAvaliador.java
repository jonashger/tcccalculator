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
import javax.swing.SwingConstants;
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
		setBounds(100, 100, 513, 193);
		getContentPane().setLayout(null);
		
		JLabel lblNomeDoAvaliador = new JLabel("Nome do Avaliador:");
		lblNomeDoAvaliador.setBounds(10, 72, 94, 26);
		getContentPane().add(lblNomeDoAvaliador);
		
		JLabel lblNewLabel = new JLabel("<html>Nesta tela \u00E9 possivel realizar o cadastro de avaliadores para ser realizado o cadastro de notas!");
		lblNewLabel.setBounds(10, 11, 497, 26);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(114, 74, 351, 23);
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
		btnCadastrar.setBounds(264, 129, 89, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
			}
		});
		btnLimpar.setBounds(141, 129, 89, 23);
		getContentPane().add(btnLimpar);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setBounds(410, 129, 14, 23);
		getContentPane().add(button_1);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setBounds(398, 129, 14, 23);
		getContentPane().add(button);
		
		JButton button_2 = new JButton("");
		button_2.setEnabled(false);
		button_2.setBounds(386, 129, 14, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(386, 129, 14, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setEnabled(false);
		button_4.setBounds(422, 129, 14, 23);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setEnabled(false);
		button_5.setBounds(434, 129, 14, 23);
		getContentPane().add(button_5);
		
		JButton button_8 = new JButton("");
		button_8.setEnabled(false);
		button_8.setBounds(69, 129, 14, 23);
		getContentPane().add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setEnabled(false);
		button_9.setBounds(374, 129, 14, 23);
		getContentPane().add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setEnabled(false);
		button_10.setBounds(362, 129, 14, 23);
		getContentPane().add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setEnabled(false);
		button_11.setBounds(446, 129, 14, 23);
		getContentPane().add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setEnabled(false);
		button_12.setBounds(227, 129, 14, 23);
		getContentPane().add(button_12);
		
		JButton button_14 = new JButton("");
		button_14.setEnabled(false);
		button_14.setBounds(81, 129, 14, 23);
		getContentPane().add(button_14);
		
		JButton button_6 = new JButton("");
		button_6.setEnabled(false);
		button_6.setBounds(57, 129, 14, 23);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(69, 129, 14, 23);
		getContentPane().add(button_7);
		
		JButton button_13 = new JButton("");
		button_13.setEnabled(false);
		button_13.setBounds(45, 129, 14, 23);
		getContentPane().add(button_13);
		
		JButton button_15 = new JButton("");
		button_15.setEnabled(false);
		button_15.setBounds(93, 129, 14, 23);
		getContentPane().add(button_15);
		
		JButton button_16 = new JButton("");
		button_16.setEnabled(false);
		button_16.setBounds(105, 129, 14, 23);
		getContentPane().add(button_16);
		
		JButton button_17 = new JButton("");
		button_17.setEnabled(false);
		button_17.setBounds(117, 129, 14, 23);
		getContentPane().add(button_17);
		
		JButton button_18 = new JButton("");
		button_18.setEnabled(false);
		button_18.setBounds(33, 129, 14, 23);
		getContentPane().add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setEnabled(false);
		button_19.setBounds(21, 129, 14, 23);
		getContentPane().add(button_19);
		
		JButton button_20 = new JButton("");
		button_20.setEnabled(false);
		button_20.setBounds(9, 129, 14, 23);
		getContentPane().add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setEnabled(false);
		button_21.setBounds(130, 129, 14, 23);
		getContentPane().add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setEnabled(false);
		button_22.setBounds(240, 129, 14, 23);
		getContentPane().add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setEnabled(false);
		button_23.setBounds(251, 129, 14, 23);
		getContentPane().add(button_23);
		
		JButton button_24 = new JButton("");
		button_24.setEnabled(false);
		button_24.setBounds(351, 129, 14, 23);
		getContentPane().add(button_24);
		
		JButton button_25 = new JButton("");
		button_25.setEnabled(false);
		button_25.setBounds(458, 129, 14, 23);
		getContentPane().add(button_25);

	}
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof CadastroAvaliador);
	}
}
