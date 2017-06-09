package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * UC3
 */
public class TestFunzAutenticazione {

	CIV civ = new CIV();
	
	@Before
	public void init() {
		civ = new CIV();
		civ.getUtenti().add(new Utente(1, "mail", "pw", "nome", "cognome", "indirizzo"));
		civ.getUtenti().add(new Utente(2, "mail2", "pw2", "nome2", "cognome2", "indirizzo2"));
	}
	
	@Test
	public void testCredenzialiOk() {
		boolean response = civ.autentica("mail2", "pw2");
		
		assertEquals(true, response);
	}
	
	@Test
	public void testCredenzialiErrate() {
		boolean response = civ.autentica("mail2", "wrongpw");
		
		assertEquals(false, response);
	}

}
