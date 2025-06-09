package starbucksscreen;

public class Ingredients {

    private String type;
    private String ingredientName;
    private int amount;
    
    // construnctor for ingredient that has an amount
    public Ingredients(String type, String ingredientName, int amount){
        this.type = type;
        this.ingredientName = ingredientName;
        this.amount = amount;
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
}
