package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStrutCarrello {

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
	public void testAggiungiProdotto() {
		
		int oldSize = c.getListaProdotti().size();
		
		c.aggiungiProdotto(u, p, 3);
		
		assertEquals(oldSize+1, c.getListaProdotti().size());
	}
	
	@Test
	public void testAggiungiProdottoNoUtente() {
		
		int oldSize = c.getListaProdotti().size();
		
		c.aggiungiProdotto(null, p, 3);
		
		assertEquals(oldSize, c.getListaProdotti().size());
	}
	
	@Test
	public void testAggiungiProdottoNeg() {
		int oldSize = c.getListaProdotti().size();
		
		c.aggiungiProdotto(u, p, -3);
		
		assertEquals(oldSize, c.getListaProdotti().size());
	}

	@Test
	public void testCancellaProdotto() {
		c.aggiungiProdotto(u, p, 3);
		
		int oldSize = c.getListaProdotti().size();
		
		c.cancellaProdotto(u, p);
		
		assertEquals(oldSize-1, c.getListaProdotti().size());
	}
	
	@Test
	public void testCancellaProdottoNoUtente() {
		c.aggiungiProdotto(u, p, 3);
		
		int oldSize = c.getListaProdotti().size();
		
		c.cancellaProdotto(null, p);
		
		assertEquals(oldSize, c.getListaProdotti().size());
	}
	
	@Test
	public void testCancellaNoProdotto() {
		c.aggiungiProdotto(u, p, 3);
		
		int oldSize = c.getListaProdotti().size();
		
		c.cancellaProdotto(u, null);
		
		assertEquals(oldSize, c.getListaProdotti().size());		
	}
}
