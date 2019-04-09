package dao;

import java.sql.Connection;
import java.util.List;

import dominio.EntidadeDominio;

public  class DAOBoleto extends AbstractDAO {

	public DAOBoleto(Connection connection, String table, String idTable) {
		super(connection, table, idTable);
		// TODO Auto-generated constructor stub
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
