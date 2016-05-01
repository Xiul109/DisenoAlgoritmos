package patternSearching;

public class KarpRabin implements PatternAlgorithm{
	private String patron;
	private int hash;
	public KarpRabin(String patron){
		this.patron=patron;
		hash=patron.hashCode();
	}

	@Override
	public int search(String texto) {
		int ocurrencias=0;
		int m=patron.length();
		if(m>0 && texto.length()>=m){
			for(int n=0;n<=texto.length()-m;n++){
				String aux=texto.substring(n, n+m);
				if (aux.hashCode()==hash && aux.equals(patron)) ocurrencias++;
			}
		}
		return ocurrencias;
	}
}
