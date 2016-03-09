package States;

import java.util.Arrays;

public class State{
	private int[] state;
	public State(int len){
		state=new int[len];
	}
	
	public State(State cState){
		state=Arrays.copyOf(cState.getArray(), cState.len());
	}
	
	public int[] getArray(){
		return state;
	}
	
	public int len(){
		return state.length;
	}
	public int get(int i) throws ArrayIndexOutOfBoundsException{
		return state[i];
	}
	public void set(int i, int val) throws ArrayIndexOutOfBoundsException{
		state[i]=val;
	}
	@Override
	public int hashCode() {
		return Arrays.hashCode(state);
	}
	
	
	public String toString(){
		String s="[";
		for(int i=0;i<state.length-1;i++){
			s+=state[i]+", ";
		}
		s+=state[state.length-1]+"]";
		return s;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof State))return false;
		return Arrays.equals(state, ((State)obj).getArray());
	}
	
	
	public void sort(){
		Arrays.sort(state);
	}
}
