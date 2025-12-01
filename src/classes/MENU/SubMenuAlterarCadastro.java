package classes.MENU;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.BO.CadastrosBO;
import classes.BO.UnicoBO;
import classes.DTO.Cadastros;

public class SubMenuAlterarCadastro extends SubMenu{

	JLabel lbl1 = new JLabel("Nome: ");
	JLabel lbl2 = new JLabel("Senha: ");
	JLabel lbl3 = new JLabel("Telefone: ");
	JLabel lbl4 = new JLabel("Email: ");
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JTextField txt4 = new JTextField();
	
	public SubMenuAlterarCadastro(Menu menu, Cadastros cadastro) {
		super(menu);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(e -> {
			UnicoBO unicoBO = new UnicoBO();
			CadastrosBO cadastrosBO = new CadastrosBO();
			
			cadastro.setSenha(txt2.getText());
			cadastro.getUnico().setNome(txt1.getText());
			cadastro.getUnico().setTelefone(txt3.getText());
			cadastro.getUnico().setEmail(txt4.getText());
			
			unicoBO.alterar(cadastro.getUnico());
			cadastrosBO.alterar(cadastro);
			JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Alterado", JOptionPane.INFORMATION_MESSAGE);
		});
		
		txt1.setMaximumSize(new Dimension(400, 40));
		txt2.setMaximumSize(new Dimension(400, 40));
		txt3.setMaximumSize(new Dimension(400, 40));
		txt4.setMaximumSize(new Dimension(400, 40));
		
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
		add(Box.createVerticalGlue());
		add(btnEnviar);
	}

}
