package starbucksscreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderList {
    private Scanner myScanner = new Scanner(System.in);
    private List<Drinks> orderList = new ArrayList<>();

    // prints out the order so far 
    public void viewOrder(){
        while (true) {
            // creates the top of menu
            System.out.println("Espresso Drinks:");
            System.out.printf("%-5s %-25s %-10s%n", "No.", "Drink Name", "Price");
            System.out.println("------------------------------------------------");

            // counter for the l
            int i = 1;
            // displays all the drinks avaiable
            for (Drinks drink : orderList) {
                System.out.printf("%-5d %-25s $%5.2f%n", i, drink.getName(), drink.getAmount());
                i++;
                }

            // returns the previous menu
            System.out.println("\nEnter 0 to go back to the previous menu:");
            int input = myScanner.nextInt();

        }
    }

    // helper function to clear user input
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}




