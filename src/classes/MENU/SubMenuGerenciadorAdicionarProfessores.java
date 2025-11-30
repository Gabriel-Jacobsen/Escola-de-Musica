package classes.MENU;

import java.awt.Dimension;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.BO.CadastrosBO;
import classes.BO.ProfessorBO;
import classes.BO.UnicoBO;
import classes.DTO.Cadastros;
import classes.DTO.Professor;

public class SubMenuGerenciadorAdicionarProfessores extends SubMenu {
	
	JLabel lbl1 = new JLabel("CPF: ");
	JLabel lbl2 = new JLabel("Nome: ");
	JLabel lbl3 = new JLabel("Nascimento ");
	JLabel lbl4 = new JLabel("Salario: ");
	JLabel lbl5 = new JLabel("Data de Contratação: ");
	JLabel lbl6 = new JLabel("Telefone: ");
	JLabel lbl7 = new JLabel("Email: ");
	
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JTextField txt4 = new JTextField();
	JTextField txt5 = new JTextField();
	JTextField txt6 = new JTextField();
	JTextField txt7 = new JTextField();

	public SubMenuGerenciadorAdicionarProfessores(Menu menu) {
		super(menu);
		
//		JPanel painel = new JPanel();
//		painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(e -> {
			try {
				double d = Double.parseDouble(txt4.getText());
				Professor prof = new Professor(txt1.getText(),txt2.getText(),Date.valueOf(txt3.getText()),d,Date.valueOf(txt5.getText()));
				prof.setTelefone(txt6.getText());
				prof.setEmail(txt7.getText());
				Cadastros cadastro =new Cadastros(prof.getCpf(),"1234");
				cadastro.setIdTipo(2);
				ProfessorBO profBO = new ProfessorBO();
				UnicoBO unicoBO = new UnicoBO();
				CadastrosBO cadastroBO = new CadastrosBO();
			
				unicoBO.inserir(prof);
				profBO.inserir(prof);
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
		txt6.setMaximumSize(new Dimension(500, 40));
		txt7.setMaximumSize(new Dimension(500, 40));
		

//		add(painel);
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
		add(lbl6);
		add(txt6);
		add(Box.createVerticalStrut(30));
		add(lbl7);
		add(txt7);
		add(Box.createVerticalStrut(30));
		add(Box.createVerticalGlue());
		add(btnEnviar);
	}
}
