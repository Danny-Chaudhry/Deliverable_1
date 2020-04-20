/*
 * This class test the BlackjackPlayer class to insure all the methods work
 */
package ca.sheridancollege.project;

/**
 *
 * @author Luqman Jehee
 */
public class TestBlackjackPlayerClass {
    public static void main(String[] args) {
        System.out.println("Testing the BlackjackPlayer class...");
        System.out.println();       //Blank line
        
        //Testing the default constructor
        BlackjackPlayer player1 = new BlackjackPlayer();
        System.out.println("...Created first player without name");
        System.out.print("...Getting name of first player: ");
        System.out.println(player1.getPlayerID());
        System.out.println();       //Blank line
        
        //Testing the custom constructer with one parameter
        BlackjackPlayer player2 = new BlackjackPlayer("Tom");
        System.out.println("...Created second player with name: 'Tom'");
        System.out.print("...Getting name of second player: ");
        System.out.println(player2.getPlayerID());
        System.out.println();       //Blank line
        
        //Adding cards in the hand for further testing
        System.out.println("...Adding cards in the hand");
        player1.getHand().add(new BlackjackCard(Suit.HEARTS,5));
        System.out.println("...Added 'Heart 5'");
        player1.getHand().add(new BlackjackCard(Suit.CLUBS,7));
        System.out.println("...Added 'Clubs 7'");
        System.out.println();       //Blank line
        
        //Testing the calculateValueInHand method
        System.out.print("...Getting value of valueInHand before calculateValueInHand method: ");
        System.out.println(player1.getValueInHand());
        player1.calculateValueInHand();
        System.out.print("...Getting value of valueInHand after calculateValueInHand method: ");
        System.out.println(player1.getValueInHand());
        System.out.println();       //Blank line
        
        //Testing the showPlayerCards method
        System.out.println("...Calling the showPlayerCards method: ");
        player1.showPlayerCards();
        System.out.println();       //Blank line
        
        //Setting deck for further testing
        System.out.println("...Creating a shuffled deck for further testing");
        BlackjackDeck deck = new BlackjackDeck();
        deck.shuffle();
        player1.setDeck(deck);
        System.out.println();       //Blank line
        
        //Testing the play method
        System.out.println("...Calling the play method: ");
        player1.play();
        
        //All methods run properly as expected 
    }
}
