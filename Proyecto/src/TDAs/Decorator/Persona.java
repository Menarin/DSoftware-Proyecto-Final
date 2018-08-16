package TDAs.Decorator;

import java.util.Date;

public abstract class Persona {
	protected String nombre, apellido, cedula;
	protected Date fechaNacimiento;
	
	public Persona() {
		
	}

	public Persona(String nombre, String apellido, String cedula, Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public abstract void crearPersona();
	
}
