package classes.MENU;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import classes.DTO.Cadastros;

public class Menu  extends JPanel {

	private Janela janela;
	
	protected static Cadastros cadastroLogado;
	
	protected BorderLayout border;

	public Menu(Janela janela) {
		this.janela = janela;

		border = new BorderLayout();

		setLayout(border);
	}

	public void trocarMenu(String nome) {
        janela.trocarMenu(nome);
    }
	public void trocarSubMenu(String nome) {
		
	}
	
	public void atualiza() {
		
	}
}
