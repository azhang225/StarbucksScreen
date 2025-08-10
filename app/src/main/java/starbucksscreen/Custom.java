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

public class Custom {
    private Scanner myScanner = new Scanner(System.in);
    private List<Ingredients> ingredients = new ArrayList<>();

    public Custom(){
        loadCustomMenu();
    }

    // adds a shot of espresso to drink
    public void addShot(Drinks drink){
        Ingredients espresso = drink.getIngredients().stream()
        .filter(ing -> ing.getIngredientName().equalsIgnoreCase("Espresso"))
        .findFirst()
        .orElse(null);  

        //if found add one espresso and charge them
        if(espresso != null){
            espresso.setAmount(espresso.getAmount() + 1);
            espresso.setCost(espresso.getCost() + 1.25);
        }else{
            // add the shot of coffee if there is no espreso
            Ingredients newEspresso = new Ingredients("Espresso", "Espresso", 1, 1.25);
            drink.getIngredients().add(newEspresso);
        }
    }

    public void viewSyrups(Drinks drink){
        // print out the drink to customize
        System.out.printf(" %-10s %-25s $%5.2f%n",  drink.getSize(), drink.getName(), drink.getAmount());
                for (Ingredients ing : drink.getIngredients()) {
                    System.out.printf("%12s %-2sx %-20s $%5.2f%n","", 
                    ing.getAmount(), ing.getIngredientName(), ing.getCost());
                }
        // counter menu for Syrups
        int counter = 1;
        List<Ingredients> syrups = new ArrayList<>();
        for (Ingredients ing : ingredients) {
                if (ing.getType().equalsIgnoreCase("Syrup")){
                    // adds syrup into a new list
                    syrups.add(ing);
                    System.out.println(counter + ". " + ing.getIngredientName());
                }
                ++counter;
            }
            while(true){
                // adds the syrups
                System.out.print("\nWhich syrup would you like to add: ");
                int input = myScanner.nextInt();
                if(input > 0 && input <= (counter)){
                    // ask user how much they want
                    System.out.print("\nHow much would you like add: ");
                    int amount = myScanner.nextInt();
                    Ingredients newSyrup = new Ingredients("Syrup", syrups.get(input - 1).getIngredientName(), amount, 0.50);
                    drink.getIngredients().add(newSyrup);
                }
                break;
            }
    }

     // load drink menu from file 
    public void loadCustomMenu(){
        File file = new File("customs.txt");
        if (!file.exists()) return;

        // reads the file 
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // while it's not the end of the file
            while ((line = reader.readLine()) != null) {
                // parse the customization per linke
                Ingredients ing = Ingredients.fromString(line);
                ingredients.add(ing); // add the add ons to the menu
            }
        } catch (IOException e) {
            System.out.println("Error loading add on menu.");
        }
    }

    // saves the add ons to a file
    private void saveCustomsToFile() {
        // tries to write to a file or create one if the following text doesnt exists
        try (PrintWriter writer = new PrintWriter(new FileWriter("drinkmenu.txt"))) {
            // for every drink in drink lists write it to file
            for (Ingredients ing : ingredients) {
                writer.println(ing.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving drink menu.");
        }
    }
    
}