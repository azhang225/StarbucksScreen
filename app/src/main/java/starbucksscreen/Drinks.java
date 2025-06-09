package starbucksscreen;

public class Drinks {
    private String name;
    private double amount;
    private String type;

    // default constructor
    public Drinks(String name, double amount, String type){
        this.name = name;
        this.amount = amount;
        this.type = type;
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
    
    // ensures that the amount is in dollar form
    public String toString() {
        return name + " - $" + amount;
    }

    // ensures when writing to file, it writes in this form
    public String toFileString() {
        return name + "," + amount + "," + type ;
    }

    // formats the the file 
    public static Drinks fromFileString(String line) {
        String[] parts = line.split(",");
        return new Drinks(parts[0], Double.parseDouble(parts[1]), parts[2]);
    }
}
