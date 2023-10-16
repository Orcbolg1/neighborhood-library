package com.pluralsight;

import java.util.Scanner;

public class Main {

    // Create a Scanner to accept user input.
    static Scanner scanner = new Scanner(System.in);

    // Initialize an array of books with a maximum size of 20.
    private static Book[] books = new Book[20];

    //The number of books stored in the book array
    private static int numBooks = 10;

    //This os the main method where the program execution starts.
    public static void main(String[] args) {

        //Run a loop until the user quits the program
        while (true) {

            //Display the options for the user.
            System.out.println("Welcome to your Neighborhood Library!\n" +
                    "What would you lik to do?\n" +
                    " 1 - List all Available books\n" +
                    " 2 - List Book that are checked out\n" +
                    " 3 - Quit Program\n" +
                    " Select your command: ");

            // Read the user's input command
            int command = scanner.nextInt();

            //Consume the newline character left in the scanner buffer after reading the command.
            scanner.nextLine();

            //using a switch statement to call the appropriate method
            switch (command){
                case 1:
                    //listAvailableBooks
                    break;
                case 2:
                    //listUnavailableBooks
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }


}
