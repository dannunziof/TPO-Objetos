package negocio;

public class Bicicleta extends Producto {
	private float seguro;

	public Bicicleta(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, float seguro) {
		super(codigo, descripcion, valorHoraBase, valorDiaBase);
		this.seguro=seguro;
	}

	public float getSeguro() {
		return seguro;
	}

	public void setSeguro(float seguro) {
		this.seguro = seguro;
	}

	
	public float alquilerPorHora(int cantidadHoras) {
		float aux=(valorHoraBase*cantidadHoras)+seguro;
		return aux;
	}

	
	public float alquilerPorDia(int cantidadDias) {
		float aux=(valorDiaBase*cantidadDias)+seguro;
		return aux;
	}

}
