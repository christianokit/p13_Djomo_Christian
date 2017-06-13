package civ;
/**
 * Contiene l'elenco dei Prodotti che l'Utente desidera acquistare
 */
public class Carrello extends Acquisto {
	
	public Carrello() {
		super();
	}
	
    /**
     * Aggiunge una certa quantità di un Prodotto al Carrello
     * Implementa UC4
     *
     * @param u Utente che effettua l'operazione
     * @param p Prodotto da inserire nel Carrello
     * @param num quantità del prodotto da inserire nel Carrello
     */
    public void aggiungiProdotto (Utente u, Prodotto p, int num) {
    	if(u == null) {	//Se l'utente non è autenticato
			System.out.println("Utente non autenticato");
			return;
		}
    	
    	if(num <= 0 || p == null) {	//Se num non e' valido
    		return;
    	}
    	
        Quantita q = new Quantita(num, p);
        listaProdotti.add(q);
    }
    
    
    /**
     * Cancella un Prodotto dal Carrello
     * Implementa UC6
     *
     * @param u Utente che effettua l'operazione
     * @param p Prodotto da eliminare
     */
    public boolean cancellaProdotto (Utente u, Prodotto p) {
    	if(u == null) {	//Se l'utente non e' autenticato
			System.out.println("Utente non autenticato");
			return false;
		}
    	
    	for(Quantita q : listaProdotti) {
    		if(q.getProdotto().equals(p)) {
    			listaProdotti.remove(q);
    			return true;
    		}
    	}
    	
    	return false;
    }
    
}

