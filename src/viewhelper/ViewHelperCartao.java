//package viewhelper;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dominio.Cartao;
//import dominio.EntidadeDominio;
//import util.Resultado;
//
//public class ViewHelperCartao implements IViewHelper {
//
//	@Override
//	public EntidadeDominio getEntidade(HttpServletRequest request) {
//		String operacao = request.getParameter("operacao");
//		Cartao cartao = null;
//		if (!operacao.equals("CONSULTAR")) {
//			cartao = new Cartao();
//			String titular = request.getParameter("txtTitular");
//			String
//		}
//
//		return cartao;
//	}
//
//	@Override
//	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
