package classes.MENU;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.DTO.Unico;

public class MenuPrincipalAluno extends Menu {
	
	JLabel lblNome;
	JLabel lblEmail;
	JLabel lblTelefone;
	JPanel painel;

	public MenuPrincipalAluno(Janela janela) {
		super(janela);

		painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		
		lblNome = new JLabel("Nome: ");
		lblEmail = new JLabel("Email: ");
		lblTelefone = new JLabel("Telefone: ");
		
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

		add(painel, BorderLayout.WEST);
	}

	public void atualiza() {
		Unico unico = cadastroLogado.getUnico();
		lblNome.setText(lblNome.getText()+ unico.getNome()); 
		lblEmail.setText(lblEmail.getText()+ unico.getEmail()); 
		lblTelefone.setText(lblTelefone.getText()+ unico.getTelefone()); 
	}
	
}
