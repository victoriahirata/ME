package dominio;

import java.util.Date;

public class Boleto extends FormaPagamento {

	private Date dataVencimento;

	private Date dataEmissao;

	public void gerarBoleto() {

	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

}
