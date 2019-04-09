package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Musico;
import dominio.Usuario;

public class DAOMusico extends AbstractDAO {

	public DAOMusico() {
		super("musico", "id");
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Musico musico = (Musico) entidade;
		Usuario usuario = musico.getUsuario();
		DAOUsuario daoUsuario = new DAOUsuario();
		Endereco endereco = musico.getEndereco();
		DAOEndereco daoEndereco = new DAOEndereco();
		ResultSet ultimoId = null;
		try {

			daoUsuario.salvar(musico.getUsuario());
			
			System.out.println(musico.getUsuario().getId());
			
//			daoEndereco.salvar(musico.getEndereco());
//			ultimoId = connection.prepareStatement(ultimoID).executeQuery();
//			
//			
//
//			while(ultimoId.next()) {
//				endereco.setId(ultimoId.getInt(1));
//			}
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO musico (nome, cpf,telefone,usuario,registro) VALUES (?,?,?,?,?)");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, musico.getNome());
			pst.setString(2, musico.getCpf());
			pst.setString(3, musico.getTelefone());
			pst.setInt(4, usuario.getId());
			//pst.setInt(5, endereco.getId());
			pst.setTimestamp(5, java.sql.Timestamp.valueOf(musico.getRegistro()));

			pst.executeUpdate();

			ultimoId = pst.getGeneratedKeys();
			int idMusico = 0;
			if (ultimoId.next())
				idMusico = ultimoId.getInt(1);
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
				if(pst != null)
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
