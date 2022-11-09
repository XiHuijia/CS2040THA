//Xi Huijia, A0220056W
import java.util.*;

public class BestRelayTeam {
	public static void main(String args[]){
		OtherLegComparator otherComp = new OtherLegComparator();
        Scanner sc = new Scanner(System.in);
	    int numOfRunners = sc.nextInt();
	    

	    List<Runner> runnerList = new ArrayList<>();
	    for(int i = 0; i < numOfRunners; i++){
	    	sc.nextLine();
	    	String name = sc.next();
	    	double firstLeg = sc.nextDouble();
	    	double otherLeg = sc.nextDouble();
	    	Runner runner = new Runner(name, firstLeg, otherLeg);
	    	runnerList.add(runner);
	    }

	    Collections.sort(runnerList, otherComp);
	    List<Runner> fastestThreeOther = runnerList.subList(0,3);
	    
	    double shortestTime = 100000000.0;
	    List<Runner> finalNameList = new ArrayList<>();
	    for(int i = 0; i < numOfRunners; i++){
	    	double time = 0.0;
	    	List<Runner> nameList = new ArrayList<>();
	    	Runner firstRunner = runnerList.get(i);
	    	time = time + firstRunner.getFirst();
	    	
	    	for (int j = 0; j < 3; j++) {
	    		if (fastestThreeOther.get(j).equals(firstRunner)) {
	    			nameList.add(runnerList.get(3));
	    		} else {
	    			nameList.add(fastestThreeOther.get(j));
	    		}	
	    	}
	    	for (int j = 0; j < 3; j++) {
	    		time = time + nameList.get(j).getOther();
	    	}
	    	nameList.add(0, firstRunner);

	    	if (time < shortestTime) {
	    		shortestTime = time;
	    		finalNameList = nameList;
	    	}
	    }
	    System.out.println(shortestTime);
	    for (int i = 0; i < 4; i++) {    
            System.out.println(finalNameList.get(i));  
        }
    }
}
