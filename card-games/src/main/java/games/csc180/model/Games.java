package games.csc180.model;

public enum Games {
	war("war"),
	poker("poker"),
	gofish("gofish"),
	blackjack("blackjack"),
	solitaire("solitaire");

	String game;
	Games(String game) {
		this.game = game;
	}
}
