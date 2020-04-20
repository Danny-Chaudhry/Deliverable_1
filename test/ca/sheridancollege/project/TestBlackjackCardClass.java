/*
 * This class test the BlackjackCard class to insure all the methods work
 */
package ca.sheridancollege.project;

/**
 *
 * @author Luqman Jehee
 */
public class TestBlackjackCardClass {
    public static void main(String[] args) {
        System.out.println("Testing the BlackjackCard class...");
        System.out.println();       //Blank line
        
        //Testing the custom constructor with two parameters
        BlackjackCard card = new BlackjackCard(Suit.CLUBS, 3);
        System.out.println("...Created card: 'Clubs 3'");
        System.out.println("...Getting card: ");
        System.out.println(card.toString());
        System.out.println();       //Blank line
        
        //Testing the equals method
        BlackjackCard card1 = new BlackjackCard(Suit.DIAMOND, 5);
        System.out.println("...Comparing first card with 'Diamond 5' : ");
        if(!card1.equals(card)){
            System.out.println("They are not equal. The equals method works");
        }
        else{
            System.out.println("They are equal. The equals method does not work");
        }
        BlackjackCard card2 = new BlackjackCard(Suit.CLUBS, 3);
        System.out.println("...Comparing first card with 'Clubs 3' : ");
        if(card.equals(card2)){
            System.out.println("They are equal. The equals method works");
        }
        else{
            System.out.println("They are not equal. The equals method does not work");
        }
        
        //All methods run properly as expected 
    }
}
