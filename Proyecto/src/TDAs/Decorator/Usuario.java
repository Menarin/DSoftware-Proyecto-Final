package TDAs.Decorator;

public class Usuario extends Persona {
	
	protected String userName, password, acceso;
	
	public Usuario() {
		super();
	}
	
	
	
	public Usuario(String nombre, String apellido, String cedula,String userName, String password, String acceso) {
		super(nombre,apellido,cedula);
		this.userName = userName;
		this.password = password;
		this.acceso = acceso;
	}

	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getAcceso() {
		return acceso;
	}



	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}


	

}
