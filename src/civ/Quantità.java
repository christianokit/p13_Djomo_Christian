package civ;
public class Quantità {
    /** Attributes */
    private int quantità;
    
    /** Associations */
    private Prodotto prodotto;
   
    public Quantità (int q, Prodotto p) {
    	this.prodotto= p;
    	this.quantità= q;
    }

    /**
     * Restituisce il prezzo della quantità di Prodotto identificata dall'oggetto
     *
     * @return il prezzo
     */
    public float getPrezzoQuantità() {
		return quantità * prodotto.getPrezzo();
        
    }
    
    public Prodotto getProdotto() {
		return prodotto;
	}
}