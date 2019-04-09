package util;

import java.util.List;

import dominio.EntidadeDominio;

public class Resultado {
	private String mensagem;
	private List<EntidadeDominio> entidades;
	/**
	 * M�todo de recupera��o do campo mensagem
	 *
	 * @return valor do campo mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}
	/**
	 * Valor de mensagem atribu�do a mensagem
	 *
	 * @param mensagem Atributo da Classe
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	/**
	 * M�todo de recupera��o do campo entidades
	 *
	 * @return valor do campo entidades
	 */
	public List<EntidadeDominio> getEntidades() {
		return entidades;
	}
	/**
	 * Valor de entidades atribu�do a entidades
	 *
	 * @param entidades Atributo da Classe
	 */
	public void setEntidades(List<EntidadeDominio> entidades) {
		this.entidades = entidades;
	}
	
}
