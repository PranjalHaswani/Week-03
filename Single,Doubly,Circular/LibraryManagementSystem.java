package com.day1;
class Book {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head;
    private Book tail;
    private int bookCount;

    public LibraryManagement() {
        head = null;
        tail = null;
        bookCount = 0;
    }

    // Add a new book at the beginning
    public void addBookAtBeginning(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    // Add a new book at the end
    public void addBookAtEnd(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(bookTitle, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // Add a new book at a specific position
    public void addBookAtPosition(String bookTitle, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position < 0 || position > bookCount) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 0) {
            addBookAtBeginning(bookTitle, author, genre, bookId, isAvailable);
        } else if (position == bookCount) {
            addBookAtEnd(bookTitle, author, genre, bookId, isAvailable);
        } else {
            Book newBook = new Book(bookTitle, author, genre, bookId, isAvailable);
            Book temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
            bookCount++;
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    if (temp.next != null) temp.next.prev = temp.prev;
                }
                bookCount--;
                System.out.println("Book with ID " + bookId + " has been removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Book Title
    public void searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookTitle.equalsIgnoreCase(title)) {
                System.out.println("Found Book: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with title " + title + " not found.");
    }

    // Search for a book by Author
    public void searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Found Book: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book by author " + author + " not found.");
    }

    // Update a book's Availability Status
    public void updateBookAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Book with ID " + bookId + " availability updated to: " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayAllBooksForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayAllBooksReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookId + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countTotalBooks() {
        return bookCount;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Add some books to the library
        library.addBookAtEnd("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 101, true);
        library.addBookAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 102, true);
        library.addBookAtBeginning("1984", "George Orwell", "Dystopian", 103, true);

        // Display books forward
        System.out.println("Library Books (Forward):");
        library.displayAllBooksForward();

        // Display books reverse
        System.out.println("\nLibrary Books (Reverse):");
        library.displayAllBooksReverse();

        // Search for books by title or author
        library.searchBookByTitle("Harry Potter and the Sorcerer's Stone");
        library.searchBookByAuthor("J.R.R. Tolkien");

        // Update availability
        library.updateBookAvailability(102, false);

        // Count total number of books
        System.out.println("\nTotal number of books in the library: " + library.countTotalBooks());

        // Remove a book by ID
        library.removeBookById(103);

        // Display books after removal
        System.out.println("\nLibrary Books After Removal:");
        library.displayAllBooksForward();
    }
}

