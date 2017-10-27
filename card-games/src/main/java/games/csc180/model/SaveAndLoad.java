package games.csc180.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveAndLoad {
	public boolean Save(Games game, String gameName, Deck deck, Player... p) throws IOException {
		File file = new File("./" + gameName + ".txt");
		FileWriter fileW = new FileWriter(file);
		fileW.write(game.game + " & ");
		for (int i = 0; i < deck.size(); i++) {
			fileW.write(deck.get(i).suit.suit + "&" + deck.get(i).cardName + "&" + deck.get(i).value + "DCS ");
		}
		fileW.write("numberOfPlayers: " + p.length + " players: ");
		for (int i = 0; i < p.length; i++) {
			Hand hand = (Hand) p[i].getHand();
			fileW.write(p[i].getName() + "&&" + p[i].getBankAmount() + "&&");
			for (int j = 0; i < hand.size(); j++) {
				fileW.write(hand.get(j).suit.suit + "&" + hand.get(j).cardName + "&" + hand.get(j).value + "HCS ");
			}
			fileW.write("PlayerSeperator ");
		}
		fileW.close();
		return true;
	}
	
	/**
	 * 
	 * @param gameName The name given to the game that was started
	 * @return .get(0) is the gamemode, .get(1) is the Deck, .get(2) is an array of Player
	 * @throws IOException - File Reader
	 */
	public ArrayList<Object> Load(String gameName) throws IOException {
		ArrayList<Object> gameState = new ArrayList<Object>();
		ArrayList<Card> deck = new ArrayList<Card>();
		String deckRegex = "(.*?)&(\\d{1,2})&(.*?)DCS ";
		String handRegex = "(.*?)&(\\d{1,2})&(.*?)HCS ";
		File file = new File("./" + gameName + ".txt");
		FileReader fileR = new FileReader(file);
		String unSplit = "";
		char c = ' ';
		int a;
		while ((a = fileR.read()) != -1) {
			c = (char) a;
			unSplit += c;
		}
		gameState.add(unSplit.split(" & ")[0]);
		Player[] players = new Player[Integer.parseInt(unSplit.split("NumberOfPlayers: ")[1].split(" players: ")[0])];
		String[] split1 = unSplit.split("DCS ");
		String[] deckCards = new String[split1.length - 1];
		for (int i = 0; i < split1.length - 1; i++) {
			deckCards[i] = split1[i] + "DCS ";
			Pattern pD = Pattern.compile(deckRegex);
			Matcher mD = pD.matcher(deckCards[i]);
			if (mD.find()) {
				Card card = new Card(Suit.valueOf(mD.group(0)), CardName.valueOf(mD.group(1)),
						Integer.parseInt(mD.group(2)));
				deck.add(card);
			}
		}
		String[] split2 = unSplit.split("players: ")[1].split("PlayerSerperator ");
		for (int i = 0; i < split2.length; i++) {
			Player player = new Player(split2[i].split("&&")[0], Integer.parseInt(split2[i].split("&&")[1]));
			String[] hands = split2[i].split("HCS ");
			ArrayList<Card> hand = new ArrayList<Card>();
			for (int j = 0; j < hands.length; j++) {
				hands[j] = hands[j] + "HCS ";
				Pattern p = Pattern.compile(handRegex);
				Matcher m = p.matcher(hands[j]);
				if(m.find()) {
					Card card = new Card(Suit.valueOf(m.group(0)), CardName.valueOf(m.group(1)),Integer.parseInt(m.group(2)));
					hand.add(card);
				}
			}
			player.setHand((Hand) hand);
			players[i] = player;
		}
		

		gameState.add(deck);
		gameState.add(players);
		fileR.close();
		return gameState;
	}

}