package fr.wolfdev.cda.morpion;

public class Morpion {
    public static void fillGrid(char[][] grid, char value) {
        for(int line = 0; line < grid.length; line++) {
            for(int column = 0; column < grid[line].length; column++) {
                grid[line][column] = value;
            }
        }
    }

    private static void fillGridWithValue(char[][] grid, String userPos, char valueChar) {
        int line = Integer.parseInt(String.valueOf(userPos.charAt(0)));
        int column = Integer.parseInt(String.valueOf(userPos.charAt(1)));
        grid[line][column] = valueChar;
    }

    public static void fillGridWithUserOneValue(char[][] grid, String userPos) {
        fillGridWithValue(grid, userPos, 'X');
    }

    public static void fillGridWithUserTwoValue(char[][] grid, String userPos) {
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
