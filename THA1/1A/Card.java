//Xi Huijia, A0220056W
import java.util.*;

class Card {
	public long type;
	public int num;
	public long buy;
	public long sell;
	public long cost;
	public boolean desired;

	public Card (long type, int num, long buy, long sell, long cost) {
		this.type = type;
		this.num = num;
		this.buy = buy;
		this.sell = sell;
		this.cost = cost;
		this.desired = false;
	}

	@Override
	public String toString() {
		return String.valueOf(type);
	}
}