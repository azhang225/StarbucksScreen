package starbucksscreen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinksList {
    // Create an empty Drink List
    private List<Drinks> drinks = new ArrayList<>();
    private OrderList newOrder = new OrderList();
    private Scanner myScanner = new Scanner(System.in);

    // load drink menu from file
    public DrinksList(){
        loadDrinkMenu();
    }

    // displays different drink category
    public void viewDrinkMenu(){
        int input;
            while(true){
            System.out.println("\nDrink Categories");
            System.out.println("------------------------------------------------");
            System.out.println("1. Espresso");
            System.out.println("2. Blended Beverages");
            System.out.println("3. Brewed Beverages");
            System.out.println("4. Iced Beverages");
            System.out.println("5. Create a New Drink");
            System.out.println("0. Go Back To Main Menu");
            
            System.out.print("\nPlease select a drink or enter 0 to go to previous menu: ");

            // takes in user input
            input = myScanner.nextInt();
            clearScreen();

            // displays drink menu based off what is selected
            switch (input) {
                case 1:
                    viewEsspresos(); // view all espresso drinks
                    break;
                case 2:
                    viewBlendedBeverages(); // view all blended drinks
                    break;
                case 3:
                    viewBrewed(); // view all brewed drinks
                    break;
                case 4: 
                    viewIcedBeverages(); // view all iced drinks
                    break;
                case 5: 
                    addDrinks(); // add a new drink
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please try selecting a valid option");
                    break;
            }
        }
    }

    // Display all espresso Type Drinks
    public void viewEsspresos(){
        // creates a espresso list in this scope
        List<Drinks> espressoList = new ArrayList<>();

        while (true) {
            // creates the top of menu
            System.out.println("\nEspresso");
            System.out.println("------------------------------------------------");
            display();
        
            espressoList.clear(); // reset before each display

            // counter for the menu
            int i = 1;
            for (Drinks drink : drinks) {
                if (drink.getType().equalsIgnoreCase("Espresso")) {
                    espressoList.add(drink);
                    System.out.printf("%-5d %-25s $%5.2f%n", i, drink.getName(), drink.getAmount());
                    i++;
                }
            }

            // returns the previous menu
            System.out.print("\nPlease select a drink or enter 0 to go to previous menu: ");
            int input = myScanner.nextInt();
            if (input == 0){ 
                clearScreen();
                break;
            }else if (input > 0 && input <= espressoList.size()){
                addDrinkToOrder(input, espressoList);
            }else{
                System.out.println("Invalid option, please try again. \n");
            }
        }
    }

    // displays all blended type drinks
    public void viewBlendedBeverages(){

        // creates a blended list in this scope
        List<Drinks> blendedList = new ArrayList<>();

        while (true) {
            // creates the top of menu
            System.out.println("\nBlended Beverages");
            System.out.println("------------------------------------------------");
            display();

            blendedList.clear();
            
            // counter for the menu
            int i = 1;
            // displays all the drinks avaiable
            for (Drinks drink : drinks) {
                if (drink.getType().equalsIgnoreCase("Blended")){
                    blendedList.add(drink);
                    System.out.printf("%-5d %-25s $%5.2f%n", i, drink.getName(), drink.getAmount());
                    i++;
                }
            }

            System.out.print("\nPlease select a drink or enter 0 to go to previous menu: ");
            int input = myScanner.nextInt();
            if (input == 0){ 
                clearScreen();
                break;
            }else if (input > 0 && input <= blendedList.size()){
                addDrinkToOrder(input, blendedList);
            }else{
                System.out.println("Invalid option, please try again. \n ");
            }

        }
    }
    // displays all brewed type drinks
    public void viewBrewed(){
        while (true) {

            // creates a brewed in this scope
            List<Drinks> brewedList = new ArrayList<>();

            // creates the top of menu
            System.out.println("\nBrewed Beverages");
            System.out.println("------------------------------------------------");
            display();

            brewedList.clear();

            // counter for the menu
            int i = 1;
            // displays all the drinks avaiable
            for (Drinks drink : drinks) {
                if (drink.getType().equalsIgnoreCase("Brewed")) {
                    brewedList.add(drink);
                    System.out.printf("%-5d %-25s $%5.2f%n", i, drink.getName(), drink.getAmount());
                    i++;
                }
            }

            // returns the previous menu
            System.out.print("\nPlease select a drink or enter 0 to go to previous menu: ");
            int input = myScanner.nextInt();
            if (input == 0){ 
                clearScreen();
                break;
            }else if (input > 0 && input <= brewedList.size()){
                addDrinkToOrder(input, brewedList);
            }else{
                System.out.println("Invalid option, please try again. \n ");
            }
        }
    }
    
    // displays all iced beverages type drinks
    public void viewIcedBeverages(){
        while (true){

            // creates a ice beverage list in this scope
            List<Drinks> icedBevList = new ArrayList<>();

            // creates the top of menu
            System.out.println("\nIced Beverages");
            System.out.println("------------------------------------------------");
            display();

            icedBevList.clear();

            // counter for the menu
            int i = 1;
            // displays all the drinks avaiable
            for (Drinks drink : drinks) {
                if (drink.getType().equalsIgnoreCase("Iced Beverage")) {
                    icedBevList.add(drink);
                    System.out.printf("%-5d %-25s $%5.2f%n", i, drink.getName(), drink.getAmount());
                    i++;
                }
            }

            // returns the previous menu
            System.out.print("\nPlease select a drink or enter 0 to go to previous menu: ");
            int input = myScanner.nextInt();
            if (input == 0){ 
                clearScreen();
                break;
            }else if (input > 0 && input <= icedBevList.size()){
                addDrinkToOrder(input, icedBevList);
            }else{
                System.out.println("Invalid option, please try again. \n ");
            }
        }
    }

    // add new drinks to the menu
    public void addDrinks(){
        System.out.print("What is the new drink called?: ");
        String name = myScanner.next();

        System.out.print("What is type of drink is this?: ");
        String type = myScanner.next();

        System.out.print("How much does the drink cost?: ");
        double amount = myScanner.nextDouble();

        // adds new Drink into the list of Drinks
        Drinks newDrink = new Drinks(name, amount, type);
        drinks.add(newDrink);

        //saves the new to file
        saveDrinkToFile();
        
    }

    // views the order
    public void viewOrder(){
        newOrder.viewOrder();
    }


    public void display(){
           // creates the top of menu
            System.out.printf("%-5s %-25s %-10s%n", "No.", "Drink Name", "Price");
            System.out.println("------------------------------------------------");
    }

    // add drink to order
    public void addDrinkToOrder(int input, List<Drinks> list){
        // add the drink to order
        newOrder.addDrinkToOrder(list.get(input - 1));
        clearScreen();
        // notifies that the drink has been added to user
        System.out.println(list.get(input - 1).getName() + " has been added to the order.");
    }

    // load drink menu from file 
    public void loadDrinkMenu(){
          File file = new File("drinkmenu.txt");
        if (!file.exists()) return;

        // reads the file 
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // while it's not the end of the file
            while ((line = reader.readLine()) != null) {
                // parse the drinks per linke
                Drinks drink = Drinks.fromFileString(line);
                drinks.add(drink); // add the drinks to the menu
            }
        } catch (IOException e) {
            System.out.println("Error loading drink menu.");
        }
    }

    // saves the drinks to a file
    private void saveDrinkToFile() {
        // tries to write to a file or create one if the following text doesnt exists
        try (PrintWriter writer = new PrintWriter(new FileWriter("drinkmenu.txt"))) {
            // for every drink in drink lists write it to file
            for (Drinks drink : drinks) {
                writer.println(drink.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving drink menu.");
        }
    }

    // helper function to clear user input
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
