package patternSearching;

public class KnuthMorrisPratt implements PatternAlgorithm{

	private String patron;
	private int [] fallo;
	
	public KnuthMorrisPratt(String patron){
		this.patron=patron;
		fallo=new int[patron.length()];
		preproceso();
	}
	@Override
	public int search(String texto) {
		int ocurrencias = 0;
		int t = 0;
		int p = 0;
		while (texto.length() - t >= patron.length()) {
			if (p == patron.length()) {
				ocurrencias++;
				p = 0;
				t++;
			} else {
				if (texto.charAt(t + p) == patron.charAt(p))
					p++;
				else {
					t = t + p - fallo[p];
					if (p > 0)
						p = fallo[p];
				}
			}
		}
		return ocurrencias;
	}

	private void preproceso() {
		int i = 2;
		int j = 0;
		fallo[0] = -1;
		if (patron.length() > 1) {
			fallo[1] = 0;
			while (i < patron.length()) {
				if (patron.charAt(i - 1) == patron.charAt(j)) {
					j++;
					fallo[i] = j;
					i++;
				} else {
					if (j > 0)
						j = fallo[j];
					else {
						fallo[i] = 0;
						i++;
					}
				}
			}
		}
	}


}
