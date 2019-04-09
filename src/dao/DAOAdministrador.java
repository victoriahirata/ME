package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dominio.Administrador;
import dominio.EntidadeDominio;
import dominio.Usuario;

public class DAOAdministrador extends AbstractDAO {

	public DAOAdministrador() {
		super("administrador","id");		
	}
	
	@Override
	public void salvar(EntidadeDominio entidade){
		openConnection();
		PreparedStatement pst = null;
		Administrador administrador = (Administrador) entidade;
		Usuario usuario = administrador.getUsuario();
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO adminstrador (usuario,registro) VALUES (?,?)");		
					
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setInt(1, usuario.getId());
			pst.setTimestamp(2, java.sql.Timestamp.valueOf(administrador.getRegistro()));
			
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();
			int idAdministrador = 0;
			if (rs.next())
				idAdministrador = rs.getInt(1);
			administrador.setId(idAdministrador);
			
			connection.commit();	
			
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
