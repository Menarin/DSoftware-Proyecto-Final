package TDAs.Prototype;

public class Refrigerador extends Articulo{
	private int numero_puertas;
	private float capacidad ;
	public Refrigerador() {}
	
	public Refrigerador(Refrigerador target) {
		super(target);
		if(target!=null) {
			this.numero_puertas=target.numero_puertas;
			this.capacidad=target.capacidad;
		}
	}
	@Override
	public Articulo clone() {
		// TODO Auto-generated method stub
		return new Refrigerador(this);
	}
	@Override
	public boolean equals(Object object2) {
		if(!(object2 instanceof Refrigerador) || !super.equals(object2)) return false;
		Refrigerador refrigerador=(Refrigerador) object2;
		return refrigerador.numero_puertas==numero_puertas && refrigerador.capacidad==capacidad;
	}

}
