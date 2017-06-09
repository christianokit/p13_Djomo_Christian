package civ;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestStrutCIV {

	CIV civ = new CIV();
	
	@Before
	public void init() {
		civ = new CIV();
		civ.getUtenti().add(new Utente(1, "mail", "pw", "nome", "cognome", "indirizzo"));
		civ.getUtenti().add(new Utente(2, "mail2", "pw2", "nome2", "cognome2", "indirizzo2"));
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		civ.getProdotti().add(p1);
		Prodotto p2 = new Prodotto(2, "Biscotti Mulino Verde", (float)4.5);
		civ.getProdotti().add(p2);
	}
	
	@Test
	public void testCredenzialiOk() {
		boolean response = civ.autentica("mail2", "pw2");
		
		assertEquals(true, response);
	}
	
	@Test
	public void testCredenzialiErrate() {
		boolean response = civ.autentica("mail", "wrongpw");
		
		assertEquals(false, response);
	}
	
	@Test
	public void testRegistraUtente() {
		boolean response = civ.registraUtente(1, "mail", "pw", "nome", "cognome", "indirizzo");
		
		assertEquals(true, response);
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
	
	@Test
	public void testRegistraNegozio() {
		civ.getUtenti().add(new ManagerCIV(3, "manager", "pwm", "nome", "cognome", "indirizzo"));
		civ.autentica("manager", "pwm");
		
		boolean response = civ.registraNegozio(new Negozio(1, "Negozio"));
		
		assertEquals(true, response);
	}
	
	@Test
	public void testRegistraNegozioNoUser() {	
		boolean response = civ.registraNegozio(new Negozio(1, "Negozio"));
		
		assertEquals(false, response);
	}
	

}
