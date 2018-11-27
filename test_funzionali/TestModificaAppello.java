import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestModificaAppello {

	Sistema s;
	Insegnamento i;
	Insegnamento i2;
	Docente d;
	
	@Before
	public void setup(){
		s = new Sistema();
		d = new Docente(1,"mail","pass");
		i = new Insegnamento(1, "Ins1", 12);
		i.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "orale", d, s);
		i2 = new Insegnamento(2, "Ins2", 6);
		i2.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 11, 0), "E1", "scritto", d, s);
	}

	
	@Test
	public void testOk() {
		Appello a = i.getListAppelli().get(0);
		
		boolean res = i.modificaAppello(a, a.getDataInizio(),
					a.getDataFine(), "E2", "scritto", d, s);
		
		assertTrue(res);
	}
	
	
	@Test
	public void testNo() {
		Appello a = i.getListAppelli().get(0);
		
		boolean res = i.modificaAppello(a, a.getDataFine(),
					a.getDataInizio(), "E2", "scritto", d, s);
		
		assertFalse(res);
		Appello a1 = i2.getListAppelli().get(0);
		
		boolean res1 = i.modificaAppello(a1, a1.getDataInizio(),
					a.getDataFine(), "E2", "scritto", d, s);
		
		assertFalse(res1);
		
		
		
	}
	
}
