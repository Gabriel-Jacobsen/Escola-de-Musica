package classes.MENU;

import java.awt.Dimension;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.BO.CadastrosBO;
import classes.BO.ProfessorBO;
import classes.BO.TipoInstrumentoBO;
import classes.BO.UnicoBO;
import classes.DTO.Cadastros;
import classes.DTO.Professor;
import classes.DTO.TipoInstrumento;

public class SubMenuGerenciadorAdicionarTipoInstrumento extends SubMenu {
	
	JLabel lbl1 = new JLabel("Nome: ");
	JLabel lbl2 = new JLabel("Descrição: ");
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	
	public SubMenuGerenciadorAdicionarTipoInstrumento(Menu menu) {
		super(menu);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(e -> {
			try {
				TipoInstrumento instrumento = new TipoInstrumento(txt1.getText());
				instrumento.setDescricao(txt2.getText());
				TipoInstrumentoBO instrumentoBO = new TipoInstrumentoBO();		
				instrumentoBO.inserir(instrumento);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso", "Inserido", JOptionPane.INFORMATION_MESSAGE);
			}catch (Exception erro){
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		txt1.setMaximumSize(new Dimension(500, 40));
		txt2.setMaximumSize(new Dimension(500, 40));
		
		add(Box.createVerticalGlue());
		add(lbl1);
		add(txt1);
		add(Box.createVerticalStrut(30));
		add(lbl2);
		add(txt2);
		add(Box.createVerticalGlue());
		add(btnEnviar);
	}

}
