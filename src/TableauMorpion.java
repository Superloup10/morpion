import java.util.Scanner;

public class TableauMorpion {
	
	
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
		

	}
}