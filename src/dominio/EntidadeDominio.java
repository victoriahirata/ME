package dominio;

import java.time.LocalDateTime;

public class EntidadeDominio {

	private int id;

	private LocalDateTime registro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getRegistro() {
		return registro;
	}

	public void setRegistro(LocalDateTime registro) {
		this.registro = registro;
	}

}
