package classes.DTO;

public class Especialidade {

	private Professor prof;
	private TipoInstrumento instrumento;
	
	public Especialidade(Professor prof, TipoInstrumento instrumento) {
		this.prof = prof;
		this.instrumento = instrumento;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public TipoInstrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(TipoInstrumento instrumento) {
		this.instrumento = instrumento;
	}
	
}
