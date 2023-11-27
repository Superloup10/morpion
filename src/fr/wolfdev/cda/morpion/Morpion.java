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
}
