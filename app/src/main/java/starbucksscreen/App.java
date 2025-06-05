package starbucksscreen;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // gets user input
       Scanner myScanner = new Scanner(System.in);

       // program initalization
       DrinksList newDrinkList = new DrinksList();

       int input;

       // loops until it exits by user
        while(true){
            System.out.printf("%30s%n","Main Menu");
            System.out.println("------------------------------------------------\n");
            System.out.println("1. Order A Drink");
            System.out.println("2. View Order");
            System.out.println("0. Exit Program");
            System.out.print("\nPlease select a drink or enter any keys to exit: ");

            input = myScanner.nextInt();
            clearScreen();
            
            switch (input) {
                case 1:
                    newDrinkList.viewDrinkMenu();
                    break;
                case 2:
                    newDrinkList.viewOrder();
                    break;
                default:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
            }
       } 
    }

    // helper function to clear user input
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
