/*
 * This class test the BlackjackDealer class to insure all the methods work
 */
package ca.sheridancollege.project;

/**
 *
 * @author Luqman Jehee
 */
public class TestBlackjackDealerClass {
    public static void main(String[] args) {
        System.out.println("Testing the BlackjackDealer class...");
        System.out.println();       //Blank line
        
        //Testing the default constructor
        BlackjackDealer dealer = new BlackjackDealer("THE DEALER");
        System.out.println("...Created a dealer with the name: 'THE DEALER'");
        System.out.print("...Getting name of the dealer: ");
        System.out.println(dealer.getPlayerID());
        System.out.println();       //Blank line
        
        //Adding cards in the hand for further testing
        System.out.println("...Adding cards for the dealer");
        dealer.getHand().add(new BlackjackCard(Suit.HEARTS,5));
        System.out.println("...Added 'Heart 5'");
        dealer.getHand().add(new BlackjackCard(Suit.CLUBS,7));
        System.out.println("...Added 'Clubs 7'");
        System.out.println();       //Blank line
        
        //Testing the showDealerCards method
        System.out.println("...Calling the showDealerCards method: ");
        dealer.showDealerCards();
        System.out.println();       //Blank line
        
        //Setting deck for further testing
        System.out.println("...Creating a shuffled deck for further testing");
        BlackjackDeck deck = new BlackjackDeck();
        deck.shuffle();
        dealer.setDeck(deck);
        System.out.println();       //Blank line
        
        //Testing the play method
        System.out.println("...Calling the play method: ");
        dealer.play();
        
        //All methods run properly as expected 
    }
}
