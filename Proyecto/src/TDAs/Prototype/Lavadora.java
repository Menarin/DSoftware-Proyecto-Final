package TDAs.Prototype;

public class Lavadora extends Articulo{
	private float capacidad;
	private boolean isSecadora;
	public Lavadora() {}
	
	public Lavadora(Lavadora target) {
		super(target);
		if(target!=null) {
			this.capacidad=target.capacidad;
		}
	}
	@Override
	public Articulo clone() {
		// TODO Auto-generated method stub
		return new Lavadora(this);
	}
	@Override
	public boolean equals(Object object2) {
		if(!(object2 instanceof Lavadora) || !super.equals(object2)) return false;
		Lavadora lavadora=(Lavadora) object2;
		return lavadora.capacidad==capacidad && lavadora.isSecadora==isSecadora;
	}

}
