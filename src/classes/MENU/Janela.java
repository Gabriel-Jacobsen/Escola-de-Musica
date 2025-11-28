package classes.MENU;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {
	
    private CardLayout card; //troca os menus
    private JPanel panelPrincipal; //conteiner com os menus

	public Janela(){
		
		setTitle("Escola de Musica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		card = new CardLayout();
        panelPrincipal = new JPanel(card);
        
        panelPrincipal.add(new MenuLogin(this), "menuLogin");
        
        add(panelPrincipal);
		
        setVisible(true);
	}
	
	public void trocarMenu(String menu) {
		card.show(panelPrincipal, menu);
	}
}
