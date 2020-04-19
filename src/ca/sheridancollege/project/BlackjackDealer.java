/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Asad_Danish
 */
public class BlackjackDealer extends BlackjackPlayer{

	public BlackjackDealer(String Name){
		super(Name);
	}
	
	/**
	 * This prints the hand of the dealer at the beginning
	 */
	public void showDealerCards() {
		String dealerHand;
		dealerHand = "At location "+1+": An unknown card";
		dealerHand += "\nAt location "+2+": "+getHand().get(1).getSuit()+", "+getHand().get(1).getValue();
		System.out.println(dealerHand);
	}

	
	@Override
	public void play() {
		System.out.println("This is "+this.getPlayerID());
		showPlayerCards();
		System.out.println("The total is:"+getValueInHand());
		
		while(getValueInHand()<17){
			System.out.println(this.getPlayerID()+", your cards sum is less than 16 or equal to 16 you must pick up a card");
			addCard(getDeck().takeCard());
			calculateValueInHand();
			showPlayerCards();
			System.out.println("The total is: "+getValueInHand());
			if(getValueInHand() >= 21){
				if(getValueInHand()>21){
					setBust(true);
				}
				return;
			}
		}
	}
	
}
