package classes.MENU;

import java.awt.Dimension;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.BO.AlunoBO;
import classes.BO.CadastrosBO;
import classes.BO.ProfessorBO;
import classes.BO.UnicoBO;
import classes.DTO.Aluno;
import classes.DTO.Cadastros;
import classes.DTO.Professor;

public class SubMenuGerenciadorAdicionarAluno extends SubMenu {
	
	JLabel lbl1 = new JLabel("CPF: ");
	JLabel lbl2 = new JLabel("Nome: ");
	JLabel lbl3 = new JLabel("Nascimento ");
	JLabel lbl4 = new JLabel("Telefone: ");
	JLabel lbl5 = new JLabel("Email: ");

	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JTextField txt4 = new JTextField();
	JTextField txt5 = new JTextField();
	
	public SubMenuGerenciadorAdicionarAluno(Menu menu) {
		super(menu);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(e -> {
			try {
				Aluno aluno = new Aluno(txt1.getText(),txt2.getText(),Date.valueOf(txt3.getText()));
				Cadastros cadastro = new Cadastros(aluno.getCpf(),"1234");
				cadastro.setIdTipo(3);
				AlunoBO alunoBO = new AlunoBO();
				UnicoBO unicoBO = new UnicoBO();
				CadastrosBO cadastroBO = new CadastrosBO();
			
				unicoBO.inserir(aluno);
				alunoBO.inserir(aluno);
				cadastroBO.inserir(cadastro);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso", "Inserido", JOptionPane.INFORMATION_MESSAGE);
			}catch (Exception erro){
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		txt1.setMaximumSize(new Dimension(500, 40));
		txt2.setMaximumSize(new Dimension(500, 40));
		txt3.setMaximumSize(new Dimension(500, 40));
		txt4.setMaximumSize(new Dimension(500, 40));
		txt5.setMaximumSize(new Dimension(500, 40));
		

		add(Box.createVerticalGlue());
		add(lbl1);
		add(txt1);
		add(Box.createVerticalStrut(30));
		add(lbl2);
		add(txt2);
		add(Box.createVerticalStrut(30));
		add(lbl3);
		add(txt3);
		add(Box.createVerticalStrut(30));
		add(lbl4);
		add(txt4);
		add(Box.createVerticalStrut(30));
		add(lbl5);
		add(txt5);
		add(Box.createVerticalStrut(30));
		add(Box.createVerticalGlue());
		add(btnEnviar);
	
	
	}
	
}
