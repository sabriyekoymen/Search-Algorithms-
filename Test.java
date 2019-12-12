package ai_searchalgorithms;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Abstract list = new Abstract();
		list.Maze();
		
		Node start = new Node(list.row,list.column);

		SearchAlgorithms algorithm = new SearchAlgorithms();
		
		algorithm.dfs(start);
		
		algorithm.bfs(start);
		
		algorithm.ucs(start);
		
		
		IterativeDeepningSearch a = new IterativeDeepningSearch();
		a.ids(start);
	}

}
