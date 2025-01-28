package com.day1;
class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    Movie head;
    Movie tail;

    // Constructor
    public MovieList() {
        head = null;
        tail = null;
    }

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 0) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            }
            temp.next = newMovie;
        }
    }

    // Remove a movie by movie title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next; // If it's the first movie
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev; // If it's the last movie
        }
        System.out.println("Movie \"" + title + "\" removed.");
    }

    // Search for a movie by director or rating
    public void searchByDirectorOrRating(String director, Double rating) {
        Movie temp = head;
        while (temp != null) {
            if ((director != null && temp.director.equals(director)) ||
                    (rating != null && temp.rating == rating)) {
                System.out.println("Found Movie: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    // Display all movie records in forward order
    public void displayAllForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movie records in reverse order
    public void displayAllReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update a movie's rating by its title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for movie \"" + title + "\".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();

        // Add some movies to the list
        movieList.addAtBeginning("The Shawshank Redemption", "Frank Darabont", 1994, 9.3);
        movieList.addAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addAtPosition("Pulp Fiction", "Quentin Tarantino", 1994, 8.9, 1);

        // Display all movies forward
        System.out.println("Movies (Forward Order):");
        movieList.displayAllForward();

        // Display all movies reverse
        System.out.println("\nMovies (Reverse Order):");
        movieList.displayAllReverse();

        // Search for a movie by director
        System.out.println("\nSearching for movies by Director (Quentin Tarantino):");
        movieList.searchByDirectorOrRating("Quentin Tarantino", null);

        // Search for a movie by rating
        System.out.println("\nSearching for movies with Rating 9.2:");
        movieList.searchByDirectorOrRating(null, 9.2);

        // Update movie rating
        System.out.println("\nUpdating Rating for 'The Godfather'...");
        movieList.updateRating("The Godfather", 9.5);

        // Display all movies after updating rating
        System.out.println("\nMovies after rating update:");
        movieList.displayAllForward();

        // Remove a movie by title
        System.out.println("\nRemoving movie 'The Dark Knight'...");
        movieList.removeByTitle("The Dark Knight");

        // Display all movies after removal
        System.out.println("\nMovies after removal:");
        movieList.displayAllForward();
    }
}

