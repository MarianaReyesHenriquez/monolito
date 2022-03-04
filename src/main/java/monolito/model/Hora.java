package monolito.model;


public class Hora {

	private final String actual;
	private final String anterior;


	public Hora(String actual, String anterior) {
		this.actual = actual;
		this.anterior = anterior;

	}


	public String getActual() {
		return actual;
	}

	public String getAnterior() {
		return anterior;
	}

}