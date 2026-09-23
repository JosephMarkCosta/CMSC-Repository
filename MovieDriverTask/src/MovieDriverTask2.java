import java.util.Scanner;

public class MovieDriverTask2 {

	public static void main(String[] args) {
		
		char continueLoop = 'y';
		Scanner keyboard = new Scanner(System.in);
		Movie movie = new Movie();
		
		while(continueLoop == 'y') {
			System.out.println("Enter the name of a movie:");
			String title = keyboard.nextLine();
			movie.setTitle(title);
			
			System.out.println("Enter the rating of the movie:");
			String rating = keyboard.nextLine();
			movie.setRating(rating);
			
			System.out.println("Enter the number of tickets sold for this movie:");
			int soldTickets = keyboard.nextInt();
			movie.setSoldTickets(soldTickets);
			keyboard.nextLine();
			
			System.out.println(movie.toString());
			
			System.out.println("Do you want to enter another movie? (Y or N)");
			char input = keyboard.nextLine().toLowerCase().charAt(0);
			while(input != 'y' && input != 'n') {
				System.out.println("Do you want to enter another movie? (Y or N)");
				input = keyboard.nextLine().toLowerCase().charAt(0);
			}
			
			if(input == 'n') {
				continueLoop = 'n';
			}
			
		}
		
		System.out.println("MovieDriverTask2 Ended");

	}

}
