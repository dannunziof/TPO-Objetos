package negocio;

public class Cuatriciclo extends Producto {
	private String patente;
	private float seguro;

	public Cuatriciclo(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, String patente, float seguro) {
		super(codigo, descripcion, valorHoraBase, valorDiaBase);
		this.patente=patente;
		this.seguro=seguro;
	}
	
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public float getSeguro() {
		return seguro;
	}

	public void setSeguro(float seguro) {
		this.seguro = seguro;
	}


	public float alquilerPorHora(int cantidadHoras) {
		float aux=(valorHoraBase+seguro)*cantidadHoras;
		return aux;
	}

	
	public float alquilerPorDia(int cantidadDias) {
		float aux=(valorDiaBase+seguro)*cantidadDias;
		return aux;
	}

}
