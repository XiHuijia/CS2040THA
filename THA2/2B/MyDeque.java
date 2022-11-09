//Xi Huijia, A0220056W
import java.util.*;

class MyDeque {
    public Integer[] elements;
    public int head;
    public int tail;

	public MyDeque() {
		elements = new Integer[16];
		head = 0;
		tail = 0;
	}

	public int size() {
		if (head > tail) {
			return elements.length - head + tail;
		} else {
			return tail - head;
		}
	}

	public int get(int index) {
		if (tail < head && index + head >= elements.length) {
			return elements[index - elements.length + head];
		} else {
			return elements[head + index];
		}		
	}

	public int getFirst() {
		return elements[head];
	}

	public int getLast() {
		if (tail !=0) {
			return elements[tail-1];
		} else {
			return elements[elements.length-1];
		}
		
	}

	public void addFirst(int value) {
        elements[head = (head - 1) & (elements.length - 1)] = value;
        if (head == tail)
            doubleCapacity();
	}

	public void addLast(int value) {
        elements[tail] = value;
        
        if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            doubleCapacity();
	}

	public void removeFirst() {
        int h = head;
        int result = elements[h];
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
	}

	public void removeLast() {
        int t = (tail - 1) & (elements.length - 1);
        int result = elements[t];
        elements[t] = null;
        tail = t;
	}

	private void doubleCapacity() {
        assert head == tail;
        int p = head;
        int n = elements.length;
        int r = n - p; // number of elements to the right of p
        int newCapacity = n << 1;
        
        Integer[] a = new Integer[newCapacity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = a;

        head = 0;
        tail = n;
	}	 
}