package civ;
import java.util.Scanner;
import java.util.ArrayList;

public class Prodotto {
    /** Attributes */
    private int id;
    private String nome;
    private float prezzo;
    
    /** Associations */
    private ArrayList <Recensione> recensioni;
    
    public Prodotto(int id, String nome, float prezzo) {
    	this.id=id;
    	this.nome= nome;
    	this.prezzo= prezzo;
    	
    	recensioni = new ArrayList<>();
    }
    
    public void infoScriviRecensione(Utente u) {
    	Scanner in = new Scanner (System.in);
    	
    	System.out.print("Inserire un voto: ");
    	int voto = in.nextInt();
    	System.out.print("Recensire il prodotto: ");
    	String messaggio = in.next();
    	
    	if(scriviRecensione(u, voto, messaggio)) {
    		System.out.println("Recensione inserita");
    	} else {
    		System.out.println("Utente non autenticato");
    	}
	}
    
    /**
     * Permette all'Utente di scrivere una Recensione su un Prodotto
     */
    public boolean scriviRecensione(Utente u, int voto, String messaggio) {
    	if(u == null) {	//Se l'utente non è autenticato
			return false;
		} 
    	
        Recensione rec = new Recensione(voto, messaggio);
        
        recensioni.add(rec);
        return true;
    }
    
    
    public float getPrezzo() {
    	return prezzo;  
    }
    
    public String getNome() {
		return nome;
	}
    
	public void setPrezzo(float newPrezzo) {
		prezzo = newPrezzo;
	}
   
    @Override
    public String toString() {
    	return "Prodotto " + nome + " - €" + prezzo + "";
    }
    
    
}