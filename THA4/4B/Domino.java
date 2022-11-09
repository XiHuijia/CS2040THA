//XI Huijia, A0220056W
import java.util.*;

class Domino {
	public static void main(String[] args) {
		//long totalTime = 0l;
		Kattio io = new Kattio(System.in, System.out);
		int numOfCase = io.getInt();

		for (int i = 0; i < numOfCase; i++) {
			int numOfDomino = io.getInt();
			int numOfLines = io.getInt();
			//Scc graph = new Scc(numOfDomino);
			UFDS set = new UFDS(numOfDomino + 1);
			int[] haveParent = new int[numOfDomino + 1];			

			for (int j = 0; j < numOfLines; j++) {
				int vertex = io.getInt();
				int neighbor = io.getInt();

				haveParent[neighbor] = 1;
				//long startTime = System.nanoTime();

				//graph.add(vertex, neighbor);
				set.unionSet(vertex, neighbor);	
				//long endTime   = System.nanoTime();
				//totalTime += endTime - startTime;			
			}

			int sum = 0;
			for(int k = 1; k <= numOfDomino; k++) {
				if (haveParent[k]==0) {
					sum++;
				}
			}

			int result = Math.max(set.numDisjointSets() -1 ,  sum);

			io.println(result);
		}	
		//System.out.println(totalTime);
		io.close();

	}
}