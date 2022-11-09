//XI Huijia, A0220056W
import java.util.*;

class Team {
	private final int name;
	private final int solved;
	private final int penalty;

	Team(int name, int solved, int penalty) {
		this.name = name;
		this.solved = solved;
		this.penalty = penalty;
	}

	int getName() {
		return this.name;
	}

	int getSolved() {
		return this.solved;
	}

	int getPenalty() {
		return this.penalty;
	}

	int compareTo(Team another) {
		if (this.getSolved() == another.getSolved()) {
			if (this.getPenalty() == another.getPenalty()) {
				return another.getName() - this.getName();
			} else {
				return another.getPenalty() - this.getPenalty();
			}
			
		} else {
			return this.getSolved() - another.getSolved();
		}
	}

	public String toString() {
		return String.format("Team %s with %s solved and %s penalty", this.name, this.solved, this.penalty);
	}
}