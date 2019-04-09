package util;

import java.util.List;

import dominio.EntidadeDominio;

public class Resultado {
	private String mensagem;
	private List<EntidadeDominio> entidades;
	/**
	 * Método de recuperação do campo mensagem
	 *
	 * @return valor do campo mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}
	/**
	 * Valor de mensagem atribuído a mensagem
	 *
	 * @param mensagem Atributo da Classe
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	/**
	 * Método de recuperação do campo entidades
	 *
	 * @return valor do campo entidades
	 */
	public List<EntidadeDominio> getEntidades() {
		return entidades;
	}
	/**
	 * Valor de entidades atribuído a entidades
	 *
	 * @param entidades Atributo da Classe
	 */
	public void setEntidades(List<EntidadeDominio> entidades) {
		this.entidades = entidades;
	}
	
}
