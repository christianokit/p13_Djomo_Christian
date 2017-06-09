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
 * UC23
 */
@RunWith(Parameterized.class)
public class TestFunzRegNegozio {

	private CIV civ;
	private ManagerCIV m;
	private Negozio n;

	private int id;
	private String nome;
	private int expect;
	
	public TestFunzRegNegozio(int id, String nome, int expect) {
		this.id = id;
		this.nome = nome;
		this.expect = expect;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{1, "Negozio", 1},
		});
	}
	
	@Before	//Eseguo prima di OGNI test
	public void init() {
		civ = new CIV();
		m = new ManagerCIV(1, "mail", "pw", "nome", "cognome", "indirizzo");
		civ.getUtenti().add(m);
		m.setCivGestito(civ);
		civ.autentica("mail", "pw");
	}
	
	@Test
	public void test() {	
		m.aggiungiNegozio(id, nome);
		
		assertEquals(expect, civ.getElencoNegozi().size());
	}

}
