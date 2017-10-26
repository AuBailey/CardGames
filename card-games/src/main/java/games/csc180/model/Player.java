package games.csc180.model;

import java.util.ArrayList;

public class Player {
	private DeckHandler ch = new DeckHandler();
	private String name;
	private int bankAmount;
	Hand hand = new Hand();

	public Player(String name, int bankAmount) {
		setName(name);
		setBankAmount(bankAmount);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBankAmount(int amount) {
		this.bankAmount = amount;
	}

	public int getBankAmount() {
		return this.bankAmount;
	}

	@Override
	public String toString() {
		return "PLayer name: " + this.getName() + ", Bank Total: " + this.getBankAmount();
	}

	public boolean shuffle() {
		for (int i = 0; i < hand.size() * 3.7; i++) {
			for (int j = 0; j < hand.size(); j++) {
				int rand = (int) (Math.random() * hand.size() + .5);
				Card hold = hand.get(rand);
				hand.set(rand, hand.get(i));
				hand.set(i, hold);
			}
		}
		return true;
	}

	public Card PlayTopCard() {
		return hand.remove(0);
	}

	public ArrayList<Card> PlayTopCards(int amount) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < amount; i++) {
			cards.add(hand.remove(0));
		}
		return cards;
	}

	public Card PlayCard(int index) {
		return hand.remove(index);
	}

	public ArrayList<Card> PlayCards(int[] indexes) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < indexes.length; i++) {
			cards.add(hand.remove(indexes[i]));
		}
		return cards;
	}
	
	public boolean DrawCard(Deck deck) {
		if(!deck.isEmpty()) {
		hand.add(ch.DealCard(deck));
		return true;}
		return false;
	}
	
	public boolean DrawCards(Deck deck, int amount) {
		if(!deck.isEmpty()&&deck.size()>=amount) {
		hand.addAll(ch.DealCards(deck, amount));
		return true;}
		return false;
	}
}
