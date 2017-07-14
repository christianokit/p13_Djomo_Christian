import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestPrenotaAppello {
	Sistema s;
	Insegnamento i;
	Insegnamento i2;
	Studente st;
	PianoStudi ps;
	Docente d;
	@Before
	public void setup(){
		 s = new Sistema();
		 d = new Docente(1,"mail","pass");
		 i = new Insegnamento(1, "Ins1", 12);
		 i2 = new Insegnamento(2, "Ins2", 12);
		 i.creaAppello(new Data(7, 7, 2017, 9, 0), 
					new Data(7, 7, 2017, 11, 0), "E0", "orale", d, s);
		 i2.creaAppello(new Data(7, 7, 2017, 9, 0), 
					new Data(7, 7, 2017, 11, 0), "E1", "orale", d, s);
		 ArrayList<Insegnamento> ins = new ArrayList<Insegnamento>();
		 ins.add(i);
		 ps = new PianoStudi(ins, NomeAnno.L1);
		 st = new Studente(1,"email", "pw");
		 st.getListPianoStudi().add(ps);
	}
	
	@Test
	public void testOk() {
		Insegnamento ins = ps.getListInsegnamenti().get(0);
		Appello app = ins.getListAppelli().get(0);
		
		
		boolean res = st.prenotaAppello(app);
		
		assertTrue(res);
		
	}
	
	@Test
	public void testNo() {
		Insegnamento ins = ps.getListInsegnamenti().get(0);
		Appello app = ins.getListAppelli().get(0);
		
		st.prenotaAppello(app);
		boolean res = st.prenotaAppello(app); // prenoto di nuovo l'appello app già prenotato
		
		assertFalse(res);
	}
	
	@Test
	public void testNoPianoStudi() {
		Appello app = i2.getListAppelli().get(0);
		
		boolean res = st.prenotaAppello(app);
		
		assertFalse(res);
	}
	
}
