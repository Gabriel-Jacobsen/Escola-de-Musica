package classes.DTO;

public class TipoInstrumento {

	private static int idMax = 1;
	private int idTipo;
	private String nome, descricao;

	public TipoInstrumento(String nome) {
		this.idTipo = idMax;
		idMax++;
		this.nome = nome;
	}

	public TipoInstrumento(String nome, int id) {
		this.idTipo = id;
		this.nome = nome;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
