package classes.MENU;

import java.awt.Dimension;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.BO.AlunoBO;
import classes.BO.AulaBO;
import classes.BO.CadastrosBO;
import classes.BO.MatriculaBO;
import classes.BO.TipoInstrumentoBO;
import classes.BO.UnicoBO;
import classes.DTO.Aluno;
import classes.DTO.Aula;
import classes.DTO.Cadastros;
import classes.DTO.Matricula;
import classes.DTO.TipoInstrumento;

public class SubMenuProfessorCriaAula extends SubMenu {
	
	private Cadastros cadastro;
	
	JComboBox<String> cbbLista = new JComboBox<>();
	
	List<Matricula> listaMatricula= new ArrayList<>();
	
	JLabel lbl1 = new JLabel("Aluno Presente: ");
	JLabel lbl2 = new JLabel("Sala: ");
	JLabel lbl3 = new JLabel("Conteudo: ");
	JCheckBox ckBox = new JCheckBox();
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();

	public SubMenuProfessorCriaAula(Menu menu, Cadastros cadastroLogado) {
		super(menu);
		cadastro = cadastroLogado;
		
		cbbLista.setMaximumSize((new Dimension(450, 40)));
		txt1.setMaximumSize(new Dimension(500, 40));
		txt2.setMaximumSize(new Dimension(500, 40));
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(e -> {
			try {
				AulaBO aulaBO = new AulaBO();
				LocalDate localDate = LocalDate.now();
		        Date sqlDate = Date.valueOf(localDate);
				Aula aula = new Aula(listaMatricula.get(cbbLista.getSelectedIndex()).getAluno(), listaMatricula.get(cbbLista.getSelectedIndex()).getProfessor(),
						listaMatricula.get(cbbLista.getSelectedIndex()).getIdTipo(), listaMatricula.get(cbbLista.getSelectedIndex()).getHorario(), sqlDate);
				aula.setAlunoPresente(ckBox.isSelected());
				if (! ( txt1.getText() == null) &&! txt1.getText().isEmpty()) {
				aula.setSala(Integer.parseInt(txt1.getText()));}
				aulaBO.inserir(aula);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso", "Inserido", JOptionPane.INFORMATION_MESSAGE);
			}catch (Exception erro){
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		add(Box.createVerticalGlue());
		add(cbbLista);
		add(Box.createVerticalStrut(30));
		add(lbl1);
		add(ckBox);
		add(Box.createVerticalStrut(30));
		add(lbl2);
		add(txt1);
		add(Box.createVerticalStrut(30));
		add(lbl3);
		add(txt2);
		add(Box.createVerticalGlue());
		add(btnEnviar);
		
	}

	public void mostrar() {
		cbbLista.removeAllItems();
		
		MatriculaBO matriculaBO = new MatriculaBO();
		listaMatricula = matriculaBO.procurarPorProfessor(cadastro);
		
		TipoInstrumento tipo;
		TipoInstrumentoBO tipoBO = new TipoInstrumentoBO();

		for (Matricula p : listaMatricula) {
			tipo = new TipoInstrumento(p.getIdTipo());
			tipo = tipoBO.procurarPorCodigo(tipo);
			cbbLista.addItem(p.getAluno().getNome() + " - " + tipo.getNome());
		}
		
	}
}
