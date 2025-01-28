package linkedlist.moviemanagement;

public class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    // Add a movie record at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie record at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie record at a specific position
    public void addMovieAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range.");
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            } else {
                tail = newMovie; // Update tail if inserted at the end
            }
            current.next = newMovie;
        }
    }

    // Remove a movie record by Movie Title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        MovieNode current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie with title \"" + title + "\" not found.");
        } else {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next; // Update head if the first node is removed
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev; // Update tail if the last node is removed
            }
        }
    }

    // Search for a movie by Director or Rating
    public void searchMovies(String director, double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director) || current.rating == rating) {
                System.out.println("Title: " + current.title + ", Director: " + current.director +
                        ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found matching the criteria.");
        }
    }

    // Display all movie records in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating based on the title
    public void updateMovieRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current != null) {
            current.rating = newRating;
            System.out.println("Rating updated for movie \"" + title + "\".");
        } else {
            System.out.println("Movie with title \"" + title + "\" not found.");
        }
    }

    // Main function to test the operations
    public static void main(String[] args) {
        MovieManagementSystem movieList = new MovieManagementSystem();

        // Adding movies
        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        movieList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.1);
        movieList.addMovieAtPosition(2, "Dunkirk", "Christopher Nolan", 2017, 7.9);

        // Displaying movies forward
        System.out.println("Movies in forward order:");
        movieList.displayMoviesForward();

        // Displaying movies reverse
        System.out.println("\nMovies in reverse order:");
        movieList.displayMoviesReverse();

        // Searching for movies
        System.out.println("\nSearching for movies by director 'Christopher Nolan':");
        movieList.searchMovies("Christopher Nolan", 0);

        // Updating a movie's rating
        movieList.updateMovieRating("Interstellar", 9.0);

        // Removing a movie
        movieList.removeMovieByTitle("Dunkirk");

        // Displaying movies after updates
        System.out.println("\nMovies after updates:");
        movieList.displayMoviesForward();
    }
}

