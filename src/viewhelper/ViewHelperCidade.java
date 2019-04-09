package viewhelper;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cidade;
import dominio.EntidadeDominio;
import dominio.Estado;
import util.Resultado;

public class ViewHelperCidade implements IViewHelper {



	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Cidade cidade = null;
		if (!operacao.equals("CONSULTAR")) {
			cidade = new Cidade();
			Estado estado = new Estado();
			String nome = request.getParameter("txtCidade");			
			cidade.setNome(nome);
			cidade.setRegistro(LocalDateTime.now());
			cidade.setEstado(estado);
		}
		return cidade;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMensagem() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMensagem("Cidade cadastrada com sucesso!");
			}

			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormCadastro.jsp");
		}

		d.forward(request, response);

	}

}
