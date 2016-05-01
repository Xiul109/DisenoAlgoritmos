import patternSearching.BoyerMoore;
import patternSearching.KarpRabin;
import patternSearching.KnuthMorrisPratt;
import patternSearching.Naive;
import patternSearching.PatternAlgorithm;

public class Exec {
	private String texto;
	
	public Exec(String texto){
		this.texto=texto;
	}
	public int ocurrencia(int algoritmo, int porcentaje, String patron){
		int saltos=100/porcentaje;
		int ocurrencias=0;
		PatternAlgorithm algo;
		String[] lineas=patron.split("\n");
		switch (algoritmo) {
		case Algorithm.BOYERMOORE:
			algo = new BoyerMoore(patron);
			break;
		case Algorithm.KARP:
			algo = new KarpRabin(patron);
			break;
		case Algorithm.KNUTH:
			algo = new KnuthMorrisPratt(patron);
			break;
		case Algorithm.NAIVE:
			algo = new Naive(patron);
			break;
		default:
			System.out.println("Te has pasado de listo");
			return -1;
		}
		for (int i=0;i<lineas.length;i+=saltos){
			ocurrencias+=algo.search(lineas[i]);
		}
		return ocurrencias*saltos;
		
	}
}
