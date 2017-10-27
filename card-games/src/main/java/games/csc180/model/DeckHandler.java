package games.csc180.model;

import java.util.ArrayList;

public class DeckHandler {
	
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
		try {
		return deck.remove(0);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return new Card(Suit.thevoid, CardName.ace, 1);
	}

	public ArrayList<Card> DealCards(Deck deck, int amount) {
		ArrayList<Card> cards = new ArrayList<Card>();
		try {
		for (int i = 0; i < amount; i++) {
			cards.add(deck.remove(0));
		}
		return cards;
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		ArrayList<Card> errCard = new ArrayList<Card>();
		errCard.add(new Card(Suit.thevoid, CardName.ace, 1));
		return errCard;
	}
	
	public boolean returnCardsToDeck(Deck deck, ArrayList<Card> cards) {
		return deck.addAll(cards);
	}
	
	public boolean returnCardsToDeck(Deck deck, Card card) {
		return deck.add(card);
	}

}
