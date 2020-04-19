/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
		
		//creates the right number of players and adds them to the players arraylist
		for(int i=0;i<numOfPlayers;i++){
			String playerName = JOptionPane.showInputDialog("Please enter Player "+(i+1)+" name");
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
