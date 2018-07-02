package controlador;
import java.time.LocalDate;
import java.util.Vector;

import negocio.Alquiler;
import negocio.Bicicleta;
import negocio.Carpa;
import negocio.Cliente;
import negocio.Cuatriciclo;
import negocio.Producto;
import negocio.Reposera;

public class Sistema {
	private Vector <Cliente> clientes;
	private Vector <Producto> productos;
	private Vector <Alquiler> alquileres;
	
	public Sistema() {
		clientes = new Vector<Cliente>();
		productos = new Vector<Producto>();
		alquileres = new Vector<Alquiler>();
		
		cargaInicial();
	}
	
	public boolean crearCliente(int dni, String nombre, String domicilio, String mail, int telefono) {
		
		Cliente cliente = buscarCliente(dni);
		
		if (cliente==null) {
			cliente=new Cliente(dni, nombre, domicilio, mail, telefono);
			clientes.add(cliente);
			return true;
		}
		return false;
	}
	
	public int modificarCliente(int dni, String nombre, String domicilio, String mail, int telefono) {
		Cliente cliente = buscarCliente(dni);
		
		if (cliente==null || cliente.getEstado().equalsIgnoreCase("baja")) {
			return 2;
		}
		
		if (cliente!=null) {
			cliente.setDni(dni);
			cliente.setNombre(nombre);
			cliente.setDomicilio(domicilio);
			cliente.setMail(mail);
			cliente.setTelefono(telefono);
			return 1;
		}
		
		return 0;
		
	}
	
	public int eliminarCliente(int dni) {
		boolean rdo = false;
		boolean rdo2 = false;
		Cliente cliente = buscarCliente(dni);
		
		if (cliente==null || cliente.getEstado().equalsIgnoreCase("baja")) {
			return 1;
		}
		
		for (int i = 0; i < alquileres.size(); i++) {
			if (cliente!=null) {
				rdo2=alquileres.elementAt(i).tenesElCliente(dni);
			}
			if (rdo2==true) {
				rdo=alquileres.elementAt(i).estasPendiente();
			}
			if (rdo2==true && rdo==true) {
				break;
			}
			rdo=false;		//cambie esto. sino se sobreescriben las variables constantemente
			rdo2=false;		//x2
		
		}
		
		
		if (rdo==false && rdo2==false) {	//x3. si es falso es que no esta pendiente
			cliente.setEstado("baja");
			return 0;
		}
		
		if (rdo2==true && rdo==true) {
			return 2;
		}
		return -1;
	}
	
	public boolean registrarCuatriciclo(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, String patente, float seguro) {
		Producto producto = buscarProducto(codigo);
		
		if (producto==null) {
			producto=new Cuatriciclo(codigo, descripcion, valorHoraBase, valorDiaBase, patente, seguro);
			productos.add(producto);
			return true;
		}
		return false;
	}
	
	public boolean registrarCarpa(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, int capacidad, float deposito, float seguro) {
		Producto producto = buscarProducto(codigo);
		if (producto==null) {
			producto=new Carpa(codigo, descripcion, valorHoraBase, valorDiaBase, capacidad, deposito, seguro);
			productos.add(producto);
			return true;
		}
		return false;
	}
	
	public boolean registrarReposera(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, float deposito) {
		Producto producto = buscarProducto(codigo);
		if (producto==null) {
			producto=new Reposera(codigo, descripcion, valorHoraBase, valorDiaBase, deposito);
			productos.add(producto);
			return true;
		}
		return false;
	}
	
	public boolean registrarBicicleta(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, float seguro) {
		Producto producto = buscarProducto(codigo);
		if (producto==null) {
			producto=new Bicicleta(codigo, descripcion, valorHoraBase, valorDiaBase, seguro);
			productos.add(producto);
			return true;
		}
		return false;
	}
	
