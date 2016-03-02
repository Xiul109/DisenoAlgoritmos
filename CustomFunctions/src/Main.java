
public class Main {

	public static void main(String[] args) {
		long T0,Tf;
		double valor;
		int n=1000000;
		double a=0.0, b=10.0;
		
		T0=System.currentTimeMillis();
		valor=Riemann.iterative(new XPowX(), a, b, n);
		Tf=System.currentTimeMillis();
		System.out.println("Iterativo tarda: "+(Tf-T0)+"ms y devuelve el valor "+valor);
		
		T0=System.currentTimeMillis();
		valor=Riemann.recursive(new XPowX(), a, b, n);
		Tf=System.currentTimeMillis();
		System.out.println("Recursivo tarda: "+(Tf-T0)+"ms y devuelve el valor "+valor);
		
		T0=System.currentTimeMillis();
		valor=Riemann.recursiveIterative(new XPowX(), a, b, n);
		Tf=System.currentTimeMillis();
		System.out.println("Recursivo-Iterativo tarda: "+(Tf-T0)+"ms y devuelve el valor "+valor);

	}

}
