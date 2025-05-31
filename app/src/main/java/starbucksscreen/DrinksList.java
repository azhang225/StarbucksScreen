package starbucksscreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinksList {
    // Create an empty Drink List
    private List<Drinks> drinks = new ArrayList<>();
    private Scanner myScanner = new Scanner(System.in);

    // displays different drink category
    public void viewDrinkMenu(){
        int input;
            while(true){
            System.out.println("Drink Categories");
            System.out.println("1. Espresso");
            System.out.println("2. Blended Beverages");
            System.out.println("3. Brewed Beverages");
            System.out.println("4. Iced Beverages");
            System.out.println("0. Go Back To Main Menu");

            // takes in user input
            input = myScanner.nextInt();
            clearScreen();

            switch (input) {
                case 1:
                    viewEsspresos();
                    break;
                case 2:
                    viewBlendedBeverages();
                    break;
                case 3:
                    viewBrewed();
                    break;
                case 4: 
                    viewIcedBeverages();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please try selecting a valid option");
                    break;
            }
        }
    }

    public void viewEsspresos(){

    }

    public void viewBlendedBeverages(){

    }

    public void viewBrewed(){

    }
    
    public void viewIcedBeverages(){

    }

    // helper function to clear user input
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
