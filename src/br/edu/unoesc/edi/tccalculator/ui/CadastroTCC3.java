package br.edu.unoesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.edu.unoesc.edi.tccalculator.db.Aluno;
import br.edu.unoesc.edi.tccalculator.db.Avaliador;
import br.edu.unoesc.edi.tccalculator.db.DAOManager;
import br.edu.unoesc.edi.tccalculator.tcc.CadastroNotaTCC;
import br.edu.unoesc.edi.tccalculator.util.IeValidator;
import br.edu.unoesc.edi.tccalculator.util.ToDouble;
import br.edu.unoesc.edi.tccalculator.util.ValidaNumero;
/**
 * Classe que representa o cadastro de tcc 3
 * @author matheus
 *
 */
public class CadastroTCC3 extends JInternalFrame {


	private JTextField txtNotaFinalAP;
	private JTextField txtNotaFinalAA;
	private final JPanel contentPane = new JPanel();
	private JTextField txtNotaFinal;
	private JTextField txtAv1Ep1AP;
	private JTextField txtAv1Ep2AP;
	private JTextField txtAv1Ep3AP;
	private JTextField txtAv2Ep1AP;
	private JTextField txtAv2Ep2AP;
	private JTextField txtAv2Ep3AP;
	private JTextField txtAv3Ep3AP;
	private ArrayList<String> listaMedias = null;
	private JTextField txtAv3Ep2AP;
	private JTextField txtAv3Ep1AP;
	private JTextField txtMedA3AP;
	private JTextField txtMedA2AP;
	private JTextField txtMedA1AP;
	private JTextField txtAv1Ep4AP;
	private JTextField txtAv2Ep4AP;
	private JTextField txtAv3Ep4AP;
	private JTextField txtMedA4AP;
	private JTextField txtAv01E3AA;
	private JTextField txtAv02E3AA;
	private JTextField txtAv03E3AA;
	private JTextField txtMedA3AA;
	private JTextField txtMedA2AA;
	private JTextField txtAv03E2AA;
	private JTextField txtAv02E2AA;
	private JTextField txtAv01E2AA;
	private JTextField txtAv01E1AA;
	private JTextField txtAv02E1AA;
	private JTextField txtAv03E1AA;
	private JTextField txtMedA1AA;
	private JTextField txtNotaAO;
	private JTextField txtNotaAAA;
	private JLabel lblAvaliarAssiduidadePontualidade;
	private JLabel label_4;
	private JPanel panel;
	private JPanel panel_1;
	private ArrayList<String> lista;
	private JLabel lblAval1;
	private JLabel lblAval3;
	private JLabel lblAval2;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnGravarNotas;
	private JLabel lblAluno;
	private JLabel lblNomeAluno;
	private JTextField txtAv3Ep5AP;
	private JTextField txtAv1Ep5AP;
	private JTextField txtMedA5AP;
	private JTextField txtAv2Ep5AP ;
	private JLabel lblAvaliador;
	private JLabel lblAvaliador_1;
	private JLabel lblAvaliador_2;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws PropertyVetoException
	 * @throws SQLException 
	 */
	public CadastroTCC3(int usr, ArrayList<Integer> arrayIdAval) throws PropertyVetoException, SQLException {
		setFrameIcon(
				new ImageIcon(CadastroTCC1.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		setTitle(" C\u00E1lculo das Avalia\u00E7\u00F5es TCC3");
		setSelected(true);
		setFrameIcon(new ImageIcon("resources/cadastroaluno].png"));
		setClosable(true);
		setBounds(100, 100, 816, 633);
		getContentPane().setLayout(null);
		getContentPane().add(contentPane, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setBounds(26, 10, 764, 169);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblmonografia = new JLabel("Avalia\u00E7\u00E3o da Monografia");
		lblmonografia.setBounds(2, 0, 226, 21);
		panel.add(lblmonografia);
		lblmonografia.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotasAP = new JLabel("Notas");
		lblNotasAP.setBounds(559, 5, 72, 14);
		panel.add(lblNotasAP);
		lblNotasAP.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblItensAvaliadosAA = new JLabel("Itens Avaliados");
		lblItensAvaliadosAA.setBounds(92, 34, 121, 14);
		panel.add(lblItensAvaliadosAA);
		lblItensAvaliadosAA.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAvaliadorAP = new JLabel("Avaliador 1");
		lblAvaliadorAP.setBounds(413, 41, 72, 14);
		panel.add(lblAvaliadorAP);
		lblAvaliadorAP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador2AP = new JLabel("Avaliador 2");
		lblAvaliador2AP.setBounds(505, 41, 75, 14);
		panel.add(lblAvaliador2AP);
		lblAvaliador2AP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador3AP = new JLabel("Avaliador 3");
		lblAvaliador3AP.setBounds(590, 41, 70, 14);
		panel.add(lblAvaliador3AP);
		lblAvaliador3AP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMediaAP = new JLabel("M\u00E9dia");
		lblMediaAP.setBounds(706, 42, 46, 14);
		panel.add(lblMediaAP);
		lblMediaAP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvalizao = new JLabel("2) Grau de ader\u00EAncia entre os desafios anunciados e os resultados alcan\u00E7ados");
		lblAvalizao.setBounds(0, 73, 401, 21);
		panel.add(lblAvalizao);

		txtAv1Ep1AP = new JTextField();
		txtAv1Ep1AP.setBounds(401, 59, 86, 20);
		((AbstractDocument) txtAv1Ep1AP.getDocument()).setDocumentFilter(new IeValidator(3));
		panel.add(txtAv1Ep1AP);

		txtAv2Ep1AP = new JTextField();
		txtAv2Ep1AP.setBounds(494, 59, 86, 20);
		((AbstractDocument) txtAv2Ep1AP.getDocument()).setDocumentFilter(new IeValidator(3));
		panel.add(txtAv2Ep1AP);

		txtAv3Ep1AP = new JTextField();
		((AbstractDocument) txtAv3Ep1AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep1AP.setBounds(585, 59, 86, 20);
		panel.add(txtAv3Ep1AP);

		txtMedA1AP = new JTextField();
		txtMedA1AP.setBounds(676, 59, 86, 20);
		panel.add(txtMedA1AP);
		txtMedA1AP.setEditable(false);
		txtAv1Ep2AP = new JTextField();
		txtAv1Ep2AP.setBounds(401, 77, 86, 20);
		((AbstractDocument) txtAv1Ep2AP.getDocument()).setDocumentFilter(new IeValidator(3));
		panel.add(txtAv1Ep2AP);
		txtAv2Ep2AP = new JTextField();
		((AbstractDocument) txtAv2Ep2AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv2Ep2AP.setBounds(494, 77, 86, 20);
		panel.add(txtAv2Ep2AP);

		txtAv3Ep2AP = new JTextField();
		((AbstractDocument) txtAv3Ep2AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep2AP.setBounds(585, 77, 86, 20);
		panel.add(txtAv3Ep2AP);

		txtMedA2AP = new JTextField();
		txtMedA2AP.setBounds(676, 77, 86, 20);
		panel.add(txtMedA2AP);
		txtMedA2AP.setEditable(false);

		txtAv1Ep3AP = new JTextField();
		((AbstractDocument) txtAv1Ep3AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv1Ep3AP.setBounds(401, 97, 86, 20);
		panel.add(txtAv1Ep3AP);

		txtAv2Ep3AP = new JTextField();
		((AbstractDocument) txtAv2Ep3AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv2Ep3AP.setBounds(494, 97, 86, 20);
		panel.add(txtAv2Ep3AP);

		txtAv3Ep3AP = new JTextField();
		((AbstractDocument) txtAv3Ep3AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep3AP.setBounds(585, 97, 86, 20);
		panel.add(txtAv3Ep3AP);

		txtMedA3AP = new JTextField();
		txtMedA3AP.setBounds(676, 97, 86, 20);
		panel.add(txtMedA3AP);
		txtMedA3AP.setEditable(false);

		txtAv1Ep4AP = new JTextField();
		((AbstractDocument) txtAv1Ep4AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv1Ep4AP.setBounds(401, 116, 86, 20);
		panel.add(txtAv1Ep4AP);

		txtAv2Ep4AP = new JTextField();
		((AbstractDocument) txtAv2Ep4AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv2Ep4AP.setBounds(494, 116, 86, 20);
		panel.add(txtAv2Ep4AP);

		txtAv3Ep4AP = new JTextField();
		((AbstractDocument) txtAv3Ep4AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep4AP.setBounds(585, 116, 86, 20);
		panel.add(txtAv3Ep4AP);

		txtMedA4AP = new JTextField();
		txtMedA4AP.setBounds(676, 116, 86, 20);
		panel.add(txtMedA4AP);
		txtMedA4AP.setEditable(false);

		JLabel lblQualidadeDo = new JLabel("1) Qualidade do trabalho, relev\u00E2ncia, coer\u00EAncia e aspectos metodol\u00F3gicos");
		lblQualidadeDo.setBounds(0, 56, 391, 21);
		panel.add(lblQualidadeDo);

		JLabel lblMateriaisE = new JLabel("3) Adequa\u00E7\u00E3o da estrutura de cap\u00EDtulos (estrutura\u00E7\u00E3o l\u00F3gica da monografia)");
		lblMateriaisE.setBounds(0, 93, 401, 21);
		panel.add(lblMateriaisE);

		JLabel lblFormataoE = new JLabel("4) Adequa\u00E7\u00E3o do tema, abrang\u00EAncia e atualidade da bibliografia utilizada\r\n");
		lblFormataoE.setBounds(0, 112, 401, 21);
		panel.add(lblFormataoE);
		
		JLabel lblArticulacaotexto = new JLabel("5) Articula\u00E7\u00E3o do texto apresentado e a sua rela\u00E7\u00E3o com a pr\u00E1tica\r\n");
		lblArticulacaotexto.setBounds(2, 129, 399, 25);
		panel.add(lblArticulacaotexto);
		
		txtAv1Ep5AP = new JTextField();
		txtAv1Ep5AP.setBounds(401, 134, 86, 20);
		panel.add(txtAv1Ep5AP);
		
	    txtAv2Ep5AP = new JTextField();
		txtAv2Ep5AP.setBounds(494, 134, 86, 20);
		panel.add(txtAv2Ep5AP);
		
		txtAv3Ep5AP = new JTextField();
		txtAv3Ep5AP.setBounds(585, 134, 86, 20);
		panel.add(txtAv3Ep5AP);
		
		txtMedA5AP = new JTextField();
		txtMedA5AP.setEditable(false);
		txtMedA5AP.setBounds(676, 134, 86, 20);
		panel.add(txtMedA5AP);

		panel_1 = new JPanel();
		panel_1.setBounds(25, 190, 765, 112);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAA = new JLabel("Avalia\u00E7\u00E3o da Apresenta\u00E7\u00E3o - AA");
		lblAA.setBounds(0, 0, 273, 21);
		panel_1.add(lblAA);
		lblAA.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotasAA = new JLabel("Notas");
		lblNotasAA.setBounds(565, 2, 72, 14);
		panel_1.add(lblNotasAA);
		lblNotasAA.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblitensAvaliadosAA = new JLabel("Itens Avaliados");
		lblitensAvaliadosAA.setBounds(93, 27, 121, 14);
		panel_1.add(lblitensAvaliadosAA);
		lblitensAvaliadosAA.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAvaliadorAA = new JLabel("Avaliador 1");
		lblAvaliadorAA.setBounds(408, 27, 72, 14);
		panel_1.add(lblAvaliadorAA);
		lblAvaliadorAA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador2AA = new JLabel("Avaliador 2");
		lblAvaliador2AA.setBounds(504, 27, 75, 14);
		panel_1.add(lblAvaliador2AA);
		lblAvaliador2AA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador3AA = new JLabel("Avaliador 3");
		lblAvaliador3AA.setBounds(596, 27, 70, 14);
		panel_1.add(lblAvaliador3AA);
		lblAvaliador3AA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMediaAA = new JLabel("M\u00E9dia");
		lblMediaAA.setBounds(707, 27, 46, 14);
		panel_1.add(lblMediaAA);
		lblMediaAA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblUtilizaoDo = new JLabel(
				"1) Utiliza\u00E7\u00E3o do tempo dispon\u00EDvel");
		lblUtilizaoDo.setBounds(3, 49, 332, 21);
		panel_1.add(lblUtilizaoDo);

		JLabel lblDominioDo = new JLabel("2) Dominio do conte\u00FAdo\r\n");
		lblDominioDo.setBounds(3, 67, 333, 21);
		panel_1.add(lblDominioDo);

		JLabel lblLinguagemclareza = new JLabel("3) Linguagem (clareza, flu\u00EAncia do assunto)");
		lblLinguagemclareza.setBounds(3, 86, 332, 21);
		panel_1.add(lblLinguagemclareza);

		txtAv01E1AA = new JTextField();
		((AbstractDocument) txtAv01E1AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv01E1AA.setBounds(408, 49, 86, 20);
		panel_1.add(txtAv01E1AA);

		txtAv02E1AA = new JTextField();
		((AbstractDocument) txtAv02E1AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv02E1AA.setBounds(499, 49, 86, 20);
		panel_1.add(txtAv02E1AA);

		txtAv03E1AA = new JTextField();
		((AbstractDocument) txtAv03E1AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv03E1AA.setBounds(588, 49, 86, 20);
		panel_1.add(txtAv03E1AA);

		txtMedA1AA = new JTextField();
		txtMedA1AA.setBounds(677, 49, 86, 20);
		panel_1.add(txtMedA1AA);
		txtMedA1AA.setEditable(false);

		txtAv02E2AA = new JTextField();
		((AbstractDocument) txtAv02E2AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv02E2AA.setBounds(499, 67, 86, 20);
		panel_1.add(txtAv02E2AA);

		txtAv03E2AA = new JTextField();
		((AbstractDocument) txtAv03E2AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv03E2AA.setBounds(588, 67, 86, 20);
		panel_1.add(txtAv03E2AA);

		txtAv01E2AA = new JTextField();
		((AbstractDocument) txtAv01E2AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv01E2AA.setBounds(408, 67, 86, 20);
		panel_1.add(txtAv01E2AA);

		txtMedA2AA = new JTextField();
		txtMedA2AA.setBounds(677, 67, 86, 20);
		panel_1.add(txtMedA2AA);
		txtMedA2AA.setEditable(false);

		txtAv01E3AA = new JTextField();
		((AbstractDocument) txtAv01E3AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv01E3AA.setBounds(408, 87, 86, 20);
		panel_1.add(txtAv01E3AA);

		txtAv02E3AA = new JTextField();
		((AbstractDocument) txtAv02E3AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv02E3AA.setBounds(499, 87, 86, 20);
		panel_1.add(txtAv02E3AA);

		txtAv03E3AA = new JTextField();
		((AbstractDocument) txtAv03E3AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv03E3AA.setBounds(588, 87, 86, 20);
		panel_1.add(txtAv03E3AA);

		txtMedA3AA = new JTextField();
		txtMedA3AA.setBounds(677, 87, 86, 20);
		panel_1.add(txtMedA3AA);
		txtMedA3AA.setEditable(false);

		panel_2 = new JPanel();
		panel_2.setBounds(25, 313, 427, 61);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblAvaliacaoOrientador = new JLabel("Avalia\u00E7\u00E3o do Orientador - AO");
		lblAvaliacaoOrientador.setBounds(0, 0, 273, 21);
		panel_2.add(lblAvaliacaoOrientador);
		lblAvaliacaoOrientador.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotaAO = new JLabel("Nota");
		lblNotaAO.setBounds(343, 2, 72, 14);
		panel_2.add(lblNotaAO);
		lblNotaAO.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtNotaAO = new JTextField();
		((AbstractDocument) txtNotaAO.getDocument()).setDocumentFilter(new IeValidator(3));
		txtNotaAO.setBounds(341, 29, 86, 20);
		panel_2.add(txtNotaAO);

		label_4 = new JLabel(
				"<html>Avaliar: Assiduidade, pontualidade, cumprimento de prazos, iniciativa e responsabilidade");
		label_4.setBounds(0, 32, 332, 29);
		panel_2.add(label_4);

		panel_3 = new JPanel();
		panel_3.setBounds(25, 389, 430, 46);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblAutoAvaliacaoAAA = new JLabel("Auto Avalia\u00E7\u00E3o do Acad\u00EAmico - AAA");
		lblAutoAvaliacaoAAA.setBounds(0, 0, 305, 21);
		panel_3.add(lblAutoAvaliacaoAAA);
		lblAutoAvaliacaoAAA.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotaAAA = new JLabel("Nota");
		lblNotaAAA.setBounds(341, 2, 62, 14);
		panel_3.add(lblNotaAAA);
		lblNotaAAA.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtNotaAAA = new JTextField();
		((AbstractDocument) txtNotaAAA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtNotaAAA.setBounds(341, 22, 86, 20);
		panel_3.add(txtNotaAAA);

		lblAvaliarAssiduidadePontualidade = new JLabel(
				"<html>Avaliar: Assiduidade, pontualidade, cumprimento de prazos, iniciativa e responsabilidade");
		lblAvaliarAssiduidadePontualidade.setBounds(1, 17, 332, 29);
		panel_3.add(lblAvaliarAssiduidadePontualidade);

		panel_4 = new JPanel();
		panel_4.setBounds(548, 313, 213, 112);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNotaFinalAp = new JLabel("Nota AP:");
		lblNotaFinalAp.setBounds(0, 36, 86, 14);
		panel_4.add(lblNotaFinalAp);
		lblNotaFinalAp.setForeground(Color.BLUE);
		lblNotaFinalAp.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotaFinalAa = new JLabel("Nota AA:");
		lblNotaFinalAa.setBounds(0, 61, 98, 14);
		panel_4.add(lblNotaFinalAa);
		lblNotaFinalAa.setForeground(Color.BLUE);
		lblNotaFinalAa.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotaFinal = new JLabel("Nota Final:");
		lblNotaFinal.setBounds(0, 93, 98, 14);
		panel_4.add(lblNotaFinal);
		lblNotaFinal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNotaFinal.setForeground(Color.BLUE);

		JLabel lblRelatrioDeNotas = new JLabel("Relat\u00F3rio de Notas:");
		lblRelatrioDeNotas.setBounds(0, 0, 171, 14);
		panel_4.add(lblRelatrioDeNotas);
		lblRelatrioDeNotas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatrioDeNotas.setForeground(Color.BLUE);

		txtNotaFinalAP = new JTextField();
		((AbstractDocument) txtNotaFinalAP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtNotaFinalAP.setBounds(111, 35, 86, 20);
		panel_4.add(txtNotaFinalAP);
		txtNotaFinalAP.setEditable(false);

		txtNotaFinalAA = new JTextField();
		((AbstractDocument) txtNotaFinalAA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtNotaFinalAA.setBounds(111, 60, 86, 20);
		panel_4.add(txtNotaFinalAA);
		txtNotaFinalAA.setEditable(false);

		txtNotaFinal = new JTextField();
		((AbstractDocument) txtNotaFinal.getDocument()).setDocumentFilter(new IeValidator(3));
		txtNotaFinal.setBounds(111, 92, 86, 20);
		panel_4.add(txtNotaFinal);
		txtNotaFinal.setEditable(false);

		JButton btnGerarMedias = new JButton("Gerar M\u00E9dias");
		btnGerarMedias.setToolTipText("");
		btnGerarMedias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarMedias();
				return;
			}

		});
		btnGerarMedias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGerarMedias.setBounds(495, 566, 128, 32);
		getContentPane().add(btnGerarMedias);

		btnGravarNotas = new JButton("Gravar Notas");
		btnGravarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gerarMedias();	lista = new ArrayList<>();
				lista.add(txtAv1Ep1AP.getText());
				lista.add(txtAv2Ep1AP.getText());
				lista.add(txtAv3Ep1AP.getText());
				lista.add(txtAv1Ep2AP.getText());
				lista.add(txtAv2Ep2AP.getText());
				lista.add(txtAv3Ep2AP.getText());
				lista.add(txtAv1Ep3AP.getText());
				lista.add(txtAv2Ep3AP.getText());
				lista.add(txtAv3Ep3AP.getText());
				lista.add(txtAv1Ep4AP.getText());
				lista.add(txtAv2Ep4AP.getText());
				lista.add(txtAv3Ep4AP.getText());
				lista.add(txtAv1Ep5AP.getText());
				lista.add(txtAv2Ep5AP.getText());
				lista.add(txtAv3Ep5AP.getText());
				lista.add(txtAv01E1AA.getText());
				lista.add(txtAv02E1AA.getText());
				lista.add(txtAv03E1AA.getText());
				lista.add(txtAv01E2AA.getText());
				lista.add(txtAv02E2AA.getText());
				lista.add(txtAv03E2AA.getText());
				lista.add(txtAv01E3AA.getText());
				lista.add(txtAv02E3AA.getText());
				lista.add(txtAv03E3AA.getText());
				lista.add(txtNotaAO.getText());
				lista.add(txtNotaAAA.getText());
				listaMedias = new ArrayList<>();
				listaMedias.add(txtMedA1AA.getText());
				listaMedias.add(txtMedA2AA.getText());
				listaMedias.add(txtMedA3AA.getText());
				listaMedias.add(txtMedA1AP.getText());
				listaMedias.add(txtMedA2AP.getText());
				listaMedias.add(txtMedA3AP.getText());
				listaMedias.add(txtMedA4AP.getText());
				listaMedias.add(txtMedA5AP.getText());
				try {
					CadastroNotaTCC.cadastroTCC(txtNotaFinal.getText(), usr, arrayIdAval,lista,listaMedias);
		 		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Nota do Aluno foi Cadastrado. Aperte em OK para fechar");
				dispose();
			}
		});
		btnGravarNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGravarNotas.setBounds(633, 565, 128, 32);
		btnGravarNotas.setBackground(new Color(127, 129, 222));
		getContentPane().add(btnGravarNotas);

		
		
		lblNomeAluno = new JLabel();
		lblNomeAluno.setBounds(82, 570, 440, 22);
		getContentPane().add(lblNomeAluno);
		lblNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		Aluno a = DAOManager.alunoDAO.queryForId(usr);
		if(a.getAluno2().equals(""))
		lblNomeAluno.setText(a.getAluno());
		else{
		lblNomeAluno.setText(a.getAluno()+" e "+ a.getAluno2());
		}
				lblAluno = new JLabel("Aluno:");
				lblAluno.setBounds(22, 571, 62, 21);
				getContentPane().add(lblAluno);
				lblAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				lblAvaliador = new JLabel("Avaliador 1:");
				lblAvaliador.setBounds(136, 477, 86, 21);
				getContentPane().add(lblAvaliador);
				
				lblAvaliador_1 = new JLabel("Avaliador 2:");
				lblAvaliador_1.setBounds(136, 506, 86, 21);
				getContentPane().add(lblAvaliador_1);
				
				lblAvaliador_2 = new JLabel("Avaliador 3:");
				lblAvaliador_2.setBounds(136, 538, 86, 21);
				getContentPane().add(lblAvaliador_2);
				
				lblNewLabel = new JLabel("Avaliadores");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel.setBounds(330, 446, 86, 22);
				getContentPane().add(lblNewLabel);
				

				Avaliador av1 = DAOManager.avaliadorDAO.queryForId(arrayIdAval.get(0));
				lblAval1 = new JLabel(av1.getAvaliador());
				lblAval1.setBounds(216, 476, 303, 22);	
				getContentPane().add(lblAval1);
				Avaliador av2 = DAOManager.avaliadorDAO.queryForId(arrayIdAval.get(1));
				lblAval2 = new JLabel(av2.getAvaliador());
				lblAval2.setBounds(216, 505, 303, 22);
				getContentPane().add(lblAval2);
				Avaliador av3 = DAOManager.avaliadorDAO.queryForId(arrayIdAval.get(2));
				lblAval3 = new JLabel(av3.getAvaliador());
				lblAval3.setBounds(216, 538, 303, 22);
				getContentPane().add(lblAval3);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtAv1Ep1AP, txtAv2Ep1AP, txtAv3Ep1AP, txtAv1Ep2AP, txtAv2Ep2AP, txtAv3Ep2AP, txtAv1Ep3AP, txtAv2Ep3AP, txtAv3Ep3AP, txtAv1Ep4AP, txtAv2Ep4AP, txtAv3Ep4AP, txtAv1Ep5AP, txtAv2Ep5AP, txtAv3Ep5AP, txtAv01E1AA, txtAv02E1AA, txtAv03E1AA, txtAv01E2AA, txtAv02E2AA, txtAv03E2AA, txtAv01E3AA, txtAv02E3AA, txtAv03E3AA, txtNotaAO, txtNotaAAA, btnGerarMedias, btnGravarNotas}));

	}

	public void gerarMedias() {
		ArrayList<Boolean> valida = new ArrayList<>();
		valida.add(ValidaNumero.validaNumero(txtAv01E1AA));
		valida.add(ValidaNumero.validaNumero(txtAv02E1AA));
		valida.add(ValidaNumero.validaNumero(txtAv03E1AA));
		valida.add(ValidaNumero.validaNumero(txtAv01E2AA));
		valida.add(ValidaNumero.validaNumero(txtAv02E2AA));
		valida.add(ValidaNumero.validaNumero(txtAv03E2AA));
		valida.add(ValidaNumero.validaNumero(txtAv01E3AA));
		valida.add(ValidaNumero.validaNumero(txtAv02E3AA));
		valida.add(ValidaNumero.validaNumero(txtAv03E3AA));
		valida.add(ValidaNumero.validaNumero(txtAv1Ep1AP));
		valida.add(ValidaNumero.validaNumero(txtAv2Ep1AP));
		valida.add(ValidaNumero.validaNumero(txtAv3Ep1AP));
		valida.add(ValidaNumero.validaNumero(txtAv1Ep2AP));
		valida.add(ValidaNumero.validaNumero(txtAv3Ep2AP));
		valida.add(ValidaNumero.validaNumero(txtAv3Ep2AP));
		valida.add(ValidaNumero.validaNumero(txtAv1Ep3AP));
		valida.add(ValidaNumero.validaNumero(txtAv2Ep3AP));
		valida.add(ValidaNumero.validaNumero(txtAv3Ep3AP));
		valida.add(ValidaNumero.validaNumero(txtAv1Ep4AP));
		valida.add(ValidaNumero.validaNumero(txtAv2Ep4AP));
		valida.add(ValidaNumero.validaNumero(txtAv3Ep4AP));
		valida.add(ValidaNumero.validaNumero(txtAv1Ep5AP));
		valida.add(ValidaNumero.validaNumero(txtAv2Ep5AP));
		valida.add(ValidaNumero.validaNumero(txtAv3Ep5AP));

		valida.add(ValidaNumero.validaNumero(txtNotaAAA));
		valida.add(ValidaNumero.validaNumero(txtNotaAO));
		boolean pass = true;
		for (int i = 0; i < valida.size(); i++) {
			if (!valida.get(i)) {
				JOptionPane.showMessageDialog(txtAv3Ep3AP,
						"Insira todos os campos requeridos. Número não superior à 0 e inferior a 10", "Informação", 0);
				pass = false;
				break;
			}
		}
		if (pass) {
			double valorEx1 = ToDouble.init(txtAv1Ep1AP);
			double valorEx2 = ToDouble.init(txtAv01E1AA);
			double valorFinal1=calculaMedia(txtAv1Ep1AP, txtAv2Ep1AP, txtAv3Ep1AP).doubleValue();
			double valorFinal2=calculaMedia(txtAv1Ep2AP, txtAv2Ep2AP, txtAv3Ep2AP).doubleValue();
			double valorFinal3=calculaMedia(txtAv1Ep3AP, txtAv2Ep3AP, txtAv3Ep3AP).doubleValue();
			double valorFinal4=calculaMedia(txtAv1Ep4AP, txtAv2Ep4AP, txtAv3Ep4AP).doubleValue();
			double valorFinal8=calculaMedia(txtAv1Ep5AP, txtAv2Ep5AP, txtAv3Ep5AP).doubleValue();
			double valorFinal5=calculaMedia(txtAv01E1AA, txtAv02E1AA, txtAv03E1AA).doubleValue();
			double valorFinal6=calculaMedia(txtAv01E2AA, txtAv02E2AA, txtAv03E2AA).doubleValue();
			double valorFinal7=calculaMedia(txtAv01E3AA, txtAv02E3AA, txtAv03E3AA).doubleValue();
			txtMedA1AP.setText(String.valueOf(valorFinal1));
			txtMedA2AP.setText(String.valueOf(valorFinal2));
			txtMedA3AP.setText(String.valueOf(valorFinal3));
			txtMedA4AP.setText(String.valueOf(valorFinal4));
			txtMedA5AP.setText(String.valueOf(valorFinal8));
			txtMedA1AA.setText(String.valueOf(valorFinal5));
			txtMedA2AA.setText(String.valueOf(valorFinal6));
			txtMedA3AA.setText(String.valueOf(valorFinal7));

			double valorFinalAP = 0;
			double valorFinalAA = 0;
			if ((valorEx1 != 0)) {
				valorFinalAP = (2 * valorFinal1 + 2.5 * valorFinal2 + 2.5 * valorFinal3 + 1.5 * valorFinal4 + 1.5 * valorFinal8) / 10;
			} else {
				System.out.println("erro no calculo da nota Ex1");
				return;
			}
			if (valorEx2 != 0) {
				valorFinalAA = (valorFinal5 * 2 + 6 * valorFinal6 + 2 * valorFinal7) / 10;
			} else {
				System.out.println("erro no calculo da nota Ex2");
				return;
			}
			BigDecimal bd;
		    bd= new BigDecimal(valorFinalAP).setScale(1, RoundingMode.HALF_EVEN);
			txtNotaFinalAP.setText(String.valueOf(bd.doubleValue()));
		    bd= new BigDecimal(valorFinalAA).setScale(1, RoundingMode.HALF_EVEN);
			txtNotaFinalAA.setText(String.valueOf(bd.doubleValue()));
			double notaFinalFinal = (valorFinalAA * 2 + valorFinalAP * 5 + ToDouble.init(txtNotaAO) * 1.5
					+ ToDouble.init(txtNotaAAA) * 1.5) / 10;
		    bd= new BigDecimal(notaFinalFinal).setScale(1, RoundingMode.HALF_EVEN);
			txtNotaFinal.setText(String.valueOf(bd.doubleValue()));

			getContentPane().repaint();
			getContentPane().revalidate();
			
		

		}
	}
	
	public BigDecimal calculaMedia(JTextField n1,JTextField n2,JTextField n3){
		BigDecimal bd;
		double valorEx = ToDouble.init(n1);
		double valor2 = ToDouble.init(n2);
		double valor3 = ToDouble.init(n3);
		double valorFinal = (valorEx + valor2 + valor3) / 3;
	    bd= new BigDecimal(valorFinal).setScale(1, RoundingMode.HALF_EVEN);
		return bd;
	}
	
	
	@Override
	public boolean equals(Object cad) {
		return (cad instanceof CadastroTCC3);
	}
}
