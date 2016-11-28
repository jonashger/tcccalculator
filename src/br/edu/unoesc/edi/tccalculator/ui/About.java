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
 * Tela que representa o About do sistema
 * @author matheus
 *
 */
public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void init(){
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/imagens/logoimg.jpg")));
		setTitle("Sobre TCCalculator");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//criação da janela e descrição.
		JLabel lblNewLabel = new JLabel("<html>TCCalculator:  <br>\r\n\r\n<br> Sistema para controle de notas de trabalho de <br>\r\n conclus\u00E3o de curso - tcc. Fa\u00E7a os c\u00E1lculos da nota final referente aos acad\u00EAmicos\r\n da sua turma utilizando o TCCalculator.<br>\r\n\r\n<br>Criado e Desenvolvido por: <br> Jonas Halmenschlager <br> Matheus Endler Haas </html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 11, 414, 206);
		contentPanel.add(lblNewLabel);
		{
			//icone 
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\jonas\\git\\tccalculator\\resources\\Calculator2.png"));
			label.setBounds(258, 112, 120, 105);
			contentPanel.add(label);
		}
		
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
