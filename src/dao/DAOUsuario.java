package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dominio.EntidadeDominio;
import dominio.Usuario;

public class DAOUsuario extends AbstractDAO {

	public DAOUsuario() {
		super("usuario", "id_usuario");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Usuario usuario = (Usuario) entidade;
		
		ResultSet ultimoId = null;
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO usuario (nome_usuario,email,senha,registro) VALUES (?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, usuario.getNomeUsuario());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setTimestamp(4, java.sql.Timestamp.valueOf(usuario.getRegistro()));
			
			pst.executeUpdate();			
			connection.commit();
			String ultimoID = "Select last_insert_id()";
			ultimoId = connection.prepareStatement(ultimoID).executeQuery();

			while(ultimoId.next()) {
				entidade.setId(ultimoId.getInt(1));
			}
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
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
