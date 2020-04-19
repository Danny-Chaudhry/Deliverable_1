package ca.sheridancollege.project;

import java.util.ArrayList;

public class BlackjackDeck extends GroupOfCards {

	/**
	 * Constructor creating a blackjack deck of 52 cards
	 */
	public BlackjackDeck(){
		super(52);
		createNewNonShuffledDeck();
	}
	
	/**
	 * Takes a card from the top of the cards array in the BlackjackDeck class
	 * @return The top most card
	 */
	public BlackjackCard takeCard() {
		BlackjackCard pickedCard = (BlackjackCard)showCards().get(0);
		showCards().remove(0);
		return pickedCard;
	}
	
	/**
	 * Creates a new non shuffled deck of 52 cards
	 */
	public void createNewNonShuffledDeck() {
		super.setSize(52);
		showCards().clear();
		for(Suit s: Suit.values()){
			for(int j=0; j<super.getSize()/4;j++){
				showCards().add(new BlackjackCard(s,(j+1)));
			}
		}
	}

	/**
	 * Displays the cards in the deck
	 */
	public void displayDeck() {
		String cardList="";
		for(int i =0; i<showCards().size();i++){
			BlackjackCard card = (BlackjackCard)showCards().get(i);
			if(i == 0 ){
				cardList = "At location "+(i+1)+": "+card.getSuit()+", "+card.getValue();
			}
			else{
				cardList += "\nAt location "+(i+1)+": "+card.getSuit()+", "+card.getValue();
			}
		}
		System.out.println(cardList);
	}

}