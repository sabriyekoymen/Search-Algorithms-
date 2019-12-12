package ai_searchalgorithms;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends Abstract {


	/*public DepthFirstSearch(Node start) {
		this.start = start;
		Maze();
		
	}*/
	
	public void dfs(Node start) {
		this.start = start;
		Maze();
		Stack<Block> stack = new Stack<Block>();
		stack.push(list[start.x][start.y]);
		
		while(!stack.isEmpty()){
			//System.out.println(stack);
			Block b = stack.pop();
			visitedList.add(b);
			b.visited = 1;
			//System.out.println("Block x:"+(r.current.x+1)+"  y:"+(r.current.y+1));
			if (b.goal == 1) {
				printSolution("dfs",b);
				//printSolution(list[r.current.x][r.current.y],visitedList,list[r.current.x][r.current.y].cost);
				return;
			}
				
			
			//east
		//	if (r.walls[0] == 0 && !visitedList.contains(list[r.current.x][r.current.y+1]) && !stack.contains(list[r.current.x][r.current.y+1])) {
			if(b.walls[0] == 0) {
				if(list[b.current.x][b.current.y+1].visited == 0) {
			list[b.current.x][b.current.y+1].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x][b.current.y+1].goal == 1) {
					printSolution("dfs",list[b.current.x][b.current.y+1]);
					//printSolution(list[r.current.x][r.current.y+1],visitedList,list[r.current.x][r.current.y+1].cost);
					return;
				}
				stack.push(list[b.current.x][b.current.y+1]);
				}
				}
			//south
			//if (r.walls[2] == 0 && !visitedList.contains(list[r.current.x+1][r.current.y]) && !stack.contains(list[r.current.x+1][r.current.y])) {
			if(b.walls[2] == 0) {
				if(list[b.current.x+1][b.current.y].visited == 0) {
			list[b.current.x+1][b.current.y].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x+1][b.current.y].goal == 1) {
					printSolution("dfs",list[b.current.x+1][b.current.y]);
					//printSolution(list[r.current.x+1][r.current.y],visitedList,list[r.current.x+1][r.current.y].cost);
					return;
				}
				stack.push(list[b.current.x+1][b.current.y]);
				}
				}
			//west
			//if (r.walls[1] == 0 && !visitedList.contains(list[r.current.x][r.current.y-1]) && !stack.contains(list[r.current.x][r.current.y-1])) {
			if(b.walls[1] == 0) {
				if(list[b.current.x][b.current.y-1].visited == 0) {
			list[b.current.x][b.current.y-1].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x][b.current.y-1].goal == 1) {
					printSolution("dfs",list[b.current.x][b.current.y-1]);
					//printSolution(list[r.current.x][r.current.y-1],visitedList,list[r.current.x][r.current.y-1].cost);
					return;
				}
				stack.push(list[b.current.x][b.current.y-1]);
				}
			}
			//north
			//if (b.walls[3] == 0 && !visitedList.contains(list[b.current.x-1][r.current.y]) && !stack.contains(list[r.current.x-1][r.current.y])) {
			if(b.walls[3] == 0) {
				if(list[b.current.x-1][b.current.y].visited == 0) {
			list[b.current.x-1][b.current.y].parent = new Node(b.current.x, b.current.y);
				if (list[b.current.x-1][b.current.y].goal == 1) {
					printSolution("dfs",list[b.current.x-1][b.current.y]);
					//printSolution(list[r.current.x-1][r.current.y],visitedList,list[r.current.x-1][r.current.y].cost);
					return;
				}
				stack.push(list[b.current.x-1][b.current.y]);
				}
			}
			
		}
	}
	
	
	
	


	
}
