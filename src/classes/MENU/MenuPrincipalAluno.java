package classes.MENU;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPrincipalAluno extends Menu {

	public MenuPrincipalAluno(Janela janela) {
		super(janela);
		
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.addActionListener(e -> {
        	
		});
		JButton btnFazerMatricula = new JButton("Matricular-se");
		btnFazerMatricula.addActionListener(e -> {
        	
		});
		JButton btnOlharMatriculas = new JButton("Matriculas Cadastradas");
		btnOlharMatriculas.addActionListener(e -> {
        	
		});
		
		btnAlterarCadastro.setMaximumSize(new Dimension(150, 40));
		btnFazerMatricula.setMaximumSize(new Dimension(150, 40));
		btnOlharMatriculas.setMaximumSize(new Dimension(150, 40));
		
		
		painel.add(Box.createVerticalGlue());
		painel.add(btnAlterarCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnFazerMatricula);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnOlharMatriculas);
		painel.add(Box.createVerticalGlue());
		
		add(painel, border.WEST);
	}

}
