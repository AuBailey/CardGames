package games.csc180.model;

public enum Suit {

	spade("Spade"),
	club("Club"),
	diamond("Diamond"),
	heart("Heart"),
	thevoid("thevoid");
	
	String suit;
	Suit(String suit){
		this.suit = suit;
	}
}
	
