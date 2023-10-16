package com.pluralsight;

import java.util.Scanner;

public class Main {

    // Create a Scanner to accept user input.
    static Scanner scanner = new Scanner(System.in);

    // Initialize an array of books with a maximum size of 20.
    private static Book[] books = new Book[20];

    //The number of books stored in the book array
    private static int numBooks = 20;

    //This os the main method where the program execution starts.
    public static void main(String[] args) {

        // Building Books with inventory
        books[0] = new Book(01, "56184118416", "The Great Gasby", true, "Johnathon Smith");
        books[1] = new Book(02, "5184352148", "Wuthering Heights", false, " ");
        books[2] = new Book(03, "985613248765", "The Handmaid's Tale", false, " ");
        books[3] = new Book(04, "98735218732", "Things Fall Apart", true, "Jason Corry");
        books[4] = new Book(05, "89765321584", "Beloved", false, " ");


        //Run a loop until the user quits the program
        while (true) {
            //Display the options for the user.
            System.out.println("Welcome to your Neighborhood Library!\n" +
                    "What would you lik to do?\n" +
                    " 1 - List all Available books\n" +
                    " 2 - List Book that are checked out\n" +
                    " 3 - Check in a book\n" +
                    " 4 - Check out a book\n" +
                    " 5- Quit Program\n" +
                    " Select your command: ");

            // Read the user's input command
            int command = scanner.nextInt();

            //Consume the newline character left in the scanner buffer after reading the command.
            scanner.nextLine();

            //using a switch statement to call the appropriate method
            switch (command) {
                case 1:
                    listAvailableBooks(books, numBooks);
                    break;
                case 2:
                    listUnavailableBooks(books, numBooks);
                    break;
                case 3:
                    checkInABook(books, numBooks);
                    break;
                case 4:
                    checkOutABook(books, numBooks);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }

    public static void listAvailableBooks(Book[] books, int numBooks){
        System.out.println("All Available Books: \n");

        for( int i = 0; i < numBooks; i++){
            if(books[i].getIsCheckedOut() == false){
                System.out.println("Book: " + books[i].getId() + " \"" +books[i].getTitle() + ": \""
                        + books[i].getIsbn());
            }
        }

        System.out.println("What would you like to do? \n" +
                "1. Check out a book?\n" +
                "2. Exit to the Home Screen?\n" +
                "What is your choice?: \n");
        int input = scanner.nextInt();
        if(input == 1){
            checkOutABook(books, numBooks);
        }else{
            System.out.println("Goodbye!\n");
        }
    }

    public static void listUnavailableBooks(Book[] books, int numBooks){
        System.out.println("All Unavailable Books: \n");

        for(int i = 0; i < numBooks; i++){
            if(books[i].getIsCheckedOut() == true) {
                System.out.println("Book: " + books[i].getId() + ", \"" + books[i].getTitle() + ", \"" + books[i].getIsbn()
                        + " is currently checked out by: " + books[i].getIsCheckedOut());
            }
                System.out.println("What would you like to do? \n" +
                        "1. Check in a book?\n" +
                        "2. Exit to the Home Screen?\n" +
                        "What is your choice?: \n");
                int input = scanner.nextInt();
                if(input == 1){
                    checkInABook(books, numBooks);
                }else {
                    System.out.println("Goodbye!");
                }
        }
    }

    public static void checkInABook(Book[] books, int numBooks){
        System.out.println("Please enter the ID of the book you would like to check in: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int bookCheck = 0;
        boolean bookFound = false;

        for(int i = 0; i < numBooks; i++) {
            if (books[i].getId() == id) {
                bookCheck = i;
                bookFound = true;
            }
        }
            if(bookFound == true){
                if(books[bookCheck].getIsCheckedOut() == true){
                    System.out.println("\"" + books[bookCheck].getTitle() + "\" has been checked in!\n\n");
                    books[bookCheck].setCheckedOut(false);
                }else{
                    System.out.println("Error: \"" + books[bookCheck].getTitle() + "\" is already checked in\n\n");
            }
        }else{
                System.out.println("Error: Book ID is incorrect");
            }
    }

    public static void checkOutABook(Book[] books, int numBooks){
        System.out.println("Please enter the ID of the book you would like to check out: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int bookCheck = 0;
        boolean bookFound = false;

        for(int i = 0; i < numBooks; i++){
            if(books[i].getId() == id){
                bookCheck = i;
                bookFound = true;
            }
        }
            if(bookFound == true){
                if(books[bookCheck].getIsCheckedOut() == true){
                    System.out.println("Error: " + books[bookCheck].getTitle() + "\" has already been check out\n\n");
                }
            }
            else{
                String title = null;
                while(title == null){
                    System.out.println("What is your name to check out \"" + books[bookCheck].getTitle() + "\" ?");
                    title = scanner.nextLine();
                }
                System.out.println("\"" + books[bookCheck].getTitle() + "\" is check out by " + title + ".\n\n" );
                books[bookCheck].setCheckedOut(true);
                books[bookCheck].setCheckedOutTo(title);
            }
    }
}










