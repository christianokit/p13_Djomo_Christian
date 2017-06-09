package civ;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Negozio {
    /** Attributes */
    private int id;
    private String nome;
    
    /** Associations */
    private List<Prodotto> prodotti;
    private List<Recensione> recensioni;
    
    
    public Negozio (int id, String nome) {
    	this.id = id;
    	this.nome = nome;
    	
    	prodotti = new ArrayList<>();
    	recensioni = new ArrayList<>();
    }
    
    /**
     * Permette a un Utente di scrivere una Recensione
     * Implementa UC12
     * @param u
     */
    public void infoScriviRecensione(Utente u) {
    	Scanner in = new Scanner (System.in);
    	
    	System.out.print("Inserire un voto: ");
    	int voto = in.nextInt();
    	System.out.print("Recensire il negozio: ");
    	String messaggio = in.next();
    	
    	if(scriviRecensione(u, voto, messaggio)) {
    		System.out.println("Recensione inserita");
    	} else {
    		System.out.println("Utente non autenticato");
    	}
	}
    
    
    /**
     * Permette a un Utente di scrivere una Recensione sul Negozio
     */
    public boolean scriviRecensione(Utente u, int voto, String messaggio) {
    	if(u == null) {	//Se l'utente non è autenticato
			return false;
		}
    	    	
        Recensione rec = new Recensione(voto, messaggio);
        
        recensioni.add(rec);
        return true;
    }
    
    
    /**
     * Ricerca un prodotto venduto in questo negozio
     *
     * @return il prodotto cercato
     */
    public Prodotto ricercaProdotto(Utente u, String nomeProd) {
    	if(u == null || !u.getClass().equals(ManagerNegozio.class)) {	//Se l'utente è un ManagerNegozio
			System.out.println("Utente non autenticato");
			return null;
		}
    	
    	if(!((ManagerNegozio)u).getNegozioGestito().equals(this)) {	//Se u non è il Manager di questo Negozio
    		System.out.println("Utente non autenticato");
			return null;
    	}    	
    	
	    Prodotto prodSelect = null;
    	for(Prodotto p : prodotti) {
    		if(p.getNome().equals(nomeProd)) {
    			prodSelect = p;
    			break;
    		}
	    }
    	return prodSelect;
    }
    
    
    public void registraProdotto(Utente u, Prodotto p, CIV civ) {
    	if(u == null || !u.getClass().equals(ManagerNegozio.class)) {	//Se l'utente è un ManagerNegozio
			System.out.println("Utente non autenticato");
			return;
		}
    	
    	if(!((ManagerNegozio)u).getNegozioGestito().equals(this)) {	//Se u non è il Manager di questo Negozio
    		System.out.println("Utente non autenticato");
			return;
    	}
    	
    	prodotti.add(p);
    	civ.getProdotti().add(p);
    }
    
    
    public List<Prodotto> getProdotti() {
		return prodotti;
	}
    
}