import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestCompilaPianoStudi {
	
	Sistema s;
	Studente st;
	Insegnamento i;
	Insegnamento i2;
	Insegnamento i3;
	
	@Before
	public void setup() {
		s = new Sistema();
		st = new Studente(1, "email", "pw");
		
		i = new Insegnamento(1, "ins1", 12);
		i2 = new Insegnamento(2, "ins2", 6);
		i3 = new Insegnamento(3, "ins3", 6);
		ArrayList<Insegnamento> ins = new ArrayList<>();
		ins.add(i);
		ins.add(i2);
		
		CorsoStudi cs = new CorsoStudi();
		cs.getListAnni().add(new Anno(NomeAnno.L1, 12, ins));
		cs.getListAnni().add(new Anno(NomeAnno.L2, 12, ins));
		s.getListCorsoStudi().add(cs);
		st.setCorsoStudi(cs);
		
	}
	
	
	@Test
	public void testOk() {
		ArrayList<Insegnamento> insList = new ArrayList<>();
		insList.add(i);
		
		boolean res = st.compilaPiano(insList, NomeAnno.L1);
		
		assertTrue(res);
	}
	
	@Test
	public void testNoCrediti() {
		ArrayList<Insegnamento> insList = new ArrayList<>();
		insList.add(i2);
		
		boolean res = st.compilaPiano(insList, NomeAnno.L1);
		
		assertFalse(res);
		
		ArrayList<Insegnamento> insList1 = new ArrayList<>();
		insList1.add(i3);
		
		boolean res1 = st.compilaPiano(insList1, NomeAnno.L1);
		
		assertFalse(res1);
	}

}
