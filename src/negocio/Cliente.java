package negocio;

public class Cliente {
	private int dni;
	private String nombre;
	private String domicilio;
	private String mail;
	private int telefono;
	private String estado;
	
	public Cliente(int dni, String nombre, String domicilio, String mail, int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.mail = mail;
		this.telefono = telefono;
		estado="alta";
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	public boolean sosElCliente(int dni2) {
		if (dni2==dni) {
			return true;
		}
		return false;
	}
	
	
}
