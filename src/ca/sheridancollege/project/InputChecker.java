/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;
/**
 *
 * @author Asad_Danish
 */
public class InputChecker {
	private InputChecker(){
	}
	
	public static int checkNumberOfPlayers(int min, int max){
		int numOfPlayer;
		Scanner input = new Scanner(System.in);
		//take valid input fot the number of players that can play the game
		do{
			int inputTemp;
			try{
				inputTemp = (int)(input.nextDouble());
			}
			catch(Exception e){
				input.nextLine();
				System.out.println("Please enter an appropriate number");
				continue;
			}
			
			if(inputTemp>=min && inputTemp<=max){
				numOfPlayer = inputTemp;
				System.out.println("The number of players are "+numOfPlayer);
				break;
			}
			else{
				input.nextLine();
				System.out.println("Please enter a number betwen "+min+" and "+max+", inclusive");	
			}
		}while(true);
		return numOfPlayer;
	}
	
	public static int checkPlayerInput(){
		Scanner input = new Scanner(System.in);
		int inputTemp;
		do{
			try{
				inputTemp = (int)(input.nextDouble());
			}
			catch(Exception e){
				input.nextLine();
				System.out.println("Please enter an appropriate command number");
				continue;
			}

			if(inputTemp>0 && inputTemp<3){
				System.out.println("You chose: "+inputTemp);
				break;
			}
			else{
				input.nextLine();
				System.out.println("Please enter a number betwen 1 and 2, inclusive");	
			}
		}while(true);
		return inputTemp;
	}

}
