package ai_searchalgorithms;

public class Block {

	Node parent;
    Node current;   //final???
    Node end;
	int column;
	int row;
	int start;
	int goal;
	int cost;
	int walls[] = {0,0,0,0}; //dbgk
	int visited = 0;
	double estimatedcost;

	Block(){
	
	}
	
	public Block(int column, int row, int start, int goal, int cost,int visited,double estimatedcost){

		this.column =  column;
		this.row = row;
		this.start = start;
		this.goal = goal;
		this.cost = cost;
		this.visited = visited;
		//this.estimatedcost = Math.sqrt((Math.pow(b.row -current.x, 2) + Math.pow(b.column-current.y, 2)));;
		this.estimatedcost = estimatedcost;
		this.current = new Node(row, column);
		//this.end = end;
	}
	
	public String toString() {
		return "row: " + row + "\n"
				+ "column: " + column + "\n"
				+ "start: " + start + "\n"
				+ "goal: " + goal + "\n"
				+ "cost: " + cost + "\n"
				+ "walls: " + walls[0] + ","+walls[1] + ","+ walls[2] + "," + walls[3] + "\n"
				+ "visited: " + visited ;
				
		
		
	}
}
