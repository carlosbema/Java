package exercises.OOP.dollarPrice.util;

public class dollarConverter {
    public static double tax = 0.06;
    
    public static double convert(double dollarPrice, double amountOfDollars) {
        return (dollarPrice * amountOfDollars) + ((dollarPrice * amountOfDollars) * tax);
    }
}
