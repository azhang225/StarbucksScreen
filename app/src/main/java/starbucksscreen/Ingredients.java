package starbucksscreen;

public class Ingredients {

    private String type;
    private String ingredientName;
    private int amount;
    private double cost;
    
    // a default constructor
    public Ingredients(){

    }
    // construnctor for ingredient that has an amount
    public Ingredients(String type, String ingredientName, int amount, double cost){
        this.type = type;
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.cost = cost;
    }

    // constructor for ingredient that does not have an amount    
    public Ingredients(String type, String ingredientName){
        this.amount = 0;
    }

    // getters for the variables
    public String getIngredientName(){
        return ingredientName;
    }

    public int getAmount(){
        return amount;
    }

    public String getType(){
        return type;
    }

    public double getCost(){
        return cost;
    }

    // to string format
    @Override
    public String toString() {
        return type + ":" + ingredientName + ":" + amount + ":" + cost;
    }

    // formatting the string back to an object
    public static Ingredients fromString(String str) {
        String[] parts = str.split(":");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid ingredient format: " + str);
        }
        String type = parts[0];
        String name = parts[1];
        int amount = Integer.parseInt(parts[2]);
        double cost = Double.parseDouble(parts[3]);
        return new Ingredients(type, name, amount, cost);
    }
}
