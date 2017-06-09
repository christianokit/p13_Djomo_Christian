package civ;
import java.util.ArrayList;
import java.util.List;

public class Acquisto {
    /** Attributes */
    private int id;
    private float prezzoTotale;
    private Data data;
 
    /** Associations */
    private Recensione recensione;
    private List<Negozio> negozi;
    protected List<Quantità> listaProdotti;
    
    public Acquisto() {
    	negozi = new ArrayList<>();
		listaProdotti = new ArrayList<>();
	}

    /**
     * Operation
     *
     * @return 
     */
    public boolean scriviRecensione() {
		return false;
    }
    

	/**
     * Operation
     *
     * @return 
     */
    public float calcolaPrezzo() {
		return 0;
       
    }

    public void setTime() {
    	data= new Data();
    	
    }
    
    /**
     * Ottiene lista dei prodotti 
     * Implementa UC5
     * @return lista dei prodotti
     */
    public List<Quantità> getListaProdotti() {
    	return listaProdotti;
	}
    
}

