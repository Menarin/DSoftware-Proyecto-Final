package Test;

import TDAs.Local;
import TDAs.Persona;
import TDAs.SqlConection;
import TDAs.Usuario;
import controller.AddClienteController;
import controller.AddUsuarioController;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.SQLException;


public class MyTest extends TestCase {

    AddClienteController ad = new AddClienteController();

    AddUsuarioController us = new AddUsuarioController();

    Local lc = new Local ();

    SqlConection sq = SqlConection.getInstance();

    Persona person = new Persona();

    Usuario user = new Usuario();



    @Test
    public void TestObjetos() {

        assertEquals(ad,us);

    }


    @Test
    public void TestNull() {

        assertNull(lc.getUbicacion());

    }


    @Test
    public void TestSame() {

        assertSame(lc, sq);



    }

    @Test
    public void TestNotNull() {

        assertNotNull(lc.getNombre());

    }


    @Test
    public void TestTrue() {

        assertTrue(lc.isEstado_wifi());

    }


    @Test
    public void TestFalse() throws SQLException {

        assertFalse(sq.iterarResultado());

    }


    @Test
    public void TestSame2() {

        assertSame(person, user);



    }


    @Test
    public void TestNull2() {

        assertNull(sq.asisRest);

    }


    @Test
    public void TestNotNullMethods() {

        assertNotSame(lc.getNombre(),user.getNombre());

    }


    @Test
    public void TestNotNullConnection() {

        assertNotNull(sq.getConnexion());

    }

}