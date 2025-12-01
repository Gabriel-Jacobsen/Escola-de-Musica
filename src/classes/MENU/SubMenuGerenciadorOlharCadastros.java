package classes.MENU;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import classes.BO.AlunoBO;
import classes.BO.MatriculaBO;
import classes.BO.ProfessorBO;
import classes.BO.TipoInstrumentoBO;
import classes.DTO.Aluno;
import classes.DTO.Matricula;
import classes.DTO.Professor;
import classes.DTO.TipoInstrumento;

public class SubMenuGerenciadorOlharCadastros extends SubMenu {
	
	private DefaultListModel<String> model = new DefaultListModel<>(); //atualizar a lista dinamicamente.
	private JList<String> lista = new JList<>(model);
	
	List<Professor> listaProfessor = new ArrayList<>();
	List<Aluno> listaAluno= new ArrayList<>();
	List<Matricula> listaMatricula= new ArrayList<>();

	public SubMenuGerenciadorOlharCadastros(Menu menu) {
		super(menu);
		
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
		
		JButton btnOlharAlunos = new JButton("Olhar Alunos");
		btnOlharAlunos.addActionListener(e -> {
			AlunoBO alunosBO = new AlunoBO();
			listaAluno = alunosBO.pesquisarTodos();
			mostrarAlunos();
			});
		JButton btnOlharProfessores = new JButton("Olhar Professores");
		btnOlharProfessores.addActionListener(e -> {
			ProfessorBO profBO = new ProfessorBO();
			listaProfessor = profBO.pesquisarTodos();
			mostrarProfessores();
		});
		JButton btnOlharMatriculas = new JButton("Olhar Matriculas");
		btnOlharMatriculas.addActionListener(e -> {
			MatriculaBO matriculaBO = new MatriculaBO();
			listaMatricula = matriculaBO.pesquisarTodos();
			mostrarMatricula();
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
			model.addElement(p.getNome() + " - " + p.getCpf() + " - R$" + p.getSalario());
		}
	}
	private void mostrarAlunos() {
		model.clear(); // limpa lista

		for (Aluno p : listaAluno) {
			model.addElement(p.getNome() + " - " + p.getCpf());
		}
	}
	private void mostrarMatricula() {
		model.clear(); // limpa lista
		
		TipoInstrumento tipo;
		TipoInstrumentoBO tipoBO = new TipoInstrumentoBO();
		
		for (Matricula p : listaMatricula) {
			tipo = new TipoInstrumento(p.getIdTipo());
			tipo = tipoBO.procurarPorCodigo(tipo);
			model.addElement(p.getAluno().getCpf() + " - " + p.getProfessor().getCpf() + " - " + tipo.getNome());
		}
	}
}
