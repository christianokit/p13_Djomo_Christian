import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestAutenticazione.class,
	TestCancellareAppello.class,
	TestCompilaPianoStudi.class,
	TestCreaAppello.class,
	TestModificaAppello.class,
	TestPrenotaAppello.class,
}) 

public class TestSuiteFunz {
	
}


/*
 * Questa test suite ha un'adeguatezza rispetto
 * allo statement coverage del 84.3%
 * e rispetto al branch coverage del 78.1%
 */