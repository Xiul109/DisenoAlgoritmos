package States;

public class StateValTuple {
	State st;
	int val;
	public StateValTuple(State st, int val) {
		this.st = st;
		this.val = val;
	}
	public State getSt() {
		return st;
	}
	public int getVal() {
		return val;
	}
	public String toString(){
		String s="";
		if(val<0) s="¡Derrota! Siguiente estado: " ;
		else if(val>0) s="¡Victoria! Siguiente estado: " ;
		s+=st;
		return s;
	}
}
