package TDAs.Decorator;

public abstract class PersonaDecorator extends Persona{
	protected Persona persona;
	
	public PersonaDecorator(Persona p) {
		this.persona=p;
	}
	
	@Override
	public void crearPersona() {
		this.persona.crearPersona();
	}
	
}
