package br.edu.unoesc.edi.tccalculator.main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;

import br.edu.unoesc.edi.tccalculator.ui.Login;
/**
 * Classe Main do projeto.
 * Splash Screen para carregar o sistema.
 *
 * @author Jonas
 */
public class Main extends JWindow {
    
  
	private static final long serialVersionUID = 1L;
	private int duration;
    /**
     * 
     * @param d  = informa os milessegundos que � enviado pela classe main
     */
    public Main(int d) {
        duration = d;
    }
    
// Este � um m�todo simples para mostrar uma tela de apresent��o
// no centro da tela durante a quantidade de tempo passada no construtor
  
    public void showSplash() {        
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        
        // Configura a posi��o e o tamanho da janela
        int width = 500;
        int height =230;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        // Constr�i o splash screen0
        JLabel label = new JLabel(new ImageIcon(Main.class.getResource("/imagens/LOGO.jpg")));
        content.add(label, BorderLayout.CENTER);
        content.setBorder(BorderFactory.createLineBorder(new Color(00, 0, 0), 5));        
        // Torna vis�vel
        setVisible(true);
        
        // Espera ate que os recursos estejam carregados
        try { Thread.sleep(duration); } catch (Exception e) {}        
        setVisible(false);  
    }
 
    public void showSplashAndExit() throws NoSuchAlgorithmException, UnsupportedEncodingException {        
        showSplash();
        this.dispose();
        Login.Init();
    }
 
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {   
        // Mostra uma imagem com o t�tulo da aplica��o, envia os milessimos SplashScreen
        Main splash = new Main(200);
        
        /**
         * Faz o setamento do look and feel
         */
        try {

        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        	
        	
        } 
        catch (Exception e) {
           // handle exception
        }
        //tela de splash
        splash.showSplashAndExit();        
    }
}
   