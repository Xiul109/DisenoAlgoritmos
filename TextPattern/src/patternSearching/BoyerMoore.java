package patternSearching;
import java.util.HashMap;

public class BoyerMoore implements PatternAlgorithm {
	private String patron;
	private int[] f;
	private int[] s;
	private HashMap<Character, Integer> badsufix;
	public BoyerMoore(String patron){
		this.patron=patron;
		badsufix=new HashMap<Character, Integer>();
		iniciaOcc();
		f=new int [patron.length()+1];
		s=new int [patron.length()+1];
		preproceso1();
		preproceso2();
	}
	@Override
	public int search(String texto) {
		int i = 0, j, ocurrencias=0;
		while (i <= texto.length() - patron.length()) {
			j = patron.length() - 1;
			while (j >= 0 && patron.charAt(j) == texto.charAt(i + j))
				j--;
			if (j < 0) {
				ocurrencias++;
				i += s[0];
			} else {
				int aux = -1;
				if (badsufix.containsKey(texto.charAt(i + j)))
					aux = badsufix.get(texto.charAt(i + j));
				i += Math.max(s[j + 1], j - aux);
			}
		}
		return ocurrencias;
	}

	private void iniciaOcc() {
		for (int n = patron.length() - 1; n >= 0; n--){
			if (!badsufix.containsKey(patron.charAt(n))) {
				badsufix.put(patron.charAt(n),n);
			}
		}
	}
	
	private void preproceso1() {
		int i = patron.length(), j = i + 1;
		f[i] = j;
		while (i > 0) {
			while (j <= patron.length() && patron.charAt(i - 1) != patron.charAt(j - 1)) {
				if (s[j] == 0)
					s[j] = j - i;
				j = f[j];
			}
			i--;
			j--;
			f[i] = j;
		}
	}

	private void preproceso2() {
		int i, j;
		j = f[0];
		for (i = 0; i <= patron.length(); i++) {
			if (s[i] == 0)
				s[i] = j;
			if (i == j)
				j = f[j];
		}
	}
}
