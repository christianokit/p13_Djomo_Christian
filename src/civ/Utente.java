package civ;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utente {
    /** Attributes */
    private int id;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String indirizzo;
    
    /** Associations */
    private Carrello carrello;
    private List<Acquisto> acquisti;
    
    public Utente (int id, String email, String password, String nome, String cognome, String indirizzo) {
    	this.id=id;
    	this.email=email;
    	this.password = password;
    	this.nome= nome;
    	this.cognome= cognome;
    	this.indirizzo= indirizzo;
    	
    	carrello = new Carrello();
    	acquisti = new ArrayList<Acquisto>();
    }
    
    
    /**
     * Verifica la password passata come parametro
     * @param pw password da verificare
     * @return true se le password coincidono, false altrimenti
     */
    public boolean checkPassword(String pw) {
    	return password.equals(pw);
    }
    
    public String getEmail() {
    	return email;
    }
    
    public Carrello getCarrello() {
		return carrello;
	}
    
}