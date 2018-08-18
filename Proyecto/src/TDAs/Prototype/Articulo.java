package TDAs.Prototype;

import java.util.Objects;

public abstract class Articulo {
	 
    protected String Nombre;
    protected float precio;
    protected String Descripcion;
    protected String marca;


    /**
     * Default constructor
     */
    public Articulo() {
    }
    
    
    public Articulo(Articulo target) {
		if(target!=null) {
	    	this.Nombre = target.Nombre;
			this.precio = target.precio;
			this.Descripcion = target.Descripcion;
			this.marca = target.marca;
		}
	}


	/**
     * @return
     */
    public String getNombre() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public double getPrecio() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public String getDescripcion() {
        // TODO implement here
        return null;
    }

    /**
     * @param nombre
     */
    private void setNombre(String nombre) {
        // TODO implement here
    }

    /**
     * @param costo
     */
    private void setPrecio(double costo) {
        // TODO implement here
    }

    /**
     * @param descripcion
     */
    private void setDescripcion(String descripcion) {
        // TODO implement here
    }

    /**
     * 
     * @throws java.lang.CloneNotSupportedException
     */
    public abstract Articulo clone();
    
    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Articulo)) return false;
        Articulo articulo2= (Articulo) object2;
        return Objects.equals(articulo2.Nombre, Nombre) && articulo2.precio==precio && Objects.equals(articulo2.Descripcion, Descripcion) && Objects.equals(articulo2.marca, marca);
    }

}
