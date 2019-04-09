package fachada;

import dominio.EntidadeDominio;
import util.Resultado;

public interface IFachada {

	public abstract Resultado salvar(EntidadeDominio entidade);

	public abstract Resultado alterar(EntidadeDominio entidade);

	public abstract Resultado consultar(EntidadeDominio entidade);

	public abstract Resultado excluir(EntidadeDominio entidade);

}
