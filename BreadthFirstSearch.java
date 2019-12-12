package ai_searchalgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Abstract {

	

/*	public BreadthFirstSearch(Node start) {
		this.start = start;
		Maze();
		
	}*/
	
	public void bfs(Node start){
		this.start = start;
		Maze();
		Queue<Block> queue = new LinkedList<Block>();
		queue.add(list[start.x][start.y]);
		
		while (!queue.isEmpty()) {
			Block b = queue.remove();
			visitedList.add(b);
			b.visited = 1;
		
			if (b.goal == 1) {
				printSolution("bfs", b);
				return;
			}
		//	if (b.walls[0] == 0 && !visitedList.contains(list[b.current.x][b.current.y+1]) && !queue.contains(list[b.current.x][b.current.y+1])) {
		if(b.walls[0] == 0) {
			if(list[b.current.x][b.current.y+1].visited == 0) {
			list[b.current.x][b.current.y+1].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x][b.current.y+1].goal == 1) {
					printSolution("bfs", list[b.current.x][b.current.y+1]);
					return;
				}
				queue.add(list[b.current.x][b.current.y+1]);
				}
		}
		//	if (b.walls[2] == 0 && !visitedList.contains(list[b.current.x+1][b.current.y]) && !queue.contains(list[b.current.x+1][b.current.y])) {
		if(b.walls[2] == 0) {
			if(list[b.current.x+1][b.current.y].visited == 0) {
		list[b.current.x+1][b.current.y].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x+1][b.current.y].goal == 1) {
					printSolution("bfs",list[b.current.x+1][b.current.y]);
					return;
				}
				queue.add(list[b.current.x+1][b.current.y]);
				}
		}
			//if (b.walls[1] == 0 && !visitedList.contains(list[b.current.x][b.current.y-1]) && !queue.contains(list[b.current.x][b.current.y-1])) {
		if(b.walls[1] == 0) {
			if(list[b.current.x][b.current.y-1].visited == 0) {
		list[b.current.x][b.current.y-1].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x][b.current.y-1].goal == 1) {
					printSolution("bfs",list[b.current.x][b.current.y-1]);
					return;
				}
				queue.add(list[b.current.x][b.current.y-1]);
				}
		}
		
		//	if (b.walls[3] == 0 && !visitedList.contains(list[b.current.x-1][b.current.y]) && !queue.contains(list[b.current.x-1][b.current.y])) {
		if(b.walls[3] == 0) {
			if(list[b.current.x-1][b.current.y].visited == 0) {
		list[b.current.x-1][b.current.y].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x-1][b.current.y].goal == 1) {
					printSolution("bfs",list[b.current.x-1][b.current.y]);
					return;
				}
				queue.add(list[b.current.x-1][b.current.y]);
				}
		}
		}
	}
	
}
