package games.csc180.model;

public class Card {
	
	public Card(Suit suit, CardName cardName, int value) {
		super();
		this.suit = suit;
		this.cardName = cardName;
		this.value = value;
	}
	public Suit suit;
	public int value;
	public CardName cardName;
	
	
}
