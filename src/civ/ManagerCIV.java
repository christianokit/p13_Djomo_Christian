package civ;
import java.util.Scanner;

public class ManagerCIV extends Utente {
	/** Associations */
    private CIV civGestito;

	public ManagerCIV(int id, String email, String password, String nome, String cognome, String indirizzo) {
    	super(id, email, password, nome, cognome, indirizzo);
    }
    
    public void infoAggiungiNegozio() {
    	Scanner in = new Scanner (System.in);
    	System.out.print("Inserire l'id del nuovo negozio: ");
    	int id = in.nextInt();
    	System.out.print("Inserire il nome del nuovo negozio: ");
    	String nome = in.next();
    	
    	aggiungiNegozio(id, nome);
	}
    
    /**
     * Permette a un ManagerCIV di aggiungere un Negozio al Civ
     * Implementa UC23
     * @param id id del Negozio
     * @param nome nome del Negozio
     */
    public void aggiungiNegozio(int id, String nome) {
    	Negozio n = new Negozio(id, nome);
    	civGestito.registraNegozio(n);
    }
    
    public CIV getCivGestito() {
    	return civGestito;
    }
    
    public void setCivGestito(CIV civGestito) {
    	this.civGestito = civGestito;
    }
}