package patternSearching;

public class Naive implements PatternAlgorithm{
	private String patron;
	public Naive(String patron){
		this.patron=patron;
	}
	@Override
	public int search(String texto) {
		int ocurrencias = 0;
		if (patron.length() > 0 && texto.length() >= patron.length()) {
			int t = 0;
			int p = 0;
			while (texto.length() - t >= patron.length()) {
				if (texto.charAt(t) == patron.charAt(p)) {
					int T = t + 1;
					int P = 1;
					while (P < patron.length() && texto.charAt(T) == patron.charAt(P)) {
						T++;
						P++;
					}
					if (P == patron.length())
						ocurrencias++;
				}
				t++;
			}
		}
		return ocurrencias;
	}

}
