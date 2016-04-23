package simulation;

import java.util.Arrays;
import java.util.List;

public class SimResult {
	private boolean success;
	private List<int[]> path;
	public SimResult(boolean success, List<int[]> path) {
		this.success = success;
		this.path = path;
	}
	public boolean isSuccess() {
		return success;
	}
	public List<int[]> getPath() {
		return path;
	}
	public String toString(){
		String str;
		if(success)
			str="¡Victoria! ";
		else
			str="¡Derrota! ";
		str+="La ruta seguida ha sido la siguiente:\n";
		for(int[] corner:path)
			str+=Arrays.toString(corner)+", ";
		
		str+="\n";
		return str;
	}
}
