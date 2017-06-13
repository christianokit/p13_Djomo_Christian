package civ;
public class Quantita {
    /** Attributes */
    private int quantita;
    
    /** Associations */
    private Prodotto prodotto;
   
    public Quantita (int q, Prodotto p) {
    	this.prodotto= p;
    	this.quantita= q;
    }

    /**
     * Restituisce il prezzo della quantita' di Prodotto identificata dall'oggetto
     *
     * @return il prezzo
     */
    public float getPrezzoQuantita() {
		return quantita * prodotto.getPrezzo();
        
    }
    
    public Prodotto getProdotto() {
		return prodotto;
	}
}