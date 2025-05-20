import java.util.ArrayList;
import java.util.Scanner;

public class MovieStudioBookingSystem {
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Studio> studioList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeStudios();
        int choice;

        do {
            System.out.println("\n--- Cinematic Studios Booking System ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Update Movie");
            System.out.println("3. Delete Movie");
            System.out.println("4. View Available Movies");
            System.out.println("5. Book a Studio");
            System.out.println("6. Cancel Studio Booking");
            System.out.println("7. View Studio Status");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addMovie();
                case 2 -> updateMovie();
                case 3 -> deleteMovie();
                case 4 -> viewMovies();
                case 5 -> bookStudio();
                case 6 -> cancelBooking();
                case 7 -> viewStudioStatus();
                case 8 -> System.out.println("Exiting system. Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    private static void initializeStudios() {
        for (int i = 1; i <= 5; i++) {
            studioList.add(new Studio(i));
        }
    }

    private static void addMovie() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter duration (minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        movieList.add(new Movie(title, genre, duration));
        System.out.println("Movie added successfully!");
    }

    private static void updateMovie() {
        viewMovies();
        if (movieList.isEmpty()) return;

        System.out.print("Enter the index of the movie to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < movieList.size()) {
            System.out.print("Enter new title: ");
            movieList.get(index).title = scanner.nextLine();
            System.out.print("Enter new genre: ");
            movieList.get(index).genre = scanner.nextLine();
            System.out.print("Enter new duration (minutes): ");
            movieList.get(index).duration = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Movie updated successfully!");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void deleteMovie() {
        viewMovies();
        if (movieList.isEmpty()) return;

        System.out.print("Enter the index of the movie to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < movieList.size()) {
            movieList.remove(index);
            System.out.println("Movie deleted successfully!");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void viewMovies() {
        if (movieList.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            System.out.println("\nAvailable Movies:");
            for (int i = 0; i < movieList.size(); i++) {
                System.out.println(i + ". " + movieList.get(i));
            }
        }
    }

    private static void bookStudio() {
        viewMovies();
        if (movieList.isEmpty()) return;

        System.out.print("Enter the index of the movie to book a studio for: ");
        int movieIndex = scanner.nextInt();
        if (movieIndex < 0 || movieIndex >= movieList.size()) {
            System.out.println("Invalid movie index.");
            return;
        }

        for (Studio studio : studioList) {
            if (!studio.isBooked) {
                studio.isBooked = true;
                System.out.println("Studio " + studio.number + " booked for " + movieList.get(movieIndex).title);
                return;
            }
        }
        System.out.println("No studios available for booking.");
    }

    private static void cancelBooking() {
        System.out.print("Enter studio number to cancel booking: ");
        int studioNumber = scanner.nextInt();

        for (Studio studio : studioList) {
            if (studio.number == studioNumber && studio.isBooked) {
                studio.isBooked = false;
                System.out.println("Studio booking cancelled successfully.");
                return;
            }
        }
        System.out.println("Invalid studio number or studio is not booked.");
    }

    private static void viewStudioStatus() {
        System.out.println("\nStudio Status:");
        for (Studio studio : studioList) {
            System.out.println(studio);
        }
    }
}