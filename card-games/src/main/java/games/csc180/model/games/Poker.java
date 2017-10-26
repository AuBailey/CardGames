package games.csc180.model.games;

import java.util.ArrayList;

import games.csc180.model.CardHandler;
import games.csc180.model.Deck;
import games.csc180.model.Player;

public class Poker {

	private ArrayList<Player> players;
	private Deck deck = new Deck(14);
	private CardHandler dealer;
	private int previousBetAmount;
	private int pot;

	public Poker(boolean housePlaying) {
		players = new ArrayList<>();
		dealer = new CardHandler();
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
		makePlayerTurn();
		whoWonHand();
	}

	private void whoWonHand() {
		checkPlayerBalances();
	}

	private void dealPlayerCards() {
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
		if(indexes.length >= 1) {
		loop:
			for (int i = 0; i < indexes.length; i++) {
				if (!player.getName().equals("House")) {
					currentCard = indexes[i];
					if (i > 0 && currentCard != (player.getHand().size() - 1)) {
						loopCount = i;
						player.getHand().remove((indexes[i]-1) - loopCount);
					} else {
						player.getHand().remove(indexes[i]-1);
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
	
	private void makePlayerTurn() {
		for(int i=0;i<players.size();i++) {
			discardAndDraw(players.get(i));
			int betAmount = 0;
			makePlayerBet(players.get(i), betAmount);
			if(betAmount>previousBetAmount && i==0) {//checks that it is not the first bet of the betting round and that the bet is a raise.
				previousBetAmount = betAmount;
				int raisingPlayer = i;
				for(int j=0;j<raisingPlayer;j++) {
					makePlayerBet(players.get(j), betAmount);
				}
			}
		}
	}
	
	private void makePlayerBet(Player p, int betAmount) {
		boolean illegalBet = true; 
		while(illegalBet) {
			illegalBet = p.makeBet(betAmount, previousBetAmount);
		}
	}
	
	private void playersAntes() {
		for (Player p : players) {
			p.makeBet(1, 1);
			pot++;
		}
	}

}
