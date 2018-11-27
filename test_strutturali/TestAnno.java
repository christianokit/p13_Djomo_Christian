import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestAnno {

	Anno a;
	
		
	
	@Before
	public void setUp() {
		Insegnamento i = new Insegnamento(1, "ins1", 12);
		Insegnamento i2 = new Insegnamento(2, "ins2", 6);
		ArrayList<Insegnamento> ins = new ArrayList<>();
		ins.add(i);
		ins.add(i2);
		
		a = new Anno(NomeAnno.L1, 12, ins);
		
		NomeAnno a1 = a.getAnno();
		int crediti = a.getCreditiRichiesti();

	}
	
	@Test
	public void testOk() {
		Insegnamento i = new Insegnamento(1, "ins1", 12);
		boolean res = a.isInsegnamentoInAnno(i);
		
		assertTrue(res);
		
		Insegnamento i2 = new Insegnamento(3, "ins3", 6);
		res = a.isInsegnamentoInAnno(i2);
		
		assertFalse(res);
	}

}
