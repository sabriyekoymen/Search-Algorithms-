package ai_searchalgorithms;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostSearch extends Abstract {

	
	public void ucs(Node start) {
		this.start = start;
		Maze();
		ArrayList<Block> queue = new ArrayList<Block>();
		queue.add(list[start.x][start.y]);
		
		while(!queue.isEmpty()) {
	
			
	        Compare compare = new Compare();
	 
			Collections.sort(queue, compare);
	        
			Block b = queue.remove(0);
			
			if(b.goal == 1) {
				printSolution("uniform", b);
				return;
			}
			
			int cost = 0;
			
			if(b.parent != null){
				cost = list[b.parent.x][b.parent.y].cost + cost;
			}
			visitedList.add(b);
			b.visited = 1;
			
			if(b.walls[0] == 0) {
				if(list[b.current.x][b.current.y+1].visited == 0 && !queue.contains(list[b.current.x][b.current.y+1])) {
						list[b.current.x][b.current.y+1].parent = new Node(b.current.x,b.current.y);
						queue.add(list[b.current.x][b.current.y+1]);
					}
					else {
						if(list[b.current.x][b.current.y+1].cost>cost) {
							list[b.current.x][b.current.y+1].cost = cost;
							list[b.current.x][b.current.y+1].parent = new Node(b.current.x, b.current.y);
						}
					}
				
			}
			
			if(b.walls[2] == 0) {
				if(list[b.current.x+1][b.current.y].visited == 0 && !queue.contains(list[b.current.x+1][b.current.y])) {
						list[b.current.x+1][b.current.y].parent = new Node(b.current.x,b.current.y);
						queue.add(list[b.current.x+1][b.current.y]);
					}
					else {
						if(list[b.current.x+1][b.current.y].cost>cost) {
							list[b.current.x+1][b.current.y].cost = cost;
							list[b.current.x+1][b.current.y].parent = new Node(b.current.x, b.current.y);
						}
					}
				
			}
			
			if(b.walls[1] == 0) {
				if(list[b.current.x][b.current.y-1].visited == 0 && !queue.contains(list[b.current.x][b.current.y-1])) {
						list[b.current.x][b.current.y-1].parent = new Node(b.current.x,b.current.y);
						queue.add(list[b.current.x][b.current.y-1]);
					}
					else {
						if(list[b.current.x][b.current.y-1].cost>cost) {
							list[b.current.x][b.current.y-1].cost = cost;
							list[b.current.x][b.current.y-1].parent = new Node(b.current.x, b.current.y);
						}
					}
				
			}
			
			if(b.walls[3] == 0) {
				if(list[b.current.x-1][b.current.y].visited == 0 && !queue.contains(list[b.current.x-1][b.current.y])) {
						list[b.current.x-1][b.current.y].parent = new Node(b.current.x,b.current.y);
						queue.add(list[b.current.x-1][b.current.y]);
					}
					else {
						if(list[b.current.x-1][b.current.y].cost>cost) {
							list[b.current.x-1][b.current.y].cost = cost;
							list[b.current.x-1][b.current.y].parent = new Node(b.current.x, b.current.y);
						}
					}
				
			}
			
			
			
		}
		
	}
}
