import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

@RunWith(Parameterized.class)
public class TestAutenticazione {
	String email;
	String pw;
	Sistema s;
	Utente u1;
	Utente u2;
	boolean res;
	
	public TestAutenticazione(String email, String pw, boolean res) {
		this.email = email;
		this.pw = pw;
		this.res = res;
	}
	
	
	@Before
	public void setup(){
		
		s = new Sistema();
		u1= new Utente(1,"email1","pw1");
		u2= new Utente(2,"email2","pw2");
		s.getListUtenti().add(u1);
		s.getListUtenti().add(u2);
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{ "email1", "pw1", true },
			{ "email5", "pw1", false},
			{"email2", "pw1", false}
		});
	}
	
	@Test
	public void testAutenticazione1() {
		boolean result = s.autentica(email, pw);
		
		assertEquals(res, result);
		
	}
	
}
