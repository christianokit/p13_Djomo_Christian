import java.util.ArrayList;

public class Insegnamento {
	/** Attributes */
    private int id;
    private String nome;
    private String contenuti;
    private int crediti;
     
    /** Associations */
    private ArrayList<Docente> listDocenti;
    private ArrayList<Appello> listAppelli;
    
    public Insegnamento(int id, String nome, int crediti) {
    	this.id = id;
    	this.nome = nome;
    	this.crediti = crediti;
		listDocenti = new ArrayList<Docente>();
		listAppelli = new ArrayList<Appello>();
	}
    
    /**
     * Creo un nuovo appello
     *
     * @param d docente che crea un nuovo appello
     * @param aula dell'appello
     * @param tipo se scritto o orale
     * @return vero se riusciamo a creare l'appello e ad falso se non riusciamo
     */
    public boolean creaAppello(Data dInizio, Data dFine, String aula, String tipo, Docente d, Sistema s) {	
    	if (dInizio.compareTo(dFine) < 0) { //Se la data di inizio è precedente a quella di fine
    		ArrayList<Insegnamento> listInsegnamenti = s.getListInsegnamenti();
    	
    		for(Insegnamento i : listInsegnamenti) {
    			ArrayList<Appello> listAppelli = i.getListAppelli();
    		
    			for(Appello a : listAppelli) {
    			
    				if(aula.equals(a.getAula()) &&	//Se c'è una sovrapposizione di aule e orari
    					( (a.getDataInizio().compareTo(dInizio)>=0 && dFine.compareTo(a.getDataInizio())>0) ||
    					(dInizio.compareTo(a.getDataInizio())>=0 && (a.getDataFine().compareTo(dInizio))>0) ) ) {
    					
    					//Se non è lo stesso insegnamento
    					//O, se è lo stesso insegnamento, è anche lo stesso tipo
    					if( (!this.equals(i)) || (this.equals(i) && tipo.equals(a.getTipo())) ) {
    						return false;
    					}
    				}
    			
    			}
    		
    		}
    	
    		//L'appello può essere inserito
    		Appello a = new Appello(dInizio, dFine, aula, tipo, this, d);
    	
    		listAppelli.add(a);
    		d.addAppello(a);
    	
    		return true;
    	}
    	
    	return false;// se la condizione di quello if d'inizio non è verificato
    }


    /**
     * cancellare un appello inserito
     *
     * @param a appello da cancellare
     * @return vero se riusciamo a cancellarlo ed a falso se non riusciamo
     */
    public boolean cancellaAppello(Appello a) {
		if (listAppelli.contains(a))
		{
			listAppelli.remove(a);
			ArrayList <Studente> listStudenti = a.getListStudenti();
			for (Studente st : listStudenti)
			{
				st.getListAppelli().remove(a);
			}
			a.getDocente().getListAppelli().remove(a);
			return true;
		}
		
		return false;
		
    }


    /**
     * Modificare dati di un appello
     *
     * @param d docente che vuole modificare l'appello
     * @param aula nuova aula dell'appello
     * @param tipo orale o scritto
     * @return vero se il docente riesce a cancellare l'appello e falso nel caso contrario
     */
    public boolean modificaAppello(Appello aDel, Data dInizio, Data dFine, String aula, String tipo, Docente d, Sistema s) {
    	if(!creaAppello(dInizio, dFine, aula, tipo, d, s)) {	//Provo a inserire nuovo appello
    		return false;
    	}
    	
    	//Recupera nuovo appello appena inserito
    	Appello appInserito = listAppelli.get(listAppelli.size()-1);
    	
    	if(!cancellaAppello(aDel)) {		//Se non riesco ad eliminare aDel dal sistema
    		cancellaAppello(appInserito);	//Riporto com'era prima
    		return false;
    	}
		
		return true;
    }
    
    
    
    /**
     * fa vedere informazioni, statistiche sull'insegnamento
     *
     * @return le info statistiche
     */
    public ArrayList<Double> infoStatistiche() {
		return null;
    }
    
    
    public int getCrediti() {
		return crediti;
	}
    
   
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insegnamento other = (Insegnamento) obj;
		if (crediti != other.crediti)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
		
	}

    
    
    public ArrayList<Appello> getListAppelli() {
		return listAppelli;
	}    
    
}