	public boolean modificarCarpa(int codigo, String descripcion, float valorHoraBase, float valorDiaBase,int capacidad,float deposito,float seguro) {
		Carpa carpa = buscarCarpa(codigo);
		
		if (carpa==null || carpa.getEstado().equals("baja")) {
			return false;
		}
		
		if (carpa!=null) {
			carpa.setCodigo(codigo);
			carpa.setDescripcion(descripcion);
			carpa.setValorHoraBase(valorHoraBase);
			carpa.setValorDiaBase(valorDiaBase);
			carpa.setCapacidad(capacidad);
			carpa.setDeposito(deposito);
			carpa.setSeguro(seguro);
			return true;
		}
		return false;
	}

	public boolean modificarBicicleta(int codigo, String descripcion, float valorHoraBase, float valorDiaBase,float seguro) {
		Bicicleta bicicleta = buscarBicicleta(codigo);
		boolean aux=false;
		
		if (bicicleta==null || bicicleta.getEstado().equals("baja")) {
//			return false;
			aux = false;
		}
		if (bicicleta!=null) {
			bicicleta.setCodigo(codigo);
			bicicleta.setDescripcion(descripcion);
			bicicleta.setValorHoraBase(valorHoraBase);
			bicicleta.setSeguro(seguro);
//			return true;
			aux = true;
		}
		return aux;
	}

	public boolean modificarCuatriciclo(int codigo, String descripcion, float valorHoraBase, float valorDiaBase, String patente, float seguro) {
		Cuatriciclo producto = buscarCuatriciclo(codigo);
		
		if (producto==null || producto.getEstado().equals("baja")) {
			return false;
		}
		
		if (producto!=null) {
			producto.setCodigo(codigo);
			producto.setDescripcion(descripcion);
			producto.setPatente(patente);
			producto.setSeguro(seguro);
			producto.setValorDiaBase(valorDiaBase);
			producto.setValorHoraBase(valorHoraBase);
			
			return true;
		}
		return false;
	}
	
	public boolean modificarReposera(int codigo, String descripcion, float valorHoraBase, float valorDiaBase,float deposito) {
		Reposera producto = buscarReposera(codigo);
		
		if (producto==null || producto.getEstado().equals("baja")) {
			return false;
		}
		
		if (producto!=null) {
			producto = new Reposera(codigo,descripcion,valorHoraBase,valorDiaBase,deposito);
			productos.add(producto);
			return true;
		}
		return false;
	}
	
	private Carpa buscarCarpa(int codigo){
		for (int i = 0; i < productos.size(); i++) {
			if (productos.elementAt(i).sosElProducto(codigo)) {
				return (Carpa) productos.get(i);
			}
		}
		return null;
	}
	
	private Cuatriciclo buscarCuatriciclo(int codigo){
		for (int i = 0; i < productos.size(); i++) {
			if (productos.elementAt(i).sosElProducto(codigo)) {
				return (Cuatriciclo) productos.get(i);
			}
		}
		return null;
	}
	
	private Reposera buscarReposera(int codigo){
		for (int i = 0; i < productos.size(); i++) {
			if (productos.elementAt(i).sosElProducto(codigo)) {
				return (Reposera) productos.get(i);
			}
		}
		return null;
	}
	
	private Bicicleta buscarBicicleta(int codigo){
		for (int i = 0; i <productos.size(); i++) {
			if (productos.elementAt(i).sosElProducto(codigo)) {
				return (Bicicleta) productos.get(i);
			}
		}
		return null;
	}

	public int eliminarProducto(int codigo) {
		boolean rdo = false;
		boolean rdo2 = false;
		Producto producto = buscarProducto(codigo);
		
		if (producto==null) {
			return 2;
		}
		if (producto.getEstado().equalsIgnoreCase("baja")) {
			return 2;
		}
		
		for (int i = 0; i < alquileres.size(); i++) {
			if (producto!=null) {
				rdo2=alquileres.elementAt(i).tenesElProducto(codigo);
			}
			if (rdo2==true) {
				rdo=alquileres.elementAt(i).estasPendiente();
			}
			if (rdo2==true&&rdo==true) {
				return 3;
			}
			
			rdo=false;
			rdo2=false;
		}
		
		if (rdo==false && rdo2==false) {
			producto.setEstado("baja");
			return 1;
		}
		return 0;
	}
	
