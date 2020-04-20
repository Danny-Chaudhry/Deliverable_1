/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Asad_Danish
 */
public class PlayerFactory {
	private PlayerFactory(){	
	}
	public static void run(int numOfPlayers, ArrayList<Player> players){
		//create the dealer
		players.add(new BlackjackDealer("DEALER"));
                 Scanner reader = new Scanner(System.in);
		
		//creates the right number of players and adds them to the players arraylist
		for(int i=0;i<numOfPlayers;i++){
			System.out.println("Please enter Player "+(i+1)+" name");
                          String playerName = reader.nextLine();
			if(playerName == null || playerName.equals("")){
				players.add(new BlackjackPlayer());
			}
			else if(playerName.equalsIgnoreCase("dealer")){
				System.out.println("Sorry the name "+playerName+" is already taken");
				players.add(new BlackjackPlayer());
			}
			else{
				players.add(new BlackjackPlayer(playerName));
			}
		}
	}
	
}
