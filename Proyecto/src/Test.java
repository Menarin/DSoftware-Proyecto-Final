import java.sql.SQLException;
import java.util.ArrayList;

import TDAs.Local;
import TDAs.SqlConection;
import TDAs.Decorator.Persona;
import TDAs.Decorator.Usuario;
import controller.AddClienteController;
import controller.AddUsuarioController;
import junit.framework.TestCase;

public class Test extends TestCase {
	AddClienteController ad = new AddClienteController();
	AddUsuarioController us = new AddUsuarioController();
	Local lc = new Local ();
	SqlConection sq = new SqlConection ();
	Persona person = new Persona();
	Usuario user = new Usuario();
	
	
	public void TestObjetos() {
		assertEquals(ad,us);
	}
	
	public void TestNull() {
		assertNull(lc.getUbicacion());
	}

	public void TestSame() {
		assertSame(lc, sq);
		
	}

	public void TestNotNull() {
		assertNotNull(lc.getNombre());
	}

	public void TestTrue() {
		assertTrue(lc.isEstado_wifi());
	}

	public void TestFalse() throws SQLException {
		assertFalse(sq.iterarResultado());
	}

	public void TestSame2() {
		assertSame(person, user);
				
	}

	public void TestNull2() {
		assertNull(sq.asisRest);
	}

	public void TestNotNullMethods() {
		assertNotSame(lc.getNombre(),user.getNombre());
	}

	public void TestNotNullConnection() {
		assertNotNull(sq.getConnexion());
	}
}
