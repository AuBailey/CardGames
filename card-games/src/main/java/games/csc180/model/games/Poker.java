package games.csc180.model.games;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import games.csc180.model.Card;
import games.csc180.model.Deck;
import games.csc180.model.DeckHandler;
import games.csc180.model.Player;


/*
 * draw and discard
 * match or raise bet
 * folding
 * check for best hand
 * 
 */
public class Poker {

	private ArrayList<Player> players;
	private Deck deck = new Deck(14);
	private DeckHandler dealer;
	private int previousBetAmount;
	private int pot;
	private int winningHandValue;
	private int handWinningPlayerIndex;

	public Poker(boolean housePlaying) {
		players = new ArrayList<>();
		dealer = new DeckHandler();
		if (housePlaying) {
			players.add(new Player("House", 100));
		}
	}

	public void play() {
		while (players.size() > 1) {
			playSingleHand();
		}
	}

	private void playSingleHand() {
		dealPlayerCards();
		playersAntes();
		makePlayerTurns();
		System.out.println(whoWonHand().getName());
	}

	private Player whoWonHand() {
		Player p = null;  
		int currentHandValue = 0;
		for (int i=0;i<players.size();i++) {
			List<Card> currentHand = players.get(i).getHand();
			currentHand = currentHand.stream().sorted((c1, c2) -> Integer.compare(c1.value, c2.value)).collect(Collectors.toList());
			if(currentHand.get(0).value == 10 && currentHand.get(1).value == 11 && currentHand.get(2).value == 12 && currentHand.get(3).value == 13 && currentHand.get(4).value == 14) {
				if(currentHand.get(0).suit.equals(currentHand.get(1).suit) && currentHand.get(1).suit.equals(currentHand.get(2).suit) && 
						currentHand.get(2).suit.equals(currentHand.get(3).suit) && currentHand.get(3).suit.equals(currentHand.get(4).suit)) {//royal flush
					currentHandValue = 9;
				}
			} else if(checkForStraight(currentHand)) {
				if(currentHand.get(0).suit.equals(currentHand.get(1).suit) && currentHand.get(1).suit.equals(currentHand.get(2).suit) && 
						currentHand.get(2).suit.equals(currentHand.get(3).suit) && currentHand.get(3).suit.equals(currentHand.get(4).suit)) {
					currentHandValue = 8;
				}
			} else if(checkFourOfAKind(currentHand)) {
				currentHandValue = 7;
			} else if(checkForThreeOfAKind(currentHand).equals("full house")) {
				currentHandValue = 6;
			} else if(currentHand.get(0).suit.equals(currentHand.get(1).suit) && currentHand.get(1).suit.equals(currentHand.get(2).suit) && currentHand.get(2).suit.equals(currentHand.get(3).suit) && 
					currentHand.get(3).suit.equals(currentHand.get(4).suit)) {
				currentHandValue = 5;
			} else if(checkForStraight(currentHand)) {
				currentHandValue = 4;
			} else if(checkForThreeOfAKind(currentHand).equals("three")) {
				currentHandValue = 3;
			} else if(checkForPairs(currentHand) == 2) {
				currentHandValue = 2;
			} else if(checkForPairs(currentHand) == 1) {
				currentHandValue = 1;
			}
			if(winningHandValue == 5 && currentHandValue == 5) {
				checkForHighestCard(currentHandValue ,i);
			}
			if(winningHandValue ==0 && currentHandValue ==0) {
				checkForHighestCard(currentHandValue ,i);
			}
			if(currentHandValue > winningHandValue) {
				winningHandValue = currentHandValue;
				handWinningPlayerIndex = i;
			}
		}
		p = players.get(handWinningPlayerIndex);
		p.addPotToBank(pot);
		pot = 0;
		checkPlayerBalances();
		return p;
	}

	public void dealPlayerCards() {
		for (int i = 0; i < 5; i++) {
			for (Player p : players) {
				p.DrawCard(deck);
			}
		}
	}

	private void discardAndDraw(Player player, int... indexes) {
		int currentCard;
		int loopCount;
		if (player.getName().equals("House")) {
			player.getHand().remove(0);
			player.DrawCard(deck);
		}
		if (indexes.length >= 1) {
			loop: for (int i = 0; i < indexes.length; i++) {
				if (!player.getName().equals("House")) {
					currentCard = indexes[i];
					if (i > 0 && currentCard != (player.getHand().size() - 1)) {
						loopCount = i;
						player.getHand().remove((indexes[i] - 1) - loopCount);
					} else {
						player.getHand().remove(indexes[i] - 1);
					}
				} else {
					break loop;
				}
			}
		}
	}

	private void checkPlayerBalances() {
		for (Player p : players) {
			if (p.getBankAmount() <= -500) {
				players.remove(p);
			}
		}
	}

