//Xi Huijia, A0220056W
import java.util.Comparator;
class CoinComp implements Comparator<Coin> {
	public int compare(Coin a, Coin b) {
		if (a.key > b.key) {
			return 1;
		} else if (a.key < b.key) {
			return -1;
		} else {
			return 0;
		}
    }

	public boolean equals(Object obj) {
		return this == obj;
	}
}