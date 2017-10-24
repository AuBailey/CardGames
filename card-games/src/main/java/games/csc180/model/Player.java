package games.csc180.model;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private int bankAmount;
	private ArrayList<String> hand;
	
	public Player(String name, int bankAmount) {
		setName(name);
		setBankAmount(bankAmount);
		hand = new ArrayList<>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setBankAmount(int amount) {
		this.bankAmount = amount;
	}
	
	public int getBankAmount() {
		return this.bankAmount;
	}

}
