package ai_searchalgorithms;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Abstract {
	
	 Block list[][];
	 static int row;
	 static int column;
	 protected Node start;
	 protected Node goal;
	 static int goalrow;
	 static int goalcolumn;
	 

	protected ArrayList<Block> visitedList = new ArrayList<Block>();



public void Maze() {
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(
				"/Users/sabriye/Desktop/input.txt"));
	//	String line = reader.readLine();
	
		reader.readLine(); // consume first line and ignore
	String	line = reader.readLine();
	String split[] = line.split("X");
	list = new Block[Integer.parseInt(split[0])][Integer.parseInt(split[1])];
	initialArray();
	edges();
	reader.readLine();
	line = reader.readLine();
	split = line.split(",");
	list[Integer.parseInt(split[0])][Integer.parseInt(split[1])].start=1;
	list[Integer.parseInt(split[0])][Integer.parseInt(split[1])].cost=0;
	row = Integer.parseInt(split[0]);
	column = Integer.parseInt(split[1]);
		while (line != null) {
			//System.out.println(line);
			if(line.contains("Goals")) {
				int limit=Integer.parseInt(line.split("-")[1]);
				for(int i=0; i<limit; i++) {
					line = reader.readLine();
					split = line.split(",");
					list[Integer.parseInt(split[0])][Integer.parseInt(split[1])].goal=1;
					goalrow = Integer.parseInt(split[0]);
					goalcolumn = Integer.parseInt(split[1]);
				}
			}
			if(line.contains("Traps")) {
				int limit=Integer.parseInt(line.split("-")[1]);
				for(int i=0; i<limit; i++) {
					line = reader.readLine();
					split = line.split(",");
					list[Integer.parseInt(split[0])][Integer.parseInt(split[1])].cost=7;
				}
			}
			if(line.contains("Walls")) {
				line = reader.readLine();
				if(line.contains("East")) {
					int limit=Integer.parseInt(line.split("-")[1]);
					for(int i=0; i<limit; i++) {
						line = reader.readLine();
						split = line.split(",");
						list[Integer.parseInt(split[0])][Integer.parseInt(split[1])].walls[0]=1;
						list[Integer.parseInt(split[0])][Integer.parseInt(split[1])+1].walls[1]=1;
					}
					line = reader.readLine();
					limit=Integer.parseInt(line.split("-")[1]);
					for(int i=0; i<limit; i++) {
						line = reader.readLine();
						split = line.split(",");
						list[Integer.parseInt(split[0])][Integer.parseInt(split[1])].walls[2]=1;
						list[Integer.parseInt(split[0])+1][Integer.parseInt(split[1])].walls[3]=1;
					}
				}
				
			}
				
			// read next line
			line = reader.readLine();
			
			
		}
		//printLab();
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	} 
	
	
	
	

}

public void printLab() {
	for (Block[] kares : list) {
		for (Block kare : kares) {
			System.out.println(kare);
		}
	}
}

public void edges() {
		for (int j=0; j<list[0].length; j++) {
			list[0][j].walls[3]=1;
			list[list[0].length-1][j].walls[2]=1;
			list[j][0].walls[1]=1;
			list[j][list[0].length-1].walls[0]=1;
		}
}



public void initialArray() {
	for(int i=0; i<list.length; i++) {
		for(int k=0; k<list[0].length;k++) {
			list[i][k] = new Block(k,i,0,0,1,0,0);
		}
	}
}


public void printSolution(String alg, Block r){

	System.out.println("\n*****" +alg + "*****\n");
		int totalCost = 1;
		System.out.println("Solution Path:\n" );
		totalCost = printSolutionPath(r,  totalCost);
		System.out.println("\n\nSolution Cost: "+totalCost+"\n");
		
		System.out.println("Expanded Path:\n");
		printVisited( visitedList);

	
}

private void printVisited( ArrayList<Block> visited) {
	for (Block block : visited) {
		System.out.print("("+(block.current.x+1)+","+(block.current.y+1)+"),");
	}
}


public int printSolutionPath(Block r, Integer totalCost){
	System.out.print("("+(r.current.x+1)+","+(r.current.y+1)+")"+" <- ");
	if(r.parent != null)
		totalCost = printSolutionPath(list[r.parent.x][r.parent.y], totalCost+list[r.parent.x][r.parent.y].cost);
	return totalCost;
}







}

