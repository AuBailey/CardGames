package games.csc180.model;

public enum Suit {
	spade("Spade"),
	club("Club"),
	diamond("Diamond"),
	heart("Heart"),
	thevoid("void");
	
	String suit;
	Suit(String suit){
		this.suit = suit;
	}
}
