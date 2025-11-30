package classes.MENU;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import classes.BO.ProfessorBO;
import classes.BO.UnicoBO;
import classes.DTO.Professor;
import classes.DTO.Unico;

public class SubMenuGerenciadorAlterarCadastro extends SubMenu {
	
	private DefaultListModel<String> modelProf = new DefaultListModel<>();
	private DefaultListModel<String> modelAluno = new DefaultListModel<>();
	private JList<String> jListaProf = new JList<>(modelProf);
	
	List<Professor> listaProfessor = new ArrayList<>();
	
	JLabel lbl1 = new JLabel("Salario: ");
	JLabel lbl2 = new JLabel("Nome: ");
	JLabel lbl3 = new JLabel("Telefone: ");
	JLabel lbl4 = new JLabel("Email: ");
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JTextField txt4 = new JTextField();

	public SubMenuGerenciadorAlterarCadastro(Menu menu) {
		super(menu);
		
		setLayout(new BorderLayout());
		
		JPanel painelW = new JPanel();
		JPanel painelL = new JPanel();
		painelW.setLayout(new BoxLayout(painelW, BoxLayout.Y_AXIS));
		painelL.setLayout(new BoxLayout(painelL, BoxLayout.Y_AXIS));
		
		JButton btnEnviarAlunos = new JButton("Enviar Aluno");
		btnEnviarAlunos.addActionListener(e -> {

		});
		JButton btnEnviarProfessores = new JButton("Enviar Professor");
		btnEnviarProfessores.addActionListener(e -> {
			ProfessorBO profBO = new ProfessorBO();
			UnicoBO unicoBO = new UnicoBO();
			Professor prof = listaProfessor.get(jListaProf.getSelectedIndex());
			double d;
			try {
				d = Double.parseDouble(txt1.getText());
			}catch(Exception erro) {
				d = prof.getSalario();
			}
			prof.setSalario(d);
			prof.setNome(txt2.getText());
			prof.setTelefone(txt3.getText());
			prof.setEmail(txt4.getText());
			
			unicoBO.alterar(prof);
			profBO.alterar(prof);
			mostrarProfessores();
		});
		
		txt1.setMaximumSize(new Dimension(250, 40));
		txt2.setMaximumSize(new Dimension(250, 40));
		txt3.setMaximumSize(new Dimension(250, 40));
		txt4.setMaximumSize(new Dimension(250, 40));
		
		//jListaProf.setMaximumSize(new Dimension(250, 500));
		
		painelW.add(new JScrollPane(jListaProf));
		painelW.add(Box.createVerticalStrut(30));
		painelW.add(lbl1);
		painelW.add(txt1);
		painelW.add(Box.createVerticalStrut(30));
		painelW.add(lbl2);
		painelW.add(txt2);
		painelW.add(Box.createVerticalStrut(30));
		painelW.add(lbl3);
		painelW.add(txt3);
		painelW.add(Box.createVerticalStrut(30));
		painelW.add(lbl4);
		painelW.add(txt4);
		painelW.add(Box.createVerticalGlue());
		painelW.add(btnEnviarProfessores);
		painelW.add(Box.createVerticalGlue());
		
		add(painelW, BorderLayout.WEST);
		
	}

	
	public void mostrarProfessores() {
		modelProf.clear(); // limpa lista

		ProfessorBO professorBO = new ProfessorBO();
		listaProfessor = professorBO.pesquisarTodos();
		
		for (Professor p : listaProfessor) {
			modelProf.addElement(p.getNome() + " - " + p.getCpf() + " - R$" + p.getSalario());
		}
	}
}
