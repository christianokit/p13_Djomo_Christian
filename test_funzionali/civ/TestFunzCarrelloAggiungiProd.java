package civ;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestFunzCarrelloAggiungiProd {

	private Carrello c;
	private Utente u;
	private Prodotto p;
	private int num;
	private int expect;
	
	public TestFunzCarrelloAggiungiProd(Utente u, Prodotto p, int num, int expect) {
		this.p = p;
		this.u = u;
		this.num = num;
		this.expect = expect;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		Utente u = new Utente(1, "mail", "pw", "nome", 
				"cognome", "indirizzo");
		Prodotto p = new Prodotto(1, "Prodotto", (float)3.5);
		
		return Arrays.asList(new Object[][]{
				{u, p, 3, 1},
				{null, p, 3, 0},
				{u, null, 3, 0},
				{u, p, -3, 0}
		});
	}
	
	@Before	//Eseguo prima di OGNI test
	public void init() {
		c = new Carrello(); 
	}
	
	@Test
	public void test() {	
		c.aggiungiProdotto(u, p, num);
		
		assertEquals(expect, c.getListaProdotti().size());	
	}

}
