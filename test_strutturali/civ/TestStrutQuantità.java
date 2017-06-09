package civ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStrutQuantità {

	Quantità q;
	Prodotto p;
	
	@Before
	public void init() {
		p = new Prodotto(1, "Prodotto", (float)3.5);
		q = new Quantità(4, p);
	}
	
	@Test
	public void test() {
		assertEquals(14, q.getPrezzoQuantità(), 0.0);
	}

}
