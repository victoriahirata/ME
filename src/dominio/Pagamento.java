package dominio;

public class Pagamento extends EntidadeDominio {

	private double valor;

	private FormaPagamento formaPagamento;

	public void confirmarPagameno() {

	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
