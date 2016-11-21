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

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unuesc.edi.tccalculator.ui.cad.CadastroAvaliador;
import br.edu.unuesc.edi.tccalculator.ui.remove.Remove;
/**
 * Home
 * Essa é a tela inicial responsavel para o usuario inserir as informações
 * @author jonas
 *
 */
public class Home extends JFrame {

	private static final long serialVersionUID = 4613687046894259317L;

	private JPanel contentPane;
	JDesktopPane janelas = null;

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

		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/imagens/logoimg.jpg")));
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
		mntmSair.setIcon(new ImageIcon(Home.class.getResource("/imagens/logout.png")));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		mnArquivo.add(mntmSair);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);

		JMenuItem mnCadastrarAluno = new JMenuItem("Cadastrar TCC");
		mnCadastrarAluno.setIcon(new ImageIcon(Home.class.getResource("/imagens/tccCad.png")));
		mnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CadastrarAluno cadastro = new CadastrarAluno();
					for (int i = 0; i < janelas.getComponents().length; i++) {
						if (janelas.getComponent(i).equals(cadastro)) {
							cadastro = (CadastrarAluno) janelas.getComponent(i++);
							cadastro.requestFocus();
							return;
						}
					}

					cadastro.setMinimumSize(new Dimension(350, 500));
					janelas.add(cadastro).setBounds(10, 10, 450, 300);
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
		mntmCurso.setIcon(new ImageIcon(Home.class.getResource("/imagens/studentd.png")));
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCurso curso = new NewCurso();

				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(curso)) {
						curso = (NewCurso) janelas.getComponent(i);
						curso.requestFocus();
						return;

					}
				}

				curso.setMinimumSize(new Dimension(450, 300));
				janelas.add(curso).setBounds(10, 10, 450, 300);
				curso.setVisible(true);
				curso.requestFocusInWindow();
			}
		});
		
		JMenuItem mntmAvaliador = new JMenuItem("Avaliador");
		mntmAvaliador.setIcon(new ImageIcon(Home.class.getResource("/imagens/classroom.png")));
		mntmAvaliador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAvaliador avaliador = new CadastroAvaliador();
				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals( avaliador)) {
						 avaliador = (CadastroAvaliador) janelas.getComponent(i);
						 avaliador.requestFocus();
						return;

					}
				}

				 avaliador.setMinimumSize(new Dimension(450, 300));
				janelas.add( avaliador).setBounds(10, 10, 513, 193);
				 avaliador.setVisible(true);
				 avaliador.requestFocusInWindow();
			}
		});
		mnCadastrar.add(mntmAvaliador);
		mnCadastrar.add(mntmCurso);

		JMenu mnGravarNotas = new JMenu("Gravar Notas");
		menuBar.add(mnGravarNotas);

		JMenuItem mntmTccI = new JMenuItem("TCC I");
		mntmTccI.setIcon(new ImageIcon(Home.class.getResource("/imagens/one.png")));
		mntmTccI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PegarAluno tcci = null;
				try {
					tcci = new PegarAluno(janelas,"tcc1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(tcci)) {
						tcci = (PegarAluno) janelas.getComponent(i);
						tcci.requestFocus();
						tcci.requestFocusInWindow();
						return;

					}
				}

				tcci.setMinimumSize(new Dimension(350, 500));
				janelas.add(tcci).setBounds(10, 10,  664, 257);
				tcci.setVisible(true);
			}
		});
		mnGravarNotas.add(mntmTccI);

		JMenuItem mntmTccIi = new JMenuItem("TCC II");
		mntmTccIi.setIcon(new ImageIcon(Home.class.getResource("/imagens/two.png")));
		mntmTccIi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PegarAluno tcci = null;
				try {
					tcci = new PegarAluno(janelas,"tcc2");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(tcci)) {
						tcci = (PegarAluno) janelas.getComponent(i);
						tcci.requestFocus(); 
						tcci.requestFocusInWindow();
						return;

					}
				}

				tcci.setMinimumSize(new Dimension(350, 500));
				janelas.add(tcci).setBounds(10, 10,  664, 257);
				tcci.setVisible(true);
			}
		});
		mnGravarNotas.add(mntmTccIi);

		JMenuItem mntmTccIii = new JMenuItem("TCC III");
		mntmTccIii.setIcon(new ImageIcon(Home.class.getResource("/imagens/three.png")));
		mntmTccIii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PegarAluno tcci = null;
				try {
					tcci = new PegarAluno(janelas,"tcc3");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(tcci)) {
						tcci = (PegarAluno) janelas.getComponent(i);
						tcci.requestFocus();
						tcci.requestFocusInWindow();
						return;

					}
				}

				tcci.setMinimumSize(new Dimension(350, 500));
				janelas.add(tcci).setBounds(10, 10, 664, 257);
				tcci.setVisible(true);
			}
		});
		mnGravarNotas.add(mntmTccIii);

		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelatrio);

		JMenuItem mntmGerarRelatrioDe = new JMenuItem("Gerar Relat\u00F3rio de Aluno");
		mntmGerarRelatrioDe.setIcon(new ImageIcon(Home.class.getResource("/imagens/search.png")));
		mntmGerarRelatrioDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarRelatorio cad = null;
				try {
					cad = new GerarRelatorio(janelas);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(cad)) {
						cad = (GerarRelatorio) janelas.getComponent(i);
						cad.requestFocus();
						cad.requestFocusInWindow();
						return;

					}
				}

				cad.setMinimumSize(new Dimension(350, 300));
				janelas.add(cad).setBounds(10, 10, 656, 281);
				cad.setVisible(true);
			}
		});
		mnRelatrio.add(mntmGerarRelatrioDe);
		
		JMenu mnRemover = new JMenu("Remover");
		menuBar.add(mnRemover);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.setIcon(new ImageIcon(Home.class.getResource("/imagens/remove.png")));
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Remove cad = null;
					cad = new Remove(janelas);
				
				for (int i = 0; i < janelas.getComponents().length; i++) {
					if (janelas.getComponent(i).equals(cad)) {
						cad = (Remove) janelas.getComponent(i);
						cad.requestFocus();
						cad.requestFocusInWindow();
						return;

					}
				}

				cad.setMinimumSize(new Dimension(350, 300));
				janelas.add(cad).setBounds(10, 10,  509,217);
				cad.setVisible(true);
			}
		});
		mnRemover.add(mntmRemover);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setIcon(new ImageIcon(Home.class.getResource("/imagens/letter-i.png")));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About.init();
			}
		});
		mnSobre.add(mntmSobre);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setIcon(new ImageIcon(Home.class.getResource("/imagens/info.png")));
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

		janelas = new JDesktopPane();
		janelas.setMaximumSize(new Dimension(1000, 700));
		janelas.setBounds(10, 10, 1000, 700);
		janelas.setMinimumSize(new Dimension(400, 280));
		janelas.setBackground(new Color(255, 255, 255));
		getContentPane().add(janelas, BorderLayout.CENTER);
		janelas.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(353, 11, 989, 663);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/imagens/calculatorLema.png")));
		janelas.add(lblNewLabel);

	

	}
}
