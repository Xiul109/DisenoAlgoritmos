import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean fin=false;
		String texto="",patron="";
		if(args.length!=2){
			fin=true;
			System.out.println("Error, número de argumentos incorrecto, solo se necesita 1");
		}
		else{
			String nFichero=args[0];
			try {
				patron=args[1];
				System.out.println(nFichero+" "+patron);
				Scanner scan=new Scanner(new File(nFichero));
				texto = scan.next();
				scan.close();
			} catch (IOException e) {
				fin=true;
				System.out.println("Error, no se pudo abrir el archivo "+nFichero);
			}
			
		}
		if(!fin){
			Exec ex=new Exec(texto);
			long t1,t2;
			int ocurs;
			
			t1=System.currentTimeMillis();
			ocurs=ex.ocurrencia(Algorithm.NAIVE, 100, patron);
			t2=System.currentTimeMillis();
			System.out.println("Se han encontrado "+ocurs+" ocurrencias");
			System.out.println("Algoritmo: Fuerza bruta");
			System.out.println("Tiempo: "+(t2-t1));
			
			t1=System.currentTimeMillis();
			ocurs=ex.ocurrencia(Algorithm.BOYERMOORE, 100, patron);
			t2=System.currentTimeMillis();
			System.out.println("Se han encontrado "+ocurs+" ocurrencias");
			System.out.println("Algoritmo: BoyerMoore");
			System.out.println("Tiempo: "+(t2-t1));
			
			t1=System.currentTimeMillis();
			ocurs=ex.ocurrencia(Algorithm.KNUTH, 100, patron);
			t2=System.currentTimeMillis();
			System.out.println("Se han encontrado "+ocurs+" ocurrencias");
			System.out.println("Algoritmo: Knuth");
			System.out.println("Tiempo: "+(t2-t1));
			
			t1=System.currentTimeMillis();
			ocurs=ex.ocurrencia(Algorithm.KARP, 100, patron);
			t2=System.currentTimeMillis();
			System.out.println("Se han encontrado "+ocurs+" ocurrencias");
			System.out.println("Algoritmo: Karp");
			System.out.println("Tiempo: "+(t2-t1));
		}		

	}

}
