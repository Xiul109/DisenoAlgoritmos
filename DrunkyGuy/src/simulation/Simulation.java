package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simulation {
	private static int[] UP={0,1},LEFT={-1,0},DOWN={0,-1},RIGTH={1,0};
	private static int[][]DIRECTIONS={UP,LEFT,DOWN,RIGTH};
	public static SimResult oneSimulation(boolean[][] police,int[] pub, int[][] houses){
		int wide=police.length, height=police[0].length,i;
		boolean success=false, surrounded=true, end=false;
		List<int[]> path=new ArrayList<int[]>(); 
		int[] pos=Arrays.copyOf(pub, 2), auxPos=new int[2];
		path.add(Arrays.copyOf(pos, 2));
		for(int[] dir:DIRECTIONS){
			auxPos[0]=pos[0]+dir[0];
			auxPos[1]=pos[1]+dir[1];
			if(inBounds(auxPos[0], auxPos[1], wide, height)) 
					surrounded=surrounded && police[auxPos[0]][auxPos[1]];
		}
		if(surrounded)
			end=true;
		while(!end){
			i=(int)(Math.random()/(1.0/DIRECTIONS.length));
			auxPos[0]=pos[0]+DIRECTIONS[i][0];
			auxPos[1]=pos[1]+DIRECTIONS[i][1];
			if(Arrays.equals(auxPos, pub)){
				path.add(auxPos);
				end=true;
			}
			else if(inHouse(auxPos, houses)){
				path.add(auxPos);
				end=success=true;
			}
			else if(inBounds(auxPos[0], auxPos[1], wide, height) && !police[auxPos[0]][auxPos[1]]){
				path.add(Arrays.copyOf(auxPos, 2));
				pos[0]=auxPos[0];pos[1]=auxPos[1];
			}
		}
		return new SimResult(success,path);
	}
	
	
	private static boolean inHouse(int[] pos,int[][] houses){
		boolean house=false;
		for(int i=0; i<houses.length && !house;i++)
			house=Arrays.equals(pos, houses[i]);
		return house;
	}
	
	private static boolean inBounds(int x,int y,int wide,int height){
		return x>0 && x<wide && y<height && y>0;
	}
	
	private static boolean[][] policeMatrix(int wide, int height,double p){
		boolean[][] police=new boolean[wide][height];
		for(int i=0;i<wide;i++)
			for(int j=0;j<height;j++)
				police[i][j]=Math.random()<p;
		return police;
	}
	
	public static int runSimulations(int simulations,int wide,int height, int[] pub, int[][] houses, double p){
		int successes=0;
		for(int i=0;i<simulations;i++){
			if(oneSimulation(policeMatrix(wide,height,p), pub, houses).isSuccess())
				successes++;
		}
		return successes;
	}
	public static double[] confidenceInterval(int simulations,int wide,int height, int[] pub, int[][] houses, double prob){
		double p=runSimulations(simulations, wide, height, pub, houses, prob)/(double) simulations;
		double v=1.96*Math.sqrt(p*(1-p)/simulations);
		
		return new double[]{p-v,p+v};
	}
}
