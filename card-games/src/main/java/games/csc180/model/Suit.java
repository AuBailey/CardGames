package games.csc180.model;

public enum Suit {
	spade("spade"),
	club("club"),
	diamond("diamond"),
	heart("heart");
	
	String suit;
	Suit(String suit){
		this.suit = suit;
	}
}
