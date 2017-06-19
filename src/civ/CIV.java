package civ;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CIV {
   
    /** Associations */
    private List<Utente> utenti;
    private List<Prodotto> prodotti;
    private List<Negozio> elencoNegozi;
    
    private Utente currentUser;
   
    public static void main(String[] args) {
    	System.out.println("Benvenuti al gestore CIV");
		CIV civ = new CIV();
		
		//Setup per test
		Prodotto p1 = new Prodotto(1, "Biscotti Mulino Bianco", (float)3.5);
		Prodotto p2 = new Prodotto(2, "Biscotti Mulino Rosso", (float)4.8);
		
		civ.getProdotti().add(p1);
		civ.getProdotti().add(p2);
		civ.getElencoNegozi().add(new Negozio(1, "Lidl"));
		civ.getElencoNegozi().get(0).getProdotti().add(p1);
		civ.getElencoNegozi().add(new Negozio(2, "Ekom"));
		civ.getElencoNegozi().get(1).getProdotti().add(p2);
		
		civ.getUtenti().add(new Utente(1, "mail", "pw", "nome", "cognome", "indirizzo"));
		//Fine setup
		
		List<Prodotto> list = civ.cercaProdotto("Biscotti"); // tutta la lista dei prodotti biscotti del Civ
		for(Prodotto p: list) {
			System.out.println(p);
		}
		
		if(civ.autentica("mail", "pw")) {
			System.out.println("Utente autenticato");
		}
		
		list.get(0).infoScriviRecensione(civ.getCurrentUser());
		
		civ.getElencoNegozi().get(0).infoScriviRecensione(civ.getCurrentUser());
	}
    
    
    public CIV() {
		utenti = new ArrayList<>();
		prodotti = new ArrayList<>();
		elencoNegozi = new ArrayList<>();
	}
    
    
    public void infoRegistraUtente() {
    	Scanner in = new Scanner (System.in);
		System.out.print("Inserisci l'id numerico: ");
		int id = in.nextInt();
		System.out.print("Inserisci l'email: ");
		String email = in.next();
		System.out.print("Inserisci la password: ");
		String password = in.next();
		System.out.print("Inserisci il nome: ");
		String nome = in.next();
		System.out.print("Inserisci il cognome: ");
		String cognome = in.next();
		System.out.print("Inserisci l'indirizzo: ");
		String indirizzo = in.next();
	       
		registraUtente(id, email, password, nome, cognome, indirizzo);
    }
    
    
    /**
     * Registra un utente nel sistema
     *
     * @return true se l'utente si è registrato correttamente 
     */
    public boolean registraUtente(int id, String email, String password, 
			String nome, String cognome, String indirizzo) {
    	Utente u = new Utente(id, email, password, nome, cognome, indirizzo);
        utenti.add(u);
        return true;
    }
    
    
    /**
     * Ricerca un prodotto data una query
     *
     * @return lista di prodotti
     */
    public List<Prodotto> cercaProdotto(String query) {
    	//Creo lista vuota
    	ArrayList<Prodotto> list = new ArrayList<>();
    	
    	//Cerco prodotti
    	Prodotto prodSelect = null;
    	for(Prodotto p : prodotti) {
    		if (p.getNome().contains(query)){	//Se nel nome e' presente query
    			list.add(p);	//aggiungo prodotto alla lista
    		}
	    }
    	
    	return list;
    }
    
    
    /**
     * Autentica un Utente
     * Implementa UC3
     *
     * @param email email dell'Utente
     * @param password password dell'Utente
     * @return true se l'utente si è correttamente autenticato, false altrimenti
     */
    public boolean autentica(String email, String password) {
    	//Cerco utente
    	for(Utente u : utenti) {
    		if(u.getEmail().equals(email)){	//Se le mail corrispondono
    			if(u.checkPassword(password)) {	//Se la password è corretta
    				currentUser = u;
    				System.out.println("Utente autenticato correttamente");
    				return true;
    			} else {
    				break;
    			}
    		}
	    }
    	
    	System.out.println("Credenziali errate");
    	return false;
    }

    
    /**
     * Inserisce un nuovo negozio nel sistema
     */
    public boolean registraNegozio (Negozio n) {
    	//Verifica che currentUser esista e che sia un ManagerCiv
    	if(currentUser != null && currentUser.getClass().equals(ManagerCIV.class)) {
    		elencoNegozi.add(n);
    		System.out.println("Negozio inserito");
    		return true;
    	}
    	
    	return false;
    }
    
    public Utente getCurrentUser() {
		return currentUser;
	}
    
    public List<Prodotto> getProdotti() {
		return prodotti;
	}
    
    public List<Utente> getUtenti() {
		return utenti;
	}
    
    public List<Negozio> getElencoNegozi() {
		return elencoNegozi;
	}
    
}

