import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSistema {

	String email;
	String pw;
	Sistema s;
	Utente u1;
	Utente u2;
	
	@Before
	public void setup(){
		email = new String("");
		pw = new String ("");
		s = new Sistema();
		u1= new Utente(1,"email1","pw1");
		u2= new Utente(2,"email2","pw2");
		s.getListUtenti().add(u1);
		s.getListUtenti().add(u2);
	
	}
	
	@Test
	public void testAutenticazione1() {
		boolean res = s.autentica("email1", "pw1");
		
		assertTrue(res);
		
	}
	
	@Test
	public void testAutenticazione2() {
		boolean res = s.autentica("email5", "pw1");
		
		assertFalse(res);
	}

	@Test
	public void testAutenticazione3() {
		boolean res = s.autentica("email2", "pw1");
		
		assertFalse(res);

	}

}
