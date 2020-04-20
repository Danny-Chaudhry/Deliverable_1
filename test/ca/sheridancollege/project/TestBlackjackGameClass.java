/*
 * This class test the BlackjackGame class to insure all the methods work
 * Please enter two players when asked
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Luqman Jehee
 */
public class TestBlackjackGameClass {
    public static void main(String[] args) {
        System.out.println("Testing the BlackjackGame class...");
        System.out.println();       //Blank line
        
        //Testing the default constructor
        BlackjackGame game = new BlackjackGame("myGame");
        System.out.println("...Created a blackjack game called 'myGame'");
        System.out.println();       //Blank line
        
        //Testing the createDeck method
        game.createDeck();
        System.out.println("...Created a shuffled deck for blackjack game");
        System.out.println("...Displaying the shuffled deck:");
        game.getDeck().displayDeck();
        System.out.println();       //Blank line
        
        //Testing the createPlayers method
        System.out.println("...Creating a dealer and players using the create player method");
        System.out.println("...Please enter two players for further testing");
        game.createPlayers();
        System.out.println();       //Blank line
        
        //Testing the setTable method
        System.out.println("...Giving each player two cards at the begining of the game");
        game.setTable();
        System.out.println();       //Blank line
        
        //Testing the displayTable method
        System.out.println("...Displaying the details for everyone on the table in the game: ");
        game.displayTable();
        System.out.println();       //Blank line
        
        //Testing the removePlayer method
        System.out.println("...Removing the first player from the game: ");
        game.removePlayer(1);
        System.out.println("...Displaying the details for everyone on the table in the game after removing the first player: ");
        game.displayTable();
        System.out.println();       //Blank line
        
        //Testing the displayPlayerStatus method
        System.out.println("...Displaying the details for players only on the table in the game: ");
        game.checkPlayersStatus();
        System.out.println();       //Blank line
        
        //Testing the playersTakeTurn method
        System.out.println("...Giving each players their turn to play: ");
        game.PlayersTakeTurn();
        System.out.println();       //Blank line
        
        //Testing the dealerTakesTurn method
        System.out.println("...Making the dealer play: ");
        game.DealerTakesTurn();
        System.out.println();       //Blank line
        
        //Testing the showResults method
        System.out.println("...Setting player value to '25'");
        ((BlackjackPlayer)game.getPlayers().get(1)).setValueInHand(25);
        System.out.println("...Showing the status of player when bust: ");
        game.showResults();
        System.out.println();       //Blank line
        
        //Testing the showResults method
        System.out.println("...Setting player value to '21'");
        ((BlackjackPlayer)game.getPlayers().get(1)).setValueInHand(21);
        System.out.println("...Showing the status of player when exactly at 21: ");
        game.showResults();
        System.out.println();       //Blank line
        
        //Testing the showResults method
        System.out.println("...Setting player value to '19'");
        ArrayList<Player> temp = new ArrayList<Player>();
        temp.add(new BlackjackDealer("Dealer"));
        temp.add(new BlackjackPlayer());
        game.setPlayers(temp);
        game.setTable();
        ((BlackjackPlayer)game.getPlayers().get(1)).setValueInHand(19);
        System.out.println("...Showing the status of player when under 21: ");
        game.showResults();
        System.out.println();       //Blank line
        
        //Testing the declareWinner method
        System.out.println("...Setting dealer value to '21");
        game.setPlayers(temp);
        game.setTable();
        ((BlackjackPlayer)game.getPlayers().get(0)).setValueInHand(21);
        System.out.println("...Declaring winner when dealer gets 21: ");
        game.declareWinner();
        System.out.println();       //Blank line
        
        //Testing the declareWinner method
        System.out.println("...Setting dealer value to '25'");
        ((BlackjackPlayer)game.getPlayers().get(0)).setValueInHand(25);
        System.out.println("...Declaring winner when dealer goes bust: ");
        game.declareWinner();
        System.out.println();       //Blank line
        
        //Testing the declareWinner method
        System.out.println("...Setting dealer value to '19'");
        ((BlackjackPlayer)game.getPlayers().get(0)).setValueInHand(19);
        System.out.println("...Setting player value to '20'");
        ((BlackjackPlayer)game.getPlayers().get(1)).setValueInHand(20);
        System.out.println("...Declaring winner when player value in hand is greater than dealer value in hand: ");
        game.declareWinner();
        System.out.println();       //Blank line
        
        //Testing the declareWinner method
        System.out.println("...Setting dealer value to '20'");
        ((BlackjackPlayer)game.getPlayers().get(0)).setValueInHand(20);
        System.out.println("...Setting player value to '19'");
        ((BlackjackPlayer)game.getPlayers().get(1)).setValueInHand(19);
        System.out.println("...Declaring winner when player value in hand is less than dealer value in hand: ");
        game.declareWinner();
        System.out.println();       //Blank line
        
        //Testing the declareWinner method
        System.out.println("...Setting dealer value to '20'");
        ((BlackjackPlayer)game.getPlayers().get(0)).setValueInHand(20);
        System.out.println("...Setting player value to '20'");
        ((BlackjackPlayer)game.getPlayers().get(1)).setValueInHand(20);
        System.out.println("...Declaring winner when player value in hand is the same dealer value in hand: ");
        game.declareWinner();
        System.out.println();       //Blank line
        
        //All methods run properly as expected 
    }
}
