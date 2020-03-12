package ca.sheridancollege.project;

public class blackjackGame {

	private blackjackPlayer dealer;
	private GroupOfCards deck;

    public blackjackGame() {
    }

    public blackjackGame(blackjackPlayer dealer, GroupOfCards deck) {
        this.dealer = dealer;
        this.deck = deck;
    }
        
        

	public blackjackPlayer getDealer() {
		return this.dealer;
	}

	/**
	 * 
	 * @param dealer
	 */
	public void setDealer(blackjackPlayer dealer) {
		this.dealer = dealer;
	}

	public GroupOfCards getDeck() {
		return this.deck;
	}

	/**
	 * 
	 * @param deck
	 */
	public void setDeck(GroupOfCards deck) {
		this.deck = deck;
	}

	/**
	 * 
	 * @param player
	 */
	public void hitPlayer(blackjackPlayer player) {
		// TODO - implement blackjackGame.hitPlayer
		throw new UnsupportedOperationException();
	}

}