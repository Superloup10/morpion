package fr.wolfdev.cda.morpion;

import java.util.Random;
import java.util.Scanner;

public class TestMorpion {
    
    public static int saisirChoixJoueur (){
    	int ChoixJoueur = 0;
        do {
        	System.out.println("Menu : ");
        	System.out.println("1 : Un joueur");
        	System.out.println("2 : Deux joueurs");
        	System.out.println("Quel est votre choix :");
        	Scanner scanner = new Scanner(System.in);
        	ChoixJoueur = scanner.nextInt();
        	if(ChoixJoueur == 1){
        		System.out.println("Vous avez le choisi le mode 1 joueur");
        		} else if(ChoixJoueur == 2){
        			System.out.println("Vous avez choisi le mode 2 joueurs");
        		} else {
        			System.out.println("Mauvais numéro");
        		}
        }while(ChoixJoueur < 1 || ChoixJoueur > 2);
        
        	return ChoixJoueur;
    } 
	
	public static void main(String[] args) {
		
		int nombreJoueur = saisirChoixJoueur();

		final Scanner sc = new Scanner(System.in);
		char[][] grid = new char[3][3];
		Morpion.initializeGrid(grid);
		String difficulty = Morpion.setDifficulty(sc);
		boolean isRun = true;
		String player1 = "";
		String player2 = "";
		Random rand = new Random();
		int turn = rand.nextInt(2) + 1;
		
		if (nombreJoueur == 1) {
    		
			System.out.println("Joueur 1 quel est votre nom ?");
			Scanner sc1 = new Scanner(System.in);
			player1 = sc1.nextLine();}

		else { 
			System.out.println("Joueur 1 quel est votre nom ?");
			Scanner sc1 = new Scanner(System.in);
			player1 = sc1.nextLine();
			System.out.println("Joueur 2 quel est votre nom ?");
			Scanner sc2 = new Scanner(System.in);
			player2 = sc2.nextLine();
			System.out.println("Du coup vous êtes " + player1 + " et " + player2);
		}
		if (turn == 1) {
			System.out.println("Le joueur 1 (" + player1 + ") commence !");
    		}
		else {
     		System.out.println("Le joueur 2 (" + player2 + ") commence !");
     		}
		do {
        	
        	
			if (turn == 1) {
        		
				System.out.print("Joueur 1 : donnez la position où vous voulez ajouter votre coup : ");
				String userPos = sc.next();
				Morpion.fillGridWithUserOneValue(grid, userPos);
				Morpion.printGrid(grid);
				turn++;
			} else {
    			
				System.out.print("Joueur 2 : donnez la position où vous voulez ajouter votre coup : ");
				String userPos = sc.next();
				Morpion.fillGridWithUserTwoValue(grid, userPos);
				Morpion.printGrid(grid);
				turn--;
			}

            /* TEST: Use only for test
                System.out.println("Au tour de l'ordinateur de jouer : ");
                Morpion.setComputerHit(grid, difficulty);
                Morpion.printGrid(grid);

                System.out.print("Joueur 2 : donnez la position où vous voulez ajouter votre coup : ");
                String user2Pos = sc.next();
                Morpion.fillGridWithUserTwoValue(grid, user2Pos);
                Morpion.printGrid(grid);
            */
			if(Morpion.isWinner(grid, 'X')) {
               System.out.println("Vous avez gagné !");
               isRun = false;
			}
			else if(Morpion.isTie(grid)) {
				System.out.println("Vous avez fait match null !");
				isRun = false;
			}
			else if(Morpion.isWinner(grid, 'O')) {
				System.out.println("Vous avez perdu !");
				isRun = false;
			}
            
			}
		while(isRun);
	

    }
}
