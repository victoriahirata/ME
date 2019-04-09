package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dominio.Arquivo;
import dominio.EntidadeDominio;

public class DAOArquivo extends AbstractDAO {
	
	public DAOArquivo() {
		super("arquivo", "id_arquivo");		
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Arquivo arquivo = (Arquivo) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO arquivo (nome, tipo_arquivo, tamanho,registro) VALUES (?,?,?,?)");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, arquivo.getNome());
			pst.setString(2, arquivo.getTipoArquivo().toString());
			pst.setDouble(3, arquivo.getTamanho());
			pst.setTimestamp(4, java.sql.Timestamp.valueOf(arquivo.getRegistro()));
			pst.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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
