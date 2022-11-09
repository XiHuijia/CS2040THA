import java.util.*;
class Testing {
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
	    System.out.println(runnerList);

	    List<Runner> fastestThreeOther = runnerList.subList(0,3);
	    System.out.println(fastestThreeOther);
	}
}