package civ;
import java.util.Scanner;

public class ManagerNegozio extends Utente {
	/** Associations */
    private Negozio negozioGestito; 

	public ManagerNegozio(int id, String email, String password, String nome, String cognome, String indirizzo) {
    	super(id, email, password, nome, cognome, indirizzo);
    }
    
    public void infoInserisciProdotto(CIV civ) {
    	Scanner in = new Scanner (System.in);
		System.out.print("Inserire l'id del prodotto: ");
		int id = in.nextInt();
		System.out.print("Inserire il nome del prodotto: ");
		String nome = in.next();
		System.out.print("Inserire il nome prezzo del prodotto: ");
		float prezzo = in.nextFloat();
		
		inserisciProdotto(civ, id, nome, prezzo);
	}
    
    public void inserisciProdotto(CIV civ, int id, String nome, float prezzo) {
		Prodotto p = new Prodotto (id, nome, prezzo);
		negozioGestito.registraProdotto(this, p, civ);
	    
	}
	
    /**
     * Permette di modificare i dati di un Prodotto
     * Implementa UC16
     */
    public void infoModificaProdotto() {
    	System.out.print("Inserire il nome del prodotto: ");
    	Scanner in = new Scanner (System.in);
    	String nomeProd = in.next();
    	Prodotto prodSelect = negozioGestito.ricercaProdotto(this, nomeProd);
    	
	    if(prodSelect == null) {
	    	System.out.println("Prodotto non trovato");
	    	return;
	    }
	    
	    //chiedi nuovo prezzo	
	    System.out.print("Inserire il nuovo prezzo: ");
	    float newPrezzo = in.nextFloat();
	    
	    modificaProdotto(prodSelect, newPrezzo);
    }
    
    public void modificaProdotto(Prodotto prodSelect, float newPrezzo) {
	    if(newPrezzo <= 0.0) {
	    	System.out.print("Prezzo inserito errato");
	    	return;
	    }
	    
	    prodSelect.setPrezzo(newPrezzo);
	    System.out.print("Prezzo aggiornato correttamente");
	    return;
	    
    }
    
    
    public void infoEliminaProdotto() {
    	System.out.print("Inserire il nome del prodotto: ");
    	Scanner in = new Scanner (System.in);
    	String nomeProd = in.next();
    	Prodotto prodSelect = negozioGestito.ricercaProdotto(this, nomeProd);
    	
    	if(prodSelect == null) {
    		System.out.println("Prodotto non trovato");
    		return;
    	}		
    	
    	eliminaProdotto(prodSelect);
	}
    
    /**
     * Permette di eliminare un Prodotto dalla lista dei Prodotti venduti
     * 	da un Negozio
     * Implementa UC17
     * @param prodSelect Prodotto da eliminare
     * @return true se il Prodotto è stato eliminato, false altrimenti
     */
    public boolean eliminaProdotto(Prodotto prodSelect) {   	
    	if(negozioGestito.getProdotti().remove(prodSelect)) {
    		System.out.println("Prodotto rimosso");
    		return true;
    	} else {
    		System.out.println("Prodotto non rimosso");
    		return false;
    	}
	}
    
    public Negozio getNegozioGestito() {
		return negozioGestito;
	}
    
    public void setNegozioGestito(Negozio negozioGestito) {
		this.negozioGestito = negozioGestito;
	}
    
}
