package viewhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Avaliacao;
import dominio.Contrato;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.EstiloMusical;
import dominio.Pagamento;
import dominio.TipoAmbiente;
import util.Resultado;

public class ViewHelperContrato implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		LocalDate data = null;
		LocalTime horaInicio = null;
		LocalTime horaFim = null;
		TipoAmbiente tipoAmbiente = null;
		EstiloMusical estiloMusical = null;
		Endereco endereco = null;
		Pagamento pagamento = null;
		Avaliacao avaliacao = null;
		
		Contrato contrato = new Contrato();
		
//		contrato.setHoraInicio(horaInicio);
//		contrato.setHoraFim(horaFim);
//		contrato.setData(data);
//		contrato.setTipoAmbiente(tipoAmbiente);
//		contrato.setEstiloMusical(estiloMusical);
//		contrato.setEndereco(endereco);
		contrato.setAvaliacao(avaliacao);
		contrato.setPagamento(pagamento);

		return contrato;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

}
