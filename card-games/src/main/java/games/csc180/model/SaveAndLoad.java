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
			fileW.write(deck.get(i).suit.suit + "&" + deck.get(i).value + "DCS ");
		}
		fileW.write("numberOfPlayers: " + p.length + " players: ");
		for (int i = 0; i < p.length; i++) {
			Hand hand = p[i].hand;
			fileW.write(p[i].getName() + "&" + p[i].getBankAmount() + " ");
			for (int j = 0; i < hand.size(); j++) {
				fileW.write(hand.get(j).suit.suit + "&" + hand.get(j).value + "HCS ");
			}
			fileW.write("PlayerSeperator ");
		}
		fileW.close();
		return true;
	}

	public ArrayList<Object> Load(String gameName) throws IOException {
		ArrayList<Object> gameState = new ArrayList<Object>();
		ArrayList<Card> deck = new ArrayList<Card>();
		ArrayList<Player> players = new ArrayList<Player>();
		String deckRegex = "(.*?)&(\\d{1,2})DCS ";
		String handRegex = "(.*?)&(\\d{1,2})HCS ";
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
		String[] split1 = unSplit.split("DCS ");
		String[] deckCards = new String[split1.length - 1];
		for (int i = 0; i < split1.length - 1; i++) {
			deckCards[i] = split1[i] + "DCS ";
		}
		String[] split2 = unSplit.split("players: ")[1].split("PlayerSerperator ");
		for (int i = 0; i < split2.length; i++) {
			String[] hands = split2[i].split("HCS ");
			for (int j = 0; j < hands.length; j++) {
				hands[j] = hands[j] + "HCS ";
				Pattern p = Pattern.compile(deckRegex);
				Matcher m = p.matcher(hands[j]);
			}
		}
		return gameState;
	}

}