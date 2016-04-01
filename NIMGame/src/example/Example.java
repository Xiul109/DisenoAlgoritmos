package example;

import java.util.InputMismatchException;
import java.util.Scanner;

import States.State;
import algorithms.Backward;
import algorithms.Forward;

class Example {

	public static void main(String[] args) {
		int filas,algoritmo=0;
		boolean correct=false;
		State s;
		System.out.println("Introduzca el nº de filas:");
		filas=readNumber();
		s=new State(filas);
		for (int i=0;i<filas;i++){
			System.out.println("Introduzca el nº de palillos en la fila: "+i);
			s.set(i, readNumber());
		}
		while (!correct){
			System.out.println("Elija el algoritmo:\n1.Backward.\n2.Forward.\n3.Ambos");
			algoritmo=readNumber();
			if (algoritmo>0&&algoritmo<4) correct=true;
			else System.out.println("Elija el nº del 1 al 3");
		}
		Backward b=new Backward(s);
		Forward f=new Forward(s);
		if (algoritmo==1) System.out.println(b.getNextMove(s));
		else if (algoritmo==2) System.out.println(f.getNextMove(s));
		else {
			System.out.println("Backward: "+b.getNextMove(s));
			System.out.println("Forward:  "+f.getNextMove(s));
		}
	}
	
	private static int readNumber(){
		boolean correct=false;
		Scanner s=new Scanner(System.in);
		int numero=0;
		while (!correct){
			try{
				numero=s.nextInt();
				if (numero<1){
					System.out.println("No se permiten nº negativos o ceros.");
				}else correct=true;
			}catch (InputMismatchException e){
				System.out.println("Introduzca un valor numérico");
				s.next();
			}
		}
		return numero;
	}
}