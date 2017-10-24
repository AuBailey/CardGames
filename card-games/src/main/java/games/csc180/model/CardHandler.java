package games.csc180.model;

public class CardHandler {
	public boolean shuffle(Deck deck) {
		for (int i = 0; i < deck.size() * 3.7; i++) {
			for (int j = 0; j < deck.size(); j++) {
				int rand = (int) Math.random() * 52;
				Card hold = deck.get(rand);
				deck.set(rand, deck.get(i));
				deck.set(i, hold);
			}
		}
		return true;
	}
}
