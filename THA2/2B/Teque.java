//Xi Huijia, A0220056W
import java.util.*;

class Teque {
	public static void main(String args[]){
		Kattio io = new Kattio(System.in, System.out);
		while (io.hasMoreTokens()) {
			int numOfOperations = io.getInt();

			MyTeque teque = new MyTeque();

			for (int i = 0; i < numOfOperations; i++) {
				String operation = io.getWord();
                int value = io.getInt();

                if (operation.equals("push_front")) {
                	teque.push_front(value);                	
                }
                if (operation.equals("push_back")) {
                	teque.push_back(value);                	
                }
                if (operation.equals("push_middle")) {
                	teque.push_middle(value);
                	
                }
                if (operation.equals("get")) {
                	io.println(teque.get(value));
                }
			}
		}
		io.close();
	}
}