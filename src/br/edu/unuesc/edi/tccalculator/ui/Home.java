package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * Home
 * Essa é a tela inicial responsavel para o usuario inserir as informações
 * @author jonas
 *
 */
public class Home extends JFrame {

	private static final long serialVersionUID = 4613687046894259317L;

	private JPanel contentPane;
	JDesktopPane cadastroAluno = null;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\logoimg.jpg"));
		setTitle("TCCalculator");
		setVisible(true);
		setMinimumSize(new Dimension(900, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setIgnoreRepaint(true);
		menuBar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		mnArquivo.add(mntmSair);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);

		JMenuItem mnCadastrarAluno = new JMenuItem("Cadastrar aluno");
		mnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CadastrarAluno cadastro = new CadastrarAluno();
					for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
						if (cadastroAluno.getComponent(i).equals(cadastro)) {
							cadastro = (CadastrarAluno) cadastroAluno.getComponent(i++);
							cadastro.requestFocus();
							return;
						}
					}

					cadastro.setMinimumSize(new Dimension(350, 500));
					cadastroAluno.add(cadastro).setBounds(10, 10, 450, 300);
					cadastro.setVisible(true);

				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnCadastrar.add(mnCadastrarAluno);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCurso curso = new NewCurso();

				for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
					if (cadastroAluno.getComponent(i).equals(curso)) {
						curso = (NewCurso) cadastroAluno.getComponent(i);
						curso.requestFocus();
						return;

					}
				}

				curso.setMinimumSize(new Dimension(450, 300));
				cadastroAluno.add(curso).setBounds(10, 10, 450, 300);
				curso.setVisible(true);
				curso.requestFocusInWindow();
			}
		});
		mnCadastrar.add(mntmCurso);

		JMenu mnGravarNotas = new JMenu("Gravar Notas");
		menuBar.add(mnGravarNotas);

		JMenuItem mntmTccI = new JMenuItem("TCC I");
		mntmTccI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PegarAluno tcci = null;
				try {
					tcci = new PegarAluno(cadastroAluno,"tcc1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
					if (cadastroAluno.getComponent(i).equals(tcci)) {
						tcci = (PegarAluno) cadastroAluno.getComponent(i);
						tcci.requestFocus();
						tcci.requestFocusInWindow();
						return;

					}
				}

				tcci.setMinimumSize(new Dimension(350, 500));
				cadastroAluno.add(tcci).setBounds(10, 10,  521, 127);
				tcci.setVisible(true);
			}
		});
		mnGravarNotas.add(mntmTccI);

		JMenuItem mntmTccIi = new JMenuItem("TCC II");
		mntmTccIi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PegarAluno tcci = null;
				try {
					tcci = new PegarAluno(cadastroAluno,"tcc2");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
					if (cadastroAluno.getComponent(i).equals(tcci)) {
						tcci = (PegarAluno) cadastroAluno.getComponent(i);
						tcci.requestFocus();
						tcci.requestFocusInWindow();
						return;

					}
				}

				tcci.setMinimumSize(new Dimension(350, 500));
				cadastroAluno.add(tcci).setBounds(10, 10,  521, 127);
				tcci.setVisible(true);
			}
		});
		mnGravarNotas.add(mntmTccIi);

		JMenuItem mntmTccIii = new JMenuItem("TCC III");
		mntmTccIii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PegarAluno tcci = null;
				try {
					tcci = new PegarAluno(cadastroAluno,"tcc3");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < cadastroAluno.getComponents().length; i++) {
					if (cadastroAluno.getComponent(i).equals(tcci)) {
						tcci = (PegarAluno) cadastroAluno.getComponent(i);
						tcci.requestFocus();
						tcci.requestFocusInWindow();
						return;

					}
				}

				tcci.setMinimumSize(new Dimension(350, 500));
				cadastroAluno.add(tcci).setBounds(10, 10,  521, 127);
				tcci.setVisible(true);
			}
		});
		mnGravarNotas.add(mntmTccIii);

		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelatrio);

		JMenuItem mntmGerarRelatrioDe = new JMenuItem("Gerar Relat\u00F3rio de Aluno");
		mnRelatrio.add(mntmGerarRelatrioDe);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About.init();
			}
		});
		mnSobre.add(mntmSobre);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajuda.init();
			}
		});
		mnSobre.add(mntmAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		cadastroAluno = new JDesktopPane();
		cadastroAluno.setMaximumSize(new Dimension(1000, 700));
		cadastroAluno.setBounds(10, 10, 1000, 700);
		cadastroAluno.setMinimumSize(new Dimension(400, 280));
		cadastroAluno.setBackground(new Color(255, 255, 255));
		getContentPane().add(cadastroAluno, BorderLayout.CENTER);
		cadastroAluno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(353, 11, 989, 663);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/imagens/calculatorLema.png")));
		cadastroAluno.add(lblNewLabel);

	

	}
}
