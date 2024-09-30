import java.util.*;

public class MovieDriver_Task1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the name of a movie");
		String title = scanner.nextLine();
		
		System.out.println("Enter the rating of a movie");
		String rating = scanner.nextLine();
		
		System.out.println("Enter the number of tickets sold for this movie");
		int soldtickets = scanner.nextInt();
		
		
		Movie movie = new Movie(title, rating, soldtickets);
		
		System.out.println(movie.toString());
		System.out.println("Goodbye");
		
	}
}
