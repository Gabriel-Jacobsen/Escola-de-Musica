package classes.MENU;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.DTO.Unico;

public class MenuPrincipalAluno extends Menu {
	
	private CardLayout card;
	private JPanel subMenus; 
	
	private SubMenuAlterarCadastro alterarCadastro;
	private SubMenuOlharMatricula olhaMatricula;
	private SubMenuCriaMatricula criaMatricula;
	
	JLabel lblNome;
	JLabel lblEmail;
	JLabel lblTelefone;
	JPanel painel;

	public MenuPrincipalAluno(Janela janela) {
		super(janela);

		painel = new PanelImage("Images\\menuPrincipal.jpg");
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		lblNome = new JLabel("Nome: ");
		lblEmail = new JLabel("Email: ");
		lblTelefone = new JLabel("Telefone: ");
		
		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.addActionListener(e -> {
			trocarSubMenu("alterarCadastro");
		});
		JButton btnFazerMatricula = new JButton("Matricular-se");
		btnFazerMatricula.addActionListener(e -> {
			criaMatricula.mostrar();
			trocarSubMenu("criarMatricula");
		});
		JButton btnOlharMatriculas = new JButton("Matriculas Cadastradas");
		btnOlharMatriculas.addActionListener(e -> {
			olhaMatricula.mostrarAlunos();
			trocarSubMenu("olharMatricula");
		});

		btnAlterarCadastro.setMaximumSize(new Dimension(150, 40));
		btnFazerMatricula.setMaximumSize(new Dimension(150, 40));
		btnOlharMatriculas.setMaximumSize(new Dimension(150, 40));

		painel.add(lblNome);
		painel.add(Box.createVerticalStrut(10));
		painel.add(lblEmail);
		painel.add(Box.createVerticalStrut(10));
		painel.add(lblTelefone);
		painel.add(Box.createVerticalGlue());
		painel.add(btnAlterarCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnFazerMatricula);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnOlharMatriculas);
		painel.add(Box.createVerticalGlue());
		
		card = new CardLayout();
        subMenus = new JPanel(card);

		add(painel, BorderLayout.WEST);
		add(subMenus, BorderLayout.CENTER);
	}

	public void atualiza() {
		Unico unico = cadastroLogado.getUnico();
		lblNome.setText(lblNome.getText()+ unico.getNome()); 
		lblEmail.setText(lblEmail.getText()+ unico.getEmail()); 
		lblTelefone.setText(lblTelefone.getText()+ unico.getTelefone()); 
		
		criaMatricula = new SubMenuCriaMatricula(this, cadastroLogado);
		olhaMatricula = new SubMenuOlharMatricula(this, cadastroLogado);
		alterarCadastro = new SubMenuAlterarCadastro(this, cadastroLogado);
		subMenus.add(olhaMatricula, "olharMatricula");
		subMenus.add(alterarCadastro, "alterarCadastro");
		subMenus.add(criaMatricula, "criarMatricula");
	}
	
	public void trocarSubMenu(String nome) {
		card.show(subMenus,nome);
	}

	
}
