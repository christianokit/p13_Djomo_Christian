import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestInsegnamento {

	Sistema s;
	Studente st;
	Insegnamento i;
	Insegnamento i2;
	Docente d;
	
	@Before
	public void setup() {
		s = new Sistema();
		i = new Insegnamento(1, "Ins1", 12);
		d = new Docente(1, " ", " ");
		s.getListInsegnamenti().add(i);
		i.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "orale", d, s);
		
		i2 = new Insegnamento(2, "Ins2", 12);
		s.getListInsegnamenti().add(i2);
		
		st = new Studente(1, "email", "pw");
	}
	
	@Test
	public void testCreaAppelloOk() {
		boolean res1 = i.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 11, 0), "E1", "orale", d, s);
		
		boolean res2 = i.creaAppello(new Data(7, 7, 2017, 11, 0), 
				new Data(7, 7, 2017, 13, 0), "E0", "orale", d, s);
		
		boolean res3 = i.creaAppello(new Data(7, 7, 2017, 8, 0), 
				new Data(7, 7, 2017, 9, 0), "E0", "orale", d, s);
		
		boolean res4 = i.creaAppello(new Data(7, 7, 2017, 8, 0), 
				new Data(7, 7, 2017, 9, 0), "E0", "scritto", d, s);
		
		assertTrue(res1);
		assertTrue(res2);
		assertTrue(res3);
		assertTrue(res4);
	}
	
	@Test
	public void testCreaAppelloErr() {
		boolean res1 = i.creaAppello(new Data(7, 7, 2017, 8, 0), 
				new Data(7, 7, 2017, 10, 0), "E0", "orale", d, s);
		
		boolean res2 = i.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 13, 0), "E0", "orale", d, s);
		
		boolean res3 = i.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 14, 0), "E0", "orale", d, s);
		
		boolean res4 = i.creaAppello(new Data(7, 7, 2017, 10, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "orale", d, s);
		
		boolean res5 = i2.creaAppello(new Data(7, 7, 2017, 10, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "scritto", d, s);
		
		boolean res6 = i2.creaAppello(new Data(7, 7, 2017, 10, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "scritto", d, s);
		
		boolean res7 = i2.creaAppello(new Data(6, 7, 2017, 10, 0), 
				new Data(6, 7, 2017, 9, 0), "E0", "scritto", d, s);
		
		assertFalse(res1);
		assertFalse(res2);
		assertFalse(res3);
		assertFalse(res4);
		assertFalse(res5);
		assertFalse(res6);
		assertFalse(res7);
	}
	
	@Test
	public void testCancellaAppelloOk() {
		Appello a = i.getListAppelli().get(0);
		a.getListStudenti().add(st);
		
		boolean res = i.cancellaAppello(a);
		
		assertTrue(res);
	}
	
	@Test
	public void testCancellaAppelloNo() {
		Appello a = new Appello(new Data(7, 7, 2017, 10, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "scritto", null, null);
		
		boolean res = i.cancellaAppello(a);
		
		assertFalse(res);
	}
	
	@Test
	public void testModificaAppelloOk() {
		Appello a = i.getListAppelli().get(0);
		
		boolean res = i.modificaAppello(a, a.getDataInizio(),
					a.getDataFine(), "E2", "scritto", d, s);
		
		assertTrue(res);
	}
	
	
	@Test
	public void testModificaAppelloNo() {
		Appello a = i.getListAppelli().get(0);
		
		boolean res = i.modificaAppello(a, a.getDataFine(),
					a.getDataInizio(), "E2", "scritto", d, s);
		
		assertFalse(res);
	}
	
	@Test
	public void testModificaAppelloNoAppello() {
		Appello a = new Appello(new Data(8, 7, 2017, 9, 0), 
				new Data(8, 7, 2017, 11, 0), "E0", "orale", i, d);
		
		boolean res = i.modificaAppello(a, a.getDataInizio(),
					a.getDataFine(), "E2", "scritto", d, s);
		
		assertFalse(res);
	}
	
	@Test
	public void testEqualsInsegnamento() {
		Insegnamento i = new Insegnamento(1, "Nome", 12);
		
		Insegnamento i2 = new Insegnamento(1, "Nome", 12);
		
		assertTrue(i.equals(i));
		
		assertFalse(i.equals(null));
		
		assertFalse(i.equals(new String()));
		
		assertTrue(i.equals(i2));
		
		i2 = new Insegnamento(1, "Nome", 6);
		assertFalse(i.equals(i2));
		
		i2 = new Insegnamento(2, "Nome", 12);
		assertFalse(i.equals(i2));
		
		i2 = new Insegnamento(1, "Nome2", 12);
		assertFalse(i.equals(i2));
		
		i = new Insegnamento(1, null, 12);
		assertFalse(i.equals(i2));
		
	
		
		
		
		
		}
	
	

}
