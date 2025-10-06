package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {

    public static Book[] books = new Book[20];

    public static void main(String[] args) {

        // preload books for library
        books[0] = new Book(101121, "Ford Explorer", "Red", false, "");
        books[1] = new Book(101122, "Toyota Camry", "Blue",false,"");
        books[2] = new Book(101123, "Chevrolet Malibu", "Black", false, "");
        books[3] = new Book(101124, "Honda Civic", "White", false, "");
        books[4] = new Book(101125, "Subaru Outback", "Green", false, "");
        books[5] = new Book(101126, "Jeep Wrangler", "Yellow", false, "");

        while (true) {
            // create a scanner for input
            Scanner input = new Scanner(System.in);

            // display options
            System.out.println("Welcome to the Neighborhood Library App!" +
                    "\n Choose from the following options\n");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit");

            // store input
            int command = input.nextInt();
            //clear buffer
            input.nextLine();

            switch (command) {
                case 1:
                    //new AvailableBooks.menu(books);
                    break;
                case 2:
                    //new CheckedOutBooks.menu(books);
                    break;
                case 3:
                    return;

            }

        }
    }

}
