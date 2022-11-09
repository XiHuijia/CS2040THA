//Xi Huijia, A0220056W
import java.util.*;

class Ladice {
	public static void main(String args[]){
		Kattio io = new Kattio(System.in, System.out);
		while (io.hasMoreTokens()) {
			int numOfItems = io.getInt();
			int numOfDrawers = io.getInt();

			UFDS disjointSet = new UFDS(numOfDrawers+1);

			for (int i = 0; i < numOfItems; i++) {
				int drawerA = io.getInt();
				int drawerB = io.getInt();

				if (!disjointSet.isSameSet(drawerA, drawerB)) {
					disjointSet.unionSet(drawerA, drawerB);
					io.println("LADICA");
				} else {
					if (disjointSet.isSameSet(drawerA, 0)) {
						io.println("SMECE");
					} else {
						disjointSet.unionSet(drawerA, 0);
						io.println("LADICA");
					}
				}				
			}
		}
		io.close();		
	}
}