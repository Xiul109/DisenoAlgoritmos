package algorithms;

import java.util.ArrayList;
import java.util.List;

import States.State;
import States.StateSpace;

public class Forward {
	private StateSpace stateSpace;
	public Forward(State baseState){
		stateSpace=new StateSpace(baseState);
	}
	public State getNextMove(State baseState){
		int auxVal, val=0;
		boolean found=false;
		List<State> stateList=new ArrayList<State>();
		List<State> ant=new ArrayList<State>();
		State ini=new State(baseState.len());
		State mov=null;
		baseState.sort();
		stateSpace.setLose(ini);
		stateList.add(ini);
		while (!stateList.isEmpty() && !found) {
			State s = stateList.remove(0);
			val = stateSpace.getVal(s);
			ant = stateSpace.anteccessors(s, baseState);
			if (ant.contains(baseState)) {
				mov = s;
				if (val == -1) {
					found = true;
				}
			} else {
				for (State next : ant) {
					auxVal = stateSpace.getVal(next);
					if (val == 1 && auxVal == 0) {
						stateSpace.setLose(next);
					} else if (val == -1 && (auxVal == 0 || auxVal == -1)) {
						stateSpace.setWin(next);
					}
				}
			}
			stateList.addAll(ant);
		}
		return mov;
	}
}
