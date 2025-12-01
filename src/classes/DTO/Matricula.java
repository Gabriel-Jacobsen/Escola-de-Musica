package classes.DTO;

import java.sql.Date;

public class Matricula {

	private Aluno aluno;
	private Professor professor;
	private int idTipo, SalaPreferencial;
	private Date Horario, HorarioFim;
	
	
    public Matricula(Aluno aluno, Professor professor, int idTipo, Date horario) {
        this.aluno = aluno; 
        this.professor = professor;
        this.idTipo = idTipo;
        this.Horario = horario;
    } 
    
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getSalaPreferencial() {
		return SalaPreferencial;
	}
	public void setSalaPreferencial(int salaPreferencial) {
		SalaPreferencial = salaPreferencial;
	}
	public Date getHorario() {
		return Horario;
	}
	public void setHorario(Date horario) {
		Horario = horario;
	}
	public Date getHorarioFim() {
		return HorarioFim;
	}
	public void setHorarioFim(Date horarioFim) {
		HorarioFim = horarioFim;
	}	
	
	
	
	//CRIAR MÉTODO GERAR MENSALIDADE
}	