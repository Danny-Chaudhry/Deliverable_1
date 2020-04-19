package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame extends Game {

	private BlackjackDeck deck;
	private int numberOfPlayers;
	private final int MAX_PLAYERS = 6;
	private final int MIN_PLAYERS = 1;

	/**
	 * Creates a Blackjack Game object
	 * @param Name The name of the game
	 */
	public BlackjackGame(String Name){
		super(Name);
	}
	
	/**
	 * Play the game. This might be one method or many method calls depending
	 * on your game.
	 */
	@Override
	public void play() {
		setup();
		playRoundFirstHalf();
		playRoundSecondHalf();
	}
	
	/**
	 * The first to run when playing a Blackjack Game
	 */
	public void setup(){
		//1. create a deck
		System.out.println("Creating a deck");
		createDeck();
		//2.create players
		createPlayers();
		//3.Set up Table
		setTable();
	}

	/**
	 * After the round is setup plays the first half of the game
	 */
	public void playRoundFirstHalf(){
		//calculate each players value inhand and determine that have gone bust
		checkPlayersStatus();
		pause();
		//check if any players won or lost yet
		showResults();
		pause();
		//Shows the remaining players left
		System.out.println("The remaining players: ");
		displayTable();
		pause();
	}
	
	/**
	 * Plays the second half of the game, now players take their turns
	 */
	public void playRoundSecondHalf(){
		//The remaining players take their turns
		PlayersTakeTurn();
		//Check if any players won or lost yet
		showResults();
		pause();
		
		if(getPlayers().size()>1){
			//Shows the remaining players left
			System.out.println("The remaining players: ");
			displayTable();
			pause();
			//The dealer takes their turn
			DealerTakesTurn();
			pause();
			declareWinner();
		}
	}
	
	/**
	 * Declares whether the remaining players won or lost
	 */
	@Override
	public void declareWinner() {
		BlackjackDealer dealer = (BlackjackDealer) getPlayers().get(0);
		if(dealer.getValueInHand() == 21){
			System.out.println("Dealer got a 21. Sorry all remaining players lost!");
			for(int i = 1; i<getPlayers().size();i++){
				BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
				System.out.println("Sorry, "+player.getPlayerID()+". You have Lost!");
			}
		}
		else if(dealer.getValueInHand()>21){
			System.out.println("Dealer went bust. Congradulations all remaining players won!");
			for(int i = 1; i<getPlayers().size();i++){
				BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
				System.out.println("Congradulations, "+player.getPlayerID()+". You have Won!");
			}
		}
		else{
			for(int i=1; i<getPlayers().size(); i++){
				BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
				if(dealer.getValueInHand() == player.getValueInHand()){
					System.out.println(player.getPlayerID()+", your is the same as the dealers, "+ player.getValueInHand());
					System.out.println("You did not win or lose. It was a draw");
				}
				else if(dealer.getValueInHand() < player.getValueInHand()){
					System.out.println(player.getPlayerID()+", your score: "+player.getValueInHand()+" is less than the dealers: "+dealer.getValueInHand());
					System.out.println("Sorry, you have Lost!");
				}
				else if(dealer.getValueInHand() > player.getValueInHand()){
					System.out.println(player.getPlayerID()+", your score: "+player.getValueInHand()+" is greater than the dealers: "+dealer.getValueInHand());
					System.out.println("Congradulations, you have Won!");
				}
				else{
					System.out.println("something went wrong!!!!");
				}
				pause();
			}
		}
		
	}

	/**
	 * Creates a shuffled deck
	 */
	private void createDeck(){
		deck = new BlackjackDeck();
		deck.shuffle();
	}
	
	/**
	 * Creates players
	 */
	private void createPlayers(){
		System.out.println(
			   "Please enter the the number of players playing."+
			   "\nEnter a number between " +MIN_PLAYERS+ " and "+ MAX_PLAYERS +", inclusive");
		setNumberOfPlayers(InputChecker.checkNumberOfPlayers(MIN_PLAYERS, MAX_PLAYERS));
		PlayerFactory.run(numberOfPlayers, getPlayers());
	}
	
	/**
	 * Removes the players that have lost
	 */
	public void removePlayer(int i) {
		getPlayers().remove(i);
		numberOfPlayers--;
	}

	/**
	 * Set the table for the setup at the beginning of the round
	 */
	public void setTable() {
		for(int i=0;i<getPlayers().size();i++){
			for(int j=0;j<2;j++){
				((BlackjackPlayer)(getPlayers().get(i))).addCard(deck.takeCard());
			}
		}
	}

	/**
	 * Displays the table, showing the remaining players and their cards
	 */
	public void displayTable() {
		System.out.println("*******************************");
		System.out.println("The Dealer's Cards:");
		((BlackjackDealer)(getPlayers().get(0))).showDealerCards();
		System.out.println("*******************************");
		for(int i=1; i<getPlayers().size();i++){
			BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
			System.out.println("*******************************");
			System.out.println("The player: " + player.getPlayerID());
			player.showPlayerCards();
			System.out.println("*******************************");
		}
	}
	
	/**
	 * Checks whether the players have gone bust and sets their bust value
	 */
	public void checkPlayersStatus() {
		for(int i = 1; i<getPlayers().size(); i++){
			BlackjackPlayer player = (BlackjackPlayer)getPlayers().get(i);
			player.calculateValueInHand();
			System.out.println("*******************************");
			System.out.println("The player: " + player.getPlayerID());
			player.showPlayerCards();
			System.out.println(player.getPlayerID() +" sum is: " + player.getValueInHand());
			System.out.println("*******************************");
			if(player.getValueInHand()>21){
				player.setBust(true);
			}
		}
	}
	
	/**
	 * All the remaining players take turn
	 */
	public void PlayersTakeTurn() {
		for(int i = 1; i<getPlayers().size();i++){
			System.out.println("*******************************");
			BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
			player.setDeck(deck);
			player.play();
			System.out.println("*******************************");
			pause();
		}
	}

	/**
	 * The dealer takes their turn
	 */
	public void DealerTakesTurn(){
		System.out.println("*******************************");
		BlackjackDealer dealer = (BlackjackDealer) getPlayers().get(0);
		dealer.setDeck(deck);
		dealer.play();
		System.out.println("*******************************");
	}
	
	/**
	 * Determines whether player won or lost mid game
	 */
	public void showResults(){
		for(int i = 1; i < getPlayers().size();){
			BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
			if(player.getBust()){
				System.out.println("Sorry, "+player.getPlayerID()+" your total is "+player.getValueInHand()+" ,which is over 21.\nYou have Lost!");
				removePlayer(i);
			}
			else if(player.getValueInHand()==21){
				System.out.println("Congradulations, "+player.getPlayerID()+" your total is "+player.getValueInHand()+" , which is exactly 21.\nYou have Won!");
				removePlayer(i);
			}
			else{
				System.out.println(player.getPlayerID()+", your total is less than 21, you are still in play");
				i++;
			}
		}
	}
	
	/**
	 * Pauses the game until the user hits enter
	 */
	public void pause(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please hit enter to continue:");
		input.nextLine();
	}

	/**
	 * Gets the number of players
	 * @return The number of players playing blackjack
	 */
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}

	/**
	 * Sets the number of players
	 * @param numberOfPlayers The new number of players the user wants
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	/**
	 * Gets the deck of cards
	 * @return The array list holding the card objects
	 */
	public BlackjackDeck getDeck() {
		return this.deck;
	}

	/**
	 * Set the deck
	 * @param deck The new array list holding card objects
	 */
	public void setDeck(BlackjackDeck deck) {
		this.deck = deck;
	}

}