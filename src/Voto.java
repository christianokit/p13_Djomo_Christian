public class Voto {
    /** Attributes */
    private int voto;
    private boolean lode;
    private StatoVoto stato;

    /** Associations */
    private Appello appello;
    private Studente studente;


    /**
     *accettare un voto
     *
     * @return true se il voto è accettato, falso altrimenti
     */
    public boolean accettaVoto() {
		return false;
    }


    /**
     * rifiutare un voto 
     *
     * @return true se il voto è rifiutato, falso altrimenti
     */
    public boolean rifiutaVoto() {
		return false;
    }


    /**
     * Regritra il voto di un esame
     *
     * @param voto di un appello
     * @param lode 
     * @return true se l'esame è registrato, falso altrimenti
     */
    public boolean registraEsame (int voto, boolean lode) {
		return false;
    }
}