package classes.MENU;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuLogin extends Menu{

	public MenuLogin(Janela janela) {
		super(janela);
		
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		JLabel lblLogin = new JLabel("Login:");
        JTextField txtLogin = new JTextField(20);
        JLabel lblSenha = new JLabel("Senha:");
        JTextField txtSenha = new JTextField(20);
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(e -> {
        	
		});
        
        // Ajusta tamanho dos TextField
        txtLogin.setMaximumSize(txtLogin.getPreferredSize());
        txtSenha.setMaximumSize(txtSenha.getPreferredSize());

        // Centralizar no painel
        lblLogin.setAlignmentX(CENTER_ALIGNMENT);
        txtLogin.setAlignmentX(CENTER_ALIGNMENT);
        lblSenha.setAlignmentX(CENTER_ALIGNMENT);
        txtSenha.setAlignmentX(CENTER_ALIGNMENT);
        btnEnviar.setAlignmentX(CENTER_ALIGNMENT);

        painel.add(Box.createVerticalGlue()); //deixa centralizado
        painel.add(lblLogin);
        painel.add(txtLogin);
        painel.add(Box.createVerticalStrut(15)); // espaçamento
        painel.add(lblSenha);
        painel.add(txtSenha);
        painel.add(Box.createVerticalStrut(30));
        painel.add(btnEnviar);
        painel.add(Box.createVerticalGlue());
        
        add(painel, border.CENTER);
	}


	
}
