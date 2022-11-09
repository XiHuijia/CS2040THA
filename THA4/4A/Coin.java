//XI Huijia, A0220056W
import java.util.*;

class Coin {
	public final int x;
	public final int y;
	public final int key;

	Coin(int x, int y, int key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}

    public String toString() {
    	return String.format("x = %d, y = %d, value = %d", this.x, this.y, this.key);
    } 
}