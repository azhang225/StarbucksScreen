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
                // pays for the order1
                    clearScreen();
                    payForOrder(total);
                    return;
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
        System.out.println("0. Return to previous menu.\n");
        System.out.println("Please select which payment method you would like to use:" );

    
        int input = myScanner.nextInt();
        switch (input) {
                case 1:
                // pays for the order
                    clearScreen();
                    payCash(total);
                    return;
                case 2:
                    clearScreen();
                    payCredit();
                    return;
                case 0:
                    return; 
                default:
                    System.out.println("Invalid input, please select another option");
                    break;
            }

    }
    
    private void payCash(double total){

        // rounds the total to the nearest whole number
        double rounded = Math.ceil(total);

        // gives user the option for selecting cash amount
        System.out.println("Please select the amount of cash:");
        System.out.println("1. $1.00");
        System.out.println("2. $5.00");
        System.out.println("3. $10.00");
        System.out.println("4. $20.00");
        System.out.printf("5. $%.2f\n\n", + rounded);
        System.out.println("Please select how much cash you want to pay with:" );

        int input = myScanner.nextInt();

        //calcualating change and tender the order
        switch (input) {
            case 1:
                calcChange(total, 1.00);
                break;
            case 2:
                calcChange(total, 5.00);
                break;
            case 3:
                calcChange(total, 10.00);
                break;
            case 4:
                calcChange(total, 20.00);
                break;
            case 5:
                calcChange(total, rounded);
                break; 
            default:
                break;
        }
    }

    // Returns the change and thanks the user for buying the drinks
    private void calcChange(double total, double cashAmount){
        double result = total - cashAmount;
        if(result <= 0){
            clearScreen();
            System.out.printf("Your change is: $%.2f\n", + Math.abs(result));
            System.out.println("Thank you for your purchase. Enjoy your drink(s).\n");
        }else{
            clearScreen();
            System.out.printf("Your remaining total is: $%.2f\n", + Math.abs(result));
            // recurring method if need to pay more
            payCash(result);
        }
    }

    // if the user pays with card
    private void payCredit(){
        orderList.clear();
        System.out.println("Thank you for your purchase. Enjoy your drink(s).\n");
    }
    

    // helper function to clear user input
    private static void clearScreen() {
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




