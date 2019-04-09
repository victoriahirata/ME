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
import dominio.Musico;
import dominio.PessoaFisica;
import dominio.Usuario;
import util.Resultado;

public class ViewHelperMusico implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String operacao = request.getParameter("operacao");
		Musico musico = null;
		if (!operacao.equals("CONSULTAR")) {
			musico = new Musico();
			Cidade cidade = new Cidade();
			Estado estado = new Estado();
			Endereco endereco = new Endereco();
			Usuario usuario = new Usuario();
			String nome = request.getParameter("txtNome");
			String cpf = request.getParameter("txtCpf");
			String senha = request.getParameter("txtSenha");
			String nomeUsuario = request.getParameter("txtNomeUsuario");
			String email = request.getParameter("txtEmail");
			String telefone = request.getParameter("txtTelefone");
			musico.setCpf(cpf);
			musico.setNome(nome);
			musico.setTelefone(telefone);
			//TODO pegar da requisição
			usuario.setRegistro(LocalDateTime.now());
			endereco.setRegistro(LocalDateTime.now());
			estado.setId(1);
			cidade.setId(1);
			cidade.setEstado(estado);
			endereco.setCidade(cidade);
			musico.setEndereco(endereco);
			usuario.setSenha(senha);
			usuario.setNomeUsuario(nomeUsuario);
			usuario.setEmail(email);
			musico.setUsuario(usuario);
			musico.setRegistro(LocalDateTime.now());
			

		} else {
			musico = null;
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			Long id = null;

			if (txtId != null && !txtId.trim().equals("")) {
				id = Long.parseLong(txtId);
			}

			for (EntidadeDominio e : resultado.getEntidades()) {
				if (e.getId() == id) {
					musico = (Musico) e;
				}
			}
		}

		return musico;

	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMensagem() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMensagem("Pessoa física cadastrada com sucesso!");
			}

			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("musico.jsp");
		}
		if (resultado.getMensagem() == null && operacao.equals("VISUALIZAR")) {

			request.setAttribute("musico", resultado.getEntidades().get(0));
			d = request.getRequestDispatcher("FormCadastro.jsp");
		}

		if (resultado.getMensagem() == null && operacao.equals("ALTERAR")) {

			d = request.getRequestDispatcher("musico.jsp");
		}

		if (resultado.getMensagem() != null) {
			if (operacao.equals("SALVAR") || operacao.equals("ALTERAR")) {
				request.getSession().setAttribute("resultado", resultado);
				d = request.getRequestDispatcher("musico.jsp");
			}
		}
		d.forward(request, response);

	}

}
