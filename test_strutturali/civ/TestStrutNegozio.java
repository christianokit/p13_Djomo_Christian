package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStrutNegozio {

	private Negozio n;
	private CIV civ;
	private Utente u;
	
	@Before
	public void init() {
		n = new Negozio(1, "Negozio");
		u = new Utente(1, "mail", "pw", "nome", "cognome", "indirizzo");
		civ = new CIV();
	}
	
	@Test
	public void testRecensione() {
		boolean response = n.scriviRecensione(u, 4, "Bello");
		
		assertEquals(true, response);
	}
	
	@Test
	public void testRecensioneNoUser() {
		boolean response = n.scriviRecensione(null, 4, "Bello");
		
		assertEquals(false, response);
	}
	
	@Test
	public void testRicercaProdotto() {
		u = new ManagerNegozio(1, "mail", "pw", "nome", "cognome", "indirizzo");
		((ManagerNegozio)u).setNegozioGestito(n);
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		n.getProdotti().add(p1);
		
		Prodotto p = n.ricercaProdotto(u, "Biscotti Mulino Bianco");
		
		assertEquals(p1, p);
	}

	@Test
	public void testRicercaProdottoNoProd() {
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		n.getProdotti().add(p1);
		
		Prodotto p = n.ricercaProdotto(u, "Biscotti Mulino Verde");
		
		assertNull(p);
	}
	
	
	@Test
	public void testRicercaProdottoNoNeg() {
		u = new ManagerNegozio(1, "mail", "pw", "nome", "cognome", "indirizzo");
		((ManagerNegozio)u).setNegozioGestito(new Negozio(2, "Altro negozio"));
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		n.getProdotti().add(p1);
		
		Prodotto p = n.ricercaProdotto(u, "Biscotti Mulino Bianco");
		
		assertNull(p);
	}

	@Test
	public void testRegistraProdotto() {
		u = new ManagerNegozio(1, "mail", "pw", "nome", "cognome", "indirizzo");
		((ManagerNegozio)u).setNegozioGestito(n);
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		
		n.registraProdotto(u, p1, civ);
		
		assertEquals(1, n.getProdotti().size());
	}

	@Test
	public void testRegistraProdottoNouser() {
//		u = null;
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		
		n.registraProdotto(u, p1, civ);
		
		assertEquals(0, n.getProdotti().size());
	}
	
	
	@Test
	public void testRegistraProdottoNoNeg() {
		u = new ManagerNegozio(1, "mail", "pw", "nome", "cognome", "indirizzo");
		((ManagerNegozio)u).setNegozioGestito(new Negozio(2, "Altro negozio"));
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		
		n.registraProdotto(u, p1, civ);
		
		assertEquals(0, n.getProdotti().size());
	}
	
}
