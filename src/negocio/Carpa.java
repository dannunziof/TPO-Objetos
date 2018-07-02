package negocio;

public class Carpa extends Producto {
	private int capacidad;
	private float deposito;
	private float seguro;


	public Carpa(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, int capacidad, float deposito, float seguro) {
		super(codigo, descripcion, valorHoraBase, valorDiaBase);
		this.deposito=deposito;
		this.seguro=seguro;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public float getDeposito() {
		return deposito;
	}

	public void setDeposito(float deposito) {
		this.deposito = deposito;
	}

	public float getSeguro() {
		return seguro;
	}

	public void setSeguro(float seguro) {
		this.seguro = seguro;
	}


	public float alquilerPorHora(int cantidadHoras) {
		float aux=((valorHoraBase+seguro)*cantidadHoras)+deposito;
		return aux;
	}

	
	public float alquilerPorDia(int cantidadDias) {
		float aux=((valorDiaBase+seguro)*cantidadDias)+deposito;
		return aux;
	}

}
