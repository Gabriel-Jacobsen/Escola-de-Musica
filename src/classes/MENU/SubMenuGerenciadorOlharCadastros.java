package classes.MENU;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import classes.BO.ProfessorBO;
import classes.DTO.Professor;

public class SubMenuGerenciadorOlharCadastros extends SubMenu {
	
	private DefaultListModel<String> model = new DefaultListModel<>(); //atualizar a lista dinamicamente.
	private JList<String> lista = new JList<>(model);
	
	List<Professor> listaProfessor = new ArrayList<>();

	public SubMenuGerenciadorOlharCadastros(Menu menu) {
		super(menu);
		
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
		
		JButton btnOlharAlunos = new JButton("Olhar Alunos");
		btnOlharAlunos.addActionListener(e -> {

		});
		JButton btnOlharProfessores = new JButton("Olhar Professores");
		btnOlharProfessores.addActionListener(e -> {
			ProfessorBO profBO = new ProfessorBO();
			listaProfessor = profBO.pesquisarTodos();
			mostrarProfessores();
		});
		JButton btnOlharMatriculas = new JButton("Olhar Matriculas");
		btnOlharMatriculas.addActionListener(e -> {

		});
		
		
		painel.add(btnOlharAlunos);
		painel.add(btnOlharProfessores);
		painel.add(btnOlharMatriculas);
		
		add(painel);
		add(new JScrollPane(lista));
	}
	
	private void mostrarProfessores() {
		model.clear(); // limpa lista

		for (Professor p : listaProfessor) {
			model.addElement(p.getNome() + " - " + p.getCpf() + " - " + p.getSalario());
		}
	}
}
