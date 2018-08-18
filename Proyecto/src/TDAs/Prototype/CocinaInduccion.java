package TDAs.Prototype;

public class CocinaInduccion extends Articulo{
 
	private String color;
	private int numHornillas;
	private boolean hasHorno;
	
	
	public CocinaInduccion() {
		
		// TODO Auto-generated constructor stub
	}


	public CocinaInduccion(CocinaInduccion target) {
		super(target);
		if(target!=null) {
			this.color=target.color;
			this.numHornillas=target.numHornillas;
			this.hasHorno=target.hasHorno;
		}
	}


	@Override
	public Articulo clone() {
		// TODO Auto-generated method stub
		return new CocinaInduccion(this);
	}
	
	
}
