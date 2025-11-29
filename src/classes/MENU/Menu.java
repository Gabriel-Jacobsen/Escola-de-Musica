package classes.MENU;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Menu  extends JPanel {
	
	private Janela janela;
	
	protected BorderLayout border;
	
	public Menu(Janela janela) {
		this.janela = janela;
		
		border = new BorderLayout();
		
		setLayout(border);
	}
	
	public void trocarMenu(String nome) {
        janela.trocarMenu(nome);
    }
}
