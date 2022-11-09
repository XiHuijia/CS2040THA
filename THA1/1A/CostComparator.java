//Xi Huijia, A0220056W
import java.util.Comparator;
class CostComparator implements Comparator<Card> {
	public int compare(Card a, Card b) {
		if (a.cost > b.cost) {
			return 1;
		} else if (a.cost < b.cost) {
			return -1;
		} else {
			return 0;
		}
    }

	public boolean equals(Object obj) {
		return this == obj;
	}
}