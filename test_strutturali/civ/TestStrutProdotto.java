package civ;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestStrutProdotto {

	public CIV civ;
	public Utente u;
	public Prodotto p1;
	
	@Before
	public void init() {
		civ = new CIV();
		u = new Utente(1, "mail", "pw", "nome", "cognome", "indirizzo");
		civ.getUtenti().add(u);
		p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
	}
	
	@Test
	public void test() {
		boolean response = p1.scriviRecensione(u, 4, "Bello");
		
		assertEquals(true, response);
	}

	@Test
	public void testNoUser() {
		boolean response = p1.scriviRecensione(null, 4, "Bello");
		
		assertEquals(false, response);
	}

}
