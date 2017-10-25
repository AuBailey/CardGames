package games.csc180.model;

import java.util.ArrayList;

public class CardHandler {
	public boolean shuffle(Deck deck) {
		for (int i = 0; i < deck.size() * 3.7; i++) {
			for (int j = 0; j < deck.size(); j++) {
				int rand = (int) (Math.random() * deck.size() + .5);
				Card hold = deck.get(rand);
				deck.set(rand, deck.get(i));
				deck.set(i, hold);
			}
		}
		return true;
	}

	public Card DealCard(Deck deck) {
		return deck.remove(0);
	}

	public ArrayList<Card> DealCards(Deck deck, int amount) {
		ArrayList<Card> cards = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			cards.add(deck.remove(0));
		}
		return cards;
	}
	

}
