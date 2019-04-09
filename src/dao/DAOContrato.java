package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dominio.Anuncio;
import dominio.Contrato;
import dominio.EntidadeDominio;
import dominio.Musico;

public class DAOContrato extends AbstractDAO {

	public DAOContrato() {
		super("contrato", "id");
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Contrato contrato = (Contrato) entidade;
		Musico musico = contrato.getMusico();
		Anuncio anuncio = contrato.getAnuncio();
		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO contrato (musico,anuncio,situacao,registro) VALUES (?,?,?,?)");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1, musico.getId());
			pst.setInt(2, anuncio.getId());
			pst.setString(3, contrato.getSituacao().toString());
			pst.setTimestamp(4, java.sql.Timestamp.valueOf(contrato.getRegistro()));

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idMusico = 0;
			if (rs.next())
				idMusico = rs.getInt(1);
			musico.setId(idMusico);

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
