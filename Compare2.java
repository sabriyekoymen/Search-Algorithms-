package ai_searchalgorithms;

import java.util.Comparator;

public class Compare2 implements Comparator<Block> {
	
	public int compare(Block b1, Block b2) {
		
		if(b1.estimatedcost > b2.estimatedcost) {
			return 1;
		}
		else {
			return -1;
		}
		
	}

}