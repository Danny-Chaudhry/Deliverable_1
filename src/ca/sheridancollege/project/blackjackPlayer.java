package ca.sheridancollege.project;

import java.util.ArrayList;

public class blackjackPlayer {

	private String playerName;
	private int valueInHand;
	private ArrayList<Card> hand;
	private boolean bust;

        public blackjackPlayer() {
        }

        public blackjackPlayer(String playerName, int valueInHand, ArrayList<Card> hand, boolean bust) {
            this.playerName = playerName;
            this.valueInHand = valueInHand;
            this.hand = hand;
            this.bust = bust;
        }
        
        

	public String getPlayerName() {
		return this.playerName;
	}

	/**
	 * 
	 * @param playerName
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getValueInHand() {
		return this.valueInHand;
	}

	/**
	 * 
	 * @param valueInHand
	 */
	public void setValueInHand(int valueInHand) {
		this.valueInHand = valueInHand;
	}

	public ArrayList<Card> getHand() {
		return this.hand;
	}

	/**
	 * 
	 * @param hand
	 */
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public boolean getBust() {
		return this.bust;
	}

	/**
	 * 
	 * @param bust
	 */
	public void setBust(boolean bust) {
		this.bust = bust;
	}

	public String toString() {
		// TODO - implement blackjackPlayer.toString
		throw new UnsupportedOperationException();
	}

}