	/*
	 * loops through each players individual turns
	 * after a player makes a bet it checks if that bet was a raise and if it was loops through the previous players to check if they want to fold of
	 * match
	 */
	private void makePlayerTurns() {
		loop:
		for(int i=0;i<players.size();i++) {
			if(!fold(players.get(i))) {
				discardAndDraw(players.get(i));
				int betAmount = 0;
				makePlayerBet(players.get(i), betAmount);
				if(betAmount>previousBetAmount && i==0) {//checks that it is not the first bet of the betting round and that the bet is a raise.
					previousBetAmount = betAmount;
					int raisingPlayer = i;
					for(int j=0;j<raisingPlayer;j++) {
						if(!fold(players.get(j))) {
							makePlayerBet(players.get(j), betAmount);
						}		
					}
				}
				pot+=betAmount;
			} else {
				break loop;
			}
		}
	}

	private void makePlayerBet(Player p, int betAmount) {//allows players to make a bet
		if(p.getName().equals("House")) {
			boolean illegalBet = true;
			while (illegalBet) {
				illegalBet = p.makeBet(betAmount, previousBetAmount);
			}
		} else {
			p.makeBet(previousBetAmount,previousBetAmount);
		}
	}

	private void playersAntes() {
		for (Player p : players) {
			p.makeBet(1, 1);
			pot++;
		}
	}

	/*
	 * should be connected to a button that passes in the player and removes them from the list.
	 */
	private boolean fold(Player p) {
		//prompt for fold
		boolean wantsToFold = false;
		if(wantsToFold) {
			players.remove(p);
			return true;
		}
		return false;
	}
	
	private Player checkForHighestCard(int currentWinningHandValue ,int i) {
		Player p = null;
		if(currentWinningHandValue>winningHandValue) {
			handWinningPlayerIndex = i;
		} else if(currentWinningHandValue==winningHandValue) {
			int highestCardValuePrevPlayer =0;
			for(int j=0;j<players.get(handWinningPlayerIndex).getHand().size();j++) {
				if(players.get(handWinningPlayerIndex).getHand().get(i).value>highestCardValuePrevPlayer) {
					highestCardValuePrevPlayer = players.get(handWinningPlayerIndex).getHand().get(i).value;
				}	
			}
			int highestCardValueCurPlayer =0;
			for(int j=0;j<players.get(i).getHand().size();j++) {
				if(players.get(i).getHand().get(i).value>highestCardValuePrevPlayer) {
					highestCardValueCurPlayer = players.get(i).getHand().get(i).value;
				}	
			}
			if(highestCardValuePrevPlayer > highestCardValueCurPlayer) {
				p = players.get(handWinningPlayerIndex);
			} else if(highestCardValuePrevPlayer < highestCardValueCurPlayer) {
				p = players.get(i);
			}
		}
		return p;
	}
	
	private String checkForThreeOfAKind(List<Card> hand) {
		if(hand.get(0).value == hand.get(1).value && hand.get(1).value == hand.get(2).value) {
			if(hand.get(3).value == hand.get(4).value) {
				return "full house";
			}
			return "three";
		} else if(hand.get(1).value == hand.get(2).value && hand.get(2).value == hand.get(3).value) {
			return "three";
		} else if(hand.get(2).value == hand.get(3).value && hand.get(3).value == hand.get(4).value) {
			if(hand.get(0).value == hand.get(1).value) {
				return "full house";
			}
			return "three";
		}
		return "no";
	}
	
	private int checkForPairs(List<Card> hand) {
		int pairCount =0;
		if(hand.get(0).value == hand.get(1).value) {
			pairCount++;
		}
		if(hand.get(1).value == hand.get(2).value) {
			pairCount++;
		}
		if(hand.get(2).value == hand.get(3).value) {
			pairCount++;
		}
		if(hand.get(3).value == hand.get(4).value) {
			pairCount++;
		}
		return pairCount;
	}
	
	private boolean checkForStraight(List<Card> hand) {
		if(hand.get(1).value == (hand.get(0).value+1) && hand.get(2).value == (hand.get(0).value+2) && hand.get(3).value == (hand.get(0).value+3) && hand.get(4).value == (hand.get(0).value+4)) {
			return true;
		}
		return false;
	}
	
	private boolean checkFourOfAKind(List<Card> currentHand) {
		if(currentHand.get(0).value == currentHand.get(1).value && currentHand.get(1).value == currentHand.get(2).value && currentHand.get(2).value == currentHand.get(3).value) {
			return true;
		} else if(currentHand.get(1).value == currentHand.get(2).value && currentHand.get(2).value == currentHand.get(3).value && currentHand.get(3).value == currentHand.get(4).value) {
			return true;
		}
		return false;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
}
