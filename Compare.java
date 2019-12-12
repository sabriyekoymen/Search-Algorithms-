package ai_searchalgorithms;

import java.util.Comparator;

public class Compare implements Comparator<Block> {
	
	@Override
	public int compare(Block b1, Block b2) {
		
		if(b1.cost > b2.cost) {
			return 1;
		}
		else {
			return -1;
		}
		
	}

}
