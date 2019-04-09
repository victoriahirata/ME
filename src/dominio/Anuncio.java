package dominio;

public class Anuncio extends EntidadeDominio{

	private String data;

	private String horaInicio;

	private String horaFim;
	
	private String titulo;
	
	private Double valor;
	
	private TipoEvento tipoEvento;

	private Endereco endereco;
	
	private EstiloMusical estiloMusical;
	
	private TipoMusico tipoMusico;
	
	private Contratante contratante;
	
	private Situacao situacao;
	
	private TipoAmbiente tipoAmbiente;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EstiloMusical getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(EstiloMusical estiloMusical) {
		this.estiloMusical = estiloMusical;
	}
	
	public TipoAmbiente getTipoAmbiente() {
		return tipoAmbiente;
	}

	public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public TipoMusico getTipoMusico() {
		return tipoMusico;
	}

	public void setTipoMusico(TipoMusico tipoMusico) {
		this.tipoMusico = tipoMusico;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
}
