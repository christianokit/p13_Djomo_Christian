package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * UC6
 */
public class TestFunzCancCarrello {
	private Carrello c;
	private Utente u;
	private Prodotto p;
	
	@Before	//Eseguo prima di OGNI test
	public void init() {
		c = new Carrello(); 
		u = new Utente(1, "mail", "pw", "nome", 
				"cognome", "indirizzo");
		p = new Prodotto(1, "Prodotto", (float)3.5);
	}

	@Test
	public void testCancellaProdotto() {
		c.aggiungiProdotto(u, p, 3);
		
		assertEquals(true, c.cancellaProdotto(u, p));
	}
	
	@Test
	public void testCancellaNoProdotto() {
		c.aggiungiProdotto(u, p, 3);
		
		assertEquals(false, c.cancellaProdotto(u, null));
	}
	
}
