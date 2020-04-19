package ca.sheridancollege.project;

import java.util.Objects;

public class BlackjackCard extends Card {

	private int value;
	private Suit suit;

	/**
	 * This constructor creates a card of a given suit and given value
	 * @param suit The suit of the created card object
	 * @param value The value of the created card object
	 */
	public BlackjackCard(Suit suit, int value){
		this.suit = suit;
		this.value = value;
	}
	/**
	 * Gets the value of the card
	 * @return  The value of the card
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Sets the value of the card
	 * @param value The value of the card
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the suit of the card
	 * @return The suit of the card
	 */
	public Suit getSuit() {
		return this.suit;
	}

	/**
	 * Sets the suit of the card
	 * @param suit The suit of the card
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	/**
	 *This returns the attributes of the object and their present set value 
	 * @return The attributes of the object and their present set value
	 */
	@Override
	public String toString() {
		return ("Suit: "+this.suit+"\nValue: "+this.value);
	}

	/**
	 * This checks whether two cards are the same based on their attributes
	 * @param card This is the card object being compare to
	 * @return true if both objects have the same attributes and their values are the same, other wise false
	 */
	@Override
	public boolean equals(Object card) {
		BlackjackCard c = (BlackjackCard)card;
		return (this.suit == c.getSuit() && this.value == c.getValue());
	}

}