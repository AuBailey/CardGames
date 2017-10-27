package games.csc180.model;

import java.util.ArrayList;

public class Deck extends ArrayList<Card> {
	private static final long serialVersionUID = 1L;

	ArrayList<Card> deck = new ArrayList<Card>();

	/**
	 * Creates a new ArrayList of Cards containing the standard 52 cards
	 * 
	 * @param maxValue
	 *            should be 13 for solitaire, 10 or 11 for blackjack, 14 for war and
	 *            14 for everything else.
	 */
	public Deck(int maxValue) {
		boolean blackJack = false;
		if (maxValue == 10 || maxValue == 11) {
			maxValue = 13;
			blackJack = true;
		}
		Suit[] suits = Suit.values();
		CardName[] cardName = CardName.values();
		boolean ace14 = false;
		outer: for (int i = 0; i < 4; i++) {
			for (int j = maxValue - 12; j <= maxValue; j++) {
				int jay = j;
				if (j == 14) {
					j = 1;
					ace14 = true;
				}
				if (blackJack && j > 10) {
					jay = 10;
				}

				deck.add(new Card(suits[i], cardName[j], jay));
				if (ace14) {
					break outer;
				}
			}
		}
	}
}
