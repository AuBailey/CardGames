package games.csc180.model;

import java.util.ArrayList;

public class Deck extends ArrayList<Card>{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Card> deck = new ArrayList<>();

	public Deck() {
		for (int i = 1; i <= 13; i++) {
			deck.add(new Card(Suit.spade, i));
		}
		for (int i = 1; i <= 13; i++) {
			deck.add(new Card(Suit.club, i));
		}
		for (int i = 1; i <= 13; i++) {
			deck.add(new Card(Suit.heart, i));
		}
		for (int i = 1; i <= 13; i++) {
			deck.add(new Card(Suit.diamond, i));
		}
	}
}
