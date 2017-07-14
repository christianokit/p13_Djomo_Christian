import java.util.ArrayList;

public class PianoStudi {
    /** Attributes */
    private NomeAnno anno;
    
    /** Associations */
    private ArrayList<Insegnamento> listInsegnamenti;
    
    public PianoStudi(ArrayList<Insegnamento> listInsegnamenti, NomeAnno anno) {
		super();
		this.anno = anno;
		this.listInsegnamenti = listInsegnamenti;
	}

	public ArrayList<Insegnamento> getListInsegnamenti() {
		return listInsegnamenti;
	}
}