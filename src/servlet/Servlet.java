package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AlterarCommand;
import command.ConsultarCommand;
import command.ExcluirCommand;
import command.ICommand;
import command.SalvarCommand;
import dominio.EntidadeDominio;
import util.Resultado;
import viewhelper.IViewHelper;
import viewhelper.ViewHelperMusico;

//@WebServlet(urlPatterns ={"/SalvarMusico"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;

	/**
	 * Default constructor.
	 */
	public Servlet() {

		/*
		 * Utilizando o command para chamar a fachada e indexando cada command pela
		 * opera��o garantimos que esta servelt atender� qualquer opera��o
		 */
		commands = new HashMap<String, ICommand>();

		commands.put("SALVAR", new SalvarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		commands.put("ALTERAR", new AlterarCommand());

		/*
		 * Utilizando o ViewHelper para tratar especifica��es de qualquer tela e
		 * indexando cada viewhelper pela url em que esta servlet � chamada no form
		 * garantimos que esta servelt atender� qualquer entidade
		 */

		vhs = new HashMap<String, IViewHelper>();
		/*
		 * A chave do mapa � o mapeamento da servlet para cada form que est� configurado
		 * no web.xml e sendo utilizada no action do html
		 */
		vhs.put("/ProjetoLES/SalvarMusico", new ViewHelperMusico());
		vhs.put("/ProjetoLES/VisualizarDadosMusico", new ViewHelperMusico());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
		// Obt�m a uri que invocou esta servlet
		String uri = request.getRequestURI();
		System.out.println(uri);
		// Obt�m a opera��o executada
		String operacao = request.getParameter("operacao");

		// Obt�m um viewhelper indexado pela uri que invocou esta servlet
		IViewHelper vh = vhs.get(uri);
		System.err.println(vh);

		// O viewhelper retorna a entidade especifica para a tela que chamou esta
		// servlet
		EntidadeDominio entidade = vh.getEntidade(request);
		System.out.println(entidade);
		// Obt�m o command para executar a respectiva opera��o
		ICommand command = commands.get(operacao);

		/*
		 * Executa o command que chamar� a fachada para executar a opera��o requisitada
		 * o retorno � uma inst�ncia da classe resultado que pode conter mensagens derro
		 * ou entidades de retorno
		 */
		Resultado resultado = command.executar(entidade);

		/*
		 * Executa o m�todo setView do view helper espec�fico para definir como dever�
		 * ser apresentado o resultado para o usu�rio
		 */
		vh.setView(resultado, request, response);
	}

}
