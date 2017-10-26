package games.csc180.model;

public enum CardName {
	ace("ace"),
	two("two"),
	three("three"),
	four("four"),
	five("five"),
	six("six"),
	seven("seven"),
	eight("eight"),
	nine("nine"),
	ten("ten"),
	jack("jack"),
	queen("queen"),
	king("king");
	
	String cardName;
	
	private CardName(String cardName) {
		this.cardName = cardName;
	}

}
