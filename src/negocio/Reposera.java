package negocio;

public class Reposera extends Producto {
	private float deposito;

	public Reposera(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, float deposito) {
		super(codigo, descripcion, valorHoraBase, valorDiaBase);
		this.deposito=deposito;
	}
	
	public float getDeposito() {
		return deposito;
	}

	public void setDeposito(float deposito) {
		this.deposito = deposito;
	}


	public float alquilerPorHora(int cantidadHoras) {
		float aux=(valorHoraBase*cantidadHoras)+deposito;
		return aux;
	}

	
	public float alquilerPorDia(int cantidadDias) {
		float aux = (valorDiaBase*cantidadDias)+deposito;
		return aux;
	}

}
