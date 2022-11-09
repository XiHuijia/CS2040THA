//XI Huijia, A0220056W
import java.util.*;

class Galactic {
	public static void main(String[] args) {
		//long startTime = System.nanoTime();
		long totalTime = 0l;

		Kattio io = new Kattio(System.in, System.out);
		int numOfTeams = io.getInt();
		int numOfEvents = io.getInt();

        HashMap<Integer, Team> map = new HashMap<Integer, Team>();
        AVLTree tree = new AVLTree();
        Team t = new Team(1, 0, 0);
        map.put(1, t);
        tree.insert(t);

		for (int i = 0; i < numOfEvents; i++) {
			int teamID = io.getInt();
			int penalty = io.getInt();

			if (!map.containsKey(teamID)) {
				Team team = new Team(teamID, 1, penalty);
				map.put(teamID, team);
				tree.insert(team);
			} else {
				Team team = map.get(teamID);
				int solved = team.getSolved();
				int existedPenalty = team.getPenalty();
				Team newTeam = new Team(teamID, solved + 1, existedPenalty + penalty);
				map.remove(teamID);
				map.put(teamID, newTeam);
				tree.remove(team);
				tree.insert(newTeam);
			}
			
			int total = map.size();
			Team t1 = map.get(1);
			
			//long startTime = System.nanoTime();
			int rank = tree.rank(t1);
			int output = total-rank+1;
			io.println(output);

			//long endTime   = System.nanoTime();
			//totalTime += endTime - startTime;

			/*
			io.println(map);
			io.println(tree.root);
			io.println(tree.root.size);
			io.println(tree.root.left);			
			io.println(tree.root.right);
			
			
            if (tree.root.left != null) {
            	io.println(tree.root.left.size);
                io.println(tree.root.left.left);
                io.println(tree.root.left.right);
            }
            if (tree.root.right != null) {
            	io.println(tree.root.right.size);
                io.println(tree.root.right.left);
                io.println(tree.root.right.right);
            }*/
            		
	    }
	    //long endTime   = System.nanoTime();
		//long totalTime = endTime - startTime;
		//io.println(totalTime);
		//io.println(totalTime);
	    io.close();
	}
}