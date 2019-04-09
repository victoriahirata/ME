package dao;

import java.util.List;

import dominio.EntidadeDominio;

public class DAORanking extends AbstractDAO {

	public DAORanking() {
		super("ranking", "id_ranking");
	}

	public void salvar(EntidadeDominio entidade) {
		
	}

	public void alterar(EntidadeDominio entidade) {

	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}
}
