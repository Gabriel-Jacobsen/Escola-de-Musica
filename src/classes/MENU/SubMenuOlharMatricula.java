package classes.MENU;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import classes.BO.AulaBO;
import classes.BO.MatriculaBO;
import classes.BO.TipoInstrumentoBO;
import classes.DTO.Aluno;
import classes.DTO.Aula;
import classes.DTO.Cadastros;
import classes.DTO.Matricula;
import classes.DTO.Professor;
import classes.DTO.TipoInstrumento;

public class SubMenuOlharMatricula extends SubMenu {
	
	private Cadastros cadastroLogado;
	private DefaultListModel<String> model = new DefaultListModel<>(); //atualizar a lista dinamicamente.
	private JList<String> lista = new JList<>(model);
	
	List<Matricula> listaMatricula= new ArrayList<>();
	List<Aula> listaAula = new ArrayList<>();

	public SubMenuOlharMatricula(Menu menu, Cadastros cadastroLogado) {
		super(menu);
		
		this.cadastroLogado = cadastroLogado;
		
		JButton btnAulas = new JButton("Ver Aulas");
		btnAulas.addActionListener(e -> {
			mostrarAulas();
		});

		add(new JScrollPane(lista));
		add(btnAulas);
	}

	
	public void mostrarProfessores() {
		model.clear(); // limpa lista
		
		MatriculaBO matriculaBO = new MatriculaBO();
		listaMatricula = matriculaBO.procurarPorProfessor(cadastroLogado);
		
		TipoInstrumento tipo;
		TipoInstrumentoBO tipoBO = new TipoInstrumentoBO();
		
		for (Matricula p : listaMatricula) {
			tipo = new TipoInstrumento(p.getIdTipo());
			tipo = tipoBO.procurarPorCodigo(tipo);
			model.addElement(p.getAluno().getNome() + " - " + tipo.getNome() + " - " + p.getHorario());
		}
	}
	public void mostrarAlunos() {
		model.clear(); // limpa lista

		MatriculaBO matriculaBO = new MatriculaBO();
		listaMatricula = matriculaBO.procurarPorAluno(cadastroLogado);
		
		TipoInstrumento tipo;
		TipoInstrumentoBO tipoBO = new TipoInstrumentoBO();
		
		for (Matricula p : listaMatricula) {
			tipo = new TipoInstrumento(p.getIdTipo());
			tipo = tipoBO.procurarPorCodigo(tipo);
			model.addElement(p.getProfessor().getNome() + " - " + tipo.getNome() + " - " + p.getHorario());
		}
	}
	public void mostrarAulas() {
		AulaBO aulaBO = new AulaBO();
		listaAula = aulaBO.procurarPorCodigo(listaMatricula.get(lista.getSelectedIndex()));
		
		model.clear(); 
		
		TipoInstrumento tipo;
		TipoInstrumentoBO tipoBO = new TipoInstrumentoBO();
		
		for (Aula p : listaAula) {
			tipo = new TipoInstrumento(p.getIdTipo());
			tipo = tipoBO.procurarPorCodigo(tipo);
			model.addElement(tipo.getNome() + " - " + p.isAlunoPresente()+ " - " + p.getConteudo() + " - " + p.getData() + " - " + p.getSala());
		}
	}
}
