package algorithms;

import java.util.ArrayList;
import java.util.List;

import States.State;
import States.StateSpace;
import States.StateValTuple;

public class Forward {
	private StateSpace stateSpace;
	public Forward(State baseState){
		stateSpace=new StateSpace(baseState);
	}
	public StateValTuple getNextMove(State baseState){
		int auxVal, val=0;
		boolean found=false;
		List<State> stateList=new ArrayList<State>();
		List<State> ant=new ArrayList<State>();
		State ini=new State(baseState.len());
		State mov=null;
		State s=null;
		baseState.sort();
		stateList.add(ini);
		while (!stateList.isEmpty() && !found) {
			s = stateList.remove(0);
			val = stateSpace.getVal(s);
			ant = stateSpace.anteccessors(s, baseState);
			if (ant.contains(baseState)) {
				mov = s;
				if (val == -1) {
					found = true;
					val=1;
				}
			} else {
				for (State next : ant) {
					auxVal = stateSpace.getVal(next);
					if (val == 1 && auxVal == 0) {
						stateSpace.setLose(next);
						stateList.add(next);
					} else if (val == -1 && (auxVal == 0 || auxVal == -1)) {
						stateSpace.setWin(next);
						stateList.add(next);
					}
				}
			}
		}
		if (!found) val=-1;
		return new StateValTuple(mov,val);
	}
}