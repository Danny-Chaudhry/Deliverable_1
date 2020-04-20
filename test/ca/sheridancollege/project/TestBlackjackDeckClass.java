/*
 * This class test the BlackjackDeck class to insure all the methods work
 */
package ca.sheridancollege.project;

/**
 *
 * @author Luqman Jehee
 */
public class TestBlackjackDeckClass {
    public static void main(String[] args) {
        System.out.println("Testing the BlackjackDeck class...");
        System.out.println();       //Blank line
        
        //Testing the default constructor and the createNewNonShuffledDeck method
        BlackjackDeck deck = new BlackjackDeck();
        System.out.println("...Created a blackjack deck using the createNewNonShuffledDeck method");
        System.out.println();       //Blank line
        
        //Testing the displayDeck method
        System.out.println("...Getting the blackjack deck using the displayDeck method: ");
        deck.displayDeck();
        System.out.println();       //Blank line
        
        //Testing the shuffle method
        deck.shuffle();
        System.out.println("...Shuffled the blackjack deck");
        System.out.println("...Displaying the shuffled the blackjack deck: ");
        deck.displayDeck();
        System.out.println();       //Blank line
        
        //Testing the takeCard method
        System.out.println("...Displaying the 3 cards at the top of the deck: ");
        System.out.println(deck.showCards().get(0).toString());
        System.out.println(deck.showCards().get(1).toString());
        System.out.println(deck.showCards().get(2).toString());
        System.out.println("...Taking a card at the top of the deck");
        System.out.println("...Displaying the card taked: ");
        System.out.println(deck.takeCard().toString());
        System.out.println("...Displaying the 3 cards at the top of the deck after taking the card: ");
        System.out.println(deck.showCards().get(0).toString());
        System.out.println(deck.showCards().get(1).toString());
        System.out.println(deck.showCards().get(2).toString());
        
        //All methods run properly as expected 
    }
}
