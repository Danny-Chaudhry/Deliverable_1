package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackPlayer extends Player {

	private int valueInHand;
	private boolean bust;
	private ArrayList<BlackjackCard> hand =new ArrayList<BlackjackCard>();
	private static int totalPlayers = 0;
	private BlackjackDeck deck;
	
	/**
	 * This is the default constructor
	 */
	public BlackjackPlayer() {
		this("Player " + totalPlayers);
	}
	
	/**
	 * This constructor which creates a player with a unique name
	 * @param name The player ID
	 */
	public BlackjackPlayer(String name){
		super(name);
		this.valueInHand = 0;
		this.bust = false;
		totalPlayers++;
	}
	
	/**
	 * Gets the total sum of the ranks, of the cards in the player's hand
	 * @return The total sum of the ranks, of the cards in the player's hand
	 */
	public int getValueInHand() {
		return this.valueInHand;
	}

	/**
	 * Sets the sum of the ranks, of the cards in the player's hand
	 * @param valueInHand The value to set the sum to
	 */
	public void setValueInHand(int valueInHand) {
		this.valueInHand = valueInHand;
	}
	
	/**
	 * Tells if the player went bust or not
	 * @return True if the player went bust, otherwise False
	 */
	public boolean getBust() {
		return this.bust;
	}

	/**
	 * Sets if the player went bust or not
	 * @param bust set to True if the player went bust, otherwise False
	 */
	public void setBust(boolean bust) {
		this.bust = bust;
	}
	
	/**
	 * Gets the player's hand
	 * @return The Players Hand
	 */
	public ArrayList<BlackjackCard> getHand() {
		return this.hand;
	}

	/**
	 * Sets the player's hand
	 * @param newHand The player's new hand
	 */
	public void setHand(ArrayList<BlackjackCard> newHand) {
		this.hand = newHand;
	}

	/**
	 * This adds a card object to the player's hand
	 * @param card The card to be added to the player's hand 
	 */
	public void addCard(BlackjackCard card){
		hand.add(card);
	}

	/**
	 * Calculates and sets the sum of the ranks, of the cards in the player's hand
	 */
	public void calculateValueInHand() {
		int temp;
		valueInHand = 0;
		boolean checkAce= false;
		for(int i=0;i<hand.size();i++){
			temp = hand.get(i).getValue();
			if(temp==1){
				checkAce=true;
			}
			if(temp>10){
				valueInHand+=10;
			}
			else{
				valueInHand +=temp;
			}
		}
		if(checkAce && (valueInHand+10)<=21){
			valueInHand += 10;
		}
	}

	/**
	 * This prints the players card
	 */
	public void showPlayerCards() {
		String playerHand="";
		for(int i =0; i<hand.size();i++){
			if(i == 0 ){
				playerHand = "At location "+(i+1)+": "+hand.get(i).getSuit()+", "+hand.get(i).getValue();
			}
			else{
				playerHand += "\nAt location "+(i+1)+": "+hand.get(i).getSuit()+", "+hand.get(i).getValue();
			}
		}
		System.out.println(playerHand);
	}

	/**
	 * Sets the Blackjack deck
	 * @param deck An array list containing car objects
	 */
	public void setDeck(BlackjackDeck deck){
		this.deck = deck;
	}
	/**
	 * Gets the Blackjack deck
	 * @return An array list containing card objects
	 */
	public BlackjackDeck getDeck(){
		return deck;
	}
	
	@Override
	public void play() {
		System.out.println("This is "+this.getPlayerID());
		this.showPlayerCards();
		System.out.println("The total is:"+valueInHand);
		
		while(true){
			while(valueInHand<17){
				System.out.println(this.getPlayerID()+", your cards sum is less than 16 or equal to 16 you must pick up a card");
				addCard(deck.takeCard());
				calculateValueInHand();
				showPlayerCards();
				System.out.println("The total is: "+valueInHand);
				if(valueInHand >= 21){
					if (valueInHand>21) {
						System.out.println("Sorry went bust");
						bust = true;
					}
					else{
						System.out.println("You got 21 !!!");
					}
					return;
				}
			}
			
			System.out.println("Please enter the interger to use the command:"+
						"\n1. Hit me"+
						"\n2. Stay");

			int command = InputChecker.checkPlayerInput();
			
			if(command == 1){
				addCard(deck.takeCard());
				calculateValueInHand();
				showPlayerCards();
				System.out.println("The total is: "+valueInHand);
				if(valueInHand >= 21){
					if (valueInHand>21) {
						System.out.println("Sorry went bust");
						bust = true;
					}
					else{
						System.out.println("You got 21 !!!");
					}
					return;
				}
			}
			else{
				System.out.println("You choose to stay.");
				break;
			}
		}
	}
}