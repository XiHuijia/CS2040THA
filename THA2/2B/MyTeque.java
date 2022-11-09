//Xi Huijia, A0220056W
import java.util.*;

class MyTeque {
	
	public MyDeque frontDeque = new MyDeque();
	public MyDeque backDeque = new MyDeque();

    public void push_front(int value) {
    	if (frontDeque.size() > backDeque.size()) {
    		int temp = frontDeque.getLast();
    		frontDeque.removeLast();
    		backDeque.addFirst(temp);
    	}
    	frontDeque.addFirst(value);
    }

    public void push_back(int value) {
    	if (backDeque.size() == 0) {
    		if (frontDeque.size() == 0) {
    			frontDeque.addLast(value);
    		} else {
    			backDeque.addLast(value);
    		}
    		
    	} else if (frontDeque.size() <= backDeque.size()) {
    		int temp = backDeque.get(0);
    		backDeque.removeFirst();
    		frontDeque.addLast(temp);
    		backDeque.addLast(value);   		
    	} else {
    		backDeque.addLast(value);
    	}    	
    }

    public void push_middle(int value) {
    	if (frontDeque.size() == 0 && backDeque.size() == 0) {
    		push_front(value);
    	} else if (frontDeque.size() == backDeque.size()) {
    		frontDeque.addLast(value);
    	} else if (frontDeque.size() > backDeque.size()) {
    		backDeque.addFirst(value);
    	}
    }

    public int get(int index) {
        if (index <= (frontDeque.size() + backDeque.size() - 1) / 2) {
        		return frontDeque.get(index);        	        	        	
        } else {
        	return backDeque.get(index - frontDeque.size());
        	}
    }
}