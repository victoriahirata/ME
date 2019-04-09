package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dominio.Arquivo;
import dominio.EntidadeDominio;
import dominio.PessoaJuridica;
import dominio.Usuario;

public class DAOContratante extends AbstractDAO{

	public DAOContratante() {
		super("contrante", "id");
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		if (connection == null) {
			openConnection();
		}

		PreparedStatement pst = null;
		PessoaJuridica contratante = (PessoaJuridica) entidade;
		Usuario usuario = contratante.getUsuario();
		Arquivo arquivo = (Arquivo) contratante.getArquivo();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO endereco(cnpj,nome,nome_fantasia,telefone,usuario,arquivo,registro");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		try {
			connection.setAutoCommit(false);

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, contratante.getCnpj());
			pst.setString(2, contratante.getNome());
			pst.setString(2, contratante.getNomeFantasia());
			pst.setString(3, contratante.getTelefone());
			pst.setInt(4, usuario.getId());
			pst.setInt(5, arquivo.getId());
			pst.setTimestamp(6, java.sql.Timestamp.valueOf(contratante.getRegistro()));

			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			int idContratante = 0;
			if (rs.next())
				idContratante = rs.getInt(1);
			contratante.setId(idContratante);

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
