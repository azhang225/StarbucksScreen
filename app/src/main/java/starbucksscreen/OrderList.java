package starbucksscreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderList {
    private Scanner myScanner = new Scanner(System.in);
    private List<Drinks> orderList = new ArrayList<>();

    // prints out the order so far 
    public void viewOrder(){
        double total = calcTotal();
        while (true) {
            // creates the top of menu
            System.out.printf("%30s%n","Current Order\n");
            System.out.printf("%-5s %-25s %-10s%n", "No.", "Drink Name", "Price");
            System.out.println("------------------------------------------------");

            // counter for the l
            int i = 1;
            // displays all the drinks avaiable
            for (Drinks drink : orderList) {
                System.out.printf("%-5d %-25s $%5.2f%n", i, drink.getName(), drink.getAmount());
                i++;
                }
            System.out.println("------------------------------------------------");
              System.out.printf("Total: $ %.2f\n\n", + total);

            System.out.println("1. Pay for Order");
            System.out.println("0. Return to previous menu.");
            int input = myScanner.nextInt();
            switch (input) {
                case 1:
                // pays for the order
                    clearScreen();
                    payForOrder(total);
                    break;
                case 0:
                    return; 
                default:
                    System.out.println("Invalid input, please select another option");
                    break;
            }

        }
    }

    // adds the drink to the order
    public void addDrinkToOrder(Drinks drink){
        orderList.add(drink);
    }
    
    // process the order
    private void payForOrder(double total){
        System.out.printf("You total is: $%.2f\n\n", + total);
        System.out.println("1. Cash");
        System.out.println("2. Credit/Debit");
    }

    // helper function to clear user input
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private double calcTotal(){
        double total = 0.00;
         for(Drinks drink: orderList){
            total += drink.getAmount();
        }
        return total;
    }
}




