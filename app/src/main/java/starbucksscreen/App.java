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
            System.out.println("Main Menu");
            System.out.println("1. Order A Drink");
            System.out.println("2. View Order");
            System.out.println("0. Exit Program");

            input = myScanner.nextInt();
            clearScreen();
            
            switch (input) {
                case 1:
                    newDrinkList.viewDrinkMenu();
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
