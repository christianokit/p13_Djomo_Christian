package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStrutManagerNegozio {

	CIV civ;
	ManagerNegozio m;
	Negozio n;
	
	@Before	//Eseguo prima di OGNI test
	public void init() {
		civ = new CIV();
		m = new ManagerNegozio(1, "mail", "pw", "nome", "cognome", "indirizzo");
		civ.getUtenti().add(m);
		civ.autentica("mail", "pw");
		
		n = new Negozio(1, "Negozio");
		m.setNegozioGestito(n);
	}
	
	@Test
	public void testInserisciProdotto() {
		m.inserisciProdotto(civ, 1, "Biscotti Mulino Bianco", (float)3.5);
		
		assertEquals(1, civ.getProdotti().size());
	}
	
	@Test
	public void testModificaProd() {
		m.inserisciProdotto(civ, 1, "Biscotti Mulino Bianco", (float)3.5);
		Prodotto p = n.ricercaProdotto(m, "Biscotti Mulino Bianco");
		m.modificaProdotto(p, (float)4.5);
		
		assertEquals(4.5, p.getPrezzo(), 0.0);
	}

	@Test
	public void testModificaProdPrezzoErrato() {	
		m.inserisciProdotto(civ, 1, "Biscotti Mulino Bianco", (float)3.5);
		Prodotto p = n.ricercaProdotto(m, "Biscotti Mulino Bianco");
		m.modificaProdotto(p, (float)-4.5);
		
		assertEquals(3.5, p.getPrezzo(), 0.0);
	}
	
	@Test
	public void testEliminaProd() {
		m.inserisciProdotto(civ, 1, "Biscotti Mulino Bianco", (float)3.5);
		Prodotto p = n.ricercaProdotto(m, "Biscotti Mulino Bianco");
		
		boolean response = m.eliminaProdotto(p);
		
		assertEquals(true, response);
	}
	
	@Test
	public void testEliminaProdNonList() {
		m.inserisciProdotto(civ, 1, "Biscotti Mulino Bianco", (float)3.5);
		
		Prodotto p2 = new Prodotto(1, "Biscotti Mulino Giallo", (float)3.5);
		
		boolean response = m.eliminaProdotto(p2);
		
		assertEquals(false, response);
	}
	
}
