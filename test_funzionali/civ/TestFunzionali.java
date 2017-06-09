package civ;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestStrutCIV.class,
	TestFunzCancCarrello.class,
	TestFunzCarrelloAggiungiProd.class,
	TestFunzCercaProd.class,
	TestFunzModificaProd.class,
	TestStrutProdotto.class,
	TestFunzRegNegozio.class,
	TestFunzRimuoviProdCarr.class,
	TestFunzVisualizCarrello.class
})

public class TestFunzionali { }

/**
 * La Test suite ha una statement coverage del 59,6%
 * e una branch coverage del 66,7%
 * 
 */
