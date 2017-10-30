package games.csc180.model;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	private static final long serialVersionUID = 1L;

	public Hand() {
		super();
	}
	
	public Hand(ArrayList<Card> hand) {
		for(Card c : hand) {
			this.add(c);
		}
	}

}
