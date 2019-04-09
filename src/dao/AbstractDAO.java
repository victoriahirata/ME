package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.Conexao;

public abstract class AbstractDAO implements IDAO {

	protected Connection connection;
	protected String table;
	protected String idTable;
	protected boolean ctrlTransaction=true;
	
	public AbstractDAO( Connection connection, String table, String idTable){
		this.table = table;
		this.idTable = idTable;
		this.connection = connection;
	}
	
	protected AbstractDAO(String table, String idTable){
		this.table = table;
		this.idTable = idTable;
	}
	protected void openConnection(){
		try {
			
			if(connection == null || connection.isClosed())
				connection = Conexao.getConnection();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
