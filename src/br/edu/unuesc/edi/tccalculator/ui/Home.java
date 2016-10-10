package br.edu.unuesc.edi.tccalculator.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

	
	private static final long serialVersionUID = 4613687046894259317L;

	private JPanel contentPane;
	JPanel cadastroAluno = null;

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
		setMinimumSize(new Dimension(	580	, 380));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
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
					cadastro.setMinimumSize(new Dimension(350,500));
					cadastroAluno.add(cadastro).setBounds(10, 10, 450, 300);;
					getContentPane().add(cadastroAluno,BorderLayout.CENTER);
					
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnCadastrar.add(mnCadastrarAluno);
		
		JMenu mnGravarNotas = new JMenu("Gravar Notas");
		menuBar.add(mnGravarNotas);
		
		JMenuItem mntmTccI = new JMenuItem("TCC I");
		mnGravarNotas.add(mntmTccI);
		
		JMenuItem mntmTccIi = new JMenuItem("TCC II");
		mnGravarNotas.add(mntmTccIi);
		
		JMenuItem mntmTccIii = new JMenuItem("TCC III");
		mnGravarNotas.add(mntmTccIii);
		
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
		mnSobre.add(mntmAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
		cadastroAluno = new JPanel();
		cadastroAluno.setMaximumSize(new Dimension(450, 300));
		cadastroAluno.setBounds(10, 10, 450, 300);
		cadastroAluno.setMinimumSize(new Dimension(400, 280));
		cadastroAluno.setLayout(null);
		
	}


}
