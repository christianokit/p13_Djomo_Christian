import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCancellareAppello {

	Sistema s;
	Insegnamento i;
	Insegnamento i2;
	Docente d;
	Studente st;
	@Before
	public void setup(){
		s = new Sistema();
		d = new Docente(1,"mail","pass");
		st = new Studente(1, "mail","pw");
		i = new Insegnamento(1, "Ins1", 12);
		i2 = new Insegnamento(2, "Ins2", 22);
		i.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "scritto", d, s);
		i2.creaAppello(new Data(6, 7, 2017, 9, 0), 
				new Data(6, 7, 2017, 11, 0), "E0", "scritto", d, s);
	}

	
	@Test
	public void testOk() {
		Appello a = i.getListAppelli().get(0);
		
		
		boolean res = i.cancellaAppello(a);
		
		assertTrue(res);
	}
	
	
	@Test
	public void testNo() {
		Appello a1 = i2.getListAppelli().get(0);
		
		boolean res1 = i.cancellaAppello(a1);
		
		assertFalse(res1);
	}

}
