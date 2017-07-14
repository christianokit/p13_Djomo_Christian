import java.util.ArrayList;

public class Docente extends Utente {
	/** Associations */
	private ArrayList<Appello> listAppelli;
	private ArrayList<Insegnamento> listInsegnamenti;
    
	public Docente(int id, String email, String password) {
		super(id, email, password);
		listAppelli = new ArrayList<>();
		this.listInsegnamenti = new ArrayList<>();
	}
	
	public ArrayList <Insegnamento> getInsegnamenti()
	{
		return listInsegnamenti;
	}
	
	public void addAppello (Appello a)
	{
		listAppelli.add(a);
	}
	
	public ArrayList <Appello> getListAppelli ()
	{
		return listAppelli;
	}

}