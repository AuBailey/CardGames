package junitTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import games.csc180.model.Player;
import games.csc180.model.games.Poker;

public class TestPoker {
	
	private Poker p = new Poker(false);
	Player pl = new Player("A", 100);

	@Test
	public void testDealPlayerCards() {
		p.addPlayer(pl);
		p.dealPlayerCards();
		Assert.assertEquals(5, pl.getHand().size());
	}
	
//	@Test
//	public void testCheckPlayerBalances() {
//		fail("not yet implemented");
//	}
//	
//	@Test
//	public void testFold() {
//		
//	}
//	
//	@Test
//	public void testCheckHighestCard() {
//		
//	}
//	
//	@Test
//	public void testThreeOfAKind() {
//		
//	}
//	
//	@Test
//	public void testPairChecking() {
//		
//	}
	
}
