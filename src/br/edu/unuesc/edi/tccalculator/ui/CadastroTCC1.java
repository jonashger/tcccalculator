package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
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

import com.j256.ormlite.stmt.UpdateBuilder;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.util.IeValidator;
import br.edu.unuesc.edi.tccalculator.util.ToDouble;
import br.edu.unuesc.edi.tccalculator.util.ValidaNumero;

public class CadastroTCC1 extends JInternalFrame {
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
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnGravarNotas;
	private JLabel lblAluno;
	private JLabel lblNomeAluno;
	private JPanel panel_5;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws PropertyVetoException
	 */
	public CadastroTCC1(String usr) throws PropertyVetoException {
		setFrameIcon(
				new ImageIcon(CadastroTCC1.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		setTitle(" C\u00E1lculo das Avalia\u00E7\u00F5es TCC1");
		setSelected(true);
		setFrameIcon(new ImageIcon("resources/cadastroaluno].png"));
		setClosable(true);
		setBounds(100, 100, 743, 545);
		getContentPane().setLayout(null);
		getContentPane().add(contentPane, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setBounds(26, 10, 684, 133);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAP = new JLabel("Avalia\u00E7\u00E3o do Projeto - AP");
		lblAP.setBounds(2, 0, 226, 21);
		panel.add(lblAP);
		lblAP.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotasAP = new JLabel("Notas");
		lblNotasAP.setBounds(481, 2, 72, 14);
		panel.add(lblNotasAP);
		lblNotasAP.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblItensAvaliadosAA = new JLabel("Itens Avaliados");
		lblItensAvaliadosAA.setBounds(92, 34, 121, 14);
		panel.add(lblItensAvaliadosAA);
		lblItensAvaliadosAA.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAvaliadorAP = new JLabel("Avaliador 1");
		lblAvaliadorAP.setBounds(335, 38, 72, 14);
		panel.add(lblAvaliadorAP);
		lblAvaliadorAP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador2AP = new JLabel("Avaliador 2");
		lblAvaliador2AP.setBounds(427, 38, 75, 14);
		panel.add(lblAvaliador2AP);
		lblAvaliador2AP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador3AP = new JLabel("Avaliador 3");
		lblAvaliador3AP.setBounds(512, 38, 70, 14);
		panel.add(lblAvaliador3AP);
		lblAvaliador3AP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMediaAP = new JLabel("M\u00E9dia");
		lblMediaAP.setBounds(628, 39, 46, 14);
		panel.add(lblMediaAP);
		lblMediaAP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvalizao = new JLabel("2) Fundamenta\u00E7\u00E3o Te\u00F3rica.");
		lblAvalizao.setBounds(0, 73, 332, 21);
		panel.add(lblAvalizao);

		txtAv1Ep1AP = new JTextField();
		txtAv1Ep1AP.setBounds(323, 56, 86, 20);
		((AbstractDocument) txtAv1Ep1AP.getDocument()).setDocumentFilter(new IeValidator(3));
		panel.add(txtAv1Ep1AP);

		txtAv2Ep1AP = new JTextField();
		txtAv2Ep1AP.setBounds(416, 56, 86, 20);
		((AbstractDocument) txtAv2Ep1AP.getDocument()).setDocumentFilter(new IeValidator(3));
		panel.add(txtAv2Ep1AP);

		txtAv3Ep1AP = new JTextField();
		((AbstractDocument) txtAv3Ep1AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep1AP.setBounds(507, 56, 86, 20);
		panel.add(txtAv3Ep1AP);

		txtMedA1AP = new JTextField();
		((AbstractDocument) txtMedA1AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtMedA1AP.setBounds(598, 56, 86, 20);
		panel.add(txtMedA1AP);
		txtMedA1AP.setEditable(false);
		txtAv1Ep2AP = new JTextField();
		txtAv1Ep2AP.setBounds(323, 74, 86, 20);
		((AbstractDocument) txtAv1Ep2AP.getDocument()).setDocumentFilter(new IeValidator(3));
		panel.add(txtAv1Ep2AP);
		txtAv2Ep2AP = new JTextField();
		((AbstractDocument) txtAv2Ep2AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv2Ep2AP.setBounds(416, 74, 86, 20);
		panel.add(txtAv2Ep2AP);

		txtAv3Ep2AP = new JTextField();
		((AbstractDocument) txtAv3Ep2AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep2AP.setBounds(507, 74, 86, 20);
		panel.add(txtAv3Ep2AP);

		txtMedA2AP = new JTextField();
		((AbstractDocument) txtMedA2AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtMedA2AP.setBounds(598, 74, 86, 20);
		panel.add(txtMedA2AP);
		txtMedA2AP.setEditable(false);

		txtAv1Ep3AP = new JTextField();
		((AbstractDocument) txtAv1Ep3AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv1Ep3AP.setBounds(323, 94, 86, 20);
		panel.add(txtAv1Ep3AP);

		txtAv2Ep3AP = new JTextField();
		((AbstractDocument) txtAv2Ep3AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv2Ep3AP.setBounds(416, 94, 86, 20);
		panel.add(txtAv2Ep3AP);

		txtAv3Ep3AP = new JTextField();
		((AbstractDocument) txtAv3Ep3AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep3AP.setBounds(507, 94, 86, 20);
		panel.add(txtAv3Ep3AP);

		txtMedA3AP = new JTextField();
		((AbstractDocument) txtMedA3AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtMedA3AP.setBounds(598, 94, 86, 20);
		panel.add(txtMedA3AP);
		txtMedA3AP.setEditable(false);

		txtAv1Ep4AP = new JTextField();
		((AbstractDocument) txtAv1Ep4AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv1Ep4AP.setBounds(323, 113, 86, 20);
		panel.add(txtAv1Ep4AP);

		txtAv2Ep4AP = new JTextField();
		((AbstractDocument) txtAv2Ep4AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv2Ep4AP.setBounds(416, 113, 86, 20);
		panel.add(txtAv2Ep4AP);

		txtAv3Ep4AP = new JTextField();
		((AbstractDocument) txtAv3Ep4AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv3Ep4AP.setBounds(507, 113, 86, 20);
		panel.add(txtAv3Ep4AP);

		txtMedA4AP = new JTextField();
		((AbstractDocument) txtMedA4AP.getDocument()).setDocumentFilter(new IeValidator(3));
		txtMedA4AP.setBounds(598, 113, 86, 20);
		panel.add(txtMedA4AP);
		txtMedA4AP.setEditable(false);

		JLabel label = new JLabel("1) Formula\u00E7\u00E3o clara da introdu\u00E7\u00E3o, objetivos e justificativa.");
		label.setBounds(0, 56, 332, 21);
		panel.add(label);

		JLabel lblMateriaisE = new JLabel("3) Materiais e M\u00E9todos.");
		lblMateriaisE.setBounds(0, 93, 332, 21);
		panel.add(lblMateriaisE);

		JLabel lblFormataoE = new JLabel("4) Formata\u00E7\u00E3o e organiza\u00E7\u00E3o do texto.");
		lblFormataoE.setBounds(0, 112, 332, 21);
		panel.add(lblFormataoE);

		panel_1 = new JPanel();
		panel_1.setBounds(25, 167, 680, 107);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAA = new JLabel("Avalia\u00E7\u00E3o da Apresenta\u00E7\u00E3o - AA");
		lblAA.setBounds(0, 0, 273, 21);
		panel_1.add(lblAA);
		lblAA.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNotasAA = new JLabel("Notas");
		lblNotasAA.setBounds(482, 2, 72, 14);
		panel_1.add(lblNotasAA);
		lblNotasAA.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblitensAvaliadosAA = new JLabel("Itens Avaliados");
		lblitensAvaliadosAA.setBounds(93, 27, 121, 14);
		panel_1.add(lblitensAvaliadosAA);
		lblitensAvaliadosAA.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAvaliadorAA = new JLabel("Avaliador 1");
		lblAvaliadorAA.setBounds(325, 27, 72, 14);
		panel_1.add(lblAvaliadorAA);
		lblAvaliadorAA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador2AA = new JLabel("Avaliador 2");
		lblAvaliador2AA.setBounds(421, 27, 75, 14);
		panel_1.add(lblAvaliador2AA);
		lblAvaliador2AA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAvaliador3AA = new JLabel("Avaliador 3");
		lblAvaliador3AA.setBounds(513, 27, 70, 14);
		panel_1.add(lblAvaliador3AA);
		lblAvaliador3AA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMediaAA = new JLabel("M\u00E9dia");
		lblMediaAA.setBounds(624, 27, 46, 14);
		panel_1.add(lblMediaAA);
		lblMediaAA.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_1 = new JLabel(
				"1) Formula\u00E7\u00E3o clara da introdu\u00E7\u00E3o, objetivos e justificativa.");
		label_1.setBounds(3, 49, 332, 21);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("2) Fundamenta\u00E7\u00E3o Te\u00F3rica.");
		label_2.setBounds(3, 67, 333, 21);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("3) Materiais e M\u00E9todos.");
		label_3.setBounds(3, 86, 332, 21);
		panel_1.add(label_3);

		txtAv01E1AA = new JTextField();
		((AbstractDocument) txtAv01E1AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv01E1AA.setBounds(325, 49, 86, 20);
		panel_1.add(txtAv01E1AA);

		txtAv02E1AA = new JTextField();
		((AbstractDocument) txtAv02E1AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv02E1AA.setBounds(416, 49, 86, 20);
		panel_1.add(txtAv02E1AA);

		txtAv03E1AA = new JTextField();
		((AbstractDocument) txtAv03E1AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv03E1AA.setBounds(505, 49, 86, 20);
		panel_1.add(txtAv03E1AA);

		txtMedA1AA = new JTextField();
		((AbstractDocument) txtMedA1AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtMedA1AA.setBounds(594, 49, 86, 20);
		panel_1.add(txtMedA1AA);
		txtMedA1AA.setEditable(false);

		txtAv02E2AA = new JTextField();
		((AbstractDocument) txtAv02E2AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv02E2AA.setBounds(416, 67, 86, 20);
		panel_1.add(txtAv02E2AA);

		txtAv03E2AA = new JTextField();
		((AbstractDocument) txtAv03E2AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv03E2AA.setBounds(505, 67, 86, 20);
		panel_1.add(txtAv03E2AA);

		txtAv01E2AA = new JTextField();
		((AbstractDocument) txtAv01E2AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv01E2AA.setBounds(325, 67, 86, 20);
		panel_1.add(txtAv01E2AA);

		txtMedA2AA = new JTextField();
		((AbstractDocument) txtMedA2AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtMedA2AA.setBounds(594, 67, 86, 20);
		panel_1.add(txtMedA2AA);
		txtMedA2AA.setEditable(false);

		txtAv01E3AA = new JTextField();
		((AbstractDocument) txtAv01E3AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv01E3AA.setBounds(325, 87, 86, 20);
		panel_1.add(txtAv01E3AA);

		txtAv02E3AA = new JTextField();
		((AbstractDocument) txtAv02E3AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv02E3AA.setBounds(416, 87, 86, 20);
		panel_1.add(txtAv02E3AA);

		txtAv03E3AA = new JTextField();
		((AbstractDocument) txtAv03E3AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtAv03E3AA.setBounds(505, 87, 86, 20);
		panel_1.add(txtAv03E3AA);

		txtMedA3AA = new JTextField();
		((AbstractDocument) txtMedA3AA.getDocument()).setDocumentFilter(new IeValidator(3));
		txtMedA3AA.setBounds(594, 87, 86, 20);
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
		panel_4.setBounds(487, 313, 213, 112);
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
		btnGerarMedias.setBounds(452, 471, 128, 32);
		getContentPane().add(btnGerarMedias);

		btnGravarNotas = new JButton("Gravar Notas");
		btnGravarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gerarMedias();
				
			}
		});
		btnGravarNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGravarNotas.setBounds(582, 471, 128, 32);
		btnGravarNotas.setBackground(new Color(127, 129, 222));
		getContentPane().add(btnGravarNotas);

		panel_5 = new JPanel();
		panel_5.setBounds(26, 472, 328, 22);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);

		lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(0, 1, 62, 21);
		panel_5.add(lblAluno);
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblNomeAluno = new JLabel();
		lblNomeAluno.setText(usr);
		lblNomeAluno.setBounds(60, 0, 240, 22);
		panel_5.add(lblNomeAluno);
		lblNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { txtAv1Ep1AP, txtAv2Ep1AP, txtAv3Ep1AP,
				txtAv1Ep2AP, txtAv2Ep2AP, txtAv3Ep2AP, txtAv1Ep3AP, txtAv2Ep3AP, txtAv3Ep3AP, txtAv1Ep4AP, txtAv2Ep4AP,
				txtAv3Ep4AP, txtAv01E1AA, txtAv02E1AA, txtAv03E1AA, txtAv01E2AA, txtAv02E2AA, txtAv03E2AA, txtAv01E3AA,
				txtAv02E3AA, txtAv03E3AA, txtNotaAO, txtNotaAAA, btnGerarMedias, btnGravarNotas }));

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
			double valor2 = ToDouble.init(txtAv2Ep1AP);
			double valor3 = ToDouble.init(txtAv3Ep1AP);
			double valorFinal1 = (valorEx1 + valor2 + valor3) / 3;
			txtMedA1AP.setText(String.valueOf(valorFinal1));

			double valor1 = ToDouble.init(txtAv1Ep2AP);
			valor2 = ToDouble.init(txtAv2Ep2AP);
			valor3 = ToDouble.init(txtAv3Ep2AP);
			double valorFinal2 = (valor1 + valor2 + valor3) / 3;
			txtMedA2AP.setText(String.valueOf(valorFinal2));

			valor1 = ToDouble.init(txtAv1Ep3AP);
			valor2 = ToDouble.init(txtAv2Ep3AP);
			valor3 = ToDouble.init(txtAv3Ep3AP);
			double valorFinal3 = (valor1 + valor2 + valor3) / 3;
			txtMedA3AP.setText(String.valueOf(valorFinal3));

			valor1 = ToDouble.init(txtAv1Ep4AP);
			valor2 = ToDouble.init(txtAv2Ep4AP);
			valor3 = ToDouble.init(txtAv3Ep4AP);
			double valorFinal4 = (valor1 + valor2 + valor3) / 3;
			txtMedA4AP.setText(String.valueOf(valorFinal4));

			double valorEx2 = ToDouble.init(txtAv01E1AA);
			valor2 = ToDouble.init(txtAv02E1AA);
			valor3 = ToDouble.init(txtAv03E1AA);
			double valorFinal5 = (valorEx2 + valor2 + valor3) / 3;
			txtMedA1AA.setText(String.valueOf(valorFinal5));

			valor1 = ToDouble.init(txtAv01E2AA);
			valor2 = ToDouble.init(txtAv02E2AA);
			valor3 = ToDouble.init(txtAv03E2AA);
			double valorFinal6 = (valor1 + valor2 + valor3) / 3;
			txtMedA2AA.setText(String.valueOf(valorFinal6));

			valor1 = ToDouble.init(txtAv01E3AA);
			valor2 = ToDouble.init(txtAv02E3AA);
			valor3 = ToDouble.init(txtAv03E3AA);
			double valorFinal7 = (valor1 + valor2 + valor3) / 3;
			txtMedA3AA.setText(String.valueOf(valorFinal7));
			double valorFinalAP = 0;
			double valorFinalAA = 0;
			if ((valorEx1 != 0)) {
				valorFinalAP = (2 * valorFinal1 + 4 * valorFinal2 + 2 * valorFinal3 + 2 * valorFinal4) / 10;
			} else {
				System.err.println("dwd");
				return;
			}
			if (valorEx2 != 0) {
				valorFinalAA = (valorFinal5 * 2 + 6 * valorFinal6 + 2 * valorFinal7) / 10;
			} else {
				System.err.println("wdw");
				return;
			}
			txtNotaFinalAP.setText(String.valueOf(valorFinalAP));
			txtNotaFinalAA.setText(String.valueOf(valorFinalAA));
			double notaFinalFinal = (valorFinalAA * 2 + valorFinalAP * 5 + ToDouble.init(txtNotaAO) * 1.5
					+ ToDouble.init(txtNotaAAA) * 1.5) / 10;
			txtNotaFinal.setText(String.valueOf(notaFinalFinal));
			txtNotaFinalAA.repaint();
			txtNotaFinalAP.repaint();
			
			
			
		}
	}

	@Override
	public boolean equals(Object cad) {
		return (cad instanceof CadastroTCC1);
	}
}
