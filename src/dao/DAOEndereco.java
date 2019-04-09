package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import dominio.Cidade;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Estado;

public class DAOEndereco extends AbstractDAO {

	public DAOEndereco() {
		super("endereco", "id");
	}

	public void salvar(EntidadeDominio entidade) {
		if (connection == null) {
			openConnection();
		}

		PreparedStatement pst = null;
		Endereco endereco = (Endereco) entidade;
		Cidade cidade = endereco.getCidade();
		Estado estado = cidade.getEstado();

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO endereco(cidade,estado,registro VALUES (?,?,?)");

		try {
			connection.setAutoCommit(false);

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, cidade.getId());
			pst.setInt(2, estado.getId());
			pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd = 0;
			if (rs.next())
				idEnd = rs.getInt(1);
			endereco.setId(idEnd);

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (ctrlTransaction) {
				try {
					pst.close();
					if (ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
