//XI Huijia, A0220056W
import java.util.*;
class AVLNode {
	Team key;
	AVLNode left;
	AVLNode right;
	int height;
	int size;

	AVLNode(Team key, AVLNode left, AVLNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.height = 0;
		this.size = 1;
	}

	public String toString() {
		return String.format("Key is [%s]", this.key);
	}
}