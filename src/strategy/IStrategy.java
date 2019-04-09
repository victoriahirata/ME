package strategy;

import dominio.EntidadeDominio;

public interface IStrategy {

	public abstract int processar(EntidadeDominio entidade);

}
