package classes.DTO;

import java.sql.Date;

public class Professor extends Unico {

	private double salario;
	private Date dataContratacao;

	public Professor(String cpf, String nome, Date nasc, double salario) {
		super(cpf, nome, nasc);
		this.salario = salario;
		this.dataContratacao = new java.sql.Date(System.currentTimeMillis());
	}

	public Professor(String cpf, String nome, Date nasc, double salario, Date dataContrataco) {
		super(cpf, nome, nasc);
		this.salario = salario;
		this.dataContratacao = dataContrataco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

}
