package fr.wolfdev.cda.morpion;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Morpion {
    public static int saisirChoixJoueur(Scanner sc) {
        int choixJoueur = 0;
        do {
            try {
                System.out.println("Menu : ");
                System.out.println("1 : Un joueur");
                System.out.println("2 : Deux joueurs");
                System.out.println("Quel est votre choix :");
                choixJoueur = sc.nextInt();
                if(choixJoueur == 1) {
                    System.out.println("Vous avez le choisi le mode 1 joueur");
                }
                else if(choixJoueur == 2) {
                    System.out.println("Vous avez choisi le mode 2 joueurs");
                }
                else {
                    System.out.println("Mauvais numéro");
                }
            }
            catch(InputMismatchException e) {
                System.err.println("Vous avez rentré autre chose qu'un entier");
                sc.nextLine();
            }
        }
        while(choixJoueur < 1 || choixJoueur > 2);

        return choixJoueur;
    }

    public static void fillGrid(char[][] grid, char value) {
        for(int line = 0; line < grid.length; line++) {
            for(int column = 0; column < grid[line].length; column++) {
                grid[line][column] = value;
            }
        }
    }

    private static void fillGridWithValue(char[][] grid, String userPos, char valueChar) throws ArrayIndexOutOfBoundsException {
        int line = Integer.parseInt(String.valueOf(userPos.charAt(0)));
        int column = Integer.parseInt(String.valueOf(userPos.charAt(1)));
        grid[line][column] = valueChar;
    }

    public static void fillGridWithUserOneValue(char[][] grid, String userPos) throws ArrayIndexOutOfBoundsException {
        fillGridWithValue(grid, userPos, 'X');
    }

    public static void fillGridWithUserTwoValue(char[][] grid, String userPos) throws ArrayIndexOutOfBoundsException {
        fillGridWithValue(grid, userPos, 'O');
    }

    public static void initializeGrid(char[][] grid) {
        fillGrid(grid, ' ');
    }

    public static void printGrid(char[][] grid) {
        for(int line = 0; line < grid.length; line++) {
            System.out.print("|");
            for(int column = 0; column < grid[line].length; column++) {
                System.out.print(grid[line][column] + "|");
            }
            System.out.println();
        }
    }

    public static String setDifficulty(Scanner sc) {
        String difficulty;
        boolean difficultyChoice;
        do {
            System.out.print("Choisissez votre mode de difficulté (facile, moyen, difficile) : ");
            difficulty = sc.next();
            difficultyChoice = Objects.equals(difficulty, "facile") ^ Objects.equals(difficulty, "moyen") ^ Objects.equals(difficulty, "difficile");
            if(!difficultyChoice) {
                System.out.println("Merci d'entrez un choix valide !");
            }
        }
        while(!difficultyChoice);
        return difficulty;
    }

    public static void setComputerHit(char[][] grid, String difficulty) {
        switch(difficulty) {
            case "facile": {
                randomComputerHit(grid);
                break;
            }
            case "moyen": { // Ordinateur défensif
                // Si l'utilisateur a l'un des quatre coins, mais pas les autres, on prend la case du centre si elle est vide
                if(grid[1][1] == ' ' && hasOneCornerOccupied(grid)) {
                    fillGridWithUserTwoValue(grid, "11");
                }
                else if(!completeLineOrColumnOrDiagonal(grid, 'X')) {
                    randomComputerHit(grid);
                }

                break;
            }
            case "difficile": {
                agressiveComputerHit(grid);
                break;
            }
        }
    }

    private static void agressiveComputerHit(char[][] grid) {
        if(!completeLineOrColumnOrDiagonal(grid, 'O') && !completeLineOrColumnOrDiagonal(grid, 'X')) {
            randomComputerHit(grid);
        }
    }

    private static void randomComputerHit(char[][] grid) {
        final Random rd = new Random();
        int line;
        int column;
        boolean isComputerHit = false;
        do {
            line = rd.nextInt(0, grid.length);
            column = rd.nextInt(0, grid[line].length);
            if(grid[line][column] == ' ') {
                fillGridWithUserTwoValue(grid, ("" + line) + ("" + column));
                isComputerHit = true;
            }
        }
        while(!isComputerHit);
    }

    private static boolean completeLineOrColumnOrDiagonal(char[][] grid, char symbol) {
        for(int i = 0; i < 3; i++) {
            if(completeIfPossible(grid, i, 0, i, 1, i, 2, symbol) ||
                    completeIfPossible(grid, 0, i, 1, i, 2, i, symbol)) {
                return true;
            }
        }

        return completeIfPossible(grid, 0, 0, 1, 1, 2, 2, symbol) ||
                completeIfPossible(grid, 0, 2, 1, 1, 2, 0, symbol);
    }

    private static boolean completeIfPossible(char[][] grid, int line1, int column1, int line2, int column2, int line3, int column3, char symbol) {
        if(grid[line1][column1] == ' ' && grid[line2][column2] == symbol && grid[line3][column3] == symbol) {
            grid[line1][column1] = 'O';
            return true;
        }
        else if(grid[line2][column2] == ' ' && grid[line1][column1] == symbol && grid[line3][column3] == symbol) {
            grid[line2][column2] = 'O';
            return true;
        }
        else if(grid[line3][column3] == ' ' && grid[line1][column1] == symbol && grid[line2][column2] == symbol) {
            grid[line3][column3] = 'O';
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean hasOneCornerOccupied(char[][] grid) {
        return ((grid[0][0] == 'X') ^ (grid[2][2] == 'X') ^ (grid[0][2] == 'X') ^ (grid[2][0] == 'X'));
    }

    public static boolean isWinner(char[][] grid, char player) {
        for(int i = 0; i < grid.length; i++) {
            if((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) ||
                    (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) {
                return true;
            }
        }
        return (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) ||
                (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player);
    }

    public static boolean isTie(char[][] grid) {
        for(int line = 0; line < grid.length; line++) {
            for(int column = 0; column < grid[line].length; column++) {
                if(grid[line][column] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
