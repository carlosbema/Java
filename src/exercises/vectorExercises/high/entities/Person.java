package exercises.vectorExercises.high.entities;

public class Person {
    private String name;
    private int age;
    private double high;

    public Person (String name, int age, double high){
        this.name = name;
        this.age = age;
        this.high = high;
    }

    public String toString(){
        return name
            + ", "
            + age
            + ", "
            + high;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){    
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getHigh(){    
        return high;
    }

    public void setHigh(double high){
        this.high = high;
    }
}
