package civ;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * UC1
 */
public class TestFunzCercaProd {

	public CIV civ;
	public Utente u;
	public Prodotto p1;
	public Prodotto p2;
	
	@Before
	public void init() {
		civ = new CIV();
		p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		civ.getProdotti().add(p1);
		p2 = new Prodotto(2, "Biscotti Mulino Verde", (float)4.5);
		civ.getProdotti().add(p2);
	}

	@Test
	public void testProd() {
		List<Prodotto> list = civ.cercaProdotto("Biscotti");
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testNoProd() {
		List<Prodotto> list = civ.cercaProdotto("rosso");
		
		assertEquals(0, list.size());
	}

}
