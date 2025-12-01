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

public class MenuPrincipalGerenciador extends Menu {

	 private CardLayout card;
	 private JPanel subMenus; 
	 private SubMenuGerenciadorOlharCadastros olhar =  new SubMenuGerenciadorOlharCadastros(this);
	 private SubMenuGerenciadorAdicionarProfessores adicionarProf = new SubMenuGerenciadorAdicionarProfessores(this);
	 private SubMenuGerenciadorAdicionarTipoInstrumento adicionarInstrumento = new SubMenuGerenciadorAdicionarTipoInstrumento(this);
	 private SubMenuGerenciadorExcluir excluirCadastro = new SubMenuGerenciadorExcluir(this);
	 private SubMenuGerenciadorAdicionarEspecialidade adicionarEspecialidade = new SubMenuGerenciadorAdicionarEspecialidade(this);
	 private SubMenuGerenciadorAlterarCadastro alteraCadastro = new SubMenuGerenciadorAlterarCadastro(this);
	 private SubMenuGerenciadorAdicionarAluno adicionarAluno = new SubMenuGerenciadorAdicionarAluno(this);
	
	JLabel lblNome;
	JLabel lblEmail;
	JLabel lblTelefone;
	JPanel painel;
	
	public MenuPrincipalGerenciador(Janela janela) {
		super(janela);

		painel = new PanelImage("Images\\menuPrincipal.jpg");
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		lblNome = new JLabel("Nome: ");
		lblEmail = new JLabel("Email: ");
		lblTelefone = new JLabel("Telefone: ");

		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.addActionListener(e -> {
			alteraCadastro.mostrarProfessores();
			trocarSubMenu("alteraCadastro");
		});
		JButton btnExcluirCadastro = new JButton("Excluir cadastro");
		btnExcluirCadastro.addActionListener(e -> {
			excluirCadastro.mostrar();
			trocarSubMenu("ExcluirCadastro");
		});
		JButton btnAdicionarAlunos = new JButton("Aluno");
		btnAdicionarAlunos.addActionListener(e -> {
			trocarSubMenu("adicionarAluno");
		});
		JButton btnAdicionarProfessores = new JButton("Professor");
		btnAdicionarProfessores.addActionListener(e -> {
			trocarSubMenu("adicionarProf");
		});
		JButton btnAdiconarEspecialidade = new JButton("Especialidade");
		btnAdiconarEspecialidade.addActionListener(e -> {
			adicionarEspecialidade.mostrar();
			trocarSubMenu("adicionarEsp");
		});
		JButton btnAdiconarTipoInstrumento = new JButton("Tipo Instrumento");
		btnAdiconarTipoInstrumento.addActionListener(e -> {
			trocarSubMenu("adicionarTipo");
		});
		JButton btnVisualizarCadastros = new JButton("Visualizar Cadastros");
		btnVisualizarCadastros.addActionListener(e -> {
			trocarSubMenu("olhar");
		});

		btnAlterarCadastro.setMaximumSize(new Dimension(150, 40));
		btnExcluirCadastro.setMaximumSize(new Dimension(150, 40));
		btnAdicionarAlunos.setMaximumSize(new Dimension(150, 40));
		btnAdicionarProfessores.setMaximumSize(new Dimension(150, 40));
		btnAdiconarEspecialidade.setMaximumSize(new Dimension(150, 40));
		btnAdiconarTipoInstrumento.setMaximumSize(new Dimension(150, 40));
		btnVisualizarCadastros.setMaximumSize(new Dimension(150, 40));

		painel.add(lblNome);
		painel.add(Box.createVerticalStrut(10));
		painel.add(lblEmail);
		painel.add(Box.createVerticalStrut(10));
		painel.add(lblTelefone);
		painel.add(Box.createVerticalGlue());
		painel.add(btnVisualizarCadastros);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAlterarCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnExcluirCadastro);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAdicionarAlunos);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAdicionarProfessores);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAdiconarEspecialidade);
		painel.add(Box.createVerticalStrut(30));
		painel.add(btnAdiconarTipoInstrumento);
		painel.add(Box.createVerticalGlue());

		card = new CardLayout();
        subMenus = new JPanel(card);
        
        subMenus.add(olhar, "olhar");
        subMenus.add(adicionarProf, "adicionarProf");
        subMenus.add(excluirCadastro, "ExcluirCadastro");
        subMenus.add(adicionarInstrumento, "adicionarTipo");
        subMenus.add(adicionarEspecialidade, "adicionarEsp");
        subMenus.add(alteraCadastro, "alteraCadastro");
        subMenus.add(adicionarAluno, "adicionarAluno");
		
		add(painel, border.WEST);
		add(subMenus, border.CENTER);
	}
	
	public void atualiza() {
		Unico unico = cadastroLogado.getUnico();
		lblNome.setText(lblNome.getText()+ unico.getNome()); 
		lblEmail.setText(lblEmail.getText()+ unico.getEmail()); 
		lblTelefone.setText(lblTelefone.getText()+ unico.getTelefone()); 
	}
	
	public void trocarSubMenu(String nome) {
		card.show(subMenus,nome);
	}
}
