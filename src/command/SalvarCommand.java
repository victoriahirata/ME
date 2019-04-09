package command;

import dominio.EntidadeDominio;
import util.Resultado;

public class SalvarCommand extends AbstractCommand {
	
	public Resultado executar(EntidadeDominio entidade) {
		
		return fachada.salvar(entidade);
	}

}
