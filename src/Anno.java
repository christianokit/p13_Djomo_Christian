import java.util.ArrayList;

public class Anno {
    /** Attributes */
    public NomeAnno anno;
    public int creditiRichiesti;
    
    /** Associations */
    private ArrayList<Insegnamento> listInsegnamenti;    
    
    public Anno(NomeAnno anno, int creditiRichiesti, ArrayList<Insegnamento> listInsegnamenti) {
    	this.anno = anno; 
    	this.creditiRichiesti = creditiRichiesti;
    	this.listInsegnamenti = listInsegnamenti;
    }
    
    public NomeAnno getAnno() {
		return anno;
	}
    
    public int getCreditiRichiesti() {
		return creditiRichiesti;
	}
    
    /**
     * Verifica che l'insegnamento i fa parte degli insegnamenti di questo anno
     * @param i
     * @return ritorna vero se l'insegnamento i fa parte degli insegnamenti di questo anno 
     * e a false se no fa parte
     */
    public boolean isInsegnamentoInAnno(Insegnamento i) {
    	for(Insegnamento ins : listInsegnamenti) {
    		if(ins.equals(i)){
    			return true;
    		}
    	}
    	return false;
    }
    
}