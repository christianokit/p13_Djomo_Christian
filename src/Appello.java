import java.util.ArrayList;

public class Appello {
    /** Attributes */
    private Data dataInizio;
    private Data dataFine;
    private String aula;
    private String tipo;

    /** Associations */
    private Insegnamento insegnamento;
    private Docente docente;
    private ArrayList<Studente> listStudenti;

    
    public Appello(Data dataInizio, Data dataFine, String aula, String tipo, Insegnamento insegnamento,
			Docente docente) {
		super();
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.aula = aula;
		this.tipo = tipo;
		this.insegnamento = insegnamento;
		this.docente = docente;
		listStudenti = new ArrayList<Studente>();
	}

	public Data getDataInizio() {
		return dataInizio;
	}

	public Data getDataFine() {
		return dataFine;
	}

	public String getAula() {
		return aula;
	}

	public String getTipo() {
		return tipo;
	}

	public Insegnamento getInsegnamento() {
		return insegnamento;
	}
	
	public Docente getDocente() {
		return docente;
	}

	public ArrayList<Studente> getListStudenti() {
		return listStudenti;
	}

	public void addStudente(Studente s) {
		listStudenti.add(s);
	}
	
}
