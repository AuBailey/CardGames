package junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import games.csc180.model.Deck;
import games.csc180.model.Player;
import junit.framework.Assert;

public class TestPlayer {
	
	private Player p = new Player("a", 100);
	private Deck deck = new Deck(14);
//
//	@Test
//	public void testPlayerShuffle() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testPlayTopCard() {
//		
//	}
//	
//	@Test
//	public void testPlayTopCards() {
//		
//	}
//	
//	@Test
//	public void testPlayCard() {
//		
//	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDrawCard() {
		p.DrawCard(deck);
		Assert.assertEquals(1, p.getHand().size());
	}

}
