package viewhelper;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.EntidadeDominio;
import dominio.Estado;
import dominio.Pais;
import util.Resultado;

public class ViewHelperEstado implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Estado estado = null;
		if (!operacao.equals("CONSULTAR")) {
			Pais pais = new Pais();
			estado = new Estado();
			String nome = request.getParameter("txtEstado");
			estado.setNome(nome);
			estado.setRegistro(LocalDateTime.now());
			estado.setPais(pais);

		}
		return estado;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMensagem() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMensagem("Estado cadastrado com sucesso!");
			}

			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormCadastro.jsp");
		}

		d.forward(request, response);
	}

}
