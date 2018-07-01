package negocio;

public abstract class Producto {
	
	protected int codigo;
	protected String descripcion;
	protected float valorHoraBase;
	protected float valorDiaBase;
	protected String estado;
	protected String estadoProducto;
	
	
	public Producto(int codigo, String descripcion, float valorHoraBase, float valorDiaBase) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.valorHoraBase = valorHoraBase;
		this.valorDiaBase = valorDiaBase;
		estado="alta";
		estadoProducto="disponible";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getValorHoraBase() {
		return valorHoraBase;
	}

	public void setValorHoraBase(float valorHoraBase) {
		this.valorHoraBase = valorHoraBase;
	}

	public float getValorDiaBase() {
		return valorDiaBase;
	}

	public void setValorDiaBase(float valorDiaBase) {
		this.valorDiaBase = valorDiaBase;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	
	public boolean sosElProducto(int codigo2) {
		if (codigo2==codigo) {
			return true;
		}
		return false;
	}
	
	public abstract float alquilerPorHora(int cantidadHoras);
	
	public abstract float alquilerPorDia(int cantidadDias);
}
