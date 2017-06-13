package civ;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * UC5
 * 
 */
public class TestFunzVisualizCarrello {

	public CIV civ;
	public Utente u;
	public Prodotto p1;
	
	@Before
	public void init() {
		civ = new CIV();
		u = new Utente(1, "mail", "pw", "nome", "cognome", "indirizzo");
		civ.getUtenti().add(u);
		p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		civ.getProdotti().add(p1);
		civ.autentica("mail", "pw");
	}

	@Test
	public void testProd() {
		civ.getCurrentUser().getCarrello().aggiungiProdotto(u, p1, 3);
		
		List<Quantita> list = civ.getCurrentUser().getCarrello().getListaProdotti();
		
		assertTrue(list.size() != 0);
	}
	
	@Test
	public void testNoProd() {
		List<Quantita> list = civ.getCurrentUser().getCarrello().getListaProdotti();
		
		assertEquals(0, list.size());
	}

}
