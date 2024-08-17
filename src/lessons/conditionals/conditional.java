package lessons.conditionals;

public class conditional {
    public static void main(String[] args) {
        //Verify x as an time and print Good morning, Good evening or Good night
        int x = 23;
        if (x > 0 && x < 12) {
            System.out.println("Good morning");
        } 
        else if (x > 12 && x < 18) {
            System.out.println("Good evening");
        }
        else{
            System.out.println("Good night");
        }   
    }
}
