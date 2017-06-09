package civ;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * UC6
 */
public class TestFunzRimuoviProdCarr {

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
		civ.getCurrentUser().getCarrello().aggiungiProdotto(u, p1, 3);
	}
	
	@Test
	public void testProd() {
		boolean response = civ.getCurrentUser().getCarrello().cancellaProdotto(u, p1);
		
		assertEquals(true, response);
	}
	
	@Test
	public void testNoProd() {
		boolean response = civ.getCurrentUser().getCarrello().cancellaProdotto(u, null);
		
		assertEquals(false, response);
	}


}
