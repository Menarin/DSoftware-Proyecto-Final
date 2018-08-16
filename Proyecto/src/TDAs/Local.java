package TDAs;

import java.util.ArrayList;

public class Local {
	protected String nombre, ubicacion;  
	protected boolean estado_wifi;
	protected int tipo;
	protected ArrayList<String> articulos;

	public Local() {}
	
	public Local(String nombre, String ubicacion, boolean estadoWifi,int tipo,ArrayList<String> articulos) {
		this.nombre=nombre;
		this.ubicacion=ubicacion;
		this.estado_wifi=estadoWifi;
		this.tipo=tipo;
		this.articulos=articulos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean isEstado_wifi() {
		return estado_wifi;
	}

	public void setEstado_wifi(boolean estado_wifi) {
		this.estado_wifi = estado_wifi;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public ArrayList<String> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<String> articulos) {
		this.articulos = articulos;
	}
	
	
	
	
}
