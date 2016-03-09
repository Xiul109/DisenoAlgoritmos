package algorithms;


import java.util.List;

import States.State;
import States.StateSpace;

public class Backward {
	private StateSpace stateSpace;
	public Backward(State initialState){
		stateSpace=new StateSpace(initialState);
	}
	public State getNextMove(State initialState){
		State succ=null;
		List<State> successors =stateSpace.successors(initialState);
		int succVal,val=-1;
		for(int i=0;i<successors.size() && val<0;i++){
			succ=successors.get(i);
			succVal=stateSpace.getVal(succ);
			if(succVal==0)
				succVal=getNextMoveVal(stateSpace, succ);
			if(succVal<0) val=1;
		}
		return succ;
	}
	private int getNextMoveVal(StateSpace stateSpace, State  state){
		int succVal,val=-1;
		State succ;
		List<State> successors=stateSpace.successors(state);
		for(int i=0;i<successors.size() && val <0;i++){
			succ=successors.get(i);
			succVal=stateSpace.getVal(succ);
			if(succVal==0)
				succVal=getNextMoveVal(stateSpace, succ);
			if(succVal<0) val=1;
		}
		stateSpace.setVal(state, val);
		return val;
	}
}