	private Cliente buscarCliente(int dni) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.elementAt(i).sosElCliente(dni)) {
				return clientes.elementAt(i);
			}
		}
		return null;
		
	}
	
	private Producto buscarProducto(int codigo) {
		for (int i = 0; i < productos.size(); i++) {
			if (productos.elementAt(i).sosElProducto(codigo)) {
				return productos.elementAt(i);
			}
		}
		return null;
	}
	
	private Alquiler buscarAlquiler(int codigo, int dni) {
		for (int i = 0; i < alquileres.size(); i++) {
			if (alquileres.elementAt(i).tenesElCliente(dni) && alquileres.elementAt(i).tenesElProducto(codigo)) {
			return alquileres.elementAt(i);
			}
		}
		return null;
	}
	
	public int devolverAlquiler(int codigo, int dni) {
		Alquiler alquiler=buscarAlquiler(codigo, dni);
		
		if (alquiler==null) {
			return 3;
		}
		if (alquiler.getProducto().getEstado().equalsIgnoreCase("baja")) {
			return 2;
		}
		if (alquiler.getCliente().getEstado().equalsIgnoreCase("baja")) {
			return 4;
		}
		if (alquiler.getEstado().equalsIgnoreCase("devuelto")) {
			return 5;
		}
		
		if (alquiler!=null) {
			alquiler.setEstado("devuelto");
			alquiler.setFechaDevolucion(LocalDate.now());
			alquiler.getProducto().setEstadoProducto("disponible");
			return 1;
		}
		
		return 0;
	}
	
	public float montoTotalPorFechas(LocalDate fechaD, LocalDate fechaH) {
		boolean alquiler;
		float total=0;
		
		for (int i = 0; i < alquileres.size(); i++) {
			alquiler=alquileres.elementAt(i).estasEnPeriodo(fechaD, fechaH);
			if (alquiler==true) {
				total=alquileres.elementAt(i).getMontoTotal()+total;
			}
		}
		return total;
	}
	
	public int cantidadAlquilado(int codigo) {
		Producto producto = buscarProducto(codigo);
		int contador = 0;
		
		if (producto==null) {
			return -1;
		}
		
		if (producto!=null) {
			for (int i = 0; i < alquileres.size(); i++) {
				if (alquileres.elementAt(i).tenesElProducto(codigo)) {
					contador++;
				}
			}
		}
		return contador;
	}
	
	public String productoDisponible(int codigo) {
		Producto producto = buscarProducto(codigo);
		String v= "";
		
		if (producto==null) {
			return v = "Producto no existe.";
		}
		if (producto.getEstado().equals("baja")) {
			v="Producto dado de baja.";
		}
		
		if (producto!=null) {
			v= producto.getEstadoProducto();
		}
		return v;
	}
	
	public int registrarAlquiler(int dni, int codigo, int cantidadHoras, int cantidadDias) {
		Producto producto=buscarProducto(codigo);
		Cliente cliente=buscarCliente(dni);
		String rdo = null;
		
		if (producto==null && cliente==null) {
			return 4;
		}
		if (producto!=null && cliente!=null) {
			rdo=productoDisponible(codigo);
		}
		if (producto==null) {
			return 2;
		}
		if (cliente==null) {
			return 3;
		}
		if (rdo.equalsIgnoreCase("alquilado")) {
			return 5;
		}
		
		if (rdo.equalsIgnoreCase("disponible")) {
			Alquiler alquiler=new Alquiler(cliente, producto, cantidadHoras, cantidadDias);
			alquileres.add(alquiler);
			alquiler.setEstado("alquilado");
			alquiler.getProducto().setEstadoProducto("alquilado");
			return 1;
		}
		
		return 0;

	}
	
	public void cargaInicial(){
		crearCliente(1, "cesar", "chile 4000", "sahjdsajh@hotmail.com", 15315325);
		crearCliente(2, "francisco", "sarmiento 275", "asdasdasdh@hotmail.com", 153156423);
		registrarBicicleta(1, "bikercleta 2.0", 100, 1000, 50);
		registrarCuatriciclo(2, "Banshee", 500, 3500, "ABM325", 150);
		registrarAlquiler(1, 1, 5, 0);
		registrarAlquiler(1, 2, 3, 1);
	}
	
	
}
