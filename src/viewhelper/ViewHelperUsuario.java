package viewhelper;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.EntidadeDominio;
import dominio.Usuario;
import util.Resultado;

public class ViewHelperUsuario implements IViewHelper {


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String operacao = request.getParameter("operacao");
		Usuario usuario = null;

		if (!operacao.equals("CONSULTAR")) {
			usuario = new Usuario();
//			String id = request.getParameter("txtId");
			String nomeUsuario = request.getParameter("txtNomeUsuario");
			String senha = request.getParameter("txtSenha");
			String confirmaSenha = request.getParameter("txtConfirmacaoSenha");
			String email = request.getParameter("txtEmail");

			if (email != null && !email.trim().equals("")) {
				usuario.setEmail(email);
			}
			if (nomeUsuario != null && !nomeUsuario.trim().equals("")) {
				usuario.setNomeUsuario(nomeUsuario);
			}
			if (senha != null && !email.trim().equals("")) {
				usuario.setSenha(senha);
			}
//			if (id != null && !id.trim().equals("")) {
//				usuario.setId(Integer.parseInt(id));
//			}
			if (confirmaSenha != null && !confirmaSenha.trim().equals("")) {
				usuario.setSenha(confirmaSenha);
			}
			usuario.setRegistro(LocalDateTime.now());
		}else {
			usuario = null;
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			Long id = null;

			if (txtId != null && !txtId.trim().equals("")) {
				id = Long.parseLong(txtId);
			}

			for (EntidadeDominio e : resultado.getEntidades()) {
				if (e.getId() == id) {
					usuario = (Usuario) e;
				}
			}
		}
		return usuario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMensagem() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMensagem("Usuario cadastrado com sucesso!");
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
