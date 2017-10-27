package junitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import games.csc180.model.Card;
import games.csc180.model.CardName;
import games.csc180.model.Hand;
import games.csc180.model.Player;
import games.csc180.model.Suit;
import games.csc180.model.games.Poker;

public class TestPoker {
	
	

//	@Test
//	public void testDealPlayerCards() {
//		Poker p = new Poker(false);
//		Player pl = new Player("A", 100);
//		p.addPlayer(pl);
//		p.dealPlayerCards();
//		Assert.assertEquals(5, pl.getHand().size());
//	}
	
//	@Test
//	public void testCheckPlayerBalances() {
//		Poker p = new Poker(false);
//		Player p1 = new Player("A", -500);
//		Player p2 = new Player("A", 100);
//		p.addPlayer(p1);
//		p.addPlayer(p2);
//		assertEquals(2, p.getPlayers().size(), 0);
//		p.checkPlayerBalances();
//		assertEquals(1, p.getPlayers().size(), 0);
//	    assertFalse(p.getPlayers().contains(p1));
//	}

//	@Test
//	public void testFold() {
//		Poker p = new Poker(false);
//		Player p1 = new Player("A", 500);
//		Player p2 = new Player("A", 100);
//		p.addPlayer(p1);
//		p.addPlayer(p2);
//		assertEquals(2, p.getPlayers().size(), 0);
//		assertTrue(p.fold(p1));
//		assertFalse(p.getPlayers().contains(p1));
//	}
	
//	@Test
//	public void testCheckHighestCard() {
//		ArrayList<Card> c = new ArrayList<>();
//		c.add(new Card(Suit.club, CardName.ace, 13));
//		Hand hand = new Hand(c);
//		Player p = new Player("a", 100);
//		p.setHand(hand);
//		ArrayList<Card> c2 = new ArrayList<>();
//		c2.add(new Card(Suit.club, CardName.king, 12));
//		Hand hand2 = new Hand(c2);
//		Player p2 = new Player("a", 100);
//		p2.setHand(hand2);
//		Poker poke = new Poker(false);
//		poke.addPlayer(p);
//		poke.addPlayer(p2);
//		assertTrue(p.equals(poke.checkForHighestCard(0, 0)));
//	}

//	@Test
//	public void testThreeOfAKind() {
//		
//	}

//	@Test
//	public void testPairChecking() {
//		
//	}
	
}
