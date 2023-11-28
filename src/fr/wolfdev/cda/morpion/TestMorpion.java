package fr.wolfdev.cda.morpion;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TestMorpion {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        char[][] grid = new char[3][3];
        int restart = 0;
        do {
        	Morpion.initializeGrid(grid);
        	int nombreJoueur = Morpion.saisirChoixJoueur(sc);
        	String difficulty = Morpion.setDifficulty(sc);
        	boolean isRun = true;
        	String player1;
        	String player2 = "";
        	Random rand = new Random();
        	int turn = rand.nextInt(2) + 1;
        	System.out.print("Joueur 1, quel est votre nom ? ");
        	player1 = sc.next();

        	if(nombreJoueur != 1) {
        		System.out.print("Joueur 2, quel est votre nom ? ");
        		player2 = sc.next();
        		System.out.println("Du coup, vous êtes " + player1 + " et " + player2);
        		if(turn == 1) {
        			System.out.println("Le joueur 1 (" + player1 + ") commence !");
        		}
        		else {
        			System.out.println("Le joueur 2 (" + player2 + ") commence !");
        		}
	        }
	        do {
	            if(turn == 1) {
	                boolean error;
	                do {
	                    System.out.print(player1 + " : donnez la position où vous voulez ajouter votre coup : ");
	                    String userPos = sc.next();
	                    try {
	                        Morpion.fillGridWithUserOneValue(grid, userPos);
	                        error = false;
	                    }
	                    catch(ArrayIndexOutOfBoundsException e) {
	                        System.err.println("Veuillez fournir une entrée valide !");
	                        error = true;
	                    }
	                }
	                while(error);
	                Morpion.printGrid(grid);
	                turn++;
	            }
	            else {
	                if(nombreJoueur == 2) {
	                    boolean error;
	                    do {
	                        System.out.print(player2 + " : donnez la position où vous voulez ajouter votre coup : ");
	                        String userPos = sc.next();
	                        try {
	                            Morpion.fillGridWithUserTwoValue(grid, userPos);
	
	                            error = false;
	                        }
	                        catch(ArrayIndexOutOfBoundsException e) {
	                            System.err.println("Veuillez fournir une entrée valide !");
	                            error = true;
	                        }
	                    }
	                    while(error);
	                }
	                else {
	                    System.out.println("L'ordinateur joue son coup : ");
	                    Morpion.setComputerHit(grid, difficulty);
	                }
	                Morpion.printGrid(grid);
	                turn--;
	            }
	
	            if(Morpion.isWinner(grid, 'X')) {
	                if(nombreJoueur == 2) {
	                    System.out.println(player1 + " a gagné et " + player2 + " a perdu !");
	                }
	                else {
	                    System.out.println(player1 + " a gagné !");
	                }
	                isRun = false;
	            }
	            else if(Morpion.isTie(grid)) {
	                System.out.println("Vous avez fait match null !");
	                isRun = false;
	            }
	            else if(Morpion.isWinner(grid, 'O')) {
	                if(nombreJoueur == 2) {
	                    System.out.println(player2 + " a gagné et " + player1 + " a perdu !");
	                }
	                else {
	                    System.out.println(player1 + " a perdu !");
	                }
	                isRun = false;
	            }
	        }
	        while(isRun);
	        boolean saisie;
	        do {
	        	try {
	        		System.out.println("Voulez-vous continuer de jouer ? 1 = Oui, 2 = Non");  
	        		restart = sc.nextInt();
	        		saisie = false;
	        	}catch(InputMismatchException e) {
	        		saisie = true;
	        		System.err.println("Mettez une bonne saisie");
	        		sc.nextLine();
	        	}
	        }while(saisie || restart < 1 || restart > 2);
	   } while(restart == 1);
        System.out.println("Merci d'avoir jouer !");
    }
}
