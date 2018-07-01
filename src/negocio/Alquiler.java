package negocio;
import java.time.LocalDate;

public class Alquiler {
	private LocalDate fecha;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Producto producto;
	private float montoTotal;
	private String estado;
	private int cantidadHoras;
	private int cantidaDias;
	
	public Alquiler(Cliente cliente, Producto producto, int cantidadHoras, int cantidadDias) {
		super();
		fecha = LocalDate.now();
		this.cliente = cliente;
		this.producto = producto;
		montoTotal = producto.alquilerPorDia(cantidadDias)+producto.alquilerPorHora(cantidadHoras);
		estado = "alquilado";
		this.cantidadHoras = cantidadHoras;
		this.cantidaDias = cantidadDias;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public int getCantidaDias() {
		return cantidaDias;
	}

	public void setCantidaDias(int cantidaDias) {
		this.cantidaDias = cantidaDias;
	}
	
	public boolean estasPendiente() {
		if (estado.equalsIgnoreCase("alquilado")) {
			return true;
		}
		return false;
	}
	
	public boolean tenesElProducto(int codigo) {
		if (producto.sosElProducto(codigo)) {
			return true;
		}
		return false;
	}
	
	public boolean tenesElCliente(int dni) {
		if (cliente.sosElCliente(dni)) {
			return true;
		}
		return false;
	}
	
	public boolean estasEnPeriodo(LocalDate fechaD, LocalDate fechaH) {
		if (fechaD.isBefore(fecha)&&fechaH.isAfter(fecha)) {
			return true;
		}
		return false;
	}
	
}
