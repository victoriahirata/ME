package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dominio.Anuncio;
import dominio.Contratante;
import dominio.Endereco;
import dominio.EntidadeDominio;

public class DAOAnuncio extends AbstractDAO{

	public DAOAnuncio() {
		super("anuncio", "id");
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		if (connection == null) {
			openConnection();
		}

		PreparedStatement pst = null;
		Anuncio anuncio = (Anuncio) entidade;
		Endereco endereco = anuncio.getEndereco();
		Contratante contratante = anuncio.getContratante();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO endereco(data,hora_inicio,hora_fim,titulo,valor,tipo_evento,endereco,estilo_musical,tipo_musico,contratante,situacao,tipo_ambiente,registro");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		try {
			connection.setAutoCommit(false);

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, anuncio.getData());
			pst.setString(2, anuncio.getHoraInicio());
			pst.setString(3, anuncio.getHoraFim());
			pst.setString(4, anuncio.getTitulo());
			pst.setDouble(5, anuncio.getValor());
			pst.setString(6, anuncio.getTipoEvento().toString());
			pst.setInt(7, endereco.getId());
			pst.setString(8, anuncio.getEstiloMusical().toString());
			pst.setString(9, anuncio.getTipoMusico().toString());
			pst.setInt(10, contratante.getId());
			pst.setString(11, anuncio.getSituacao().toString());
			pst.setString(12, anuncio.getTipoAmbiente().toString());
			pst.setTimestamp(13, java.sql.Timestamp.valueOf(endereco.getRegistro()));

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

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
