package classes.DTO;

import java.sql.Date;

public class Unico {

	private String cpf, nome, telefone, email;
	private Date nasc;

	public Unico(String cpf, String nome, Date nasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.nasc = nasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (! nome.trim().isEmpty()) {
		this.nome = nome;}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (! telefone.trim().isEmpty()) {
		this.telefone = telefone;}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (! email.trim().isEmpty()) {
		this.email = email;}
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

}
