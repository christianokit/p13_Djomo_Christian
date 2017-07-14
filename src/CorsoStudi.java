import java.util.ArrayList;

public class CorsoStudi {
    /** Attributes */
    private int id;
    private String nome;
    private String manifesto;
    
    /** Associations */
    private ArrayList<Anno> listAnni;
    
    public CorsoStudi() {
		listAnni = new ArrayList<>();
	}

    public ArrayList<Anno> getListAnni() {
		return listAnni;
	}
    
}