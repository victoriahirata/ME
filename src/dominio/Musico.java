package dominio;

import java.util.List;

public class Musico extends PessoaFisica {

	private double tempoExperiencia;

	private List<TipoMusico> tipoMusico;

	private List<EstiloMusical> estiloMusical;

	public double getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(double tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}

	public List<TipoMusico> getTipoMusico() {
		return tipoMusico;
	}

	public void setTipoMusico(List<TipoMusico> tipoMusico) {
		this.tipoMusico = tipoMusico;
	}

	public List<EstiloMusical> getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(List<EstiloMusical> estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

}
