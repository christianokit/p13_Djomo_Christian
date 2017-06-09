package civ;
public class Quantit� {
    /** Attributes */
    private int quantit�;
    
    /** Associations */
    private Prodotto prodotto;
   
    public Quantit� (int q, Prodotto p) {
    	this.prodotto= p;
    	this.quantit�= q;
    }

    /**
     * Restituisce il prezzo della quantit� di Prodotto identificata dall'oggetto
     *
     * @return il prezzo
     */
    public float getPrezzoQuantit�() {
		return quantit� * prodotto.getPrezzo();
        
    }
    
    public Prodotto getProdotto() {
		return prodotto;
	}
}