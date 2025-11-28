package classes.MENU;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Menu  extends JPanel {
	
	private Janela janela;
	
	public Menu(Janela janela) {
		this.janela = janela;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void trocarMenu(String nome) {
        janela.trocarMenu(nome);
    }
}
