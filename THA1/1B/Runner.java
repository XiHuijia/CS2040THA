//Xi Huijia, A0220056W
import java.util.*;

class Runner {
	public String name;
	public double firstLeg;
	public double otherLeg;

	public Runner(String name, double firstLeg, double otherLeg) {
		this.name = name;
		this.firstLeg = firstLeg;
		this.otherLeg = otherLeg;
	}

	public String getName() {
		return name;
	}

	public double getFirst() {
		return firstLeg;
	}

	public double getOther() {
		return otherLeg;
	}

	@Override
	public String toString() {
		return name;
	}
}