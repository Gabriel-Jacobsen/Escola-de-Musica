package classes.MENU;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.BO.ProfessorBO;
import classes.DTO.Cadastros;
import classes.DTO.Professor;
import classes.DTO.Unico;

public class MenuPrincipalProfessor extends Menu {
	
	Professor prof;
	
	private CardLayout card;
	private JPanel subMenus; 
	
	private SubMenuAlterarCadastro alterarCadastro;
	
	JLabel lblNome;
	JLabel lblEmail;
	JLabel lblTelefone;
	JLabel lblSalario;
	JPanel painel;

	public MenuPrincipalProfessor(Janela janela) {
		super(janela);

		painel = new PanelImage("Images\\menuPrincipal.jpg");
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		lblNome = new JLabel("Nome: ");
		lblEmail = new JLabel("Email: ");
		lblTelefone = new JLabel("Telefone: ");
		lblSalario = new JLabel("Salario: ");

		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.addActionListener(e -> {

		});
		JButton btnAulas = new JButton("Gerenciar Aulas");
		btnAulas.addActionListener(e -> {

		});
		JButton btnOlharMatriculas = new JButton("Matriculas Cadastradas");
		btnOlharMatriculas.addActionListener(e -> {

		});

		btnAlterarCadastro.setMaximumSize(new Dimension(150, 40));
		btnAulas.setMaximumSize(new Dimension(150, 40));
		btnOlharMatriculas.setMaximumSize(new Dimension(150, 40));

		painel.add(lblNome);
		painel.add(Box.createVerticalStrut(10));
		painel.add(lblEmail);
		painel.add(Box.createVerticalStrut(10));
		painel.add(lblTelefone);
		painel.add(Box.createVerticalStrut(10));
		painel.add(lblSalario);
		painel.add(Box.createVerticalGlue());
		painel.add(btnAlterarCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAulas);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnOlharMatriculas);
		painel.add(Box.createVerticalGlue());

		card = new CardLayout();
        subMenus = new JPanel(card);
        
		
		add(painel, BorderLayout.WEST);
		add(subMenus, BorderLayout.CENTER);
	}
	
	public void atualiza() {
		ProfessorBO profBO = new ProfessorBO();
		Unico unico = cadastroLogado.getUnico();
		prof = profBO.procurarPorCodigo(unico.getCpf());
		lblNome.setText(lblNome.getText()+ unico.getNome()); 
		lblEmail.setText(lblEmail.getText()+ unico.getEmail()); 
		lblTelefone.setText(lblTelefone.getText()+ unico.getTelefone()); 
		lblSalario.setText(lblSalario.getText() + prof.getSalario());
		
		alterarCadastro = new SubMenuAlterarCadastro(this, cadastroLogado);
		subMenus.add(alterarCadastro, "alterarCadastro");
	}
	
	public void trocarSubMenu(String nome) {
		card.show(subMenus,nome);
	}

}
