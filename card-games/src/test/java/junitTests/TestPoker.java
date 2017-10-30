package junitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
//		Hand h1 = new Hand();
//		h1.add(new Card(Suit.club, CardName.ace, 13));
//		h1.add(new Card(Suit.spade, CardName.ace, 13));
//		h1.add(new Card(Suit.heart, CardName.ace, 13));
//		h1.add(new Card(Suit.club, CardName.eight, 8));
//		h1.add(new Card(Suit.heart, CardName.five, 5));
//		Player p = new Player("a", 100);
//		p.setHand(h1);
//		Poker poke = new Poker(false);
//		poke.addPlayer(p);
//		assertEquals("three", poke.checkForThreeOfAKind(p.getHand()));
//	}
	
//	@Test
//	public void testFullHouse() {
//		Hand h1 = new Hand();
//		h1.add(new Card(Suit.club, CardName.ace, 13));
//		h1.add(new Card(Suit.spade, CardName.ace, 13));
//		h1.add(new Card(Suit.heart, CardName.ace, 13));
//		h1.add(new Card(Suit.club, CardName.eight, 8));
//		h1.add(new Card(Suit.heart, CardName.five, 8));
//		Player p = new Player("a", 100);
//		p.setHand(h1);
//		Poker poke = new Poker(false);
//		poke.addPlayer(p);
//		assertEquals("full house", poke.checkForThreeOfAKind(p.getHand()));
//	}

//	@Test
//	public void testSinglePairChecking() {
//		Hand h1 = new Hand();
//		h1.add(new Card(Suit.club, CardName.ace, 13));
//		h1.add(new Card(Suit.spade, CardName.ace, 13));
//		h1.add(new Card(Suit.heart, CardName.nine, 9));
//		h1.add(new Card(Suit.club, CardName.eight, 8));
//		h1.add(new Card(Suit.heart, CardName.five, 5));
//		Player p = new Player("a", 100);
//		List<Card> cards = h1.stream().sorted((c1, c2) -> Integer.compare(c1.value, c2.value)).collect(Collectors.toList());
//		p.setHand(h1);
//		Poker poke = new Poker(false);
//		poke.addPlayer(p);
//		assertEquals(1, poke.checkForPairs(cards));
//	}
	
//	@Test
//	public void testTwoPairChecking() {
//		Hand h1 = new Hand();
//		h1.add(new Card(Suit.club, CardName.ace, 13));
//		h1.add(new Card(Suit.spade, CardName.ace, 13));
//		h1.add(new Card(Suit.heart, CardName.nine, 9));
//		h1.add(new Card(Suit.club, CardName.eight, 8));
//		h1.add(new Card(Suit.heart, CardName.eight, 8));
//		Player p = new Player("a", 100);
//		List<Card> cards = h1.stream().sorted((c1, c2) -> Integer.compare(c1.value, c2.value)).collect(Collectors.toList());
//		p.setHand(h1);
//		Poker poke = new Poker(false);
//		poke.addPlayer(p);
//		assertEquals(2, poke.checkForPairs(cards));
//	}
	
//	@Test
//	public void testFourOfAKind() {
//		Hand h1 = new Hand();
//		h1.add(new Card(Suit.club, CardName.ace, 13));
//		h1.add(new Card(Suit.spade, CardName.ace, 13));
//		h1.add(new Card(Suit.heart, CardName.ace, 13));
//		h1.add(new Card(Suit.diamond, CardName.eight, 13));
//		h1.add(new Card(Suit.heart, CardName.eight, 8));
//		Player p = new Player("a", 100);
//		List<Card> cards = h1.stream().sorted((c1, c2) -> Integer.compare(c1.value, c2.value)).collect(Collectors.toList());
//		p.setHand(h1);
//		Poker poke = new Poker(false);
//		poke.addPlayer(p);
//		assertTrue(poke.checkFourOfAKind(cards));
//	}
	
//	@Test
//	public void testStraight() {
//		Hand h1 = new Hand();
//		h1.add(new Card(Suit.club, CardName.two, 2));
//		h1.add(new Card(Suit.spade, CardName.three, 3));
//		h1.add(new Card(Suit.heart, CardName.four, 4));
//		h1.add(new Card(Suit.diamond, CardName.five, 5));
//		h1.add(new Card(Suit.heart, CardName.six, 6));
//		Player p = new Player("a", 100);
//		List<Card> cards = h1.stream().sorted((c1, c2) -> Integer.compare(c1.value, c2.value)).collect(Collectors.toList());
//		p.setHand(h1);
//		Poker poke = new Poker(false);
//		poke.addPlayer(p);
//		assertTrue(poke.checkForStraight(cards));
//	}
	
}
