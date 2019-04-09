package viewhelper;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Pessoa;
import dominio.Usuario;
import util.Resultado;

public class ViewHelperPessoa implements IViewHelper {

	/**
	 * @param request
	 * @param response
	 */
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String operacao = request.getParameter("operacao");
		Pessoa pessoa = null;
		if (!operacao.equals("CONSULTAR")) {
			Usuario usuario = new Usuario();
			Endereco endereco = new Endereco();
			pessoa = new Pessoa();
//			String id = request.getParameter("txtId");
			String nome = request.getParameter("txtNome");
			String telefone = request.getParameter("txtTelefone");
			pessoa.setNome(nome);
			pessoa.setTelefone(telefone);
//			if (id != null && !id.trim().equals("")) {
//				pessoa.setId(Integer.parseInt(id));
//			}
			pessoa.setRegistro(LocalDateTime.now());
			pessoa.setUsuario(usuario);
			pessoa.setEndereco(endereco);
//			pessoa.setCartao(cartao);
		}else {
			pessoa = null;
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			Long id = null;

			if (txtId != null && !txtId.trim().equals("")) {
				id = Long.parseLong(txtId);
			}

			for (EntidadeDominio e : resultado.getEntidades()) {
				if (e.getId() == id) {
					pessoa = (Pessoa) e;
				}
			}
		}
		return pessoa;
	}

	/**
	 * TODO Descrição do Método
	 * 
	 * @param request
	 * @param response
	 */
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMensagem() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMensagem("Pessoa cadastrada com sucesso!");
			}

			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormCadastro.jsp");
		}
		
		if(resultado.getMensagem() == null && operacao.equals("VISUALIZAR")){
			
			request.setAttribute("musico", resultado.getEntidades().get(0));
			d= request.getRequestDispatcher("DadosDoMusico.jsp");  			
		}

		d.forward(request, response);

	}

}
