public class Utente {
    /** Attributes */
    protected int id;
    protected String email;
    protected String password;
    
    public Utente (int id, String email, String password){
    	this.id=id;
    	this.email=email;
    	this.password = password;
    }
    
    
    /**
     * modifica dati del profilo
     *
     * @param email dell'utente
     * @param password dell'utente
     * @return true se la modifica va a buon fine, falso altrimenti
     */
    public boolean modificaDatiProfilo(String email, String password ) {
    	return false;
    }
    
    public String getEmail() {
		return email;
	}
    
    public boolean checkPassword(String pw) {
		return password.equals(pw);
	}
	
}