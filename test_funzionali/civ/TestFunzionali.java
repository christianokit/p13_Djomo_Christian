package civ;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestFunzAutenticazione.class,
	TestFunzRecensione.class,
	TestFunzCancCarrello.class,
	TestFunzCarrelloAggiungiProd.class,
	TestFunzCercaProd.class,
	TestFunzEliminaProdManger.class,
	TestFunzModificaProd.class,
	TestFunzRegNegozio.class,
	TestFunzRimuoviProdCarr.class,
	TestFunzVisualizCarrello.class
})

public class TestFunzionali { }

/**
 * La Test suite ha una statement coverage del 53,2%
 * e una branch coverage del 62,9%
 * 
 */
