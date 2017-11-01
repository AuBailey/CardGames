package games.csc180.model.games;

import java.io.IOException;
import java.lang.Thread.State;
import java.util.ArrayList;

import games.csc180.model.*;

public class War {
	public static int numberOfPlayers = 2;
	public static ArrayList<Card> field = new ArrayList<Card>();
	public static Deck deck;
	public static Player[] players;

	public static void main(String[] args) throws Exception {
		Player[] players = new Player[numberOfPlayers];
		Deck deck = new Deck(14);
		String[] names = new String[2];
		names[1] = "Bob";
		names[0] = "Jack";
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
		RotateTurns: while (true) {
			for (int i = 0; i < numberOfPlayers; i++) {
				players[i].shuffle();
			}
			initiateWar(players);
			if(players[0].hand.isEmpty()) {
				System.out.println("Player 2 has won a war");
				break RotateTurns;
			}
			else if(players[1].hand.isEmpty()) {
				System.out.println("Player 1 has won a war");
				break RotateTurns;
			}
		}
	}
	
	/**
	 * Starts a game of war, waiting as necessary for players to be ready
	 * @throws Exception 
	 */
	public static void playWar(String[] names) throws Exception {
		players = new Player[numberOfPlayers];
		deck = new Deck(14);
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
			if(players[0].getHand().size()<4) {
				//player 2 wins
				break rotateTurns;
			}
			else if(players[1].getHand().size()<4) {
				//player 1 wins
				break rotateTurns;
			}
		}
	}
	
	/**
	 * Waits for the players to be ready and then plays their top card, and then plays 3 if 'war' and then calls itself if war.
	 * @param players The list of current players
	 * @throws Exception 
	 */
	private static void initiateWar(Player[] players) throws Exception {
		for (int i = field.size()-1; i > 0; i--) {
			field.remove(i);
		}
		for (int i = 0; i < numberOfPlayers; i++) {
			if(players[i].hand.size()==0) {return;}
			field.add(players[i].PlayTopCard());
			System.out.println("Player " + (i+1) + " played a card");
		}
		if (field.get(field.size() - 1).value > field.get(field.size() - 2).value) {
			players[0].getHand().addAll(field);
			System.out.println("Player 2 won the cards");
		} else if (field.get(field.size() - 1).value < field.get(field.size() - 2).value) {
			players[1].getHand().addAll(field);
			System.out.println("Player 1 won the cards");
		} else {
			for (int i = 0; i < numberOfPlayers; i++) {
			field.addAll(players[i].PlayTopCards(3));
			}
			System.out.println("War has been initiated");
			initiateWar(players);
		}
	}
	
	public static void saveWar(String gameName, Deck deck, Player[] players) throws IOException {
		SaveAndLoad SAL = new SaveAndLoad();
		SAL.Save(Games.war, gameName, deck, players);
	}
	
	public static void loadWar(String gameName) throws IOException {
		SaveAndLoad SAL = new SaveAndLoad();
		ArrayList<Object> obj = SAL.Load(gameName);
		deck = (Deck)obj.get(1);
		players = (Player[])obj.get(2);
	}
}
