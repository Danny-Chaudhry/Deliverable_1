package ca.sheridancollege.project;

public class playingCard {

	private int value;

        public playingCard() {
        }

        public playingCard(int value) {
            this.value = value;
        }

        

	public int getValue() {
		return this.value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		// TODO - implement playingCard.toString
		throw new UnsupportedOperationException();
	}

}