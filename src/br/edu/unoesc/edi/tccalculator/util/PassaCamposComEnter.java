package br.edu.unoesc.edi.tccalculator.util;

import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import javax.swing.JPanel;
public class PassaCamposComEnter {
   @SuppressWarnings("unchecked")
public void passaCamposComEnter(JPanel painel){
        // Colocando enter para pular de campo
        @SuppressWarnings("rawtypes")
		HashSet conj = new HashSet(painel.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        painel.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }
}
