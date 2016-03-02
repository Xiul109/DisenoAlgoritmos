import java.util.Stack;
import java.util.function.Function;

public class Riemann {
	public static double iterative(Function<Double, Double> f,double a,double b,int n){
		double res=0.0,c=(b-a)/n;
		for(int k=1;k<=n;k++)
			res+=f.apply(a+k*c);
		
		return c*res;
	}
	
	public static double recursive(Function<Double, Double> f,double a, double b,int n){
		return recursive(f,a,b,n,n);
	}
	private static double recursive(Function<Double, Double> f,double a, double b,int n,int k){
		double res=0.0,c=(b-a)/n;
		if(k<=1) res=c*(f.apply(a+k*c));
		else res=c*(f.apply(a+k*c))+recursive(f,a,b,n,k-1);
		return res;
	}
	
	public static double recursiveIterative(Function<Double, Double> f,double a, double b,int n){
		Stack<Double> pilaRes= new Stack<Double>();
		pilaRes.push(0.0);
		Stack<Double> pilaVal= new Stack<Double>();
		pilaVal.push(0.0);
		Stack<Integer> pilaK= new Stack<Integer>();
		pilaK.push(n);
		
		while(pilaK.peek()>1){
			pilaK.push(pilaK.peek()-1);
			pilaRes.push(0.0);
			pilaVal.push(0.0);
		}
		
		double c=(b-a)/n;
		
		pilaVal.pop();
		pilaVal.push(c*(f.apply(a+1*c)));
		
		while(!pilaK.empty()){
			pilaK.pop();
			if(!pilaK.isEmpty()){
				pilaRes.pop();
				pilaRes.pop();
				pilaRes.push(pilaVal.pop()+c*(f.apply(a+pilaK.peek()*c)));
				pilaVal.pop();
				pilaVal.push(pilaRes.peek());
			}
		}
		
		return pilaVal.pop();
	}
}
