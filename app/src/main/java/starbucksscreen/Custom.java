package starbucksscreen;

public class Custom {

    public Custom(){

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
    
}