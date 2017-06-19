package civ;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * UC16
 */
@RunWith(Parameterized.class)
public class TestFunzModificaProd {

	private CIV civ;
	private ManagerNegozio m;
	private Negozio n;
	private Float expect;
	private String query;
	private float newPrezzo;
	
	public TestFunzModificaProd(String query, float newPrezzo, Float expect) {
		this.query = query;
		this.newPrezzo = newPrezzo;
		this.expect = expect;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"Biscotti Mulino Bianco", (float)4.5, (float)4.5},
				{"Biscotti Mulino Bianco", (float)-4.5, (float)3.5},
				{"Biscotti", (float)4.5, null},
		});
	}
	
	@Before	//Eseguo prima di OGNI test
	public void init() {
		civ = new CIV();
		m = new ManagerNegozio(1, "mail", "pw", "nome", "cognome", "indirizzo");
		civ.getUtenti().add(m);
		civ.autentica("mail", "pw");
		
		n = new Negozio(1, "Negozio");
		m.setNegozioGestito(n);
		
		m.inserisciProdotto(civ, 1, "Biscotti Mulino Bianco", (float)3.5);
	}
	
	@Test
	public void test() {	
		Prodotto p = n.ricercaProdotto(m, query);
		
		if(p == null) {
			assertEquals(expect, p);
			return;
		}
		
		m.modificaProdotto(p, newPrezzo);
		
		assertEquals(expect, p.getPrezzo(), 0.0);
	}

}
