//Xi Huijia, A0220056W
import java.util.*;

class Join {
	public static void main(String args[]){
		Kattio io = new Kattio(System.in, System.out);
		while (io.hasMoreTokens()) {
            int numOfStrings = io.getInt();

            //make an LinkedList of strings
            List<StringBuilder> stringList = new ArrayList<>();

            LinkedList[] indexOrder= new LinkedList[numOfStrings];
            for (int i = 0; i < numOfStrings; i++) {
            	StringBuilder str  = new StringBuilder();  
                str.append(io.getWord());
            	stringList.add(str);
            	
            	LinkedList index = new LinkedList();
            	index.addBack(i);
            	indexOrder[i] = index;
            }



            int operationA = 0;
            for (int i = 0; i < numOfStrings - 1; i++) {
            	operationA = io.getInt() - 1;
            	int operationB = io.getInt() - 1;

            	indexOrder[operationA].addAll(indexOrder[operationB]);            	         	
                }
                       
            LinkedList finalIndex = indexOrder[operationA];       
            for (ListNode cur = finalIndex.getHead(); cur != null; cur = cur.getNext()) {
            	int index = cur.getItem();
                io.print(stringList.get(index));	
            }                       
        }
    io.close();
	}
}
