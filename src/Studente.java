import java.util.ArrayList;

public class Studente extends Utente {
    /** Associations */
    private CorsoStudi corsoStudi;
    private ArrayList<Appello> listAppelli;
    private ArrayList<Voto> listVoti;
    private ArrayList<PianoStudi> listPianoStudi;
    
    
    public Studente(int id, String email, String password) {
		super(id, email, password);
		listAppelli = new ArrayList<>();
		listVoti = new ArrayList<>();
		listPianoStudi = new ArrayList<>();
	}
    
    
    public double getMediaPesataVoti() {
    	return 0.0;
    }
    
    
    /**
     * rifiutare il voto v 
     *
     * @param v voto
     * @return vero se il voto v è rifiutato e falso se non è rifiutato
     */
    public boolean rifiutoVoto(Voto v) {
		return false;
    }
  
  
    /**
     *accettare un voto
     *
     * @param v voto
     * @return vero se il voto v è accettato e falso se non è accettato
     */
    public boolean accettaVoto(Voto v) {
		return false;
    }
   
   
    /**
     * prenota un appello
     *
     * @param a appello
     * @return vero se l'appello è stato prenotato, falso altrimenti
     */
    public boolean prenotaAppello(Appello a) {
    	//Cerca l'insegnamento nel piano di studi dello studente
    	boolean flag = false;
    	for(PianoStudi p : listPianoStudi) {
    		for(Insegnamento i : p.getListInsegnamenti()) {
    			if(i.equals(a.getInsegnamento())) {
    				flag = true;
    			}
    		}
    	}
    	
    	//Se l'insegnamento non è nel piano di studi dello studente
    	if(!flag) {
    		return false;
    	}

    	flag = false;
    	//Cerca se si è già iscritti allo stesso appello
    	for(Appello app : listAppelli) {
    		if(a.equals(app)) {
    			flag = true;
    		}
    	}
    	
    	//Se sono già prenotato all'appello
    	if(flag) {
    		return false;
    	}
    	
    	
    	a.addStudente(this);
    	listAppelli.add(a);
    	
    	return true;
    }
  
  
    /**
     * compila un piano di studi
     *
     * @param list lista degli insegnamenti
     * @return vero se il piano è stato compilato, falso altrimenti
     */
    public boolean compilaPiano(ArrayList<Insegnamento> list, NomeAnno nAnno) {
		//Trovo anno del piano di studi da compilare nel corso di studi scelto
    	Anno a = null;
    	for(Anno anno : corsoStudi.getListAnni()) {
    		if(anno.getAnno() == nAnno) {
    			a = anno;
    			break;
    		}
    	}
    	
    	if(a == null) {
    		return false;
    	}
    	
    	//Controllo se insegnamenti sono del corso di studi scelto
    	//e calcolo il totale dei crediti
    	int totCrediti = 0; 
    	for(Insegnamento i : list) {// faccio la somma dei crediti di tutti gli insegnamenti
			totCrediti = totCrediti + i.getCrediti();
			if(!a.isInsegnamentoInAnno(i)) {
				return false;
			}
		}
    	
    	if(totCrediti != a.getCreditiRichiesti()) {
    		return false;
    	}
    	
    	//Tutto ok, creo piano di studi e inserisco
    	listPianoStudi.add(new PianoStudi(list, nAnno));
    	return true;
    }


	public ArrayList<Appello> getListAppelli() {
		return listAppelli;
	}


    
	public ArrayList<PianoStudi> getListPianoStudi() {
		return listPianoStudi;
	}


	public void setCorsoStudi(CorsoStudi corsoStudi) {
		this.corsoStudi = corsoStudi;
	}
    
	
}