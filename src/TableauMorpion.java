import java.util.Scanner;

public class TableauMorpion {
	
	private static int lenght;

	public static char [][] creerTableMorpion() {
		char[][] grid = new char[3][3];
        for(int line = 0; line < grid.length; line++) {
            for(int column = 0; column < grid[line].length; column++) {
                grid[line][column] = '|';
            }	
        }    
        return grid;

	}
	
	public static void afficheTableauMorpion(char[][] tableauMorpion) {
		
		for (int i = 0; i < tableauMorpion.length; i++) {
			for (int j = 0; j < tableauMorpion[i].length; j++) {
				System.out.print(tableauMorpion[i][j]);
			}System.out.println();
			
		}
		
	}

	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

			char[][] TableauMorpion = creerTableMorpion();
		
			afficheTableauMorpion(TableauMorpion);

 
	}
}