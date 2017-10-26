package junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import games.csc180.model.Deck;

public class TestDeck {

	@Test
	public void testDeckSize() {
		Deck deck = new Deck(14);
		assertEquals(52, deck.size(), 0);
	}

	@Test
	public void testBlackJackDeck() {
		Deck deck = new Deck(10);
		boolean thingsGreaterThan10 = false;
		for(int i=0;i<deck.size();i++) {
		if(deck.get(i).value>10) {thingsGreaterThan10 = true;}
		}
		assertFalse(thingsGreaterThan10);
	}
	
//	@Test
//	public void testSuits() {
//		
//	}
}
