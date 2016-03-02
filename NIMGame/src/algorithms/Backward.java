package algorithms;


import java.util.List;

import States.StateSpace;

public class Backward {
	public static List<Integer> getNextMove(StateSpace stateSpace, List<Integer>  initialState){
		List<Integer> succ=null;
		List<List<Integer>> successors =stateSpace.successors(initialState);
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
	private static int getNextMoveVal(StateSpace stateSpace, List<Integer>  state){
		int succVal,val=-1;
		List<Integer> succ;
		List<List<Integer>> successors=stateSpace.successors(state);
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
