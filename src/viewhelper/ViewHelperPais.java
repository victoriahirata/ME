package viewhelper;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.EntidadeDominio;
import dominio.Pais;
import util.Resultado;

public class ViewHelperPais implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Pais pais = null;
		if(!operacao.equals("CONSULTAR")) {
			pais = new Pais();
			String nome = request.getParameter("txtNome");
			pais.setNome(nome);
			pais.setRegistro(LocalDateTime.now());
		}
		return pais;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMensagem() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMensagem("Pais cadastrado com sucesso!");
			}

			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormCadastro.jsp");
		}

		d.forward(request, response);
		
	}

}
