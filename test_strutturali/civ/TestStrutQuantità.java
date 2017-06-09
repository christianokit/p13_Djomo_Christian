package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStrutQuantit� {

	Quantit� q;
	Prodotto p;
	
	@Before
	public void init() {
		p = new Prodotto(1, "Prodotto", (float)3.5);
		q = new Quantit�(4, p);
	}
	
	@Test
	public void test() {
		assertEquals(14, q.getPrezzoQuantit�(), 0.0);
	}

}
