import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestAnno.class,
	TestInsegnamento.class,
	TestSistema.class,
	TestStudente.class,
}) 


public class TestSuiteStrut {

}



/*
 * Lo statement coverage della suite strutturale
 * non raggiunge il 100% perché non si vanno a 
 * testare funzioni di supporto
 */