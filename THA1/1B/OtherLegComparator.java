//Xi Huijia, A0220056W
import java.util.Comparator;
class OtherLegComparator implements Comparator<Runner> {
	public int compare(Runner a, Runner b) {
		if (a.getOther() > b.getOther()) {
			return 1;
		} else if (a.getOther() < b.getOther()) {
			return -1;
		} else {
			return 0;
		}
    }

	public boolean equals(Object obj) {
		return this == obj;
	}
}