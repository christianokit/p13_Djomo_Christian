import java.util.ArrayList;

public class Sistema {
    /** Associations */
    private ArrayList<Utente> listUtenti;
    private ArrayList<Insegnamento> listInsegnamenti;
    private ArrayList<CorsoStudi> listCorsoStudi;
    
	public Sistema() {
		listInsegnamenti = new ArrayList<Insegnamento>();
		listUtenti = new ArrayList<Utente>();
		listCorsoStudi = new ArrayList<CorsoStudi>();
	}
    
    /**
     * permette a uno studente o a un docente di entrare nel sistema
     *
     * @param email dello studente o docente 
     * @param pw dello studente o docente
     * @return vero se riesce ad entrare nel sistema e falso se no riesce
     */
    public boolean autentica(String email, String pw) {
    	for(Utente u : listUtenti) {
    		if(u.getEmail().equals(email)) {
    			if(u.checkPassword(pw) == true) {
    				return true;
    			}
    		}
    	}
    	
		return false;
    }


    public ArrayList<Utente> getListUtenti() {
		return listUtenti;
	}

	/**
     * cercare un insegnamento
     *
     * @param query di ricerca 
     * @return all'insegnamento cercato
     */
    public Insegnamento cercaInsegnamento(String query) {
		return null;
    }
    
    public ArrayList<Insegnamento> getListInsegnamenti() {
		return listInsegnamenti;
	}
    
    public ArrayList<CorsoStudi> getListCorsoStudi() {
		return listCorsoStudi;
	}
}