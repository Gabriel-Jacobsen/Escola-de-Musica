package classes.DTO;

import java.sql.Date;

public class Aula extends Matricula{
	
	private Date data;
	private boolean alunoPresente;
	private int sala;
	private String conteudo;
	

	public Aula(Aluno aluno, Professor professor, int idTipo, Date horario, Date data) {
		super(aluno, professor, idTipo, horario);
			this.data = data;
		
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public boolean isAlunoPresente() {
		return alunoPresente;
	}


	public void setAlunoPresente(boolean alunoPresente) {
		this.alunoPresente = alunoPresente;
	}


	public int getSala() {
		return sala;
	}


	public void setSala(int sala) {
		this.sala = sala;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	
	
}
