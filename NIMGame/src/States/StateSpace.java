package States;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class StateSpace {
	private Hashtable<State, Integer> states;
	
	public Hashtable<State, Integer> getTable(){
		return states;
	}
	
	public StateSpace(State initialState) {
		this.states = new Hashtable<State,Integer>();
		State baseState= new State(initialState.len());
		states.put(baseState, -1);
	}

	public int getVal(State state){
		int val=0;
		if(states.containsKey(state)) val=states.get(state);
		return val;
	}
	public void setVal(State state,int val){
		states.put(state, val);
	}
	
	public void setWin(State state){
		states.put(state, 1);
	}
	
	public void setLose(State state){
		states.put(state, -1);
	}
	
	public List<State> successors(State state){
		List<State> succ= new ArrayList<State>();
		State auxState;
		List<Integer> prev=new ArrayList<Integer>();
		for(int i=0;i<state.len();i++){
			if(!prev.contains(state.get(i))){
				for(int j=state.get(i)-1;j>=0;j--){
					auxState=new State(state);
					auxState.set(i, j);
					auxState.sort();
					succ.add(auxState);
				}
			}
			
			prev.add(state.get(i));
		}
		return succ;
	}
	public List<List<Integer>> anteccessors(List<Integer> state,List<Integer> baseState){
		List<List<Integer>> ant= new ArrayList<List<Integer>>();
		List<Integer> auxState;
		int val, maxVal=baseState.get(baseState.size()-1);;
		for(int i=0;i<state.size();i++){
			val=state.get(i);
			while(val<=maxVal){
				auxState=new ArrayList<Integer>(state);
				auxState.set(i, val++);
				ant.add(auxState);
			}
		}
//		if(state.size()<baseState.size()){
//			int maxVal=baseState.get(baseState.size()-1);
//			for(int i=0;i<=max){
//				
//			}
//		}
		
		
		return ant;
	}
	
}
