package com.pluralsight;

import java.util.Scanner;

public class AvailableBooks {

    private static Scanner input = new Scanner(System.in);

    public static void menu(Book[] books) {

        // call the show method
        show(books);

        boolean validated = false;

        while (!validated) {

            System.out.println("Choose from the following options");
            System.out.println("1 - Check out a book");
            System.out.println("2 - Exit");

            int command = input.nextInt();

            switch (command) {
                case 1:
                    // clear buffer
                    input.nextLine();

                    System.out.println("Select a book");
                    String selection = input.nextLine();

                    validated = findSelection(selection, books);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid input detected. Try (1 or 2)");

            }
        }

    }

    // this method shows available books
    private static void show(Book[] books) {
        System.out.println("Available books");

        // loop through all books
        for(int i = 0; i < books.length; i++) {
            // if the book is not checked out
           if (!books[i].isCheckedOut()) {
               System.out.printf("ID: %d, ISBN: %s, Title: %s\n", books[i].getId(), books[i].getIsbn(), books[i].getTitle());
           }

        }
    }

    // this method finds a selected book and checks it out, then returns a boolean,
    // if operation was successful bool = true, else bool = false
    private static boolean findSelection (String selection, Book[] books) {

        // check each book
        for (int i = 0; i < books.length; i++) {
            // search for selection match in ID, ISBN or Title
            if (String.valueOf(books[i].getId()).equalsIgnoreCase(selection) || selection.equalsIgnoreCase(books[i].getIsbn()) || selection.equalsIgnoreCase(books[i].getTitle()) ) {
                // get a name and check out the book
                System.out.println("Enter your name");
                String name = input.nextLine();

                books[i].checkOut(name);

                // print confirmation and validate input
                System.out.printf("%s was checked out by %s\n", books[i].getTitle(), books[i].getCheckedOutTo());
                return true;
            }
        }
        // book not found
        System.out.println("Book not");
        return false;

    }

}
