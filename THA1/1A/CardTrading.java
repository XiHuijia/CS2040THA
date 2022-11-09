//Xi Huijia, A0220056W
import java.util.*;

class CardTrading {
	public static void main(String args[]){
		CostComparator costComp = new CostComparator();
		Scanner sc = new Scanner(System.in);
		long numOfCards = sc.nextLong();
		long numOfTypes = sc.nextLong();
		long numOfDesiredCombos = sc.nextLong();
		sc.nextLine();

		//cards(arraylist)
		List<Long> cardsList = new ArrayList<>();
		for (long i = 0; i < numOfCards; i++) {
			cardsList.add(sc.nextLong());
		}
		
		//cards and number of cards (hashmap)
		HashMap<Long, Integer> cardsMap = new HashMap<Long, Integer>();
		for (int i = 0; i < numOfCards; i++) {
			long currentCard = cardsList.get(i);
			if (cardsMap.containsKey(currentCard)) {
				int value = cardsMap.get(currentCard);
				cardsMap.replace(currentCard, value, value + 1);
			} else {
				cardsMap.put(currentCard, 1);
			}
		}

        //cards and price
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numOfTypes; i++) {
			sc.nextLine();
			long buy = sc.nextLong();
			long sell = sc.nextLong();
			long type = i+1;
			int num = 0;
			if (cardsMap.containsKey(type)) {
				num = cardsMap.get(type);
			} else {
				num = 0;
			}

			long cost = 0;			
			if (num == 2) {
				cost = sell * 2;												
			} else if (num == 1) {
				cost = sell + buy;				
			} else {
                cost = buy * 2;
			}
			Card card = new Card(type, num, buy, sell, cost);
			cards.add(card);			
		}
		Collections.sort(cards, costComp);	

        //final desk
		List<Card> desiredCards = new ArrayList<>();
		
		for (int i = 0; i < numOfDesiredCombos; i++) {
			desiredCards.add(cards.get(i));
			cards.get(i).desired = true;			
		}
		
		long spending = 0;

		//buy desired cards
		for (int i = 0; i < numOfDesiredCombos; i++) {
			Card current = desiredCards.get(i);
			if (current.num < 2) {
				spending -= current.buy * (2 - current.num);			
			}
		}

        //sell undesired cards
		for (int i = (int)numOfDesiredCombos; i < cards.size() ; i++) {
			if (cards.get(i).desired == false) {
				spending += cards.get(i).sell * cards.get(i).num;
			}
		}
		System.out.println(spending);
	}		
}




		/*System.out.println(cardsList);
		System.out.println(cardsMap);
		System.out.println(cards);
		System.out.println(desiredCards);
		*/

