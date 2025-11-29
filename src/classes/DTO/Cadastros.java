package classes.DTO;

public class Cadastros {

	private String senha;
	private Unico unico;
	private int idTipo = 1;
	private String login;

	public Cadastros(Unico unico, String senha) {
		this.unico = unico;
		this.senha = senha;
		this.login = unico.getCpf();
	}

	public Cadastros(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Unico getUnico() {
		return unico;
	}

	public void setUnico(Unico unico) {
		this.unico = unico;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}



}
