package classes.MENU;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPrincipalGerenciador extends Menu {

	public MenuPrincipalGerenciador(Janela janela) {
		super(janela);
			
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.addActionListener(e -> {
        	
		});
		JButton btnExcluirCadastro = new JButton("Excluir cadastro");
		btnExcluirCadastro.addActionListener(e -> {
        	
		});
		JButton btnOlharMatriculas = new JButton("Matriculas Existentes");
		btnOlharMatriculas.addActionListener(e -> {
        	
		});
		JButton btnAdicionarCadastro = new JButton("Realizar Cadastro");
		btnAdicionarCadastro.addActionListener(e -> {
        	
		});
		JButton btnVisualizarCadastros = new JButton("Visualizar Cadastros");
		btnVisualizarCadastros.addActionListener(e -> {
        	
		});
		
		btnAlterarCadastro.setMaximumSize(new Dimension(150, 40));
		btnExcluirCadastro.setMaximumSize(new Dimension(150, 40));
		btnOlharMatriculas.setMaximumSize(new Dimension(150, 40));
		btnAdicionarCadastro.setMaximumSize(new Dimension(150, 40));
		btnVisualizarCadastros.setMaximumSize(new Dimension(150, 40));
		
		painel.add(Box.createVerticalGlue());
		painel.add(btnVisualizarCadastros);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAlterarCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnExcluirCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAdicionarCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnOlharMatriculas);
		painel.add(Box.createVerticalGlue());
		
		add(painel, border.WEST);
	}

}
