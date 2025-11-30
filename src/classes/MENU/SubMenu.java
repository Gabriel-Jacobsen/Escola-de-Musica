package classes.MENU;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SubMenu extends JPanel {

	private Menu menu;
	
	public SubMenu(Menu menu) {
		this.menu = menu;
			
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void trocarSubMenu(String nome) {
		menu.trocarSubMenu(nome);
	}
}
