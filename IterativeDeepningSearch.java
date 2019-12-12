package ai_searchalgorithms;

public class IterativeDeepningSearch extends Abstract {
	
	
	public void ids(Node start){
		this.start = start;
		Maze();
		Block b = null;
		int limit = 0;
		while ((b = dls(list[start.x][start.y], limit)) == null){
			//System.out.println("not found in limit:"+limit);
			limit++;
		}
		list[start.x][start.y].parent = null;
		printSolution("ids", b);
	}
	
	
	  public Block dls(Block block, int limit){
			
		    visitedList.add(block);
		    block.visited = 1;
			if (block.goal == 1) {
				return block;
				
			}else if (limit == 0) {
				return null;
			}else {
				Block result = null;
		
				
				//if(block.walls[0] == 0) {
				//	if(block.parent != null) {
					//	if(block.current.y+1 != block.parent.y) {
				if (block.walls[0] == 0 && ((block.parent != null )? (block.current.y+1)!=block.parent.y:true)) {
							list[block.current.x][block.current.y+1].parent = block.current;
							result = dls(list[block.current.x][block.current.y+1], limit-1);
							if (result != null) {
								return result;
							}
				}
					//	}
				//	}
				//}
				
				/*if(block.walls[2] == 0) {
					if(block.parent != null) {
						if(block.current.x+1 != block.parent.x) {*/
				if (block.walls[2] == 0 && ((block.parent != null )? (block.current.x+1)!=block.parent.x:true)) {
							list[block.current.x+1][block.current.y].parent = block.current;
							result = dls(list[block.current.x+1][block.current.y], limit-1);
							if (result != null) {
								return result;
							}
					//	}
					//}
			//	}
				
			/*	if(block.walls[1] == 0) {
					if(block.parent != null) {
						if(block.current.y-1 != block.parent.y) {*/
							if (block.walls[1] == 0 && ((block.parent != null )? (block.current.y-1)!=block.parent.y:true)) {
							list[block.current.x][block.current.y-1].parent = block.current;
							result = dls(list[block.current.x][block.current.y-1], limit-1);
							if (result != null) {
								return result;
							}
							}
					//	}
					//}
				//}
		
				/*if(block.walls[3] == 0) {
					if(block.parent != null) {
						if(block.current.x-1 != block.parent.x) {*/
							if (block.walls[3] == 0 && ((block.parent != null )? (block.current.x-1)!=block.parent.x:true)) {
							list[block.current.x-1][block.current.y].parent = block.current;
							result = dls(list[block.current.x-1][block.current.y], limit-1);
							if (result != null) {
								return result;
							}
							}
					//	}
				//	}
				//}
				
			}
	  
				
			return null;
		}
	
}

}