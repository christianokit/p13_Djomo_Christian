package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStrutManagerCIV {

	ManagerCIV m;
	CIV civ;
	
	@Before
	public void init() {
		civ = new CIV();
		m = new ManagerCIV(1, "manager", "pw", "nome", "cognome", "indirizzo");
		civ.getUtenti().add(m);
		m.setCivGestito(civ);
		civ.autentica("manager", "pw");
	}

	@Test
	public void test() {
		m.aggiungiNegozio(1, "Negozio");
		
		assertEquals(1, civ.getElencoNegozi().size());
	}
	
}
