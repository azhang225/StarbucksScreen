package starbucksscreen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Drinks {
    private String name;
    private double amount;
    private String type;
    private List<Ingredients> ingredients;
    

    // default constructor
    public Drinks(String name, double amount, String type, List<Ingredients> ingredients){
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.ingredients = ingredients;
    }

    // returns name of drink
    public String getName(){
        return name;
    }

    // returns drink type
    public String getType(){
        return type;
    }

    //returns amount for drink
    public double getAmount(){
        return amount;
    }

    public List<Ingredients> getIngredients(){
        return ingredients;
    }
    
    // ensures that the amount is in dollar form
    public String toString() {
        return name + " - $" + amount;
    }

    // ensures when writing to file, it writes in this form
    public String toFileString() {
        String ingredientStr = ingredients.stream()
            .map(Ingredients::toString)
            .collect(Collectors.joining("|"));
        return name + "," + amount + "," + type + "," + ingredientStr;
    }

    // formats the the file 
    public static Drinks fromFileString(String line) {
        String[] parts = line.split(",", 4);
        String name = parts[0];
        double amount = Double.parseDouble(parts[1]);
        String type = parts[2];

        List<Ingredients> ingredients = new ArrayList<>();
        if (parts.length == 4 && !parts[3].isEmpty()) {
            String[] ingredientParts = parts[3].split("\\|");
            for (String ingStr : ingredientParts) {
                ingredients.add(Ingredients.fromString(ingStr));
            }
        }

        return new Drinks(name, amount, type, ingredients);
    }
}
