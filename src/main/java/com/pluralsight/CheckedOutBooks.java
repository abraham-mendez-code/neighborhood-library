package com.pluralsight;

import java.util.Scanner;

public class CheckedOutBooks {

    private static Scanner input = new Scanner(System.in);

    public static void menu(Book[] books) {

        // call the show method
        show(books);

        boolean validated = false;

        while (!validated) {

            System.out.println("Choose from the following options");
            System.out.println("C - Check In a book");
            System.out.println("X - Return to home");

            // store only the first character in lowercase form
            char command = input.nextLine().charAt(0);
            command = Character.toLowerCase(command);

            switch (command) {
                case 'c':
                    // clear buffer
                    input.nextLine();

                    System.out.println("Enter the ID");
                    int id = input.nextInt();

                    validated = findSelection(id, books);
                    break;
                case 'x':
                    return;
                default:
                    System.out.println("Invalid input detected. Try (C or X)");

            }
        }

    }

    // this method shows available books
    private static void show(Book[] books) {
        System.out.println("Checked Out books");

        // loop through all books
        for(int i = 0; i < books.length; i++) {
            // if the book is not checked out
            if (books[i].isCheckedOut()) {
                System.out.printf("ID: %d, ISBN: %s, Title: %s, is checked out by %s\n", books[i].getId(), books[i].getIsbn(), books[i].getTitle(), books[i].getCheckedOutTo());
            }

        }
    }

    // this method finds a selected book and checks it out, then returns a boolean,
    // if operation was successful bool = true, else bool = false
    private static boolean findSelection (int id, Book[] books) {

        // check each book
        for (int i = 0; i < books.length; i++) {
            // search for match in ID
            if (id == books[i].getId())  {
                //check in book
                books[i].checkIn();
                return true;
            }
        }
        // book not found
        System.out.println("Book not found");
        return false;

    }

}
