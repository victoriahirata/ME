package fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DAOAdministrador;
import dao.DAOAnuncio;
import dao.DAOArquivo;
import dao.DAOContratante;
import dao.DAOContrato;
import dao.DAOEndereco;
import dao.DAOMusico;
import dao.DAOUsuario;
import dao.IDAO;
import dominio.Administrador;
import dominio.Anuncio;
import dominio.Arquivo;
import dominio.Contratante;
import dominio.Contrato;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Musico;
import dominio.Usuario;
import util.Resultado;

public class Fachada implements IFachada {

	private Map<String, IDAO> daos;

	private Resultado resultado;

	public Fachada() {
		/* Intânciando o Map de DAOS */
		daos = new HashMap<String, IDAO>();

		/* Criando instâncias dos DAOs a serem utilizados */
//		DAOContrato daoContrato = new DAOContrato();
		DAOEndereco daoEndereco = new DAOEndereco();
		DAOMusico daoMusico = new DAOMusico();
		DAOArquivo daoArquivo = new DAOArquivo();
		DAOUsuario daoUsuario = new DAOUsuario();
		DAOContratante daoContratante = new DAOContratante();
		DAOAnuncio daoAnuncio = new DAOAnuncio();
		DAOContrato daoContrato = new DAOContrato();
		DAOAdministrador daoAdministrador = new DAOAdministrador();

		/* Adicionando cada dao no MAP indexando pelo nome da classe */
		daos.put(Endereco.class.getName(), daoEndereco);
		daos.put(Musico.class.getName(), daoMusico);
		daos.put(Arquivo.class.getName(), daoArquivo);
		daos.put(Usuario.class.getName(), daoUsuario);
		daos.put(Contratante.class.getName(), daoContratante);
		daos.put(Anuncio.class.getName(), daoAnuncio);
		daos.put(Contrato.class.getName(), daoContrato);
		daos.put(Administrador.class.getName(), daoAdministrador);
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();

		String nome = entidade.getClass().getName();

		String msg = executarRegras(entidade, "SALVAR");

//		if (msg == null) {
		if(true) {
			IDAO dao = daos.get(nome);
			try {
				System.out.println(entidade);
				dao.salvar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMensagem("Não foi possível executar a ação!");
			}
		} else {
			resultado.setMensagem(msg);
		}
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nomeClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade, "ALTERAR");

		if (msg == null) {
			IDAO dao = daos.get(nomeClasse);
			try {
				dao.alterar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMensagem("Não foi possível executar a ação!");
			}
		} else {
			resultado.setMensagem(msg);
		}
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		resultado = new Resultado();
		String nomeClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade, "Consultar");
		if(msg == null) {
			IDAO dao = daos.get(nomeClasse);
			try {
				resultado.setEntidades(dao.consultar(entidade));
			}catch(SQLException e){
				e.printStackTrace();
				resultado.setMensagem("Não foi possível executar a ação");
			}
		}else {
			resultado.setMensagem(msg);
		}
		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		resultado = new Resultado();
		
		String nomeClasse = entidade.getClass().getName();
		
		String msg = executarRegras(entidade, "EXCLUIR");
		
		if(msg == null) {
			IDAO dao = daos.get(nomeClasse);
			try {
				dao.excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			}catch (SQLException e) {
				e.printStackTrace();
				resultado.setMensagem("Não foi possível executar a ação!");
			}
		}else {
			resultado.setMensagem(msg);
		}
		return resultado;
	}

	private String executarRegras(EntidadeDominio entidade, String operacao) {
		StringBuilder mensagem = new StringBuilder();

		if (mensagem.length() > 0) {
			return mensagem.toString();
		} else {
			return null;
		}
	}

}
