import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestStudente {

	Sistema s;
	Studente st;
	Insegnamento i;
	Insegnamento i2;
	Insegnamento i3;
	PianoStudi ps;
	Docente d;
	Appello a;
	
	@Before
	public void setup() {
		s = new Sistema();
		st = new Studente(1, "email", "pw");
		d = new Docente(1,"mail","pass");
		
		i = new Insegnamento(1, "ins1", 12);
		i2 = new Insegnamento(2, "ins2", 6);
		i3 = new Insegnamento(3, "ins3", 6);
		ArrayList<Insegnamento> ins = new ArrayList<>();
		ins.add(i);
		ins.add(i2);
		
		CorsoStudi cs = new CorsoStudi();
		cs.getListAnni().add(new Anno(NomeAnno.L1, 12, ins));
		cs.getListAnni().add(new Anno(NomeAnno.L2, 12, ins));
		
		ArrayList<Insegnamento> ins2 = new ArrayList<Insegnamento>();
		ins2.add(i);
		cs.getListAnni().add(new Anno(NomeAnno.L3, 12, ins2));
		s.getListCorsoStudi().add(cs);
		st.setCorsoStudi(cs);
		
		i.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 11, 0), "E0", "orale", d, s);
		i.creaAppello(new Data(8, 7, 2017, 9, 0), 
				new Data(8, 7, 2017, 11, 0), "E0", "orale", d, s);
		i3.creaAppello(new Data(7, 7, 2017, 9, 0), 
				new Data(7, 7, 2017, 11, 0), "E1", "orale", d, s);
		
		ps = new PianoStudi(ins2, NomeAnno.L1);
		st.getListPianoStudi().add(ps);
		st.getListAppelli().add(a);
		
		
	}
	
	
	@Test
	public void testCompilaPianoOk() {
		ArrayList<Insegnamento> insList = new ArrayList<>();
		insList.add(i);
		
		boolean res = st.compilaPiano(insList, NomeAnno.L1);
		
		assertTrue(res);
	}
	
	@Test
	public void testCompilaPianoNoCrediti() {
		ArrayList<Insegnamento> insList = new ArrayList<>();
		insList.add(i2);
		
		boolean res = st.compilaPiano(insList, NomeAnno.L1);
		
		assertFalse(res);
	}
	
	@Test
	public void testCompilaPianoNoAnno() {
		ArrayList<Insegnamento> insList = new ArrayList<>();
		insList.add(i2);
		
		boolean res = st.compilaPiano(insList, NomeAnno.M2);
		
		assertFalse(res);
	}
	
	@Test
	public void testCompilaPianoAnnoErrato() {
		ArrayList<Insegnamento> insList = new ArrayList<>();
		insList.add(i2);
		
		boolean res = st.compilaPiano(insList, NomeAnno.L3);
		
		assertFalse(res);
	}
	
	
	@Test
	public void testPrenotaAppelloOk() {
		Insegnamento ins = ps.getListInsegnamenti().get(0);
		Appello app1 = ins.getListAppelli().get(0);
		Appello app2 = ins.getListAppelli().get(1);
		
		st.prenotaAppello(app1);
		boolean res = st.prenotaAppello(app2);
		
		assertTrue(res);
	}
	
	@Test
	public void testPrenotaAppelloNo() {
		Insegnamento ins = ps.getListInsegnamenti().get(0);
		Appello app = ins.getListAppelli().get(0);
		
		st.prenotaAppello(app);
		boolean res = st.prenotaAppello(app);
		
		assertFalse(res);
	}
	
	@Test
	public void testPrenotaAppelloNoPianoStudi() {
		Appello app = i3.getListAppelli().get(0);
		
		boolean res = st.prenotaAppello(app);
		
		assertFalse(res);
	}

}
