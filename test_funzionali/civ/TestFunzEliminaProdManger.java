package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFunzEliminaProdManger {

	Negozio n;
	ManagerNegozio m;
	Prodotto p;
	
	@Before
	public void init() {
		m = new ManagerNegozio(1, "mail", "pw", "nome", "cognome", "indirizzo");
		n = new Negozio(1, "Negozio");
		
		m.setNegozioGestito(n);
		
		p = new Prodotto(1, "Biscotti", (float)3.5);
		
		n.getProdotti().add(p);

	}
	
	
	@Test
	public void testEliminaOk() {
		boolean result = m.eliminaProdotto(p);
		
		assertTrue(result);
	}
	
	@Test
	public void testEliminaNo() {
		Prodotto p2 = new Prodotto(2, "Salame", (float)2.7);
		
		boolean result = m.eliminaProdotto(p2);
		
		assertFalse(result);
	}

}
