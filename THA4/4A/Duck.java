//XI Huijia, A0220056W
import java.util.*;

class Duck {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int lengthM = io.getInt();
		int widthN = io.getInt();
		int ladder = 0;

		int[][] adjMatrix1 = new int[lengthM][widthN];  //read input data
		int[][] adjMatrix2 = new int[lengthM][widthN];  //boolean array matrix to record visited coins
		
		for (int i = 0; i < lengthM; i++) {
			for (int j = 0; j < widthN; j++) {
				adjMatrix1[i][j] = io.getInt();
				adjMatrix2[i][j] = 0;
			}
		}

		PriorityQueue<Coin> coins = new PriorityQueue<Coin>(new CoinComp());
		
		coins.add(new Coin(0, 0, 0));

		int[] direction1 = {0, 0, 1, -1};
		int[] direction2 = {1, -1, 0, 0};

		while (!coins.isEmpty()) {
			Coin temp = coins.poll();
			//io.println(temp);
			
			if (adjMatrix2[temp.x][temp.y] == 1) {
				continue;
			}

			if (temp.x + 1 == lengthM && temp.y + 1 == widthN ) {
				break;
			}

			adjMatrix2[temp.x][temp.y] = 1;
            ladder = Math.max(ladder, temp.key);

			for (int i = 0; i < 4; i++) {
				int newX = temp.x + direction1[i];
				int newY = temp.y + direction2[i];
				if (newX < 0 || newX >= lengthM || newY < 0 || newY >= widthN) {
					continue;					
				}

				if (adjMatrix2[newX][newY] == 0) {
					Coin newCoin = new Coin(newX, newY, Math.max(0, adjMatrix1[newX][newY] - adjMatrix1[temp.x][temp.y]));
					coins.add(newCoin);
				}
			}		           
		}
		io.println(ladder);		
		io.close();
	}
}