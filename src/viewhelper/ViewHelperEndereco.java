package viewhelper;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Cidade;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Estado;
import util.Resultado;

public class ViewHelperEndereco implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Endereco endereco = null;
		if (!operacao.equals("CONSULTAR")) {
			Cidade cidade = new Cidade();
			Estado estado = new Estado();
			endereco = new Endereco();
			
			String cep = request.getParameter("txtCep");
			String logradouro = request.getParameter("txtLogradouro");
			Integer numero = request.getIntHeader("txtNumero");
			String bairro = request.getParameter("txtBairro");
			String complemento = request.getParameter("txtComplemento");

			endereco.setLogradouro(logradouro);
			endereco.setNumero(numero);
			endereco.setBairro(bairro);
			endereco.setComplemento(complemento);
			endereco.setCep(cep);
			endereco.setRegistro(LocalDateTime.now());
			endereco.setCidade(cidade);
			endereco.getCidade().setEstado(estado);
			
		}else {
			endereco = null;
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			Long id = null;

			if (txtId != null && !txtId.trim().equals("")) {
				id = Long.parseLong(txtId);
			}

			for (EntidadeDominio e : resultado.getEntidades()) {
				if (e.getId() == id) {
					endereco = (Endereco) e;
				}
			}
		}
		return endereco;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMensagem() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMensagem("Endereco cadastrado com sucesso!");
			}

			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormCadastro.jsp");
		}

		d.forward(request, response);

	}

}
