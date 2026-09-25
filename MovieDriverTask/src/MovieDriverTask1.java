import java.util.Scanner;

public class MovieDriverTask1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Movie movie = new Movie();
		
		System.out.println("Enter the name of a movie:");
		String title = scan.nextLine();
		movie.setTitle(title);
		
		System.out.println("Enter the rating of the movie:");
		String rating = scan.nextLine();
		movie.setRating(rating);
		
		System.out.println("Enter the number of tickets sold for this movie:");
		int soldTickets = scan.nextInt();
		movie.setSoldTickets(soldTickets);
		
		System.out.println(movie.toString());
		
		System.out.println("MovieDriverTask1 has ended.");
		
	}

}
