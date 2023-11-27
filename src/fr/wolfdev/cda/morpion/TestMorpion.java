package fr.wolfdev.cda.morpion;

public class TestMorpion {
    public static void main(String[] args) {
        char[][] grid = new char[3][3];
        Morpion.initializeGrid(grid);
        Morpion.fillGridWithUserOneValue(grid, "00");
        Morpion.printGrid(grid);
    }
}
