package States;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class StateSpace {
	private Hashtable<List<Integer>, Integer> states;
	
	public Hashtable<List<Integer>, Integer> getTable(){
		return states;
	}
	
	public StateSpace() {
		this.states = new Hashtable<List<Integer>,Integer>();
		List<Integer> baseState= new ArrayList<Integer>();
		states.put(baseState, -1);
	}

	public int getVal(List<Integer> state){
		int val=0;
		if(states.containsKey(state)) val=states.get(state);
		return val;
	}
	public void setVal(List<Integer> state,int val){
		states.put(state, val);
	}
	
	public void setWin(List<Integer> state){
		states.put(state, 1);
	}
	
	public void setLose(List<Integer> state){
		states.put(state, -1);
	}
	
	public List<List<Integer>> successors(List<Integer> state){
		List<List<Integer>> succ= new ArrayList<List<Integer>>();
		List<Integer> auxList,prev=new ArrayList<Integer>();
		for(int i=0;i<state.size();i++){
			if(!prev.contains(state.get(i))){
				for(int j=state.get(i)-1;j>=0;j--){
					auxList=new ArrayList<Integer>(state);
					if(j<=0) auxList.remove(i);
					else auxList.set(i, j);
					Collections.sort(auxList);
					succ.add(auxList);
				}
			}
			
			prev.add(state.get(i));
		}
		return succ;
	}
	public List<List<Integer>> anteccessors(List<Integer> state,List<Integer> baseState){
		List<List<Integer>> ant= new ArrayList<List<Integer>>();
		List<Integer> auxState;
		int val;
		for(int i=0;i<state.size();i++){
			val=state.get(i);
			while(val<baseState.get(i)){
				auxState=new ArrayList<Integer>(state);
				auxState.set(i, val++);
				ant.add(auxState);
			}
		}
		if(state.size()<baseState.size()){
			int maxVal=baseState.get(baseState.size()-1);
			for(int i=0;i<=max){
				
			}
		}
		
		
		return ant;
	}
	
}
