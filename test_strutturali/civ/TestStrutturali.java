package civ;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestStrutCarrello.class,
	TestStrutCIV.class,
	TestStrutManagerCIV.class,
	TestStrutManagerNegozio.class,
	TestStrutProdotto.class,
	TestStrutNegozio.class,
	TestStrutQuantità.class
})

/**
 * La test suite non raggiunge il 100% di copertura perché
 * non sono stati testati diversi metodi setter e getter,
 * alcuni metodi sono di use case che non sono stati implementati,
 * e alcuni metodi gestiscono l'interfaccia grafica col sistema.
 */
public class TestStrutturali { }
