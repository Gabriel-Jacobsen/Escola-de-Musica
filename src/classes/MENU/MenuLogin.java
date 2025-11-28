package classes.MENU;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuLogin extends Menu{

	public MenuLogin(Janela janela) {
		super(janela);
		
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

        add(Box.createVerticalGlue()); //deixa centralizado
        add(lblLogin);
        add(txtLogin);
        add(Box.createVerticalStrut(15)); // espaçamento
        add(lblSenha);
        add(txtSenha);
        add(Box.createVerticalStrut(30));
        add(btnEnviar);
        add(Box.createVerticalGlue());
	}


	
}
