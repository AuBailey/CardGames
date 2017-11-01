package games.csc180.model;

import java.util.ArrayList;

public class Player {
	private DeckHandler ch = new DeckHandler();
	private String name;
	private int bankAmount;
	public Hand hand = new Hand();
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
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}

	@Override
	public String toString() {
		return "PLayer name: " + this.getName() + ", Bank Total: " + this.getBankAmount();
	}
	
	/**
	 * Shuffles the player's hand during the game of war.
	 * @return
	 * always returns true
	 */
	public boolean shuffle() {
		for (int i = 0; i < getHand().size() * 3.7; i++) {
			for (int j = 0; j < getHand().size(); j++) {
				int rand = (int) (Math.random() * getHand().size());
				Card hold = getHand().get(rand);
				getHand().set(rand, getHand().get(j));
				getHand().set(j, hold);
			}
		}
		return true;
	}
	
	/**
	 * For the game of war. Removes and plays the top card in the player's hand.
	 * @return
	 * 	returns is the played card.
	 * @throws Exception 
	 */
	public Card PlayTopCard() throws Exception {
		if(hand.size() == 0) {throw new Exception();}
		return hand.remove(0);
	}

	public ArrayList<Card> PlayTopCards(int amount) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < amount; i++) {
			if(getHand().size() == 0) {return cards;}
			cards.add(hand.remove(0));
		}
		return cards;
	}

	public Card PlayCard(int index) {
		return getHand().remove(index);
	}

	public ArrayList<Card> PlayCards(int[] indexes) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < indexes.length; i++) {
			cards.add(getHand().remove(indexes[i]));
		}
		return cards;
	}
	
	public boolean DrawCard(Deck deck) {
		if(!deck.isEmpty()) {
			getHand().add(ch.DealCard(deck));
			return true;
		}
		return false;
	}
	
	public boolean DrawCards(Deck deck, int amount) {
		if(!deck.isEmpty()&&deck.size()>=amount) {
		getHand().addAll(ch.DealCards(deck, amount));
		return true;}
		return false;
	}
	
	/**
	 * Check that the player's bet is a legal bet.
	 * @param amount
	 * @param betAmount
	 * @return
	 */
	public boolean makeBet(int amount, int betAmount) {
		if(amount<betAmount || amount<0) {
			return false;
		}
		bankAmount-=amount;
		return true;
	}
	
	public void addPotToBank(int pot) {
		this.bankAmount += pot;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	@Override
	public boolean equals(Object p) {
		boolean equal = false;
		if(!(p instanceof Player)) {
			return equal;
		}
		equal = this.toString().equals(p.toString());
		return equal;
	}
}
