package ai_searchalgorithms;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class BestFirstSearch extends Abstract {

	public BestFirstSearch(Node start) {
		this.start = start;
		Maze();
	}
	
	
	public void gbfs() {	
		
		ArrayList<Block> queue = new ArrayList<Block>();
		queue.add(list[start.x][start.y]);
		

		int cost = 0;
		
	
		
		while(!queue.isEmpty()) {

			
			   Compare2 compare = new Compare2();
				 
				Collections.sort(queue, compare);
			
			
				
			Block b = queue.remove(0);
	
			
			/*double estcost = Math.sqrt((Math.pow(goalrow-b.row, 2) + Math.pow(goalcolumn-b.column, 2)));
			list[start.x][start.y].estimatedcost = estcost;
			cost =+ (int)  list[start.x][start.y].estimatedcost;*/
			
			
			if(b.goal == 1) {

				
				printSolution("greedy", b);
				return;
			}
			
	/*	    estcost = Math.sqrt((Math.pow(goalrow-b.current.x, 2) + Math.pow(goalcolumn-b.current.y, 2)));
			b.estimatedcost = estcost;
			cost =+ (int)  b.estimatedcost;*/
			
			visitedList.add(b);
			b.visited = 1;
			
		
			
			if(b.walls[0] == 0) {
				if(list[b.current.x][b.current.y+1].visited == 0 ) {
					if(!queue.contains(list[b.current.x][b.current.y+1])) {
						list[b.current.x][b.current.y+1].parent = new Node(b.current.x,b.current.y);
						/*double estcost = Math.sqrt((Math.pow(goalrow-b.current.x, 2) + Math.pow(goalcolumn-b.current.y+1, 2)));
						b.cost = (int) estcost;*/
						queue.add(list[b.current.x][b.current.y+1]);
					}
				}
			}
			
			if(b.walls[2] == 0) {
				if(list[b.current.x+1][b.current.y].visited == 0 ) {
					if(!queue.contains(list[b.current.x+1][b.current.y])) {
						list[b.current.x+1][b.current.y].parent = new Node(b.current.x,b.current.y);
						/*double estcost = Math.sqrt((Math.pow(goalrow-b.current.x+1, 2) + Math.pow(goalcolumn-b.current.y, 2)));
						b.cost = (int) estcost;*/
						queue.add(list[b.current.x+1][b.current.y]);
					}
				}
			}
			
			if(b.walls[1] == 0) {
				if(list[b.current.x][b.current.y-1].visited == 0 ) {
					if(!queue.contains(list[b.current.x][b.current.y-1])) {
						list[b.current.x][b.current.y-1].parent = new Node(b.current.x,b.current.y);
						/*double estcost = Math.sqrt((Math.pow(goalrow-b.current.x, 2) + Math.pow(goalcolumn-b.current.y-1, 2)));
						b.cost = (int) estcost;*/
						queue.add(list[b.current.x][b.current.y-1]);
					}
				}
			}
			
			if(b.walls[3] == 0) {
				if(list[b.current.x-1][b.current.y].visited == 0 ) {
					if(!queue.contains(list[b.current.x-1][b.current.y])) {
						list[b.current.x-1][b.current.y].parent = new Node(b.current.x,b.current.y);
						/*double estcost = Math.sqrt((Math.pow(goalrow-b.current.x-1, 2) + Math.pow(goalcolumn-b.current.y, 2)));
						b.cost = (int) estcost;*/
						queue.add(list[b.current.x-1][b.current.y]);
					}
				}
			}
			
		}
		
	}
	
}
