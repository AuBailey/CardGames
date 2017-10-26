package games.csc180.model;

import java.lang.Thread.State;
import java.util.ArrayList;

public class War {
	public static int numberOfPlayers = 2;
	public static ArrayList<Card> field = new ArrayList<Card>();

//	public static void main(String[] args) throws InterruptedException {
//		Player[] players = new Player[numberOfPlayers];
//		Deck deck = new Deck(14);
//		String[] names = null;
//		for (int i = 0; i < numberOfPlayers; i++) {
//			players[i] = new Player(names[i], 0);
//		}
//		outerLoop: while (true) {
//			for (int i = 0; i < numberOfPlayers; i++) {
//				if (!players[i].DrawCard(deck)) {
//					break outerLoop;
//				}
//			}
//		}
//		rotateTurns: while (true) {
//			for (int i = 0; i < numberOfPlayers; i++) {
//				players[i].shuffle();
//			}
//			initiateWar(players);
//			if(players[0].hand.isEmpty()||players[1].hand.isEmpty()) {
//				return 1;
//			}
//			else if(players[1].hand.isEmpty()) {
//				return 0;
//			}
//		}
//	}
	
	/**
	 * Starts a game of war, waiting as necessary for players to be ready
	 * @throws InterruptedException from Thread.State.WAITING
	 */
	public static void playWar() throws InterruptedException {
		Player[] players = new Player[numberOfPlayers];
		Deck deck = new Deck(14);
		String[] names = null;
		for (int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(names[i], 0);
		}
		outerLoop: while (true) {
			for (int i = 0; i < numberOfPlayers; i++) {
				if (!players[i].DrawCard(deck)) {
					break outerLoop;
				}
			}
		}
		rotateTurns: while (true) {
			for (int i = 0; i < numberOfPlayers; i++) {
				players[i].shuffle();
			}
			initiateWar(players);
			if(players[0].getHand().isEmpty()) {
				//player 2 wins
				break rotateTurns;
			}
			else if(players[1].getHand().isEmpty()) {
				//player 1 wins
				break rotateTurns;
			}
		}
	}
	
	/**
	 * Waits for the players to be ready and then plays their top card, and then plays 3 if 'war' and then calls itself if war.
	 * @param players The list of current players
	 * @throws InterruptedException from Thread.State.WAITING
	 */
	private static void initiateWar(Player[] players) throws InterruptedException {
		for (int i = field.size(); i > 0; i--) {
			field.remove(i);
		}
		for (int i = 0; i < numberOfPlayers; i++) {
			field.add(players[i].PlayTopCard());
		}
		if (field.get(field.size() - 1).value > field.get(field.size() - 2).value) {
			players[0].getHand().addAll(field);
		} else if (field.get(field.size() - 1).value < field.get(field.size() - 2).value) {
			players[1].getHand().addAll(field);
		} else {
			for (int i = 0; i < numberOfPlayers; i++) {
			field.addAll(players[i].PlayTopCards(3));
			}
			initiateWar(players);
		}
	}
}
