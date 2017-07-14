public class Data implements Comparable<Data> {
    /** Attributes */
    public int giorno;
    public int mese;
    public int anno;
    public int ora;
    public int minuti;
	
    
    public Data(int giorno, int mese, int anno, int ora, int minuti) {
		super();
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		this.ora = ora;
		this.minuti = minuti;
	}


	@Override
	public int compareTo(Data oth) {
		if(oth == null) {
			return 0;
		}
		
		if(anno != oth.anno) {
			return Integer.compare(anno, oth.anno);
		}
		if(mese != oth.mese) {
			return Integer.compare(mese, oth.mese);
		}
		if(giorno != oth.giorno) {
			return Integer.compare(giorno, oth.giorno);
		}
		if(ora != oth.ora) {
			return Integer.compare(ora, oth.ora);
		}
		if(minuti != oth.minuti) {
			return Integer.compare(minuti, oth.minuti);
		}
		
		return 0;
	}
    
}