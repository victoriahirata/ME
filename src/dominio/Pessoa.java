package dominio;

import java.util.List;

public class Pessoa extends EntidadeDominio {

	private String nome;

	private String telefone;

	private Usuario usuario;

	private Endereco endereco;

	private List<Contrato> contratos;

	private List<Arquivo> arquivos;

	private Ranking ranking;

	private Cartao cartao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Contrato> getContrato() {
		return contratos;
	}

	public void setContrato(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public List<Arquivo> getArquivo() {
		return arquivos;
	}

	public void setArquivo(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
