package classes.MENU;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Janela extends JFrame {

    private CardLayout card; //troca os menus
    private JPanel panelPrincipal; //conteiner com os menus
    
    public MenuLogin menuLogin = new MenuLogin(this);
    public MenuPrincipalAluno menuPrincipalAluno = new MenuPrincipalAluno(this);
    public MenuPrincipalProfessor menuPrincipalProfessor = new MenuPrincipalProfessor(this);
    public MenuPrincipalGerenciador menuPrincipalGerenciador = new MenuPrincipalGerenciador(this);

	public Janela(){

		setTitle("Escola de Musica");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);
		setResizable(false);
		setLocationRelativeTo(null);

		card = new CardLayout();
        panelPrincipal = new JPanel(card);

        panelPrincipal.add(menuLogin, "menuLogin");
        panelPrincipal.add(menuPrincipalAluno, "menuPrincipalAluno");
        panelPrincipal.add(menuPrincipalProfessor, "menuPrincipalProfessor");
        panelPrincipal.add(menuPrincipalGerenciador, "menuPrincipalGerenciador");

        add(panelPrincipal);

        setVisible(true);
	}

	public void trocarMenu(String menu) {
		card.show(panelPrincipal, menu);
	}
	
	
}
