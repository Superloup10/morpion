package fr.wolfdev.cda.morpion;

import java.util.Scanner;

public class TestMorpion {
    
    public static int saisirChoixJoueur (int joueur){

        System.out.println("Menu : ");
        System.out.println("1 : Un joueur");
        System.out.println("2 : Deux joueurs");
        System.out.println("Quel est votre choix :");
        Scanner scanner = new Scanner(System.in);
        joueur = scanner.nextInt();
        System.err.println("Vous avez choisi le mode :" + joueur);

        return joueur;
    } 

	
	public static void main(String[] args) {
        
        int ChoixContinue = 0;

        saisirChoixJoueur(ChoixContinue);
    	
    	final Scanner sc = new Scanner(System.in);
        char[][] grid = new char[3][3];
        Morpion.initializeGrid(grid);
        boolean isRun = true;
        do {
            System.out.print("Joueur 1 : donnez la position où vous voulez ajouter votre coup : ");
            String userPos = sc.next();
            Morpion.fillGridWithUserOneValue(grid, userPos);
            Morpion.printGrid(grid);
            /* TEST: Use only for test
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
