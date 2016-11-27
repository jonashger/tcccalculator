package br.edu.unoesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * Tela de ajuda para o usuário
 * @author matheus
 *
 */
public class Ajuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void init(){
		try {
			Ajuda dialog = new Ajuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ajuda() {
		//imagem,posicionamento...
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ajuda.class.getResource("/imagens/logoimg.jpg")));
		setTitle("Ajuda TCCalculator");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//janela e descrição
		JLabel lblNewLabel = new JLabel("<html>TCCalculator:  <br>\r\n\r\n<br> Sistema para controle de notas de trabalho de <br>\r\n conclus\u00E3o de curso - tcc. <br>\r\n<br> Precisa de Ajuda? Tens uma sujest\u00E3o? Entre em contato: <br>\r\nmatheusendler@hotmail.com\t\t\t<br>jonassjo@outlook.com\r\n\r\n</html>");
		lblNewLabel.setIcon(new ImageIcon("resources\\ajuda.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 11, 414, 206);
		contentPanel.add(lblNewLabel);
		
		{
			//botao ok
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}

}
